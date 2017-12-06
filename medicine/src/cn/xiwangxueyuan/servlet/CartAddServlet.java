package cn.xiwangxueyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CarAddServlet
 */
@WebServlet("/cartAdd")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		CartDao cd=new CartDao();
		// 判断是否登陆
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null){
			//证明没有登录，提示登陆			
			out.print("<script type='text/javascript'>alert('请先登录再购买!');window.location.href='login.jsp';</script>");
		}else{
			//说明登录了   将商品添加到购物车
			int goods_id=Integer.parseInt(request.getParameter("goods_id"));
			int buyNumber=Integer.parseInt(request.getParameter("buyNumber"));
			GoodsDao gd=new GoodsDao();
			Goods goods=gd.queryById(goods_id);
			//判断该用户是否已经添加了该商品
			Cart queryCart=cd.queryByCon(user.getUser_id(), goods.getGoods_id());
			if(queryCart==null){
				//证明没有添加则添加到数据库
				Cart cart=new Cart(user.getUser_id(),goods_id,buyNumber);
				cd.addCart(cart);
			}else{
				//说明数据库里有该商品   将数量加1再修改
				int newNumber=queryCart.getBuy_number()+buyNumber;
				cd.updateCartNumber(queryCart.getCart_id(), newNumber);			
			}
		}
		//跳转到购物车界面，将购物车的数据显示出来
		response.sendRedirect("cartQuery");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
