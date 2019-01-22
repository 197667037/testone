package com.test.test2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class JdbcUtil {
	private static String url = "jdbc:mysql://10.255.134.169:8066/testdb";
	private static String username = "root";
	private static String password = "123456";
	private JdbcUtil(){}
	public static Connection getConn() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws SQLException {
		Connection con = getConn();
        System.out.println(1);
		String sql = "/*!mycat:sql=SELECT 1 */call NewProc(@un)";
		CallableStatement cs = con.prepareCall(sql);
        System.out.println(2);
		boolean hadResults = cs.execute();

        Object object = cs.getObject(0);
        System.out.println(object);
//        System.out.println(resultSet.getNString("@un"));
        System.out.println(3);
		int i=0;
		while (hadResults) {
			System.out.println("result No:----"+(++i));
			ResultSet rs = cs.getResultSet();
			while (rs != null && rs.next()) {
				int id1 = rs.getInt(1);
				String name1 = rs.getString(2);
				System.out.println(id1 + ":" + name1);
			}
			hadResults = cs.getMoreResults(); //检查是否存在更多结果集
		}
//		System.out.println(getConn());
		con.close();
	}
}
