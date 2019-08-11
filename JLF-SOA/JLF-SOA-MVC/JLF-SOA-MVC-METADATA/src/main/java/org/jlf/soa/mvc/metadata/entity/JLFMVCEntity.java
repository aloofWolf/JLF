package org.jlf.soa.mvc.metadata.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;

/**
 * 
 * @ClassName: JLFMVCBean
 * @Description:实体类基类
 * @author Lone Wolf
 * @date 2019年5月25日
 */
public class JLFMVCEntity implements Serializable {

	private static final long serialVersionUID = -8754870124474277604L;

	@JLFMVCBeanFieldMapped(desc = "主键",isPrimary = true)
	private Long id;
	@JLFMVCBeanFieldMapped(desc = "版本号")
	private Long version;
	@JLFMVCBeanFieldMapped(desc = "是否删除  0:已删除 1:未删除")
	private BooleanType isDelete;
	@JLFMVCBeanFieldMapped(desc = "删除编码")
	private Long deleteNum;
	@JLFMVCBeanFieldMapped(desc = "创建记录用户id")
	private Long createUserId;
	@JLFMVCBeanFieldMapped(desc = "创建时间")
	private Date createTime;
	@JLFMVCBeanFieldMapped(desc = "更新用户id")
	private Long updateUserId;
	@JLFMVCBeanFieldMapped(desc = "更新时间")
	private Date updateTime;

	private Map<String, Object> data = new HashMap<String, Object>();// 其它数据

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

	public String getStr(String key) {
		return (String) data.get(key);
	}

	public Byte getByte(String key) {
		return (byte) data.get(key);
	}

	public Short getShort(String key) {
		return (Short) data.get(key);
	}

	public Integer getInt(String key) {
		return (Integer) data.get(key);
	}

	public Long getLong(String key) {
		return (Long) data.get(key);
	}

	public BigDecimal getDouble(String key) {
		return (BigDecimal) data.get(key);
	}

	public void set(String key, Object value) {
		this.data.put(key, value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUserId == null) ? 0 : createUserId.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
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
				+ ", updateTime=" + updateTime + ", data=" + data + "]";
	}

}
