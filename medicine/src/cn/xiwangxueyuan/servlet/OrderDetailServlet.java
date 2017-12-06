package cn.xiwangxueyuan.servlet;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiwangxueyuan.dao.OrderDao;
import cn.xiwangxueyuan.dao.OrderGoodsDao;
import cn.xiwangxueyuan.model.Order;
import cn.xiwangxueyuan.model.OrderGoods;

/**
 * Servlet implementation class OrderDetailServlet
 */
@WebServlet("/orderDetail")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderSn=request.getParameter("sn");
		OrderDao od=new OrderDao();
		OrderGoodsDao ogd=new OrderGoodsDao();
		Order order=od.queryBySn(orderSn);
		List<OrderGoods> ogList=ogd.queryBySn(orderSn);
		request.setAttribute("order", order);
		request.setAttribute("ogList", ogList);
		request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
