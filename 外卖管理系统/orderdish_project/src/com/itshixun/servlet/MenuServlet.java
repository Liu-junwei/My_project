package com.itshixun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itshixun.dao.CarDao;
import com.itshixun.dao.MenuDao;
import com.itshixun.dao.impl.CarDaoImpl;
import com.itshixun.dao.impl.MenuDaoImpl;
import com.itshixun.pojo.Car;
import com.itshixun.pojo.Menu;
import com.itshixun.pojo.User;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MenuDao menuDao=new MenuDaoImpl();
	
	public MenuServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String chose=request.getParameter("chose");
		if("showmenu".equals(chose)){
			showMenu(request,response);
		}else if("showMenudetail".equals(chose)){
			showMenuDetail(request,response);
		}else if("managemenu".equals(chose)){
			manageMenu(request,response);
		}else if("goaddmenu".equals(chose)){
			request.getRequestDispatcher("addMenu.jsp").forward(request, response);
		}else if("addmenu".equals(chose)){
			addMenu(request,response);
		}else if("deletemenu".equals(chose)){
			deleteMenu(request,response);
			manageMenu(request,response);
		}else if("gochangemenu".equals(chose)){
			goChangeMenu(request,response);
		}else if("changemenu".equals(chose)){
			changeMenu(request,response);
		}

	}
	private void showMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String sortway=request.getParameter("sortway");
		List<Menu> list=menuDao.findMenu(sortway);
		request.setAttribute("menuList", list);
		request.getRequestDispatcher("showMenu.jsp").forward(request, response);
	}
	private void deleteMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String menuname=request.getParameter("menuname"); 
		menuDao.deleteMenu( menuname);
	}
	private void manageMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String sortway=request.getParameter("sortway");
		List<Menu> list=menuDao.findMenu(sortway);
		request.setAttribute("menuList", list);
		request.getRequestDispatcher("manageMenu.jsp").forward(request, response);
	}
	private void addMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter   out = response.getWriter();
		
		String menuname= request.getParameter("menuname");
		String picturepath= request.getParameter("picturepath");
		double price=Double.parseDouble(request.getParameter("price"));
		String describes= request.getParameter("describes");

		Menu menu = new Menu(menuname,picturepath,price,describes);
		int menucount=menuDao.checkMenu(menu);
		if(menucount>0){
			out.println("<script type='text/javascript'>");
			out.println("alert('菜单里面已经有这个菜了哦');");
			out.println("window.location='addMenu.jsp'");
			out.println("</script>");
		}else{
			menuDao.addMenu(menu);
			
		}
		response.sendRedirect("MenuServlet?chose=managemenu&sortway=sortNormol");
	}
	private void showMenuDetail(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		MenuDao menuDao=new MenuDaoImpl();
		String menuname=request.getParameter("menuname"); 
		Menu menu=menuDao.showMenuByUsername(menuname);
		System.out.print(menu);
		request.setAttribute("menuDetail", menu);
		request.getRequestDispatcher("showMenuDetail.jsp").forward(request, response);
	}
	private void goChangeMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String menuname=request.getParameter("menuname"); 
		Menu menu=menuDao.showMenuByUsername(menuname);
		request.setAttribute("menuDetail", menu);
		request.getRequestDispatcher("changemenu.jsp").forward(request, response);
	}
	private void changeMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter   out = response.getWriter();
		
		String menuname= request.getParameter("menuname");
		String picturepath= request.getParameter("picturepath");
		double price=Double.parseDouble(request.getParameter("price"));
		String describes= request.getParameter("describes");
		Menu menu=new Menu(menuname,picturepath,price,describes);
		menuDao.changeMenu(menu, menuname);
	
		out.println("<script type='text/javascript'>");
		out.println("alert('修改成功');");
		out.println("window.location.href='/orderdish_project/MenuServlet?chose=managemenu&sortway=sortNormol'");
		out.println("</script>");
		
	}



}
