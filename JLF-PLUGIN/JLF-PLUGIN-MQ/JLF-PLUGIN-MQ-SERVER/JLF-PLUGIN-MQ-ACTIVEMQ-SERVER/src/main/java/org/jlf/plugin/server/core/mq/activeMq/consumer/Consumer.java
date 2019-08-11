package org.jlf.plugin.server.core.mq.activeMq.consumer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jlf.common.util.SerializeUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.threadPool.JLFThreadPoolClient;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: Consumer
 * @Description:������
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public abstract class Consumer<T extends Serializable> {

	private Connection conn;
	private Session session;
	private MessageConsumer consumer;
	private JLFThreadPoolSubmit<T> threadPoolSubmit;
	
	public Consumer(JLFThreadPoolSubmit<T> threadPoolSubmit){
		this.threadPoolSubmit = threadPoolSubmit;
	}

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
	 * @return @
	 */
	public abstract Destination getDestination(Session session);

	/**
	 * 
	 * @Title: getConn
	 * @Description:��ȡ����
	 * @return
	 */
	public abstract Connection getConn();

	/**
	 * 
	 * @Title: process
	 * @Description:������Ϣ��Ĵ�����
	 * @param result
	 * @
	 */
	public void process(String result){
		T bean = SerializeUtil.serializeToObject(result);
		JLFThreadPoolClient.get().submit(bean, threadPoolSubmit);
	}

	/**
	 * 
	 * @Title: getConsumer
	 * @Description:��ȡconsumer
	 * @return @
	 */
	public MessageConsumer getConsumer() {
		conn = getConn();
		try {
			conn.start();
			this.session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = getDestination(session);
			this.consumer = session.createConsumer(destination);
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return consumer;
	}

	/**
	 * 
	 * @Title: start
	 * @Description:�������� @
	 */
	public void start() {
		MessageConsumer consumer = getConsumer();
		try {
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
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: stop
	 * @Description:�رռ��� @
	 */
	public void stop() {
		if (consumer != null) {
			try {
				consumer.close();
			} catch (JMSException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
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
