package com.itshixun.dao;

import java.util.List;

import com.itshixun.pojo.Menu;

public interface MenuDao {
	public int checkMenu(Menu menu);
	public int addMenu(Menu menu);
	 public List<Menu> findMenu(String sortway);
	 public void changeSales(String menuname,int menunum );
	 public int deleteMenu(String menuname);
	 public Menu showMenuByUsername(String menuname);
	public void changeMenu(Menu menu,String menuname);

}
