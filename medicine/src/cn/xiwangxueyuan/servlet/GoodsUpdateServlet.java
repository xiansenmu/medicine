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
 * Servlet implementation class GoodsUpdateServlet
 */
@WebServlet("/admin/goodsUpdate.do")
public class GoodsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ɲ�ѯ��Ҫ�޸ĵ���Ʒ��Ϣ
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		GoodsDao gd=new GoodsDao();
		Goods updateGoods=gd.queryById(goods_id);
		//����Ҫ�޸ĵ�ҳ����Ϣ���ݸ�ҳ��
		request.setAttribute("goods", updateGoods);
		request.setAttribute("title", "�޸���Ʒ��Ϣ");
		request.setAttribute("url", "goodsUpdate.do");
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
			//�޸�
			Goods goods=new Goods(goods_id, goods_name, goods_type, goods_mdl, goods_price, goods_number);
			GoodsDao gd=new GoodsDao();
			gd.updateInfo(goods);
			//��ת���б�ҳ��		
			response.sendRedirect("goodsList.do");
	}

}
