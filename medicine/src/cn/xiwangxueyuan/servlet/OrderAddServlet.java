package cn.xiwangxueyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiwangxueyuan.dao.CartDao;
import cn.xiwangxueyuan.dao.GoodsDao;
import cn.xiwangxueyuan.dao.OrderDao;
import cn.xiwangxueyuan.dao.OrderGoodsDao;
import cn.xiwangxueyuan.model.Cart;
import cn.xiwangxueyuan.model.Goods;
import cn.xiwangxueyuan.model.Order;
import cn.xiwangxueyuan.model.OrderGoods;
import cn.xiwangxueyuan.model.User;
import cn.xiwangxueyuan.util.Util;

/**
 * Servlet implementation class OrderAddServlet
 */
@WebServlet("/orderAdd")
public class OrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String [] cartIds=request.getParameterValues("cartIds");
		
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null){
			if(cartIds!=null){
				//����һ��������Ϣ��д�����ݿ�
				String order_sn=String.valueOf(Calendar.getInstance().getTime().getTime());
				Order order=new Order(user.getUser_id(), order_sn, 1);
				OrderDao od=new OrderDao();
				CartDao cd=new CartDao();
				GoodsDao gd=new GoodsDao();
				OrderGoodsDao ogd=new OrderGoodsDao();
				
				//�������飬ȡ����Ʒ���ݣ���װ�ɶ���д�����ݿ�
				int orderPrice=0;
				for(int i=0;i<cartIds.length;i++){
					int cartId=Integer.parseInt(cartIds[i]);
					//��ѯ���ﳵ��¼����Ʒ��¼
					Cart cart=cd.queryById(cartId);
					Goods goods=gd.queryById(cart.getGoods_id());
					//��װ�ɶ�����Ʒ����  д�����ݿ�
					OrderGoods og=new OrderGoods(order_sn,goods.getGoods_name(),goods.getGoods_type(),goods.getGoods_price(),goods.getGoods_number(),cart.getBuy_number());
					ogd.add(og);
					//���ﳵ���ˣ�ɾ�����ﳵ��¼
					cd.deleteInfo(cartId);
					orderPrice+=cart.getBuy_number()*goods.getGoods_price();
				}
				order.setOrder_price(orderPrice);
				order.setOrder_time(Util.getInstance().getNow());
				od.add(order);
				response.sendRedirect("orderAddress?orderSn="+order.getOrder_sn());
			}else{
				out.print("<script type='text/javascript'>alert('��ѡ������Ʒ���ύ����!');window.location.href='cartQuery';</script>");
			}
			
			
		}else{
			out.print("<script type='text/javascript'>alert('���ȵ�¼���ύ����!');window.location.href='login.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
