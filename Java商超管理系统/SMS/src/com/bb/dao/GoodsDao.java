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
 * ����Ʒ��Ϣ����ɾ�Ĳ�Ȳ�����
 * 
 * @author ����
 * 
 */
public class GoodsDao {

	/**
	 * �����Ʒ��Ϣ
	 * 
	 * @param goods
	 */
	public static int add(Goods goods) {
		// �����õ��Ķ���
		PreparedStatement pstmt = null;
		// �������ݿ�����
		Connection conn = DBConnectionUtil.getConn();
		// �������ݿ���Ϣ
		String sql = "insert into GOODS values(?,?,?,?)";
		int count = 0;
		try {
			// ��������
			pstmt = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			pstmt.setInt(1, getGoodsId());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setFloat(3, goods.getGoodsPrice());
			pstmt.setInt(4, goods.getGoodsNum());
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
	 * ������Ʒ��Ϣ
	 * 
	 * @param goods
	 */
	public static int mod(Goods goods, String goodsName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "update GOODS set GID=?,GNAME=?,GPRICE=?,GNUM=? where GNAME=?";
		int count = 0;
		try {
			// ��������
			pstmt = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			pstmt.setInt(1, getGoodsId());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setFloat(3, goods.getGoodsPrice());
			pstmt.setInt(4, goods.getGoodsNum());
			pstmt.setString(5, goodsName);
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
	 * ɾ����Ʒ��Ϣ
	 * 
	 * @param goods
	 */

	public static int del(String goodsName) {
		PreparedStatement pstmt = null;
		Connection conn = DBConnectionUtil.getConn();
		String sql = "delete from GOODS where GNAME=?";
		int count = 0;
		try {
			// ��������
			pstmt = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			pstmt.setString(1, goodsName);
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
	 * ��ѯ������Ʒ��Ϣ
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
							rs.getInt("GNUM"),"*����Ʒ�Ѳ���10����");
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
	 * ����Ʒ���������ѯ������Ʒ��Ϣ
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
							rs.getInt("GNUM"),"*����Ʒ�Ѳ���10����");
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
	 * ����Ʒ���������ѯ������Ʒ��Ϣ
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
							rs.getInt("GNUM"),"*����Ʒ�Ѳ���10����");
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
	 * ����������ѯ��Ʒ��Ϣ
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
							rs.getInt("GNUM"),"*����Ʒ�Ѳ���10����");
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
	 * ��ȡ��Ʒ���ֵ,��������Ʒ���ֵ�Ļ����ϼ�1��
	 * 
	 * @return
	 */
	public static int getGoodsId() {
		int maxId = 0;// ���������Ʒ���ֵ��Ĭ��ֵ��Ϊ0.
		// �����õ��Ķ���
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// �������ݿ�����
		Connection conn = DBConnectionUtil.getConn();
		// �������ݿ���Ϣ
		String sql = "select max(GID) from GOODS";
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
