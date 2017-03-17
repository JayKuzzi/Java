package com.bb.bean;

public class TodaySold {
	private String saleGoodsName;// �۳���Ʒ����
	private float saleGoodsPrice;// �۳���Ʒ�۸�
	private int saleGoodsSums;// �۳���Ʒ��ʣ����
	private int saleGoodsNums;// �۳���Ʒ����
	private String info;// �۳���Ʒ��ע

	public TodaySold() {

	}

	public TodaySold(String saleGoodsName, float saleGoodsPrice, int saleGoodsSums, int saleGoodsNum) {
		this.saleGoodsName = saleGoodsName;
		this.saleGoodsPrice = saleGoodsPrice;
		this.saleGoodsSums = saleGoodsSums;
		this.saleGoodsNums = saleGoodsNum;
	}

	public TodaySold(String saleGoodsName, float saleGoodsPrice, int saleGoodsSums, int saleGoodsNums, String info) {
		this.saleGoodsName = saleGoodsName;
		this.saleGoodsPrice = saleGoodsPrice;
		this.saleGoodsSums = saleGoodsSums;
		this.saleGoodsNums = saleGoodsNums;
		this.info = info;
	}

	public String getSaleGoodsName() {
		return saleGoodsName;
	}

	public void setSaleGoodsName(String saleGoodsName) {
		this.saleGoodsName = saleGoodsName;
	}

	public float getSaleGoodsPrice() {
		return saleGoodsPrice;
	}

	public void setSaleGoodsPrice(float saleGoodsPrice) {
		this.saleGoodsPrice = saleGoodsPrice;
	}

	public int getSaleGoodsSums() {
		return saleGoodsSums;
	}

	public void setSaleGoodsSums(int saleGoodsSums) {
		this.saleGoodsSums = saleGoodsSums;
	}

	public int getSaleGoodsNums() {
		return saleGoodsNums;
	}

	public void setSaleGoodsNum(int saleGoodsNums) {
		this.saleGoodsNums = saleGoodsNums;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setSaleGoodsNums(int saleGoodsNums) {
		this.saleGoodsNums = saleGoodsNums;
	}

}
