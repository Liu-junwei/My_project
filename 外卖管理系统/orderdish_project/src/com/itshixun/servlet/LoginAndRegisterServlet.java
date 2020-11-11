package com.itshixun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.itshixun.dao.UserDao;
import com.itshixun.dao.impl.UserDaoImpl;
import com.itshixun.pojo.User;

public class LoginAndRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();

	public LoginAndRegisterServlet() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		chosepage(request,response);
		if("register".equals(method)){
			userRegister(request,response);
		}else if("login".equals(method)){
			userLogin(request,response);
		}

	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter   out = response.getWriter();
		//获取参数
		String  userid=request.getParameter("userid");
		String  password=request.getParameter("password");
		String  rememberMe=request.getParameter("rememberMe");
		String role=request.getParameter("role");
		//登录验证
		UserDao userDao = new UserDaoImpl();
		User user = new User(userid,password,role);
		int count= userDao.login(user);
		if(count>0){
			String userid1=user.getUserid();
			User user1=userDao.showUserByUid(userid1);
			//用户登录成功 存储到sesssion
			request.getSession().setAttribute("SESSION_user", user1);
			if(role.equals("顾客"))
			    response.sendRedirect("MenuServlet?chose=showmenu&sortway=sortNormol");
			else
				response.sendRedirect("MenuServlet?chose=managemenu&sortway=sortNormol");
			
		}else{
			//fail
			//给你一个错误提示 并且回到login.jsp
			out.println("<script type='text/javascript'>");
			out.println("alert('用户名不存在或密码错误');");
			out.println("window.location='login.jsp'");
			out.println("</script>");
		}

	}

	private void userRegister(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter   out = response.getWriter();
		
		String userid= request.getParameter("userid");
		String nickname= request.getParameter("nickname");
		String password= request.getParameter("password");
		String role="顾客";

		User user1 = new User(userid,nickname,password,role);
		int usercount=userDao.checkRegister(user1);
		System.out.print(usercount);
		if(usercount>0){
			out.println("<script type='text/javascript'>");
			out.println("alert('用户已存在');");
			out.println("window.location='register.jsp'");
			out.println("</script>");
		}
		else{
			userDao.addUser(user1);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	private void chosepage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String chose= request.getParameter("chose");
		if("register".equals(chose)){
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else if("login".equals(chose)){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}


}
