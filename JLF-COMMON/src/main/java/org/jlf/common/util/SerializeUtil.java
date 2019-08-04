package org.jlf.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @ClassName: SerializeUtil
 * @Description:���л�������
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class SerializeUtil {

	/**
	 * 
	 * @Title: serialize
	 * @Description:���������л�Ϊ�ַ���
	 * @param t
	 * @return
	 */
	public static <T extends Serializable> String serialize(T t) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		String string = null;
		try {
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(t);
			string = byteArrayOutputStream.toString("ISO-8859-1");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayOutputStream.close();
				objectOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return string;
	}

	/**
	 * 
	 * @Title: serializeToObject
	 * @Description:���ַ��������л�Ϊ����
	 * @param ser
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T serializeToObject(String ser) {
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		T t = null;
		try {
			byteArrayInputStream = new ByteArrayInputStream(ser.getBytes("ISO-8859-1"));
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			t = (T) objectInputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
				byteArrayInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return t;
	}

}
