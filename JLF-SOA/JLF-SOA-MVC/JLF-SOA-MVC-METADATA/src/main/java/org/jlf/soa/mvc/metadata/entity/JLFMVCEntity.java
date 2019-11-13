package org.jlf.soa.mvc.metadata.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;

/**
 * 
 * @ClassName: JLFMVCBean
 * @Description:ʵ�������
 * @author Lone Wolf
 * @date 2019��5��25��
 */
public class JLFMVCEntity implements Serializable {

	private static final long serialVersionUID = -8754870124474277604L;

	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "����", isPrimary = true)
	private Long id;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "�汾��", defaultValue = "0")
	private Long version;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "�Ƿ�ɾ��  0:��ɾ�� 1:δɾ��", defaultValue = "1")
	private BooleanType isDelete;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "ɾ������", defaultValue = "-1")
	private Long deleteNum;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "������¼�û�id")
	private Long createUserId;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "����ʱ��")
	private Date createTime;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "�����û�id")
	private Long updateUserId;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "����ʱ��")
	private Date updateTime;

	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(isSkipMapped = true)

	/**
	 * �ڻ����л�ȡ����ʱ,������ִ��ֶ�Ϊtrue,����ȥ���ݿ��в�ѯ
	 */
	private Boolean isReLoad = false;
	/**
	 * ���ֶ����뻺�漯��ʱʱ��,�жϻ����д洢�Ķ����Ƿ�Ϊ������,�������ݿ�ͬ��
	 */
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(isSkipMapped = true)
	private Boolean isBlack = false;

	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(isSkipMapped = true)
	private Map<Class<? extends JLFMVCEntity>, JLFMVCEntity> relationMap = new HashMap<Class<? extends JLFMVCEntity>, JLFMVCEntity>();// ��������

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public BooleanType getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(BooleanType isDelete) {
		this.isDelete = isDelete;
	}

	public Long getDeleteNum() {
		return deleteNum;
	}

	public void setDeleteNum(Long deleteNum) {
		this.deleteNum = deleteNum;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@SuppressWarnings("unchecked")
	public <ENTITY extends JLFMVCEntity> ENTITY get(Class<ENTITY> entityCls) {
		return (ENTITY) relationMap.get(entityCls);
	}

	public <ENTITY extends JLFMVCEntity> void set(Class<? extends JLFMVCEntity> entityCls, JLFMVCEntity entity) {
		relationMap.put(entityCls, entity);
	}

	public Boolean getIsReLoad() {
		return isReLoad;
	}

	public void setIsReLoad(Boolean isReLoad) {
		this.isReLoad = isReLoad;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUserId == null) ? 0 : createUserId.hashCode());
		result = prime * result + ((relationMap == null) ? 0 : relationMap.hashCode());
		result = prime * result + ((deleteNum == null) ? 0 : deleteNum.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUserId == null) ? 0 : updateUserId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JLFMVCEntity other = (JLFMVCEntity) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUserId == null) {
			if (other.createUserId != null)
				return false;
		} else if (!createUserId.equals(other.createUserId))
			return false;
		if (relationMap == null) {
			if (other.relationMap != null)
				return false;
		} else if (!relationMap.equals(other.relationMap))
			return false;
		if (deleteNum == null) {
			if (other.deleteNum != null)
				return false;
		} else if (!deleteNum.equals(other.deleteNum))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUserId == null) {
			if (other.updateUserId != null)
				return false;
		} else if (!updateUserId.equals(other.updateUserId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JLFMVCBean [id=" + id + ", version=" + version + ", isDelete=" + isDelete + ", deleteNum=" + deleteNum
				+ ", createUserId=" + createUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", relationMap=" + relationMap + "]";
	}

}
