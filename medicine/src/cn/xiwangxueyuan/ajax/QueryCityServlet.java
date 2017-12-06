package cn.xiwangxueyuan.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.xiwangxueyuan.dao.RegionDao;
import cn.xiwangxueyuan.model.Region;

/**
 * Servlet implementation class QueryCityServlet
 */
@WebServlet("/queryCity")
public class QueryCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCityServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		int id=Integer.parseInt(request.getParameter("id"));
		RegionDao rd=new RegionDao();
		List<Region> regionList=rd.queryList(id);
		//JSON包的封装【将JAVA的对象或者集合封装成JOSN格式】
		JSONArray ja=JSONArray.fromObject(regionList);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		//后台测试代码
		/*for(Region region:regionList){
			System.out.println(region.getRegionName());
		}*/
	}

}
