package org.jlf.plugin.server.core.mq.activeMq.producer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jlf.common.util.SerializeUtil;
import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: Producer
 * @Description:������
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public abstract class Producer {

	/**
	 * 
	 * @Title: getDestination
	 * @Description:��ȡdestination
	 * @param session
	 * @param name
	 * @return
	 */
	public abstract Destination getDestination(Session session, String name);

	/**
	 * 
	 * @Title: getConn
	 * @Description:��ȡ����
	 * @return
	 */
	public abstract Connection getConn();

	/**
	 * 
	 * @Title: send
	 * @Description:������Ϣ
	 * @param name
	 * @param obj
	 * @
	 */
	public void send(String name, Serializable obj) {
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
				try {
					session.close();
				} catch (JMSException e) {
					e.printStackTrace();
					throw new JLFException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (JMSException e) {
					e.printStackTrace();
					throw new JLFException(e);
				}
			}

		}

	}
}
