package com.bb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * �������ݿ����ù��߷���
 * 
 * @author ����
 * 
 */
public class DBConnectionUtil {
	/**
	 * ��ȡ���ݿ������
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		// String className = "oracle.jdbc.driver.OracleDriver";
		// String username = "scott";
		// String password = "tiger";
		// String url = "jdbc:oracle:thin:@localhost:1521:inspur";
		String className = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/shopdb";
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر���Դ
	 * 
	 * @param pstmt
	 * @param conn
	 */
	public static void close(PreparedStatement pstmt, Connection conn) {

		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	/**
	 * �ر���Դ
	 * 
	 * @param pstmt
	 * @param rs
	 * @param conn
	 */
	public static void close(PreparedStatement pstmt, ResultSet rs,
			Connection conn) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
