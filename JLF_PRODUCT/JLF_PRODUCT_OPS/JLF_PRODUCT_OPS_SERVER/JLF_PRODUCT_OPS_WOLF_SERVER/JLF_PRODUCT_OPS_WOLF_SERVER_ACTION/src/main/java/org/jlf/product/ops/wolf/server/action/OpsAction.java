package org.jlf.product.ops.wolf.server.action;

import org.jlf.product.ops.web.api.JLFOpsAction;
import org.jlf.product.ops.web.api.JLFOpsDriverAction;
import org.jlf.product.ops.web.api.JLFOpsQueryAction;

/**
 * 
 * @ClassName: OpsAction
 * @Description:OpsAction
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */
public class OpsAction implements JLFOpsAction {

	@Override
	public JLFOpsDriverAction getOpsDriverAction() throws Exception {
		return new OpsDriverAction();
	}

	@Override
	public JLFOpsQueryAction getOpsQueryAction() throws Exception {
		return new OpsQueryAction();
	}

}
