package org.jlf.soa.mvc.dao.blacklist;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.jlf.common.util.DateUtil;
import org.jlf.soa.mvc.dao.blacklist.mq.JLFMVCBlackListMqTopicProduct;
import org.jlf.soa.mvc.dao.blacklist.mq.JLFMVCBlackListOperatorType;

public class JLFMVCDaoBlackList {
	
	/**
	 * 黑名单列表 
	 * key为 dbName_tableName_id  value为过期时间 ,如果value为空则永久生效
	 */
	private static ConcurrentHashMap<String,Date> blackList = new ConcurrentHashMap<String,Date>();
	
	public static void addBlack(String dbName,String tableName,Long id){
		
		String key = new StringBuffer(dbName).append("-").append(tableName).append("-").append(id).toString();
		if(!blackList.containsKey(key)){
			Date date = DateUtil.formatDate("2100-12-13 23:59:59",DateUtil.DEFAULT_DATETIMEPATTERN);
			blackList.put(key, date);
			JLFMVCBlackListMqTopicProduct.send(JLFMVCBlackListOperatorType.ADD, dbName, tableName, id, date);
		}
		
	}
	
	public static void addBlack(String dbName,String tableName,Long id,Date expireTime){
		String key = new StringBuffer(dbName).append("-").append(tableName).append("-").append(id).toString();
		if(!blackList.containsKey(key)){
			blackList.put(key, expireTime);
			JLFMVCBlackListMqTopicProduct.send(JLFMVCBlackListOperatorType.ADD, dbName, tableName, id, expireTime);
		}
		
	}
	
	
	
	public static void removeBlack(String dbName,String tableName,Long id){
		String key = new StringBuffer(dbName).append("-").append(tableName).append("-").append(id).toString();
		blackList.remove(key);
		JLFMVCBlackListMqTopicProduct.send(JLFMVCBlackListOperatorType.REMOVE, dbName, tableName, id, null);
	}
	
	public static boolean isExist(String dbName,String tableName,Long id){
		String key = new StringBuffer(dbName).append("-").append(tableName).append("-").append(id).toString();
		Date expireTime = blackList.get(key);
		if(expireTime == null){
			return false;
		}
		Date now = new Date();
		int compareData = DateUtil.compareData(now, expireTime);
		if(compareData == 1){
			return true;
		}
		return false;
	}
}
