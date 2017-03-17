package com.bb.bean;

/**
 * ��Ʒ��Ϣbean
 * 
 * @author ����
 * 
 */
public class Salesman {
	private int salesManId;//�ۻ�Ա���
	private String salesManName;//�ۻ�Ա����
	private String salesManPassword;//�ۻ�Ա����
	
	
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
