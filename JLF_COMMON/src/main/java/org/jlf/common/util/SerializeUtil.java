package org.jlf.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @ClassName: SerializeUtil
 * @Description:序列化工具类
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class SerializeUtil {

	/**
	 * 
	 * @Title: serialize
	 * @Description:将对象序列化为字符串
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static <T extends Serializable> String serialize(T t) throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream;
		objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(t);
		String string = byteArrayOutputStream.toString("ISO-8859-1");
		objectOutputStream.close();
		byteArrayOutputStream.close();
		return string;
	}

	/**
	 * 
	 * @Title: serializeToObject
	 * @Description:将字符串反序列化为对象
	 * @param ser
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T serializeToObject(String ser, Class<T> cls) throws Exception {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ser.getBytes("ISO-8859-1"));
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		T t = (T) objectInputStream.readObject();
		objectInputStream.close();
		byteArrayInputStream.close();
		return t;
	}

}
