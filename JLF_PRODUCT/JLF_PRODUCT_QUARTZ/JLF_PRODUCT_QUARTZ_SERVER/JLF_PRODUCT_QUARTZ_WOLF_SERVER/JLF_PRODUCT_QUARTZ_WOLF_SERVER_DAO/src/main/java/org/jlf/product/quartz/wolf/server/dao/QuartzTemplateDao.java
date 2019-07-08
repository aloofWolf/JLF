package org.jlf.product.quartz.wolf.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateListReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplatePageReq;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;

/**
 * 
 * @ClassName: QuartzTemplateDao
 * @Description:QuartzTemplateDao
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzTemplateDao extends JLFMVCDao<QuartzTemplate> {

	/**
	 * 
	 * @Title: getByTemplateName
	 * @Description:����ģ�����Ʋ�ѯģ��
	 * @param templateName
	 * @return
	 */
	public QuartzTemplate getByTemplateName(String templateName) {
		String sql = new StringBuffer("select ").append(this.fieldStr).append(" from ").append(this.tableName)
				.append(" where templateName = ? and isDelete = ?").toString();
		return getUnique(sql, templateName, BooleanType.FALSE.getId());
	}
	
	/**
	 * 
	    * @Title: getByTemplateNameWithOutId
	    * @Description:��ģ�����Ʋ�ѯģ��,�ų�id
	    * @param templateName
	    * @param id
	    * @return
	 */
	public QuartzTemplate getByTemplateNameWithOutId(String templateName,Long id) {
		String sql = new StringBuffer("select ").append(this.fieldStr).append(" from ").append(this.tableName)
				.append(" where templateName = ? and id != ? and isDelete = ?").toString();
		return getUnique(sql, templateName, id,BooleanType.FALSE.getId());
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ѯ��ʱ�����ҳ
	 * @param req
	 * @return
	 */
	public JLFMVCPage<QuartzTemplate> getPage(QuartzTemplatePageReq req) {
		JLFMVCSqlBean sqlBean = getSqlBean(req);
		return this.getPage(sqlBean, req.getPages().getPageNum(), req.getPages().getPageSize());

	}

	/**
	 * 
	 * @Title: getList
	 * @Description:��ѯ��ʱ�����б�
	 * @param req
	 * @return
	 */
	public List<QuartzTemplate> getList(QuartzTemplateListReq req) {
		JLFMVCSqlBean sqlBean = getSqlBean(req);
		String sql = sqlBean.getQrySql();
		return this.getList(sql, sqlBean.getParams());

	}

	/**
	 * 
	 * @Title: getSqlBean
	 * @Description:��ȡgetSqlBean
	 * @param req
	 * @return
	 */
	public JLFMVCSqlBean getSqlBean(QuartzTemplateListReq req) {
		String selectSql = new StringBuffer("select ").append(this.fieldStr).toString();
		StringBuffer fromSql = new StringBuffer("from ").append(this.tableName).append(" where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (req.getTemplateName() != null || req.getTemplateName().length() > 0) {
			fromSql.append(" and locate(?,templateName) > 0");
			params.add(req.getTemplateName());
		}
		if (req.getEnabled() != null) {
			fromSql.append(" and enabled = ?");
			params.add(req.getEnabled().getId());
		}
		return new JLFMVCSqlBean(selectSql, fromSql.toString(), params.toArray(new Object[0]));
	}

}
