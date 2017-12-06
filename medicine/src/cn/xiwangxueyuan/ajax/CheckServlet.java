package cn.xiwangxueyuan.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiwangxueyuan.dao.UserDao;
import cn.xiwangxueyuan.model.User;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受用户Id
		String userId=request.getParameter("userId");
		//System.out.println("接受的Id:"+userId);
		UserDao ud=new UserDao();
		User user=ud.queryById(userId);
		int flag=0;
		if(user==null){
			//说明没有该用户，可以使用
			flag=1;
		}else{
			//用户被占用，不可以使用
		}
		//采用response的输出对象给浏览器信息
		PrintWriter out = response.getWriter();
		out.print(flag);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
