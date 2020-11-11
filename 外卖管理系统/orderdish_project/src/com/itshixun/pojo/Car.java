package com.itshixun.pojo;

public class Car {
	private int carid;
	private String caruserid;
	private String carmenuname;
	private String carmenupicture;
	private double carmenuprice;
	private int carnum;
	private double carprice;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int carid, String caruserid, String carmenuname,
			String carmenupicture, double carmenuprice, int carnum,double carprice) {
		super();
		this.carid = carid;
		this.caruserid = caruserid;
		this.carmenuname = carmenuname;
		this.carmenupicture = carmenupicture;
		this.carmenuprice = carmenuprice;
		this.carnum = carnum;
		this.carprice=carprice;
	}
	
	public Car(String caruserid, String carmenuname) {
		super();
		this.caruserid = caruserid;
		this.carmenuname = carmenuname;
	}
	public Car(String caruserid, String carmenuname, String carmenupicture,
			double carmenuprice, int carnum, double carprice) {
		super();
		this.caruserid = caruserid;
		this.carmenuname = carmenuname;
		this.carmenupicture = carmenupicture;
		this.carmenuprice = carmenuprice;
		this.carnum = carnum;
		this.carprice = carprice;
	}
	public Car(String carmenuname, String carmenupicture, double carmenuprice,
			int carnum, double carprice) {
		super();
		this.carmenuname = carmenuname;
		this.carmenupicture = carmenupicture;
		this.carmenuprice = carmenuprice;
		this.carnum = carnum;
		this.carprice = carprice;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCaruserid() {
		return caruserid;
	}
	public void setCaruserid(String caruserid) {
		this.caruserid = caruserid;
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
		return "Car [carid=" + carid + ", caruserid=" + caruserid
				+ ", carmenuname=" + carmenuname + ", carmenupicture="
				+ carmenupicture + ", carmenuprice=" + carmenuprice
				+ ", carnum=" + carnum + ", carprice=" + carprice + "]";
	}
	
}
