package org.jlf.plugin.excel.server.api;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @ClassName: JLFExcelCell
 * @Description:ExcelCellApi
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public interface JLFExcelCell {

	/**
	 * 
	 * @Title: getStrValue
	 * @Description:获取strValue
	 * @return
	 */
	public String getStrValue();

	/**
	 * 
	 * @Title: getIntValue
	 * @Description:获取intValue
	 * @return
	 */
	public Integer getIntValue();

	/**
	 * 
	 * @Title: getLongValue
	 * @Description:获取longValue
	 * @return
	 */
	public Long getLongValue();

	/**
	 * 
	 * @Title: getDoubleValue
	 * @Description:获取doubleValue
	 * @return
	 */
	public Double getDoubleValue();

	/**
	 * 
	 * @Title: getFloatValue
	 * @Description:获取floatValue
	 * @return
	 */
	public Float getFloatValue();

	/**
	 * 
	 * @Title: getShortValue
	 * @Description:获取shortValue
	 * @return
	 */
	public Short getShortValue();

	/**
	 * 
	 * @Title: getByteValue
	 * @Description:获取byteValue
	 * @return
	 */
	public Byte getByteValue();

	/**
	 * 
	 * @Title: getDateValue
	 * @Description:获取dateValue
	 * @param format
	 * @return
	 */
	public Date getDateValue(String format);

	/**
	 * 
	 * @Title: getBooleanValue
	 * @Description:获取booleanValue
	 * @return
	 */
	public Boolean getBooleanValue();

	/**
	 * 
	 * @Title: getBigDecimalValue
	 * @Description:获取bigDecimalValue
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
