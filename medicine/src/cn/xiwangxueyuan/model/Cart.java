package cn.xiwangxueyuan.model;

public class Cart {
	private int cart_id;
	private String user_id;
	private int goods_id;
	private int buy_number;
	
	
	//不是对应的数据库字段  为了页面显示
	private String goods_name;
	private String goods_type;
	private int goods_price;
	
	public Cart(){

	}
	
	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	
	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public Cart( String user_id, int goods_id, int buy_number) {
		this.user_id = user_id;
		this.goods_id=goods_id;
		this.buy_number = buy_number;
	}
	public Cart(int cart_id) {
		this.cart_id = cart_id;

	}
	public Cart(int cart_id, String user_id, int goods_id , int buy_number) {
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.goods_id=goods_id;
		this.buy_number = buy_number;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public int getBuy_number() {
		return buy_number;
	}
	public void setBuy_number(int buy_number) {
		this.buy_number = buy_number;
	}
	
	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	
}
