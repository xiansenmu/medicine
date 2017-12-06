package cn.xiwangxueyuan.model;

import java.util.List;

public class Order {
	private int order_id;
	private String user_id;
	private String order_sn;
	private String order_user_name;
	private String order_user_address;
	private String order_user_phone;
	private int order_price;
	private String order_time;
	private int order_state;//1是未付款2是已付款，等待发货3是已发货，等待收货，4货到未付款，5是已收货
	
	private List<OrderGoods> ogList;//订单商品列表

	public Order(){
		
		
	}
	
	public Order(int order_id,String order_sn,String order_time,int order_price){
		this.order_id=order_id;
		this.order_sn = order_sn;
		
		this.order_time=order_time;
		this.order_price=order_price;
	}
	
	public Order(int order_id,String order_sn,String order_user_name,String order_user_address,String order_user_phone,String order_time,int order_price){
		this.order_id=order_id;
		this.order_sn = order_sn;
		this.order_user_name= order_user_name;
		this.order_user_address = order_user_address;
		this.order_user_phone = order_user_phone;
		this.order_time=order_time;
		this.order_price=order_price;
	}
	
	public Order(String order_user_name,String order_user_address,String order_user_phone,String order_sn){
		this.order_user_name=order_user_name;
		this.order_sn = order_sn;
		this.order_user_address=order_user_address;
		this.order_user_phone=order_user_phone;
	}
	
	public Order(String user_id,String order_sn, int order_state){
		this.user_id = user_id;
		this.order_sn = order_sn;
		this.order_state = order_state;
	}

	public Order(int order_id, String user_id, String order_sn,
			String order_user_name, String order_user_address,
			String order_user_phone, int order_state, int order_price) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_sn = order_sn;
		this.order_user_name = order_user_name;
		this.order_user_address = order_user_address;
		this.order_user_phone = order_user_phone;
		this.order_state = order_state;
		this.order_price = order_price;
	}


	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	public String getOrder_user_name() {
		return order_user_name;
	}
	public void setOrder_user_name(String order_user_name) {
		this.order_user_name = order_user_name;
	}
	public String getOrder_user_address() {
		return order_user_address;
	}
	public void setOrder_user_address(String order_user_address) {
		this.order_user_address = order_user_address;
	}
	public String getOrder_user_phone() {
		return order_user_phone;
	}
	public void setOrder_user_phone(String order_user_phone) {
		this.order_user_phone = order_user_phone;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public int getOrder_price() {
		return order_price;
	}


	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public List<OrderGoods> getOgList() {
		return ogList;
	}

	public void setOgList(List<OrderGoods> ogList) {
		this.ogList = ogList;
	}
	

}
