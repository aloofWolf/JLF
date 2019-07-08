package org.jlf.plugin.excel.server.api;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @ClassName: JLFExcelCell
 * @Description:ExcelCellApi
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public interface JLFExcelCell {

	/**
	 * 
	 * @Title: getStrValue
	 * @Description:��ȡstrValue
	 * @return
	 */
	public String getStrValue();

	/**
	 * 
	 * @Title: getIntValue
	 * @Description:��ȡintValue
	 * @return
	 */
	public Integer getIntValue();

	/**
	 * 
	 * @Title: getLongValue
	 * @Description:��ȡlongValue
	 * @return
	 */
	public Long getLongValue();

	/**
	 * 
	 * @Title: getDoubleValue
	 * @Description:��ȡdoubleValue
	 * @return
	 */
	public Double getDoubleValue();

	/**
	 * 
	 * @Title: getFloatValue
	 * @Description:��ȡfloatValue
	 * @return
	 */
	public Float getFloatValue();

	/**
	 * 
	 * @Title: getShortValue
	 * @Description:��ȡshortValue
	 * @return
	 */
	public Short getShortValue();

	/**
	 * 
	 * @Title: getByteValue
	 * @Description:��ȡbyteValue
	 * @return
	 */
	public Byte getByteValue();

	/**
	 * 
	 * @Title: getDateValue
	 * @Description:��ȡdateValue
	 * @param format
	 * @return
	 */
	public Date getDateValue(String format);

	/**
	 * 
	 * @Title: getBooleanValue
	 * @Description:��ȡbooleanValue
	 * @return
	 */
	public Boolean getBooleanValue();

	/**
	 * 
	 * @Title: getBigDecimalValue
	 * @Description:��ȡbigDecimalValue
	 * @return
	 */
	public BigDecimal getBigDecimalValue();

	/**
	 * 
	 * @Title: setStrValue
	 * @Description:setStrValue
	 * @param value
	 */
	public void setStrValue(String value);

	/**
	 * 
	 * @Title: setIntValue
	 * @Description:setIntValue
	 * @param value
	 */
	public void setIntValue(Integer value);

	/**
	 * 
	 * @Title: setLongValue
	 * @Description:setLongValue
	 * @param value
	 */
	public void setLongValue(Long value);

	/**
	 * 
	 * @Title: setDoubleValue
	 * @Description:setDoubleValue
	 * @param value
	 */
	public void setDoubleValue(Double value);

	/**
	 * 
	 * @Title: setFloatValue
	 * @Description:setFloatValue
	 * @param value
	 */
	public void setFloatValue(Float value);

	/**
	 * 
	 * @Title: setShortValue
	 * @Description:setShortValue
	 * @param value
	 */
	public void setShortValue(Short value);

	/**
	 * 
	 * @Title: setByteValue
	 * @Description:setByteValue
	 * @param value
	 */
	public void setByteValue(Byte value);

	/**
	 * 
	 * @Title: setDateValue
	 * @Description:setDateValue
	 * @param value
	 */
	public void setDateValue(Date value);

	/**
	 * 
	 * @Title: setBooleanValue
	 * @Description:setBooleanValue
	 * @param value
	 */
	public void setBooleanValue(Boolean value);

	/**
	 * 
	 * @Title: setBigDecimalValue
	 * @Description:setBigDecimalValue
	 * @param value
	 */
	public void setBigDecimalValue(BigDecimal value);

}
