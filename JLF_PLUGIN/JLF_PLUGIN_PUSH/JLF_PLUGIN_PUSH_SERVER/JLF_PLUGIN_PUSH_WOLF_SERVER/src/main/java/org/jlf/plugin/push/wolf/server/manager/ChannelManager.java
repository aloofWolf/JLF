package org.jlf.plugin.push.wolf.server.manager;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.IniUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.common.util.PackageUtil;
import org.jlf.plugin.push.server.api.JLFChannelAnn;
import org.jlf.plugin.push.server.api.JLFInterAnn;
import org.jlf.plugin.push.user.api.channel.JLFChannel;
import org.jlf.plugin.push.user.api.inter.JLFInter;

/**
 * 
 * @ClassName: ChannelManager
 * @Description:��������
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class ChannelManager {

	/**
	 * �ӿڵļ���,keyΪchannelCode+"_"interCode
	 */
	public static Map<String, JLFInter<?, ?, ?>> inters = new HashMap<String, JLFInter<?, ?, ?>>();

	/**
	 * 
	 * @Title: init
	 * @Description:��ʼ��inters
	 * @param ini
	 * @throws Exception
	 */
	public static void init(IniUtil ini) throws Exception {
		Properties props = ini.getSection("channls");
		if (props != null) {
			for (Enumeration<Object> keys = props.keys(); keys.hasMoreElements();) {
				String channelCode = (String) keys.nextElement();
				String packages = props.getProperty(channelCode);
				Properties config = ini.getSection(channelCode);
				if (config == null || config.isEmpty()) {
					throw new JLFException("�������" + channelCode + "δ�ҵ�������Ϣ");
				}
				List<Class<?>> clss = PackageUtil.getPackageClss(packages);
				JLFChannel<?> channel = pasreChannel(channelCode, clss, config);
				pasreInter(channelCode, clss, channel);
			}
		} else {
			throw new JLFException("PUSH���δ����ɨ���");
		}
		
		//�������ɨ��Ľ��
		Iterator<Map.Entry<String, JLFInter<?, ?, ?>>> it = inters.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, JLFInter<?, ?, ?>> entry = it.next();
			LogUtil.get().debug("inter key:{}", entry.getKey());
			LogUtil.get().debug("inter value:{}", entry.getValue().getClass().getName());
		}
	}

	/**
	 * 
	 * @Title: pasreChannel
	 * @Description:����ÿ������
	 * @param channelCode
	 * @param clss
	 * @param config
	 * @return
	 * @throws Exception
	 */
	private static JLFChannel<?> pasreChannel(String channelCode, List<Class<?>> clss, Properties config)
			throws Exception {
		List<Class<?>> channels = new ArrayList<Class<?>>();
		for (Class<?> channelCls : clss) {
			JLFChannelAnn channelAnn = (JLFChannelAnn) channelCls.getAnnotation(JLFChannelAnn.class);
			if (channelAnn != null && channelAnn.channelCode().equals(channelCode)) {
				if (!JLFChannel.class.isAssignableFrom(channelCls)) {
					throw new JLFException("�������" + channelCode + "δ�̳и���JLFChannel");
				}
				if (channels.size() > 0) {
					throw new JLFException("�������" + channelCode + "ƥ�䵽���ʵ����");
				}
				channels.add(channelCls);
			}
		}
		if (channels.size() == 0) {
			throw new JLFException("�������" + channelCode + "δƥ�䵽ʵ������");
		}
		Class<?> channelCls = channels.get(0);
		JLFChannel<?> channel = (JLFChannel<?>) channelCls.newInstance();
		channel.initConfig(config);
		return channel;
	}

	/**
	 * 
	 * @Title: pasreInter
	 * @Description:����ÿ���ӿ�
	 * @param channelCode
	 * @param clss
	 * @param channel
	 * @throws Exception
	 */
	private static void pasreInter(String channelCode, List<Class<?>> clss, JLFChannel<?> channel) throws Exception {
		for (Class<?> interCls : clss) {
			JLFInterAnn channelAnn = (JLFInterAnn) interCls.getAnnotation(JLFInterAnn.class);
			if (channelAnn != null && channelAnn.channelCode().equals(channelCode)) {
				if (JLFInter.class.isAssignableFrom(interCls)) {
					String interCode = channelAnn.interCode();
					String intersMapKey = new StringBuffer(channelCode).append("_").append(interCode).toString();
					if (inters.get(intersMapKey) != null) {
						throw new JLFException("���ظ����������:" + channelCode + "�ͽӿڱ��:" + interCode);
					}

					Constructor<?> interConstuc = interCls.getConstructor(channel.getClass());
					JLFInter<?, ?, ?> inter = (JLFInter<?, ?, ?>) interConstuc.newInstance(channel);
					inters.put(intersMapKey, inter);
				}

			}
		}
	}

	/**
	 * 
	 * @Title: getInter
	 * @Description:����channelCode��interCode��ȡ�ӿڶ���
	 * @param channelCode
	 * @param interCode
	 * @return
	 */
	public static JLFInter<?, ?, ?> getInter(String channelCode, String interCode) {
		String intersMapKey = new StringBuffer(channelCode).append("_").append(interCode).toString();
		return inters.get(intersMapKey);
	}
}
