package cn.xiwangxueyuan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiwangxueyuan.dao.GoodsDao;
import cn.xiwangxueyuan.model.Goods;
import cn.xiwangxueyuan.util.Mark;
import cn.xiwangxueyuan.util.Page;


/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/admin/goodsList.do")
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nowPage=1;
		int totalPage=0;
		if(request.getParameter("page")!=null){
			nowPage=Integer.parseInt(request.getParameter("page"));			
		}
		GoodsDao gd=new GoodsDao();
		int totalGoods=gd.getCount();
	    totalPage=(totalGoods % Mark.PAGE_SIZE==0) ? (totalGoods/Mark.PAGE_SIZE):(totalGoods/Mark.PAGE_SIZE+1); 
		
		//上一页  下一页
		//判断一下    如果是第一页      则不减一
		int prePage=(nowPage==1) ? nowPage : (nowPage-1);
		//判断一下   如果是最后一页      则不加一
		int nextPage=(nowPage == totalPage) ? totalPage : nowPage+1;
		String preLink="goodsList.do?page="+prePage;
		String nextLink="goodsList.do?page="+nextPage;
	    List<Goods> goodsList=gd.queryByPage(nowPage, Mark.PAGE_SIZE);
		Page page=new Page(nowPage, Mark.PAGE_SIZE, totalGoods, totalPage, preLink, nextLink);
		request.setAttribute("page", page);
	    request.setAttribute("goodsList",goodsList);
	    
	    request.getRequestDispatcher("goodsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
