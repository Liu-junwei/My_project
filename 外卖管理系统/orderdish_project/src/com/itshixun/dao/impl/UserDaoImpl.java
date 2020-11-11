package com.itshixun.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itshixun.dao.UserDao;
import com.itshixun.pojo.Menu;
import com.itshixun.pojo.User;
import com.itshixun.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
public class UserDaoImpl implements UserDao{
    Connection conn=null;
    PreparedStatement pstmt=null;
    Statement stmt =null;
    ResultSet rs=null;
	@Override
	public int checkRegister(User user) {
		int usercount=-1;
		String sql="select count(1) as cnum from user where userid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			rs=pstmt.executeQuery();
			if(rs.next()){
				usercount=rs.getInt("cnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return usercount;
	}
	@Override
	public int addUser(User user) {
		int count=-1;
		String sql="insert into user (userid,nickname,password,role) values(?,?,?,?)";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getNickname());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getRole());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return count;
	}
	@Override
	public int login(User user) {
		int count=-1;
		String sql="select count(1) as cnum from user where userid=? and password=? and role=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRole());
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt("cnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return count;
	}
	@Override
	public List<User> findUser() {
		List<User> list =new ArrayList<User>();
		String sql="select userid,nickname,password,role from user";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User user = 
				new User(rs.getString("userid"),
						rs.getString("nickname"),
						rs.getString("password"),
						rs.getString("role"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return list;
	}
	@Override
	public int deleteUser(String userid) {
		int count=-1;
		String sql="delete from user where userid=?";
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
	public User showUserByUid(String userid) {
		 User user= null;
		String sql="select userid,nickname,password,role from user where userid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				  user = 
				new User(rs.getString("userid"),
						rs.getString("nickname"),
						rs.getString("password"),
						rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
		return user; 
	}
	@Override
	public void changeUser(User user,String userid) {
		
		String sql="update user set nickname=?,password=?,role=? where userid=?";
		conn=JDBCUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,user.getNickname());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getRole());
			pstmt.setString(4,userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, rs, pstmt, pstmt);
		}
	}

}
