package com.itshixun.dao;

import java.sql.ResultSet;
import java.util.List;

import com.itshixun.pojo.User;

public interface UserDao {
public int checkRegister(User user);
 public int addUser(User user);
 public void changeUser(User user,String userid);
 public int login(User user);
 public List<User> findUser();
 public int deleteUser(String userid);
 public User showUserByUid(String userid);
}
