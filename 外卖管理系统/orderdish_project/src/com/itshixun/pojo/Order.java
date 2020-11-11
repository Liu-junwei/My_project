package com.itshixun.pojo;

public class Order {
	private String orderid;
	private String userid;
	private String ordertime;
	private String receivename;
	private String receivetel;
	private String receiveaddr;
	private int ordernum;
	private double orderprice;
	private String orderstatus;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderid, String userid, String ordertime,
			String receivename, String receivetel, String receiveaddr,
			int ordernum, double orderprice, String orderstatus) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.ordertime = ordertime;
		this.receivename = receivename;
		this.receivetel = receivetel;
		this.receiveaddr = receiveaddr;
		this.ordernum = ordernum;
		this.orderprice = orderprice;
		this.orderstatus = orderstatus;
	}
	
	public Order(String userid, String ordertime, String receivename,
			String receivetel, String receiveaddr, int ordernum,
			double orderprice, String orderstatus) {
		super();
		this.userid = userid;
		this.ordertime = ordertime;
		this.receivename = receivename;
		this.receivetel = receivetel;
		this.receiveaddr = receiveaddr;
		this.ordernum = ordernum;
		this.orderprice = orderprice;
		this.orderstatus = orderstatus;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public String getReceivetel() {
		return receivetel;
	}
	public void setReceivetel(String receivetel) {
		this.receivetel = receivetel;
	}
	public String getReceiveaddr() {
		return receiveaddr;
	}
	public void setReceiveaddr(String receiveaddr) {
		this.receiveaddr = receiveaddr;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", userid=" + userid
				+ ", ordertime=" + ordertime + ", receivename=" + receivename
				+ ", receivetel=" + receivetel + ", receiveaddr=" + receiveaddr
				+ ", ordernum=" + ordernum + ", orderprice=" + orderprice
				+ ", orderstatus=" + orderstatus + "]";
	}
	
}
