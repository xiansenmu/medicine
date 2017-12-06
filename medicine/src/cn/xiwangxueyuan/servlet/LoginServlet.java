package cn.xiwangxueyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xiwangxueyuan.dao.UserDao;
import cn.xiwangxueyuan.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		//通过ID去数据库查询记录
		UserDao ud=new UserDao();
		User queryUser=ud.queryById(user);
		if(queryUser!=null){
			if(queryUser.getUser_pass().equals(password)){
				HttpSession session=request.getSession();
				session.setAttribute("user", queryUser);
				if(queryUser.getUser_state()==1){
					response.sendRedirect("admin/goodsList.do");
				}else if(queryUser.getUser_state()==2){
					response.sendRedirect("indexdetail.do");
				}
			}else{
				out.print("<script type='text/javascript'>alert('用户名或密码错误。');window.location.href='login.jsp';</script>");
			}
		}else{
			out.print("<script type='text/javascript'>alert('用户名或密码错误。');window.location.href='login.jsp';</script>");
		}
	}

}
