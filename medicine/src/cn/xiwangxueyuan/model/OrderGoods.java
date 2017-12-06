package cn.xiwangxueyuan.model;

public class OrderGoods {
	private int og_id;
	private String order_sn;
	private String goods_name;
	private String goods_type;
	private int goods_price;
	private int goods_number;
	private int buy_number;
	
	
	public OrderGoods(){
		
		
	}
	
	
	
	public OrderGoods(String order_sn, String goods_name, int goods_price,int buy_number) {
		super();
		this.order_sn = order_sn;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.buy_number = buy_number;
	}



	public OrderGoods(String order_sn, String goods_name, String goods_type,
			int goods_price, int goods_number, int buy_number) {
		this.order_sn = order_sn;
		this.goods_name = goods_name;
		this.goods_type = goods_type;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		this.buy_number = buy_number;
	}


	public OrderGoods(int og_id, String order_sn, String goods_name,String goods_type, int goods_price, int goods_number, int buy_number) {
		this.og_id = og_id;
		this.order_sn = order_sn;
		this.goods_name = goods_name;
		this.goods_type = goods_type;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		this.buy_number = buy_number;
	}
	public int getOg_id() {
		return og_id;
	}
	public void setOg_id(int og_id) {
		this.og_id = og_id;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
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
	public int getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}
	public int getBuy_number() {
		return buy_number;
	}
	public void setBuy_number(int buy_number) {
		this.buy_number = buy_number;
	}
	
	
}
