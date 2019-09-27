package org.jlf.product.server.ops.custom;

import org.jlf.product.ops.server.api.JLFOps;
import org.jlf.product.ops.server.api.JLFOpsExecute;
import org.jlf.product.ops.server.api.JLFOpsQuery;
import org.jlf.product.server.core.ops.custom.service.OpsExecuteService;
import org.jlf.product.server.core.ops.custom.service.OpsQueryService;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;

/**
 * 
 * @ClassName: OpsCustomCore
 * @Description: OpsCustomCore
 * @author Lone Wolf
 * @date 2019Äê9ÔÂ25ÈÕ
 */
public class OpsCustomCore implements JLFOps {

	@Override
	public JLFOpsExecute getJLFOpsExecute() {
		return JLFMVCBeanContainer.get(OpsExecuteService.class);
	}

	@Override
	public JLFOpsQuery getJLFOpsQuery() {
		return JLFMVCBeanContainer.get(OpsQueryService.class);
	}

}
