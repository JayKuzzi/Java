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
 * 对售货员信息的增删改查等操作。
 * 
 * @author 汪博
 * 
 */
public class SalesmanDao {
	/**
	 * 添加售货员信息
	 * 
	 * @param Salesman
	 */

	public static int add(Salesman sales) {
		// 声明用到的对象
		PreparedStatement pstmt = null;
		// 创建数据库连接
		Connection conn = DBConnectionUtil.getConn();
		// 插入数据库信息
		String sql = "insert into salesman values(?,?,?)";
		int count = 0;
		try {
			// 声明对象
			pstmt = conn.prepareStatement(sql);
			// 给占位符赋值
			pstmt.setInt(1, getSalesManId());
			pstmt.setString(2, sales.getSalesManPassword());
			pstmt.setString(3, sales.getSalesManName());
			// 执行sql语句
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, conn);
		}
		return count;
	}

	/**
	 * 更改售货员信息
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
	 * 删除售货员信息
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
	 * 查询所有售货员信息
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
	 * 查询售货员信息
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
	 * 前台收银登陆
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
	 * 获取售货员编号值,在最大的售货员编号值的基础上加1。
	 * 
	 * @return
	 */
	public static int getSalesManId() {
		int maxId = 0;// 存放最大的商品编号值，默认值设为0.
		// 声明用到的对象
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// 创建数据库连接
		Connection conn = DBConnectionUtil.getConn();
		// 插入数据库信息
		String sql = "select max(SID) from salesman";
		try {
			// 声明对象
			pstmt = conn.prepareStatement(sql);
			// 执行sql语句并获取返回值
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
