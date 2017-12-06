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
		//�����û�Id
		String userId=request.getParameter("userId");
		//System.out.println("���ܵ�Id:"+userId);
		UserDao ud=new UserDao();
		User user=ud.queryById(userId);
		int flag=0;
		if(user==null){
			//˵��û�и��û�������ʹ��
			flag=1;
		}else{
			//�û���ռ�ã�������ʹ��
		}
		//����response�����������������Ϣ
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
