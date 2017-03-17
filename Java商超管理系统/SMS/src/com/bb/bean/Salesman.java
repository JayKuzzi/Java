package com.bb.bean;

/**
 * 商品信息bean
 * 
 * @author 汪博
 * 
 */
public class Salesman {
	private int salesManId;//售货员编号
	private String salesManName;//售货员姓名
	private String salesManPassword;//售货员密码
	
	
	public Salesman(String salesManName, String salesManPassword) {
		
		this.salesManName = salesManName;
		this.salesManPassword = salesManPassword;
	}

	public Salesman(int salesManId, String salesManName, String salesManPassword) {
		this.salesManId = salesManId;
		this.salesManName = salesManName;
		this.salesManPassword = salesManPassword;
	}



	public int getSalesManId() {
		return salesManId;
	}


	public void setSalesManId(int salesManId) {
		this.salesManId = salesManId;
	}


	public String getSalesManName() {
		return salesManName;
	}


	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}


	public String getSalesManPassword() {
		return salesManPassword;
	}


	public void setSalesManPassword(String salesManPassword) {
		this.salesManPassword = salesManPassword;
	}
	
	
	@Override
	public boolean equals(Object arg0) {
		Salesman another = (Salesman) arg0;
		return salesManName.equals(another.getSalesManName())&&salesManPassword.equals(another.salesManPassword);
	}
	
	
	
	
	
	

}
