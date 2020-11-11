package com.itshixun.pojo;

public class OrderDetail {
	private int id;
	private String orderid;
	private String carmenuname;
	private String carmenupicture;
	private double  carmenuprice;
	private int carnum;
	private double carprice;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int id, String orderid, String carmenuname,
			String carmenupicture, double carmenuprice, int carnum,
			double carprice) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.carmenuname = carmenuname;
		this.carmenupicture = carmenupicture;
		this.carmenuprice = carmenuprice;
		this.carnum = carnum;
		this.carprice = carprice;
	}
	public OrderDetail(String orderid, String carmenuname,
			String carmenupicture, double carmenuprice, int carnum,
			double carprice) {
		super();
		this.orderid = orderid;
		this.carmenuname = carmenuname;
		this.carmenupicture = carmenupicture;
		this.carmenuprice = carmenuprice;
		this.carnum = carnum;
		this.carprice = carprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getCarmenuname() {
		return carmenuname;
	}
	public void setCarmenuname(String carmenuname) {
		this.carmenuname = carmenuname;
	}
	public String getCarmenupicture() {
		return carmenupicture;
	}
	public void setCarmenupicture(String carmenupicture) {
		this.carmenupicture = carmenupicture;
	}
	public double getCarmenuprice() {
		return carmenuprice;
	}
	public void setCarmenuprice(double carmenuprice) {
		this.carmenuprice = carmenuprice;
	}
	public int getCarnum() {
		return carnum;
	}
	public void setCarnum(int carnum) {
		this.carnum = carnum;
	}
	public double getCarprice() {
		return carprice;
	}
	public void setCarprice(double carprice) {
		this.carprice = carprice;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderid=" + orderid
				+ ", carmenuname=" + carmenuname + ", carmenupicture="
				+ carmenupicture + ", carmenuprice=" + carmenuprice
				+ ", carnum=" + carnum + ", carprice=" + carprice + "]";
	}
	
	

}
