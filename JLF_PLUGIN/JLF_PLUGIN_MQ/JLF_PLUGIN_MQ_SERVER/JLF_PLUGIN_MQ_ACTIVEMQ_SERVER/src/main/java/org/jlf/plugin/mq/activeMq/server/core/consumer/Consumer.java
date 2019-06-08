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
	 * @Description:当前主题或队列名称
	 * @return
	 */
	public abstract String getName();

	/**
	 * 
	 * @Title: getDestination
	 * @Description:获取destination
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public abstract Destination getDestination(Session session) throws Exception;
	
	/**
	 * 
	 * @Title: getConn
	 * @Description:获取连接
	 * @return
	 */
	public abstract Connection getConn() throws Exception;

	/**
	 * 
	 * @Title: process
	 * @Description:接收消息后的处理方法
	 * @param result
	 * @throws Exception
	 */
	public abstract void process(String result) throws Exception;

	/**
	 * 
	 * @Title: getConsumer
	 * @Description:获取consumer
	 * @return
	 * @throws Exception
	 */
	public MessageConsumer getConsumer() throws Exception {
		conn = getConn();
		conn.start();
		// 不使用事务
		// 设置客户端签收模式
		this.session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = getDestination(session);
		this.consumer = session.createConsumer(destination);
		return consumer;
	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动监听
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
	 * @Description:关闭监听
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
