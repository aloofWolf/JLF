package org.jlf.plugin.mq.activeMq.server.core.producer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jlf.common.util.SerializeUtil;

/**
 * 
 * @ClassName: Producer
 * @Description:生产者
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public abstract class Producer {

	/**
	 * 
	 * @Title: getDestination
	 * @Description:获取destination
	 * @param session
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public abstract Destination getDestination(Session session, String name) throws Exception;

	/**
	 * 
	 * @Title: getConn
	 * @Description:获取连接
	 * @return
	 */
	public abstract Connection getConn() throws Exception;

	/**
	 * 
	 * @Title: send
	 * @Description:发送消息
	 * @param name
	 * @param obj
	 * @throws Exception
	 */
	public void send(String name, Serializable obj) throws Exception {
		Connection conn = null;
		Session session = null;
		try {
			conn = getConn();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(null);
			Destination destination = getDestination(session, name);
			TextMessage textMessage = session.createTextMessage(SerializeUtil.serialize(obj));
			producer.send(destination, textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			if (conn != null) {
				conn.close();
			}

		}

	}
}
