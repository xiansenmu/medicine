package cn.xiwangxueyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xiwangxueyuan.dao.CartDao;
import cn.xiwangxueyuan.dao.GoodsDao;
import cn.xiwangxueyuan.model.Cart;
import cn.xiwangxueyuan.model.Goods;
import cn.xiwangxueyuan.model.User;

/**
 * Servlet implementation class CartQueryServlet
 */
@WebServlet("/cartQuery")
public class CartQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//�ж��Ƿ��¼
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){
				//�û���Ϣ��Ϊ��   ���Բ�ѯ���ﳵ��Ϣ
				CartDao cd=new CartDao();
				GoodsDao gd=new GoodsDao();
				List<Cart> cartList=cd.queryByUserId(user.getUser_id());
				int totalPrice=0;
				if(cartList!=null){
					for(Cart cart:cartList){
						int goodsId=cart.getGoods_id();
						Goods goods=gd.queryById(goodsId);
						cart.setGoods_name(goods.getGoods_name());
						cart.setGoods_type(goods.getGoods_type());
						cart.setGoods_price(goods.getGoods_price());
						totalPrice=totalPrice+goods.getGoods_price()*cart.getBuy_number();
					}
				}
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("cartList", cartList);
				request.getRequestDispatcher("cartList.jsp").forward(request, response);
		}else{
			//֤��û�е�¼����ʾ��½			
			out.print("<script type='text/javascript'>alert('���ȵ�¼�ٲ�ѯ���ﳵ��¼!');window.location.href='login.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
