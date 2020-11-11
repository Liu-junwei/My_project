package com.itshixun.pojo;

public class Menu {
	private String menuname;//菜品名称
	private String picturepath;//菜品图片路径
	private double price;//菜品价格
	private int sales;//菜品销量
	private String describe;//菜品描述
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String menuname, String picturepath, double price, int sales,
			String describe) {
		super();
		this.menuname = menuname;
		this.picturepath = picturepath;
		this.price = price;
		this.sales = sales;
		this.describe = describe;
	}
	public Menu(String picturepath, String menuname, double price,int sales) {
		super();
		this.picturepath = picturepath;
		this.menuname = menuname;
		this.price = price;
		this.sales=sales;
	}
	public Menu(String menuname, String picturepath, double price,
			String describe) {
		super();
		this.menuname = menuname;
		this.picturepath = picturepath;
		this.price = price;
		this.describe = describe;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "Menu [menuname=" + menuname + ", picturepath=" + picturepath
				+ ", price=" + price + ", sales=" + sales + ", describe="
				+ describe + "]";
	}
	
	

}
