package com.itshixun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itshixun.dao.CarDao;
import com.itshixun.pojo.Car;
import com.itshixun.pojo.User;
import com.itshixun.util.JDBCUtil;

public class CarDaoImpl implements CarDao{
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt =null;
	ResultSet rs=null;

	@Override
	public int checkCar(Car car) {//加购物车时检查购物车里面是否已经有该菜品
		int carcount=-1;
		String sql="select count(1) as cnum from car where caruserid=? and carmenuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, car.getCaruserid());
			pstmt.setString(2, car.getCarmenuname());
			rs=pstmt.executeQuery();
			if(rs.next()){
				carcount=rs.getInt("cnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return carcount;
	}
	@Override
	public int showCarNum(String userid) {//找到该用户购物车里商品的总数量
		int allnum=0;
		String sql="select sum(carnum) as allnum from car where caruserid=? group by caruserid";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next())
			    allnum=rs.getInt("allnum");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return allnum;
	}
	@Override
	public double showCarPrice(String userid) {//找到该用户购物车里商品的总价格
		double allprice=0;
		String sql="select sum(carprice) as allprice from car where caruserid=? group by caruserid";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next())
			allprice=rs.getDouble("allprice");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return allprice;
	}
	@Override
	public void addCarNum(Car car) {//但是购物车已有该菜品，数量+1即可
		String sql="update car set carnum=carnum+1,carprice=carnum*carmenuprice where caruserid=? and carmenuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, car.getCaruserid());
			pstmt.setString(2, car.getCarmenuname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}
	@Override
	public void reduceCarNum(Car car) {
		String sql="update car set carnum=carnum-1,carprice=carnum*carmenuprice where caruserid=? and carmenuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, car.getCaruserid());
			pstmt.setString(2, car.getCarmenuname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}
	@Override
	public void addCar(Car car) {
		String sql="insert into car (caruserid,carmenuname,carmenupicture,carmenuprice,carnum,carprice) values(?,?,?,?,1,?)";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, car.getCaruserid());
			pstmt.setString(2, car.getCarmenuname());
			pstmt.setString(3, car.getCarmenupicture());
			pstmt.setDouble(4, car.getCarmenuprice());
			pstmt.setDouble(5, car.getCarmenuprice()*1);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}

	@Override
	public List<Car> findCar(String userid) {
		List<Car> list =new ArrayList<Car>();
		String sql="select carmenuname,carmenupicture,carmenuprice,carnum,carprice from car where caruserid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Car car = 
						new Car(rs.getString("carmenuname"),
								rs.getString("carmenupicture"),
								rs.getDouble("carmenuprice"),
								rs.getInt("carnum"),
								rs.getDouble("carprice"));
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return list;
	}

	@Override
	public int deleteCar(String userid, String menuname) {
		int count=-1;
		String sql="delete from car where caruserid=? and carmenuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, menuname);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return count;
	}
	@Override
	public int deleteAllCar(String userid) {
		int count=-1;
		String sql="delete from car where caruserid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return count;
	}

	@Override
	public Car showCarBy(String userid, String menuname) {
		// TODO Auto-generated method stub
		return null;
	}


}
