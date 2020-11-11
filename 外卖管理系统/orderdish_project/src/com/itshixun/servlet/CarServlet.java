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
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarDao carDao=new CarDaoImpl();

	public CarServlet() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String chose=request.getParameter("chose");
		if("showcar".equals(chose)){
			showCar(request,response);
		}else if("addcar".equals(chose)){
			addCar(request,response);
		}else if("reducenum".equals(chose)){
			reduceNum(request,response);
			showCar(request,response);
		}else if("addnum".equals(chose)){
			addNum(request,response);
			showCar(request,response);
		}else if("deletecar".equals(chose)){
			deleteCar(request,response);
			showCar(request,response);
		}else if("goorder".equals(chose)){
			goOrder(request,response);
		}
		
	}

	private void showCar(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{

		CarDao carDao=new CarDaoImpl();
		String userid=request.getParameter("userid");
		List<Car> list=carDao.findCar(userid);
		int allnum=carDao.showCarNum(userid);
		double allprice=carDao.showCarPrice(userid);
		request.setAttribute("carList", list);
		request.setAttribute("allnum", allnum);
		request.setAttribute("allprice", allprice);
		request.getRequestDispatcher("showCar.jsp").forward(request, response);

	}
	private void goOrder(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{

		CarDao carDao=new CarDaoImpl();
		String userid=request.getParameter("userid");
		List<Car> list=carDao.findCar(userid);
		int allnum=carDao.showCarNum(userid);
		double allprice=carDao.showCarPrice(userid);
		request.setAttribute("carList", list);
		request.setAttribute("allnum", allnum);
		request.setAttribute("allprice", allprice);
		request.getRequestDispatcher("goorder.jsp").forward(request, response);

	}
	private void addCar(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String caruserid= request.getParameter("caruserid");
		String carmenuname= request.getParameter("carmenuname");
		String carpicture= request.getParameter("carpicture");
		double carmenuprice=Double.parseDouble(request.getParameter("carmenuprice"));
		int carnum=1;
		double carprice=carmenuprice*1;

		Car car = new Car(caruserid,carmenuname,carpicture,carprice,carnum,carprice);
		int carcount=carDao.checkCar(car);
		if(carcount>0){
			carDao.addCarNum(car);
		}else{
			carDao.addCar(car);
			
		}
		response.sendRedirect("MenuServlet?chose=showmenu&sortway=sortNormol");
	}
	private void reduceNum(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter   out = response.getWriter();
		CarDao carDao=new CarDaoImpl();
		String userid=request.getParameter("userid");
		String menuname=request.getParameter("menuname");
		int carnum=Integer.parseInt(request.getParameter("carnum"));
		if(carnum>1){
			Car car = new Car(userid,menuname);
		    carDao.reduceCarNum(car);
		}
		
	}
	private void addNum(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		CarDao carDao=new CarDaoImpl();
		String userid=request.getParameter("userid");
		String menuname=request.getParameter("menuname");
		Car car = new Car(userid,menuname);
		carDao.addCarNum(car);
	}
	private void deleteCar(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		CarDao carDao=new CarDaoImpl();
		String userid=request.getParameter("userid"); 
		String menuname=request.getParameter("menuname"); 
		carDao.deleteCar(userid, menuname);
	}
	
	

}
