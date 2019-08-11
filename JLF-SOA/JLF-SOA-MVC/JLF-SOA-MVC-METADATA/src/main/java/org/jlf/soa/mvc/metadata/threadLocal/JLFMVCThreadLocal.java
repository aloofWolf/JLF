package org.jlf.soa.mvc.metadata.threadLocal;

/**
 * 
 * @ClassName: JLFMVCThreadLocal
 * @Description:��ǰ�̵߳�ThreadLocal����
 * @author Lone Wolf
 * @date 2019��6��1��
 */
public class JLFMVCThreadLocal {

	/**
	 * ��ǰ�߳��Լ����̵߳�dbName
	 */
	private static InheritableThreadLocal<String> dbName = new InheritableThreadLocal<String>();// ��ǰsession�����ʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡ��ǰ�̵߳�dbName
	 * @return
	 */
	public static String getDbName() {
		return dbName.get();
	}

	/**
	 * 
	 * @Title: set
	 * @Description:���õ�ǰ�̵߳�dbName
	 * @param value
	 */
	public static void setDbName(String value) {
		dbName.set(value);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ����ǰ�̵߳�dbName
	 */
	public static void deleteDbName() {
		dbName.remove();
	}
}
