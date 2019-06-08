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
 * @Description:渠道管理
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class ChannelManager {

	/**
	 * 接口的集合,key为channelCode+"_"interCode
	 */
	public static Map<String, JLFInter<?, ?, ?>> inters = new HashMap<String, JLFInter<?, ?, ?>>();

	/**
	 * 
	 * @Title: init
	 * @Description:初始化inters
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
					throw new JLFException("渠道编号" + channelCode + "未找到配置信息");
				}
				List<Class<?>> clss = PackageUtil.getPackageClss(packages);
				JLFChannel<?> channel = pasreChannel(channelCode, clss, config);
				pasreInter(channelCode, clss, channel);
			}
		} else {
			throw new JLFException("PUSH插件未配置扫描包");
		}
		
		//遍历输出扫描的结果
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
	 * @Description:解析每个渠道
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
		JLFChannel<?> channel = (JLFChannel<?>) channelCls.newInstance();
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
						throw new JLFException("有重复的渠道编号:" + channelCode + "和接口编号:" + interCode);
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
	 * @Description:根据channelCode和interCode获取接口对象
	 * @param channelCode
	 * @param interCode
	 * @return
	 */
	public static JLFInter<?, ?, ?> getInter(String channelCode, String interCode) {
		String intersMapKey = new StringBuffer(channelCode).append("_").append(interCode).toString();
		return inters.get(intersMapKey);
	}
}
