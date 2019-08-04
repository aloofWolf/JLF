package org.jlf.plugin.server.core.push.custom.manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.util.IniUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.common.util.PackageUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.push.server.api.JLFPushChannelAnn;
import org.jlf.plugin.push.server.api.JLFPushInterAnn;
import org.jlf.plugin.push.user.api.channel.JLFPushChannel;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;

/**
 * 
 * @ClassName: ChannelManager
 * @Description:渠道管理
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class ChannelManager {

	/**
	 * 接口的集合,key为channelCode+"_"interCode
	 */
	public static Map<String, JLFPushInter<?, ?, ?>> inters = new HashMap<String, JLFPushInter<?, ?, ?>>();

	/**
	 * 
	 * @Title: init
	 * @Description:初始化inters
	 * @param ini
	 * @
	 */
	public static void init(IniUtil ini) {
		Properties props = ini.getSection("channls");
		if (props != null) {
			for (Enumeration<Object> keys = props.keys(); keys.hasMoreElements();) {
				String channelCode = (String) keys.nextElement();
				String packages = props.getProperty(channelCode);
				Properties config = ini.getSection(channelCode);
				if (config == null || config.isEmpty()) {
					throw new JLFException("渠道编号" + channelCode + "未找到配置信息");
				}
				List<Class<?>> clss = PackageUtil.getPackageClss(packages);
				JLFPushChannel<?> channel = pasreChannel(channelCode, clss, config);
				pasreInter(channelCode, clss, channel);
			}
		} else {
			throw new JLFException("PUSH插件未配置扫描包");
		}

		// 遍历输出扫描的结果
		Iterator<Map.Entry<String, JLFPushInter<?, ?, ?>>> it = inters.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, JLFPushInter<?, ?, ?>> entry = it.next();
			LogUtil.get().debug("inter key:{}", entry.getKey());
			LogUtil.get().debug("inter value:{}", entry.getValue().getClass().getName());
		}
	}

	/**
	 * 
	 * @Title: pasreChannel
	 * @Description:解析每个渠道
	 * @param channelCode
	 * @param clss
	 * @param config
	 * @return @
	 */
	private static JLFPushChannel<?> pasreChannel(String channelCode, List<Class<?>> clss, Properties config) {
		List<Class<?>> channels = new ArrayList<Class<?>>();
		for (Class<?> channelCls : clss) {
			JLFPushChannelAnn channelAnn = (JLFPushChannelAnn) channelCls.getAnnotation(JLFPushChannelAnn.class);
			if (channelAnn != null && channelAnn.channelCode().equals(channelCode)) {
				if (!JLFPushChannel.class.isAssignableFrom(channelCls)) {
					throw new JLFException("渠道编号" + channelCode + "未继承父类JLFChannel");
				}
				if (channels.size() > 0) {
					throw new JLFException("渠道编号" + channelCode + "匹配到多个实现类");
				}
				channels.add(channelCls);
			}
		}
		if (channels.size() == 0) {
			throw new JLFException("渠道编号" + channelCode + "未匹配到实现类类");
		}
		Class<?> channelCls = channels.get(0);
		JLFPushChannel<?> channel;
		try {
			channel = (JLFPushChannel<?>) channelCls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		channel.initConfig(config);
		return channel;
	}

	/**
	 * 
	 * @Title: pasreInter
	 * @Description:解析每个接口
	 * @param channelCode
	 * @param clss
	 * @param channel
	 * @
	 */
	private static void pasreInter(String channelCode, List<Class<?>> clss, JLFPushChannel<?> channel) {
		for (Class<?> interCls : clss) {
			JLFPushInterAnn channelAnn = (JLFPushInterAnn) interCls.getAnnotation(JLFPushInterAnn.class);
			if (channelAnn != null && channelAnn.channelCode().equals(channelCode)) {
				if (JLFPushInter.class.isAssignableFrom(interCls)) {
					String interCode = channelAnn.interCode();
					String intersMapKey = new StringBuffer(channelCode).append("_").append(interCode).toString();
					if (inters.get(intersMapKey) != null) {
						throw new JLFException("有重复的渠道编号:" + channelCode + "和接口编号:" + interCode);
					}

					Constructor<?> interConstuc;
					JLFPushInter<?, ?, ?> inter;
					try {
						interConstuc = interCls.getConstructor(channel.getClass());
						inter = (JLFPushInter<?, ?, ?>) interConstuc.newInstance(channel);
					} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
						throw new JLFException(e);
					}

					inters.put(intersMapKey, inter);
				}

			}
		}
	}

	/**
	 * 
	 * @Title: getInter
	 * @Description:根据channelCode和interCode获取接口对象
	 * @param channelCode
	 * @param interCode
	 * @return
	 */
	public static JLFPushInter<?, ?, ?> getInter(String channelCode, String interCode) {
		String intersMapKey = new StringBuffer(channelCode).append("_").append(interCode).toString();
		return inters.get(intersMapKey);
	}
}
