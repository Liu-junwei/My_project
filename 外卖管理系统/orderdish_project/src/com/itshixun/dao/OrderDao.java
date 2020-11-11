package com.itshixun.dao;

import java.util.List;

import com.itshixun.pojo.Car;
import com.itshixun.pojo.Order;
import com.itshixun.pojo.OrderDetail;

public interface OrderDao {
	public void addOrder(Order order);
	public void addOrderDetail(Car car,String orderid);
	public List<Order> findOrder(String userid);
	public Order findOrderByid(String orderid);
	public List<OrderDetail> findOrderDetail(String orderid);
	public List<Order> findAllOrder();
	public void changeOrderStatus(String orderid,String orderstatus);

}
