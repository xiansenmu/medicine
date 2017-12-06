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
 * Servlet implementation class GoodsAddServlet
 */
@WebServlet("/admin/goodsAdd.do")
public class GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "添加药品信息");
		request.setAttribute("url", "goodsAdd.do");
		request.getRequestDispatcher("goodsEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收页面信息
		String goods_name=request.getParameter("goods_name");
		String goods_type=request.getParameter("goods_type");
		String goods_mdl=request.getParameter("goods_mdl");
		int goods_price=Integer.parseInt(request.getParameter("goods_price"));
		int goods_number=Integer.parseInt(request.getParameter("goods_number"));
	    //将接受的内容写入数据库
		Goods goods=new Goods(goods_name,goods_type,goods_mdl,goods_price,goods_number);
		GoodsDao gd=new GoodsDao();
		gd.add(goods);
		//跳回列表
		response.sendRedirect("goodsList.do");
	}

}
