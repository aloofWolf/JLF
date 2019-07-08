package org.jlf.test.common.util;

import org.jlf.common.util.ClassLoaderUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: ClassLoaderUtilTest
 * @Description:ClassLoaderUtil≤‚ ‘
 * @author Lone Wolf
 * @date 2019ƒÍ7‘¬4»’
 */
public class ClassLoaderUtilTest {

	/**
	 * 
	 * @Title: getOutCls
	 * @Description:getOutCls≤‚ ‘
	 */
	@Test
	public void getOutCls() {
		String path = "jar:file:/aop_cglib.jar!/";
		Class<?> cls = ClassLoaderUtil.getOutCls(path, "org.jlf.plugin.aop.cglib.server.AopCglibServer");
		System.out.println(cls.getName());
	}

}
