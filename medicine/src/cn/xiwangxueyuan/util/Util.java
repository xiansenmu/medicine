package cn.xiwangxueyuan.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




public class Util {
	private static Util util;
	
	public static Util getInstance(){
		if(util==null){
			util=new Util();
			
		}
		return util;
	}
	public String getNow(){
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=Calendar.getInstance().getTime();
		return sf.format(date);
	}
}
