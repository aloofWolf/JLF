package org.jlf.plugin.dbPool.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class MyTest {
	
	static String sql1 = "select id as jobId,version as jobVersion from QuartzJob as job";
	
	public static void main(String[] args) throws Exception{
		 Class.forName("com.mysql.jdbc.Driver");
         //2.获取数据库连接
		 Connection  conn=DriverManager.getConnection("jdbc:mysql://39.108.166.34:3306/wolf1?useOldAliasMetadataBehavior=false", "root", "yun4xue2wen2");
		 PreparedStatement ps = conn.prepareStatement(sql1);
		 ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 ResultSetMetaData meta = rs.getMetaData();
			 int columnCount = meta.getColumnCount();
			 for (int i = 1; i <= columnCount; i++) {
				 String table1 = meta.getTableName(i);
				 String field1 = meta.getColumnName(i);
				 
				// String table2 = meta.getColumnTypeName(i);
				 String field2 = meta.getColumnLabel(i);
				 
				 Object value = rs.getObject(field2);
				 System.out.println(table1);
				 System.out.println(field1);
				// System.out.println(table2);
				 System.out.println(field2);
				 System.out.println(value);
			 }
			}
	}

}
