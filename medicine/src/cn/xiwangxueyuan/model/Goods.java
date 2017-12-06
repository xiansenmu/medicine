package cn.xiwangxueyuan.model;

public class Goods {
	private int goods_id;
	private String goods_name;
	private String goods_type;//类别
	private String goods_mdl;//mdl
	private int goods_price;//价格
	private int goods_number;//库存
	private String goods_pic;//图片
	
	public Goods(){
		
		
	}
	
	public Goods( String goods_name, String goods_type,String goods_mdl, int goods_price, int goods_number) {
		this.goods_name = goods_name;
		this.goods_type = goods_type;
		this.goods_mdl = goods_mdl;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		
	}
	public Goods(int goods_id) {
		this.goods_id = goods_id;
	
	}
	public Goods(int goods_id, String goods_name, String goods_type,String goods_mdl, int goods_price, int goods_number) {
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_type = goods_type;
		this.goods_mdl = goods_mdl;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		
	}
	public Goods(int goods_id, String goods_name, String goods_type,String goods_mdl, int goods_price, int goods_number,String goods_pic) {
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_type = goods_type;
		this.goods_mdl = goods_mdl;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		this.goods_pic = goods_pic;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
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
	public String getGoods_mdl() {
		return goods_mdl;
	}
	public void setGoods_mdl(String goods_mdl) {
		this.goods_mdl = goods_mdl;
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
	public String getGoods_pic() {
		return goods_pic;
	}
	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}
	
	
}
