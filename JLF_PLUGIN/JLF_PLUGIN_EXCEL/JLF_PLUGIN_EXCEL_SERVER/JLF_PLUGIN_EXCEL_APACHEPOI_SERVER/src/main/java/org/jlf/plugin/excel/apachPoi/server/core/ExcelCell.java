package org.jlf.plugin.excel.apachPoi.server.core;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.jlf.common.util.DateUtil;
import org.jlf.plugin.excel.server.api.JLFExcelCell;

/**
 * 
 * @ClassName: ExcelCell
 * @Description:JLFExcelCell实现
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class ExcelCell implements JLFExcelCell {

	private HSSFCell cell;

	protected ExcelCell(HSSFCell cell) {
		this.cell = cell;
	}

	@Override
	public String getStrValue() {
		return cell.toString();
	}

	@Override
	public Integer getIntValue() {
		String value = cell.toString();
		return Integer.parseInt(value);
	}

	@Override
	public Long getLongValue() {
		String value = cell.toString();
		return Long.parseLong(value);
	}

	@Override
	public Double getDoubleValue() {
		String value = cell.toString();
		return Double.parseDouble(value);
	}

	@Override
	public Float getFloatValue() {
		String value = cell.toString();
		return Float.parseFloat(value);
	}

	@Override
	public Short getShortValue() {
		String value = cell.toString();
		return Short.parseShort(value);
	}

	@Override
	public Byte getByteValue() {
		String value = cell.toString();
		return Byte.parseByte(value);
	}

	@Override
	public Date getDateValue(String format) {
		String value = cell.toString();
		return DateUtil.formatDate(value, format);
	}

	@Override
	public Boolean getBooleanValue() {
		String value = cell.toString();
		return Boolean.parseBoolean(value);
	}

	@Override
	public BigDecimal getBigDecimalValue() {
		String value = cell.toString();
		return new BigDecimal(value);
	}

	@Override
	public void setStrValue(String value) {
		cell.setCellValue(value);

	}

	@Override
	public void setIntValue(Integer value) {
		cell.setCellValue(value);

	}

	@Override
	public void setLongValue(Long value) {
		cell.setCellValue(value);

	}

	@Override
	public void setDoubleValue(Double value) {
		cell.setCellValue(value);

	}

	@Override
	public void setFloatValue(Float value) {
		cell.setCellValue(value);

	}

	@Override
	public void setShortValue(Short value) {
		cell.setCellValue(value);

	}

	@Override
	public void setByteValue(Byte value) {
		cell.setCellValue(value);

	}

	@Override
	public void setDateValue(Date value) {
		cell.setCellValue(value);

	}

	@Override
	public void setBooleanValue(Boolean value) {
		cell.setCellValue(value);

	}

	@Override
	public void setBigDecimalValue(BigDecimal value) {
		cell.setCellValue(value.doubleValue());

	}

}
