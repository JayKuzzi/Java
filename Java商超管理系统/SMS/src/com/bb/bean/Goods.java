package com.bb.bean;

/**
 * ��Ʒ��Ϣbean
 * 
 * @author ����
 * 
 */
public class Goods {
	private int goodsId;// ��Ʒ���
	private String goodsName;// ��Ʒ����
	private float goodsPrice;// ��Ʒ�۸�
	private int goodsNum;// ��Ʒ����
    private String info;//��Ʒ��ע
    
	public Goods(String goodsName, float goodsPrice, int goodsNum, String info) {
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.info = info;
	}

	public Goods(String goodsName, float goodsPrice, int goodsNum) {
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
	}

	public Goods(int goodsId, String goodsName, float goodsPrice, int goodsNum) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
	}
	
	

	public Goods(int goodsId, String goodsName, float goodsPrice, int goodsNum, String info) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.info = info;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
