package com.bb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bb.bean.Goods;
import com.bb.bean.TodaySold;
import com.bb.dao.DBConnectionUtil;
/**
 * 销售信息操作。
 * 
 * @author 汪博
 * 
 */
public class GSalesDao {

	/**
	 * 模糊查询商品列表
	 */
	public static List<Goods> vagueQuery(String vagueName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "select * from GOODS where GNAME like ?";
		ResultSet rs = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + vagueName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("GNUM") < 10){
					Goods goods = new Goods(rs.getString(2), rs.getFloat(3), +rs.getInt(4),"*该商品已不足10件！");
					goodsList.add(goods);
				}else{
					Goods goods = new Goods(rs.getString(2), rs.getFloat(3), +rs.getInt(4),"  ");
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
	 * 增加销售商品在销售商品表
	 */
	public static void addSalesGoods(Goods goods, int buyNums, int salesmanID) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "insert into GSALES values(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getSalesGoodsId());
			pstmt.setInt(2, goods.getGoodsId());
			pstmt.setFloat(3, salesmanID);
			pstmt.setString(4, getNowDate());
			pstmt.setInt(5, buyNums);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, conn);
		}

	}

	/**
	 * 卖出商品后库存变化
	 */
	public static void goodsChange(int soldNum, String goodsName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "update GOODS set GNUM=? where GNAME=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, soldNum);
			pstmt.setString(2, goodsName);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt, conn);
		}

	}

	/**
	 * 查询当日卖出的商品表
	 */
	public static List<TodaySold> GoodSales() {
		int num = 0, sNum = 0;
		PreparedStatement pstmt1 = null;
		Connection conn1 = DBConnectionUtil.getConn();
		ResultSet rs1 = null;
		PreparedStatement pstmt2 = null;
		Connection conn2 = DBConnectionUtil.getConn();
		ResultSet rs2 = null;
		String sql = "select * from GSALES where SDATE=?";
		List<TodaySold> goodsList = new ArrayList<TodaySold>();
		try {
			pstmt1 = conn1.prepareStatement(sql);
			pstmt1.setString(1, getNowDate());
			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				num = rs1.getInt(2);
				sNum = rs1.getInt(5);
				String sql2 = "select * from GOODS where GID=?";
				pstmt2 = conn2.prepareStatement(sql2);
				pstmt2.setInt(1, num);
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					if (rs2.getInt("GNUM") < 10){
						TodaySold ts = new TodaySold(rs2.getString(2), rs2.getFloat(3), +rs2.getInt(4), sNum,"*该商品已不足10件！");
						goodsList.add(ts);
					}else{
						TodaySold ts = new TodaySold(rs2.getString(2), rs2.getFloat(3), +rs2.getInt(4), sNum," ");
						goodsList.add(ts);
					}
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(pstmt1, conn1);
		}
		return goodsList;
	}

	/**
	 * 获得当前日期
	 */
	public static String getNowDate() {
		java.util.Date nowdate = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(nowdate);
	}

	/**
	 * 获取销售商品编号值,在最大值的基础上加1。
	 * 
	 * @return
	 */
	public static int getSalesGoodsId() {
		int maxId = 0;// 存放最大的销售商品编号值，默认值设为0.
		// 声明用到的对象
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// 创建数据库连接
		Connection conn = DBConnectionUtil.getConn();
		// 插入数据库信息
		String sql = "select max(GSID) from GSALES";
		try {
			// 声明对象
			pstmt = conn.prepareStatement(sql);
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
