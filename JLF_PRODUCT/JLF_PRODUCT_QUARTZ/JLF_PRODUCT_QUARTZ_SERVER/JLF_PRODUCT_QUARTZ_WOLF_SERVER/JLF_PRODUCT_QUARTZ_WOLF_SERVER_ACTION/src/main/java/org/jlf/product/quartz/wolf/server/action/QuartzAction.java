package org.jlf.product.quartz.wolf.server.action;

import org.jlf.product.quartz.web.api.JLFQuartzAcion;
import org.jlf.product.quartz.web.api.JLFQuartzDefineAction;
import org.jlf.product.quartz.web.api.JLFQuartzQueryAction;

/**
 * 
 * @ClassName: QuartzAction
 * @Description:QuartzAction
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class QuartzAction implements JLFQuartzAcion {

	@Override
	public JLFQuartzDefineAction getDefineAction() {
		return new QuartzDefineAction();
	}

	@Override
	public JLFQuartzQueryAction getQueryAction() {
		return new QuartzQueryAction();
	}

}
