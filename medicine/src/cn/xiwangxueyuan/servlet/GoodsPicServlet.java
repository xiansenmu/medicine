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
		//�����ļ��ϴ�������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//���û�������С
		factory.setSizeThreshold(4*1024);
		//�õ��������ϴ����߶���
		ServletFileUpload upload = new ServletFileUpload(factory);
		int goods_id=0;
		//��Web��Ŀ��Ŀ¼���ж��Ƿ�����ļ��У����������½�һ��
		String root=request.getRealPath("//goodsPic");
		File file=new File(root);
		if(!file.exists()){
			file.mkdir();	
		}
		String newFileName="";
		System.out.println(root);
		try {
			//�õ������ݹ����ļ��� 
			List<FileItem> fileList=upload.parseRequest(request);
			for(FileItem item:fileList){
				if(item.isFormField()){	
					goods_id=Integer.parseInt(item.getString());
				}else{
					String fileName=item.getName();
					//�ҵ��ļ���׺��
					String subFix=fileName.substring(fileName.lastIndexOf("."));
					//����һ����Զ���ظ����ļ���
					newFileName=Calendar.getInstance().getTime().getTime()+subFix;
					//����һ�����������ļ�
					File uploadedFile = new File(root+"/"+newFileName);
					//���ϴ���ͼƬд��������ļ�
					item.write(uploadedFile);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(goods_id);
		//ͨ��goodsIdȥ�޸����ݿ��ͼƬ�ֶ���Ϣ
		GoodsDao gd=new GoodsDao();
		gd.update(goods_id, newFileName);
		response.sendRedirect("goodsList.do");
	}

}
