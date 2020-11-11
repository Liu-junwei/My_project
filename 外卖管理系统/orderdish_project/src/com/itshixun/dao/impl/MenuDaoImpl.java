package com.itshixun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itshixun.dao.MenuDao;
import com.itshixun.pojo.Car;
import com.itshixun.pojo.Menu;
import com.itshixun.pojo.User;
import com.itshixun.util.JDBCUtil;

public class MenuDaoImpl implements MenuDao{
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt =null;
	ResultSet rs=null;

	@Override
	public int checkMenu(Menu menu) {
		int menucount=-1;
		String sql="select count(1) as cnum from menu where menuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMenuname());
			rs=pstmt.executeQuery();
			if(rs.next()){
				menucount=rs.getInt("cnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		System.out.print(menucount);
		return menucount;
	
	}
	@Override
	public int addMenu(Menu menu) {
		int count=-1;
		String sql="insert into menu (menuname,picturepath,price,sales,describes) values(?,?,?,0,?)";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMenuname());
			pstmt.setString(2, menu.getPicturepath());
			pstmt.setDouble(3, menu.getPrice());
			pstmt.setString(4, menu.getDescribe());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return count;
	}
	@Override
	public int deleteMenu(String menuname) {//删除菜品
		int count=-1;
		String sql="delete from menu where menuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, menuname);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return count;
	}

	@Override
	public List<Menu> findMenu(String sortway) {
		List<Menu> list =new ArrayList<Menu>();
		String sql="";
		if(sortway.equals("sortByPrice")){
			 sql="select picturepath,menuname,price,sales,describes from menu order by price asc";
		}else if(sortway.equals("sortBySales")){
			 sql="select picturepath,menuname,price,sales,describes from menu order by sales desc";
		}else if(sortway.equals("sortNormol")){
			 sql="select picturepath,menuname,price,sales,describes from menu ";
		}
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Menu menu = 
				new Menu(rs.getString("menuname"),
						rs.getString("picturepath"),
						rs.getDouble("price"),
						rs.getInt("sales"),
						rs.getString("describes"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return list;
	}

	@Override
	public void changeSales(String menuname,int menunum) {
		String sql="update menu set sales=sales+? where menuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,menunum);
			pstmt.setString(2,menuname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}

	@Override
	public Menu showMenuByUsername(String menuname) {
		
		 Menu menu= null;
		String sql="select menuname,picturepath,price,sales,describes from menu where menuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, menuname);
			rs=pstmt.executeQuery();
			if(rs.next()){
				  menu = 
				new Menu(rs.getString("menuname"),
						rs.getString("picturepath"),
						rs.getDouble("price"),
						rs.getInt("sales"),
						rs.getString("describes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return menu; 
	}
	@Override
	public void changeMenu(Menu menu,String menuname) {
		
		String sql="update menu set picturepath=?,price=?,describes=? where menuname=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,menu.getPicturepath());
			pstmt.setDouble(2,menu.getPrice());
			pstmt.setString(3,menu.getDescribe());
			pstmt.setString(4,menuname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		
	}

}
