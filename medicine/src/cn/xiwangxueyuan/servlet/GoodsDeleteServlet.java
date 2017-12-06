package cn.xiwangxueyuan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiwangxueyuan.dao.GoodsDao;
import cn.xiwangxueyuan.model.Goods;

/**
 * Servlet implementation class GoodsDeleteServlet
 */
@WebServlet("/admin/goodsDelete.do")
public class GoodsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ѯ��Ҫɾ������Ʒ��Ϣ
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		GoodsDao gd=new GoodsDao();
		Goods deleteGoods=gd.queryById(goods_id);
		//����Ҫɾ������Ʒ��Ϣ���ݸ�ҳ��
		request.setAttribute("goods", deleteGoods);
		request.setAttribute("title", "ɾ����Ʒ��Ϣ");
		request.setAttribute("url", "goodsDelete.do");
		request.getRequestDispatcher("goodsEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ҳ����Ϣ
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		String goods_name=request.getParameter("goods_name");
		String goods_type=request.getParameter("goods_type");
		String goods_mdl=request.getParameter("goods_mdl");
		int goods_price=Integer.parseInt(request.getParameter("goods_price"));
		int goods_number=Integer.parseInt(request.getParameter("goods_number"));
		//ɾ��
		Goods goods=new Goods(goods_id);
		GoodsDao gd=new GoodsDao();
		gd.deleteInfo(goods);
		//��ת���б�ҳ��
		response.sendRedirect("goodsList.do");
	}

}
