package jlf.web.log.service;

import com.alibaba.fastjson.JSONObject;
import jlf.web.log.bean.RequestLog;
import jlf.web.log.dao.RequestLogDao;
import jlf.web.response.bean.ResponseBean;
import jlf.web.session.bean.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: RequestLogSend
 * @Description: RequestLogSendKafka
 * @author Lone Wolf
 * @date 2023年12月13日
 */
@Service
@Slf4j
public class RequestLogService {


	@Autowired
	private RequestLogDao dao;

	@Async("recordLog")
	public void saveRequestLog(Object body, Date endTime, RequestLog requestLog, UserSession<?> session) {
		long consumTime = endTime.getTime() - requestLog.getStartTime().getTime();
		requestLog.setEndTime(endTime);
		requestLog.setConsumTime(consumTime);
		ResponseBean responseData = (ResponseBean) body;
		String responseString = JSONObject.toJSONString(responseData);
		requestLog.setResponseParam(responseString);
		requestLog.setResult(responseData.getResult());
		requestLog.setErrMsg(responseData.getErrMsg());
		if (session != null) {
			requestLog.setUserId(session.getUserId()).setUserName(session.getUserName());
		}
		String logJsonString = JSONObject.toJSONString(requestLog);
		log.info("详细报文:{}", logJsonString);
		dao.insert(requestLog);
	}
}
