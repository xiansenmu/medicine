package cn.xiwangxueyuan.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.xiwangxueyuan.dao.GoodsDao;

/**
 * Servlet implementation class GoodsPicServlet
 */
@WebServlet("/admin/goodsPic.do")
public class GoodsPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsPicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		request.setAttribute("goods_id", goods_id);
		request.getRequestDispatcher("goodsPic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建文件上传工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置缓冲区大小
		factory.setSizeThreshold(4*1024);
		//得到控制器上传工具对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		int goods_id=0;
		//在Web项目根目录下判断是否存在文件夹，不存在则新建一个
		String root=request.getRealPath("//goodsPic");
		File file=new File(root);
		if(!file.exists()){
			file.mkdir();	
		}
		String newFileName="";
		System.out.println(root);
		try {
			//得到表单传递过来的集合 
			List<FileItem> fileList=upload.parseRequest(request);
			for(FileItem item:fileList){
				if(item.isFormField()){	
					goods_id=Integer.parseInt(item.getString());
				}else{
					String fileName=item.getName();
					//找到文件后缀名
					String subFix=fileName.substring(fileName.lastIndexOf("."));
					//生成一个永远不重复的文件名
					newFileName=Calendar.getInstance().getTime().getTime()+subFix;
					//创建一个服务器的文件
					File uploadedFile = new File(root+"/"+newFileName);
					//将上传的图片写入服务器文件
					item.write(uploadedFile);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(goods_id);
		//通过goodsId去修改数据库的图片字段信息
		GoodsDao gd=new GoodsDao();
		gd.update(goods_id, newFileName);
		response.sendRedirect("goodsList.do");
	}

}
