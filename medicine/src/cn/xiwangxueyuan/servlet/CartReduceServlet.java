package cn.xiwangxueyuan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiwangxueyuan.dao.CartDao;

/**
 * Servlet implementation class CartReduceServlet
 */
@WebServlet("/cartReduce")
public class CartReduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartReduceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId=Integer.parseInt(request.getParameter("id"));
		int number=Integer.parseInt(request.getParameter("number"));
		int flag=Integer.parseInt(request.getParameter("flag"));
		int newNumber=0;
		// 注：1是减2是加
		if(flag==1){
			if(number==1){
				//不能再减了   直接删除
				newNumber=1;
			}else{
				//在原来的基础上加1
				newNumber=number-1;
			}
		}else if(flag==2){
			newNumber=number+1;
		}
		//根据ID修改购物车数量
		CartDao cd=new CartDao();
		cd.updateCartNumber(cartId,newNumber);
		response.sendRedirect("cartQuery");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
