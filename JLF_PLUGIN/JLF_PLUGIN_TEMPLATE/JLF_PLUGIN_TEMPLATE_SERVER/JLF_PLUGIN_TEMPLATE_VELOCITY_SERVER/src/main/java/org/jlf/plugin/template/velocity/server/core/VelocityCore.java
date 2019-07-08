package org.jlf.plugin.template.velocity.server.core;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.jlf.common.util.FileUtil;
import org.jlf.plugin.template.server.api.JLFTemplate;

/**
 * 
 * @ClassName: VelocityCore
 * @Description:VelocityCore
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class VelocityCore implements JLFTemplate {

	private static final Properties prop = new Properties();
	static {
		prop.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
		prop.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
	}

	@Override
	public String getStringFromJar(String templateFilePath, Map<String, Object> map, String contextName,
			String jarPath) {
		VelocityEngine ve = new VelocityEngine(prop);
		ve.setProperty("RuntimeConstants.RESOURCE_LOADER", "jar");
		ve.setProperty("jar.resource.loader.class", "org.apache.velocity.runtime.resource.loader.JarResourceLoader");
		ve.setProperty("jar.resource.loader.path", jarPath);
		return getString(ve, templateFilePath, map, contextName);
	}

	@Override
	public String getStringFromJar(String templateFilePath, Object obj, String contextName, String jarPath) {
		VelocityEngine ve = new VelocityEngine(prop);
		ve.setProperty("RuntimeConstants.RESOURCE_LOADER", "jar");
		ve.setProperty("jar.resource.loader.class", "org.apache.velocity.runtime.resource.loader.JarResourceLoader");
		ve.setProperty("jar.resource.loader.path", jarPath);
		return getString(ve, templateFilePath, obj, contextName);
	}

	@Override
	public String getStringFromClassPath(String templateFilePath, Map<String, Object> map, String contextName) {
		VelocityEngine ve = new VelocityEngine(prop);
		ve.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		return getString(ve, templateFilePath, map, contextName);
	}

	@Override
	public String getStringFromClassPath(String templateFilePath, Object obj, String contextName) {
		VelocityEngine ve = new VelocityEngine(prop);
		ve.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		return getString(ve, templateFilePath, obj, contextName);
	}

	@Override
	public String getStringFromAbsolutePath(String templateFilePath, Map<String, Object> map, String contextName) {
		VelocityEngine ve = new VelocityEngine(prop);
		ve.setProperty("VelocityEngine.FILE_RESOURCE_LOADER_PATH", FileUtil.getDirByFilePath(templateFilePath));
		return getString(ve, FileUtil.getFileNameByFilePath(templateFilePath), map, contextName);
	}

	@Override
	public String getStringFromAbsolutePath(String templateFilePath, Object obj, String contextName) {
		VelocityEngine ve = new VelocityEngine(prop);
		ve.setProperty("VelocityEngine.FILE_RESOURCE_LOADER_PATH", FileUtil.getDirByFilePath(templateFilePath));
		return getString(ve, FileUtil.getFileNameByFilePath(templateFilePath), obj, contextName);
	}

	/**
	 * 
	 * @Title: getString
	 * @Description:根据模板文件生成字符串
	 * @param ve
	 * @param templateFilePath
	 * @param obj
	 * @param contextName
	 * @return
	 */
	private String getString(VelocityEngine ve, String templateFilePath, Object obj, String contextName) {
		VelocityContext context = new VelocityContext();
		context.put(contextName, obj);
		StringWriter writer = new StringWriter();
		ve.mergeTemplate(templateFilePath, "UTF-8", context, writer);
		return writer.toString();
	}

}
