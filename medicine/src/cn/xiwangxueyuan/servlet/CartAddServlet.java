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
		// �ж��Ƿ��½
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null){
			//֤��û�е�¼����ʾ��½			
			out.print("<script type='text/javascript'>alert('���ȵ�¼�ٹ���!');window.location.href='login.jsp';</script>");
		}else{
			//˵����¼��   ����Ʒ��ӵ����ﳵ
			int goods_id=Integer.parseInt(request.getParameter("goods_id"));
			int buyNumber=Integer.parseInt(request.getParameter("buyNumber"));
			GoodsDao gd=new GoodsDao();
			Goods goods=gd.queryById(goods_id);
			//�жϸ��û��Ƿ��Ѿ�����˸���Ʒ
			Cart queryCart=cd.queryByCon(user.getUser_id(), goods.getGoods_id());
			if(queryCart==null){
				//֤��û���������ӵ����ݿ�
				Cart cart=new Cart(user.getUser_id(),goods_id,buyNumber);
				cd.addCart(cart);
			}else{
				//˵�����ݿ����и���Ʒ   ��������1���޸�
				int newNumber=queryCart.getBuy_number()+buyNumber;
				cd.updateCartNumber(queryCart.getCart_id(), newNumber);			
			}
		}
		//��ת�����ﳵ���棬�����ﳵ��������ʾ����
		response.sendRedirect("cartQuery");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
