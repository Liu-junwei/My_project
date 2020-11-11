package com.itshixun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itshixun.dao.UserDao;
import com.itshixun.dao.impl.UserDaoImpl;
import com.itshixun.pojo.Menu;
import com.itshixun.pojo.User;

/**
 * Servlet implementation class UserManagerServlet
 */
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();
  
    public UserManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("deleteuser".equals(method)){
			deleteUser(request,response);
			showUser(request,response);
		}else if("showInformation".equals(method)){
			showInformation(request,response);
		}else if("showuser".equals(method)){
			showUser(request,response);
		}else if("gochangeuser".equals(method)){
			goChangeUser(request,response);
		}else if("changeuser".equals(method)){
			changeUser(request,response);
		}
	}
	private void showInformation(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException {
		String userid=request.getParameter("userid"); 
		User user=userDao.showUserByUid(userid);
		request.setAttribute("userDetail", user);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	private void showUser(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		List<User> list=userDao.findUser();
		request.setAttribute("userList", list);
		request.getRequestDispatcher("manageuser.jsp").forward(request, response);
	}
	private void goChangeUser(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String userid=request.getParameter("userid"); 
		User user=userDao.showUserByUid(userid);
		request.setAttribute("userDetail", user);
		request.getRequestDispatcher("changeuser.jsp").forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		String userid=request.getParameter("userid"); 
		userDao.deleteUser(userid);
	}
	private void changeUser(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter   out = response.getWriter();
		
		String userid= request.getParameter("userid");
		String nickname= request.getParameter("nickname");
		String password=request.getParameter("password");
		String role= request.getParameter("role");
		User user=new User(userid,nickname,password,role);
		userDao.changeUser(user,userid);
	
		out.println("<script type='text/javascript'>");
		out.println("alert('修改成功');");
		out.println("window.location.href='/orderdish_project/UserManagerServlet?method=showuser'");
		out.println("</script>");
		
	}
	


}
