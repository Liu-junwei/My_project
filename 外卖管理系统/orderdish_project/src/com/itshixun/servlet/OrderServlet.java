package com.itshixun.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itshixun.dao.CarDao;
import com.itshixun.dao.MenuDao;
import com.itshixun.dao.OrderDao;
import com.itshixun.dao.impl.CarDaoImpl;
import com.itshixun.dao.impl.MenuDaoImpl;
import com.itshixun.dao.impl.OrderDaoImpl;
import com.itshixun.pojo.Car;
import com.itshixun.pojo.Order;
import com.itshixun.pojo.OrderDetail;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MenuDao menuDao=new MenuDaoImpl();
	OrderDao orderDao=new OrderDaoImpl();
	CarDao carDao =new CarDaoImpl();

    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String chose=request.getParameter("chose");
		if("addorder".equals(chose)){//添加订单
			addOrder(request,response);//添加订单
			addOrderDetail(request,response);//添加订单明细
			//添加订单后，清空该用户的购物车
			String userid=request.getParameter("userid");
			List<Car> carlist=carDao.findCar(userid);
			for(int i=0;i<carlist.size();i++){
				String menuname=carlist.get(i).getCarmenuname();
				int menunum=carlist.get(i).getCarnum();
				menuDao.changeSales(menuname, menunum);
			}
			deleteAllCar(request,response);
			showOrder(request,response);
		}else if("myorder".equals(chose)){
			showOrder(request,response);
		}else if("adminshoworderdetail".equals(chose)){
			adminShowOrderDetail(request,response);
		}else if("usershoworderdetail".equals(chose)){
			userShowOrderDetail(request,response);
		}else if("manageorder".equals(chose)){
			manageOrder(request,response);
		}else if("changestatus".equals(chose)){
			changeStatus(request,response);
			String userid=request.getParameter("userid");
			if("admin".equals(userid)){
				manageOrder(request,response);
			}else{
				showOrder(request,response);
			}
			
		}
	}
	private void addOrder(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String orderid=request.getParameter("orderid");
		String userid= request.getParameter("userid");
		String ordertime= request.getParameter("ordertime");
		String receivename= request.getParameter("receivename");
		String receivetel= request.getParameter("receivetel");
		String receiveaddr= request.getParameter("receiveaddr");
		int ordernum=Integer.parseInt(request.getParameter("ordernum"));
		double orderprice=Double.parseDouble(request.getParameter("orderprice"));
		String orderstatus= request.getParameter("orderstatus");

		Order order = new Order(orderid,userid,ordertime,receivename,receivetel,receiveaddr,ordernum,orderprice,orderstatus);
		orderDao.addOrder(order);
	}
	private void changeStatus(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String orderid=request.getParameter("orderid");
		String orderstatus= request.getParameter("orderstatus");
		if(orderstatus.equals("已付款")){
			orderstatus="等待顾客收货";
		}else if(orderstatus.equals("等待顾客收货")){
			orderstatus="已完成";
		}
		orderDao.changeOrderStatus(orderid, orderstatus);
	}
	private void addOrderDetail(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String userid= request.getParameter("userid");
		List<Car> list=carDao.findCar(userid);
		for(int i=0;i<list.size();i++){
			String orderid=request.getParameter("orderid");
			String carmenuname=list.get(i).getCarmenuname();
			String carmenupicture=list.get(i).getCarmenupicture();
			double carmenuprice=list.get(i).getCarprice();
			int carnum=list.get(i).getCarnum();
			double carprice=list.get(i).getCarprice();
			Car car=new Car(carmenuname,carmenupicture,carmenuprice,carnum,carprice);
			orderDao.addOrderDetail(car, orderid);
		}	
	}
	private void showOrder(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{

		String userid=request.getParameter("userid");
		request.setAttribute("userid",userid);
		request.getRequestDispatcher("myorder.jsp").forward(request, response);

	}
	private void adminShowOrderDetail(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String orderid=request.getParameter("orderid");
		Order order=orderDao.findOrderByid(orderid);
		List<OrderDetail> list=orderDao.findOrderDetail(orderid);
		request.setAttribute("orderDetail",order);
		request.setAttribute("orderDetailList",list);
		request.getRequestDispatcher("adminshoworderdetail.jsp").forward(request, response);
	}
	private void userShowOrderDetail(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String orderid=request.getParameter("orderid");
		Order order=orderDao.findOrderByid(orderid);
		List<OrderDetail> list=orderDao.findOrderDetail(orderid);
		request.setAttribute("orderDetail",order);
		request.setAttribute("orderDetailList",list);
		request.getRequestDispatcher("usershoworderdetail.jsp").forward(request, response);
	}
	private void manageOrder(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{

		request.getRequestDispatcher("manageorder.jsp").forward(request, response);

	}
	private void deleteAllCar(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		CarDao carDao=new CarDaoImpl();
		String userid=request.getParameter("userid"); 
		carDao.deleteAllCar(userid);
	}

}
