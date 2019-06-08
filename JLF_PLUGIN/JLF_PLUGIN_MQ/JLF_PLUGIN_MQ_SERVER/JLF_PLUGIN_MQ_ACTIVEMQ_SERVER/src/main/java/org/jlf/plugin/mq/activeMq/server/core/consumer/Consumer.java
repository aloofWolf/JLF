package org.jlf.plugin.mq.activeMq.server.core.consumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

public abstract class Consumer {

	private Connection conn;
	private Session session;
	private MessageConsumer consumer;

	/**
	 * 
	 * @Title: getName
	 * @Description:��ǰ������������
	 * @return
	 */
	public abstract String getName();

	/**
	 * 
	 * @Title: getDestination
	 * @Description:��ȡdestination
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public abstract Destination getDestination(Session session) throws Exception;
	
	/**
	 * 
	 * @Title: getConn
	 * @Description:��ȡ����
	 * @return
	 */
	public abstract Connection getConn() throws Exception;

	/**
	 * 
	 * @Title: process
	 * @Description:������Ϣ��Ĵ�����
	 * @param result
	 * @throws Exception
	 */
	public abstract void process(String result) throws Exception;

	/**
	 * 
	 * @Title: getConsumer
	 * @Description:��ȡconsumer
	 * @return
	 * @throws Exception
	 */
	public MessageConsumer getConsumer() throws Exception {
		conn = getConn();
		conn.start();
		// ��ʹ������
		// ���ÿͻ���ǩ��ģʽ
		this.session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = getDestination(session);
		this.consumer = session.createConsumer(destination);
		return consumer;
	}

	/**
	 * 
	 * @Title: start
	 * @Description:��������
	 * @throws Exception
	 */
	public void start() throws Exception {
		MessageConsumer consumer = getConsumer();
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				try {
					process(textMessage.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * @Title: stop
	 * @Description:�رռ���
	 * @throws Exception
	 */
	public void stop() throws Exception {
		if (consumer != null) {
			consumer.close();
		}
		if (session != null) {
			session.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

}
