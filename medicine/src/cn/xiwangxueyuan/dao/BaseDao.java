package cn.xiwangxueyuan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class BaseDao {
	
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/medical";
	private String user="root";
	private String password="root";
	
    protected Connection con;
    protected PreparedStatement pre;
    protected ResultSet re;
    
    public void getConnection(){
    	try {
    		Class.forName(driver);
    		con= DriverManager.getConnection(url,user,password);
    		//System.out.print("suc");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void close(){
    	try {
    		if(re!=null){
    			  re.close();
    		}
    		if(pre!=null){
    			pre.close();
     		}
    		if(con!=null){
    			con.close();
    		}
			
		} catch (Exception e) {
			System.out.println("关闭数据库资源出错");
			e.printStackTrace();
		}
    	
    }
    
    public static void main(String[] args){    	
    	new BaseDao().getConnection();
    }
    
}
