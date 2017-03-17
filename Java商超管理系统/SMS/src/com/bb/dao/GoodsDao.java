package com.bb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bb.bean.Goods;
import com.bb.dao.DBConnectionUtil;

/**
 * 对商品信息的增删改查等操作。
 * 
 * @author 汪博
 * 
 */
public class GoodsDao {

	/**
	 * 添加商品信息
	 * 
	 * @param goods
	 */
	public static int add(Goods goods) {
		// 声明用到的对象
		PreparedStatement pstmt = null;
		// 创建数据库连接
		Connection conn = DBConnectionUtil.getConn();
		// 插入数据库信息
		String sql = "insert into GOODS values(?,?,?,?)";
		int count = 0;
		try {
			// 声明对象
			pstmt = conn.prepareStatement(sql);
			// 给占位符赋值
			pstmt.setInt(1, getGoodsId());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setFloat(3, goods.getGoodsPrice());
			pstmt.setInt(4, goods.getGoodsNum());
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
	 * 更改商品信息
	 * 
	 * @param goods
	 */
	public static int mod(Goods goods, String goodsName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "update GOODS set GID=?,GNAME=?,GPRICE=?,GNUM=? where GNAME=?";
		int count = 0;
		try {
			// 声明对象
			pstmt = conn.prepareStatement(sql);
			// 给占位符赋值
			pstmt.setInt(1, getGoodsId());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setFloat(3, goods.getGoodsPrice());
			pstmt.setInt(4, goods.getGoodsNum());
			pstmt.setString(5, goodsName);
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
	 * 删除商品信息
	 * 
	 * @param goods
	 */

	public static int del(String goodsName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "delete from GOODS where GNAME=?";
		int count = 0;
		try {
			// 声明对象
			pstmt = conn.prepareStatement(sql);
			// 给占位符赋值
			pstmt.setString(1, goodsName);
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
	 * 查询所有商品信息
	 * 
	 * @param goods
	 */

	public static List<Goods> query() {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from GOODS";
		ResultSet rs = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("GNUM") < 10) {
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM"),"*该商品已不足10件！");
					goodsList.add(goods);
				}else{
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM")," ");
					goodsList.add(goods);
				}
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, rs, conn);
		}

		return goodsList;
	}
	/**
	 * 按商品数量升序查询所有商品信息
	 * 
	 * @param goods
	 */

	public static List<Goods> upNumsQuery() {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from goods order by gnum";
		ResultSet rs = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("GNUM") < 10) {
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM"),"*该商品已不足10件！");
					goodsList.add(goods);
				}else{
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM")," ");
					goodsList.add(goods);
				}
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, rs, conn);
		}

		return goodsList;
	}
	
	/**
	 * 按商品数量升序查询所有商品信息
	 * 
	 * @param goods
	 */

	public static List<Goods> upPrice() {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from goods order by gprice";
		ResultSet rs = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("GNUM") < 10) {
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM"),"*该商品已不足10件！");
					goodsList.add(goods);
				}else{
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM")," ");
					goodsList.add(goods);
				}
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, rs, conn);
		}

		return goodsList;
	}
	
	/**
	 * 根据姓名查询商品信息
	 * 
	 * @param goods
	 */

	public static List<Goods> getByName(String goodsName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from GOODS where GNAME like ?";
		ResultSet rs = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + goodsName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("GNUM") < 10) {
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM"),"*该商品已不足10件！");
					goodsList.add(goods);
				}else{
					Goods goods = new Goods(rs.getInt("GID"), rs.getString("GNAME"), rs.getFloat("GPRICE"),
							rs.getInt("GNUM")," ");
					goodsList.add(goods);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, rs, conn);
		}

		return goodsList;
	}


	/**
	 * 获取商品编号值,在最大的商品编号值的基础上加1。
	 * 
	 * @return
	 */
	public static int getGoodsId() {
		int maxId = 0;// 存放最大的商品编号值，默认值设为0.
		// 声明用到的对象
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// 创建数据库连接
		Connection conn = DBConnectionUtil.getConn();
		// 插入数据库信息
		String sql = "select max(GID) from GOODS";
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
