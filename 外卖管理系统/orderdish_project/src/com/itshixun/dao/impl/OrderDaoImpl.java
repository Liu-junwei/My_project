package com.itshixun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.util.ArrayList;
import java.util.List;

import com.itshixun.dao.OrderDao;
import com.itshixun.pojo.Car;
import com.itshixun.pojo.Order;
import com.itshixun.pojo.OrderDetail;
import com.itshixun.util.JDBCUtil;

public class OrderDaoImpl implements OrderDao{
	    Connection conn=null;
	    PreparedStatement pstmt=null;
	    Statement stmt =null;
	    ResultSet rs=null;

	@Override
	public void addOrder(Order order) {
		String sql="insert into torder (orderid,userid,ordertime,receivename,receivetel,receiveaddr,ordernum,orderprice,orderstatus) values(?,?,?,?,?,?,?,?,?)";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrderid());
			pstmt.setString(2, order.getUserid());
			pstmt.setString(3, order.getOrdertime());
			pstmt.setString(4, order.getReceivename());
			pstmt.setString(5, order.getReceivetel());
			pstmt.setString(6, order.getReceiveaddr());
			pstmt.setInt(7, order.getOrdernum());
			pstmt.setDouble(8, order.getOrderprice());
			pstmt.setString(9, order.getOrderstatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}
	@Override
	public void addOrderDetail(Car car,String orderid) {
		String sql="insert into torderdetail (orderid,carmenuname,carmenupicture,carmenuprice,carnum,carprice) values(?,?,?,?,?,?)";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, orderid);
			pstmt.setString(2, car.getCarmenuname());
			pstmt.setString(3, car.getCarmenupicture());
			pstmt.setDouble(4, car.getCarmenuprice());
			pstmt.setInt(5, car.getCarnum());
			pstmt.setDouble(6, car.getCarprice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}
	@Override
	public List<Order> findOrder(String userid) {
		List<Order> list =new ArrayList<Order>();
		String sql="select orderid,userid,ordertime,receivename,receivetel,receiveaddr,ordernum,orderprice,orderstatus from torder where userid=? order by ordertime desc";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Order order = 
						new Order(rs.getString("orderid"),
								rs.getString("userid"),
								rs.getString("ordertime"),
								rs.getString("receivename"),
								rs.getString("receivetel"),
								rs.getString("receiveaddr"),
								rs.getInt("ordernum"),
								rs.getDouble("orderprice"),
								rs.getString("orderstatus"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return list;
		
	}
	@Override
	public Order findOrderByid(String orderid) {
		Order order=null;
		String sql="select orderid,userid,ordertime,receivename,receivetel,receiveaddr,ordernum,orderprice,orderstatus from torder where orderid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, orderid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				   order = 
						new Order(rs.getString("orderid"),
								rs.getString("userid"),
								rs.getString("ordertime"),
								rs.getString("receivename"),
								rs.getString("receivetel"),
								rs.getString("receiveaddr"),
								rs.getInt("ordernum"),
								rs.getDouble("orderprice"),
								rs.getString("orderstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return order;
		
	}
	@Override
	public List<Order> findAllOrder() {
		List<Order> list =new ArrayList<Order>();
		String sql="select orderid,userid,ordertime,receivename,receivetel,receiveaddr,ordernum,orderprice,orderstatus from torder order by ordertime desc";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Order order = 
						new Order(rs.getString("orderid"),
								rs.getString("userid"),
								rs.getString("ordertime"),
								rs.getString("receivename"),
								rs.getString("receivetel"),
								rs.getString("receiveaddr"),
								rs.getInt("ordernum"),
								rs.getDouble("orderprice"),
								rs.getString("orderstatus"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return list;
		
	}
	@Override
	public List<OrderDetail> findOrderDetail(String orderid) {
		List<OrderDetail> list =new ArrayList<OrderDetail>();
		String sql="select orderid,carmenuname,carmenupicture,carmenuprice,carnum,carprice from torderdetail where orderid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, orderid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				OrderDetail orderDetail = 
						new OrderDetail(rs.getString("orderid"),
								rs.getString("carmenuname"),
								rs.getString("carmenupicture"),
								rs.getDouble("carmenuprice"),
								rs.getInt("carnum"),
								rs.getDouble("carprice"));
				list.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return list;
	}
	@Override
	public void changeOrderStatus(String orderid,String orderstatus) {
		String sql="update torder set orderstatus=? where orderid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, orderstatus);
			pstmt.setString(2, orderid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}



}
