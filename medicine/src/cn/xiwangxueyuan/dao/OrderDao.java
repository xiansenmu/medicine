package cn.xiwangxueyuan.dao;

import java.util.ArrayList;
import java.util.List;

import cn.xiwangxueyuan.model.Order;

public class OrderDao extends BaseDao{
	
	public void add(Order order){
		try {
			this.getConnection();
			String sql="insert into m_order(user_id,order_sn,order_state,order_price,order_time) values(?,?,?,?,?)";
			pre=con.prepareStatement(sql);
			pre.setString(1, order.getUser_id());
			pre.setString(2, order.getOrder_sn());
			pre.setInt(3, order.getOrder_state());
			pre.setInt(4, order.getOrder_price());
			pre.setString(5, order.getOrder_time());
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
public void update(Order order){
	try {
		this.getConnection();
		String sql="update m_order set order_user_name=?,order_user_address=?,order_user_phone=? where order_sn=?";
		pre=con.prepareStatement(sql);
		pre.setString(1, order.getOrder_user_name());
		pre.setString(2, order.getOrder_user_address());
		pre.setString(3, order.getOrder_user_phone());
		pre.setString(4, order.getOrder_sn());
		pre.executeUpdate();
		this.close();
	} catch (Exception e) {
		e.printStackTrace();
		}	
	}
public Order queryBySn(String orderSn){
	Order order=null;
	try {
		this.getConnection();
		String sql="select * from m_order where order_sn=?";
		pre=con.prepareStatement(sql);
		pre.setString(1, orderSn);
		re=pre.executeQuery();
		if(re.next()){
			String name=re.getString("order_user_name");
			String address=re.getString("order_user_address");
			String phone=re.getString("order_user_phone");
			int price=re.getInt("order_price");
			String time=re.getString("order_time");
			order=new Order(name, address, phone,orderSn);
			order.setOrder_time(time);
			order.setOrder_price(price);
		}
		this.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return order;
	}
public List<Order> queryByUserId(String userId){
	List<Order> orderList=new ArrayList<Order>();
	try {
		this.getConnection();
		String sql="select * from m_order where user_id=?";
		pre=con.prepareStatement(sql);
		pre.setString(1, userId);
		re=pre.executeQuery();
		while(re.next()){
			int order_id=re.getInt("order_id");
			String order_sn=re.getString("order_sn");
			String order_user_name=re.getString("order_user_name");
			String order_user_address=re.getString("order_user_address");
			String order_user_phone=re.getString("order_user_phone");
			String order_time=re.getString("order_time");
			int price=re.getInt("order_price");
			Order order=new Order(order_id,order_sn,order_user_name,order_user_address,order_user_phone,order_time,price);
			orderList.add(order);			
		}
		this.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return orderList;
}
}
