package org.jlf.plugin.aop.cglib.test;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: AopCglibDoTest
 * @Description:AopCglib处理测试
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class AopCglibDoTest implements JLFAopDo<Object> {

	@Override
	public Object doBefore(Object obj, Method method, Object[] args) throws Exception {
		if (args == null) {
			args = new Object[1];
			args[0] = "wolf";
		} else {
			args = Arrays.copyOf(args, args.length + 1);
			args[args.length - 1] = "aloof";
		}
		LogUtil.get().info("Test1方法执行前");
		return args;
	}

	@Override
	public Object doAfter(Object obj, Method method, Object[] args, Object pro) throws Exception {
		for (Object param : args) {
			LogUtil.get().info(param.toString());
		}
		return args;

	}

	@Override
	public Object[] doException(Object obj, Method method, Object[] args, Object pro) throws Exception {
		if (method.equals(TargetInstance.class.getMethod("Test3"))) {
			LogUtil.get().info("Test3执行异常");
		}
		return args;
	}

}
