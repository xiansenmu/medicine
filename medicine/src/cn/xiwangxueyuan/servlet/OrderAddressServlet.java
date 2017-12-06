package cn.xiwangxueyuan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiwangxueyuan.dao.OrderDao;
import cn.xiwangxueyuan.model.Order;

/**
 * Servlet implementation class OrderAddressServlet
 */
@WebServlet("/orderAddress")
public class OrderAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderSn=request.getParameter("orderSn");
		request.setAttribute("orderSn", orderSn);
		request.getRequestDispatcher("orderAddress.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收信息
		String sn=request.getParameter("sn");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		Order order=new Order(name,address,phone,sn);
		
		OrderDao od=new OrderDao();
		od.update(order);
		response.sendRedirect("orderDetail?sn="+sn);
	}

}
