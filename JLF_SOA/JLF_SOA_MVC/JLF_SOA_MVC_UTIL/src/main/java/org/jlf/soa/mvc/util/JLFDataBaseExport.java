package org.jlf.soa.mvc.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.EnumUtil;
import org.jlf.common.util.PackageUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.common.util.StringUtil;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;
import org.jlf.soa.mvc.metadata.export.JLFMVCFieldMetadata;
import org.jlf.soa.mvc.metadata.export.JLFMVCTableMetadata;
import org.jlf.soa.mvc.metadata.export.JLFMVCTablesMetadata;

/**
 * 
 * @ClassName: JLFDataBaseExport
 * @Description:JLFDataBase��������,
 * ���ཫbeanת�ɴ�������metadata, Ȼ�󵼳�excel����͵���sql�ű����඼���ɴ��� ,�ֱ�metadata������excel��sql�ű�
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class JLFDataBaseExport {

	/**
	 * 
	 * @Title: genDataBaseMetadata
	 * @Description:����������beanʵ��ת��JLFMVCTablesMetadata
	 * @param packageName
	 * @return
	 */
	public static JLFMVCTablesMetadata genDataBaseMetadata(String packageName) {
		List<JLFMVCTableMetadata> tables = new ArrayList<JLFMVCTableMetadata>();
		List<Class<?>> clss = PackageUtil.getPackageClss(packageName);
		for (Class<?> beanCls : clss) {
			if (!JLFMVCBean.class.isAssignableFrom(beanCls)) {
				continue;
			}
			JLFMVCBeanTableMapped tableMapped = (JLFMVCBeanTableMapped) beanCls
					.getAnnotation(JLFMVCBeanTableMapped.class);
			JLFMVCTableMetadata table = parseEntity(beanCls, tableMapped);
			tables.add(table);
		}
		return new JLFMVCTablesMetadata(tables);
	}

	/**
	 * 
	 * @Title: parseEntity
	 * @Description:����ÿ��bean
	 * @param beanCls
	 * @param tableMapped
	 * @return
	 */
	private static JLFMVCTableMetadata parseEntity(Class<?> beanCls, JLFMVCBeanTableMapped tableMapped) {
		JLFMVCTableMetadata table = new JLFMVCTableMetadata();
		String tableName = (tableMapped == null ? beanCls.getSimpleName() : tableMapped.tableName());
		String desc = (tableMapped == null ? null : tableMapped.tableName());
		if (tableName == null || tableName.length() == 0) {
			tableName = beanCls.getSimpleName();
		}
		table.setTableName(tableName);
		table.setDesc(desc);
		List<Field> fields = ReflectUtil.getAllFields(beanCls);
		for (Field field : fields) {
			String fieldName = field.getName();
			if (fieldName.equals("serialVersionUID") || fieldName.equals("data")) {
				continue;
			}
			JLFMVCBeanFieldMapped fieldMapped = field.getAnnotation(JLFMVCBeanFieldMapped.class);
			if (fieldMapped != null && fieldMapped.isSkipMapped()) {
				continue;
			}
			JLFMVCFieldMetadata fieldMatadata = parseField(field, fieldMapped);
			table.setField(fieldMatadata);
		}
		return table;

	}

	/**
	 * 
	 * @Title: parseField
	 * @Description:����bean�е�ÿ���ֶ�
	 * @param field
	 * @param fieldMapped
	 * @return
	 */
	private static JLFMVCFieldMetadata parseField(Field field, JLFMVCBeanFieldMapped fieldMapped) {
		JLFMVCFieldMetadata fieldMatadata = new JLFMVCFieldMetadata();

		fieldMatadata.setFieldName(field.getName());
		fieldMatadata.setPrimary(fieldMapped == null ? JLFMVCBeanFieldMapped.isPrimary : fieldMapped.isPrimary());
		fieldMatadata.setNotNull(fieldMapped == null ? JLFMVCBeanFieldMapped.isNotNull : fieldMapped.isNotNull());
		fieldMatadata.setUnique(fieldMapped == null ? JLFMVCBeanFieldMapped.isUnique : fieldMapped.isUnique());
		fieldMatadata.setUniqueName(fieldMapped == null ? null : fieldMapped.uniqueName());
		fieldMatadata.setJoinUniqueField(fieldMapped == null ? null : fieldMapped.joinUniqueField());
		fieldMatadata.setDefaultValue(fieldMapped == null ? null : fieldMapped.defaultValue());
		fieldMatadata.setDesc(fieldMapped == null ? null : fieldMapped.desc());
		parseFieldType(field, fieldMapped, fieldMatadata);
		return fieldMatadata;
	}

	/**
	 * 
	 * @Title: parseFieldType
	 * @Description:����ÿ���ֶε�����
	 * @param field
	 * @param fieldMapped
	 * @param fieldMatadata
	 */
	@SuppressWarnings("unchecked")
	private static void parseFieldType(Field field, JLFMVCBeanFieldMapped fieldMapped,
			JLFMVCFieldMetadata fieldMatadata) {
		Class<?> fieldType = field.getType();
		String dataType = null;
		if (Integer.class.equals(fieldType)) {
			dataType = new StringBuffer("int(").append(fieldMapped.intLength()).append(")").toString();
		} else if (Long.class.equals(fieldType)) {
			dataType = new StringBuffer("bigint(").append(fieldMapped.intLength()).append(")").toString();
		} else if (Double.class.equals(fieldType) || Float.class.equals(fieldType)
				|| BigDecimal.class.equals(fieldType)) {
			Integer[] arr = Arrays.stream(fieldMapped.doubleLenth()).boxed().toArray(Integer[]::new);
			dataType = new StringBuffer("double(").append(StringUtil.arrToStr(arr)).append(")").toString();
		} else if (Date.class.equals(fieldType)) {
			dataType = "datetime";
		} else if (String.class.equals(fieldType)) {
			dataType = new StringBuffer("varchar(").append(fieldMapped.strLength()).append(")").toString();
		} else if (IEnum.class.isAssignableFrom(fieldType)) {
			dataType = "smallint(2)";
			fieldMatadata.setCheck(EnumUtil.getAllIds((Class<? extends IEnum>) fieldType));
		}
		fieldMatadata.setDataType(dataType);
	}
}
