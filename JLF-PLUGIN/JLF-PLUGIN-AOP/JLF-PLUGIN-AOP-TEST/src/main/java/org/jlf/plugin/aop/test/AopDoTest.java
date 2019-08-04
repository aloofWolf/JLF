package org.jlf.plugin.aop.test;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: AopDoTest
 * @Description:Aop�������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class AopDoTest implements JLFAopDo<Object> {

	@Override
	public Object doBefore(Object obj, Method method, Object[] args) {
		if (args == null) {
			args = new Object[1];
			args[0] = "wolf";
		} else {
			args = Arrays.copyOf(args, args.length + 1);
			args[args.length - 1] = "aloof";
		}
		LogUtil.get().info("Test1����ִ��ǰ");
		return args;
	}

	@Override
	public Object doAfter(Object obj, Method method, Object[] args, Object pro) {
		for (Object param : args) {
			LogUtil.get().info(param.toString());
		}
		return args;

	}

	@Override
	public Object[] doException(Object obj, Method method, Object[] args, Object pro) {
		try {
			if (method.equals(TargetInstance.class.getMethod("Test3"))) {
				LogUtil.get().info("Test3ִ���쳣");
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return args;
	}

}
