package cn.xiwangxueyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import cn.xiwangxueyuan.model.User;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null){
			OrderDao od=new OrderDao();
			OrderGoodsDao ogd=new OrderGoodsDao();
			List<Order> orderList=od.queryByUserId(user.getUser_id());
			if(orderList!=null){
				for(Order order:orderList){
					List<OrderGoods> ogList=ogd.queryBySn(order.getOrder_sn());
					order.setOgList(ogList);
				}
			}
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("orderList.jsp").forward(request, response);
		}else{
			out.print("<script type='text/javascript'>alert('请先登录再查询订单!');window.location.href='login.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
