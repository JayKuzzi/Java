package com.bb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bb.bean.Salesman;
import com.bb.dao.DBConnectionUtil;

/**
 * ���ۻ�Ա��Ϣ����ɾ�Ĳ�Ȳ�����
 * 
 * @author ����
 * 
 */
public class SalesmanDao {
	/**
	 * ����ۻ�Ա��Ϣ
	 * 
	 * @param Salesman
	 */

	public static int add(Salesman sales) {
		// �����õ��Ķ���
		PreparedStatement pstmt = null;
		// �������ݿ�����
		Connection conn = DBConnectionUtil.getConn();
		// �������ݿ���Ϣ
		String sql = "insert into salesman values(?,?,?)";
		int count = 0;
		try {
			// ��������
			pstmt = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			pstmt.setInt(1, getSalesManId());
			pstmt.setString(2, sales.getSalesManPassword());
			pstmt.setString(3, sales.getSalesManName());
			// ִ��sql���
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, conn);
		}
		return count;
	}

	/**
	 * �����ۻ�Ա��Ϣ
	 * 
	 * @param Salesman
	 */

	public static int mod(Salesman sales, String salesManName) {

		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "update salesman set SID=?,SPASSWORD=?,SNAME=? where SNAME=?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getSalesManId());
			pstmt.setString(2, sales.getSalesManPassword());
			pstmt.setString(3, sales.getSalesManName());
			pstmt.setString(4, salesManName);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, conn);
		}
		return count;
	}

	/**
	 * ɾ���ۻ�Ա��Ϣ
	 * 
	 * @param Salesman
	 */

	public static int del(String salesManName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "delete from salesman where SNAME=?;";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, salesManName);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, conn);
		}
		return count;
	}

	/**
	 * ��ѯ�����ۻ�Ա��Ϣ
	 * 
	 * @param Salesman
	 */

	public static List<Salesman> query() {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from salesman";
		ResultSet rs = null;
		List<Salesman> salesmanList = new ArrayList<Salesman>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Salesman sales = new Salesman(rs.getInt("SID"), rs.getString("SNAME"), rs.getString("SPASSWORD"));
				salesmanList.add(sales);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, rs, conn);
		}

		return salesmanList;
	}

	/**
	 * ��ѯ�ۻ�Ա��Ϣ
	 * 
	 * @param Salesman
	 */

	public static List<Salesman> getByName(String salesmanName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from salesman where SNAME like ?";
		ResultSet rs = null;
		List<Salesman> salesmanList = new ArrayList<Salesman>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + salesmanName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Salesman sales = new Salesman(rs.getInt("SID"), rs.getString("SNAME"), rs.getString("SPASSWORD"));
				salesmanList.add(sales);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, rs, conn);
		}

		return salesmanList;
	}

	/**
	 * ǰ̨������½
	 * 
	 * @param Salesman
	 */

	public static List<Salesman> login() {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from salesman";
		ResultSet rs = null;
		List<Salesman> salesmanList = new ArrayList<Salesman>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Salesman sales = new Salesman(rs.getInt("SID"), rs.getString("SNAME"), rs.getString("SPASSWORD"));
				salesmanList.add(sales);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, rs, conn);
		}

		return salesmanList;

	}

	/**
	 * ��ȡ�ۻ�Ա���ֵ,�������ۻ�Ա���ֵ�Ļ����ϼ�1��
	 * 
	 * @return
	 */
	public static int getSalesManId() {
		int maxId = 0;// ���������Ʒ���ֵ��Ĭ��ֵ��Ϊ0.
		// �����õ��Ķ���
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// �������ݿ�����
		Connection conn = DBConnectionUtil.getConn();
		// �������ݿ���Ϣ
		String sql = "select max(SID) from salesman";
		try {
			// ��������
			pstmt = conn.prepareStatement(sql);
			// ִ��sql��䲢��ȡ����ֵ
			result = pstmt.executeQuery();
			if (result.next()) {
				maxId = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, result, conn);
		}
		return maxId + 1;
	}
}
