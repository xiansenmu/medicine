package cn.xiwangxueyuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import cn.xiwangxueyuan.model.Cart;

public class CartDao extends BaseDao {
	
	/**
	 * 通过USER—_Id和GOODSID查询购物车是否存在该商品
	 * @param user_id
	 * @param goods_id
	 * @return
	 */
	public Cart queryByCon(String user_id,int goods_id){
		Cart cart=null;
		try {
			this.getConnection();
			String sql="select * from m_cart where user_id=? and goods_id=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, user_id);
			pre.setInt(2, goods_id);
			re=pre.executeQuery();
			if(re.next()){
				cart=this.getByResult(re);
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	/**
	 * 取得结果集 
	 * @param re
	 * @return
	 * @throws Exception
	 */
	public Cart getByResult(ResultSet re) throws Exception{
		int cart_id=re.getInt("cart_id");
		String user_id=re.getString("user_id");
		int goods_id=re.getInt("goods_id");
		int buy_number=re.getInt("buy_number");
		Cart cart=new Cart(cart_id, user_id, goods_id, buy_number);
		return cart;
	}
	/**
	 * 通过CARTID查询购物车信息
	 * @return
	 */
	public Cart queryById(int cart_id){
		Cart cart=null;
		try {
			this.getConnection();
			String sql="select * from m_cart where cart_id=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, cart_id);
			re=pre.executeQuery();
			if(re.next()){
				cart=this.getByResult(re);				
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	/**
	 * 通过USERID查询购物车信息
	 * @param userId
	 * @return
	 */
	public List<Cart> queryByUserId(String userId){
		List<Cart> cartList=new ArrayList<Cart>();
		try {
			this.getConnection();
			String sql="select * from m_cart where user_id=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, userId);
			re=pre.executeQuery();
			while(re.next()){
				Cart cart=this.getByResult(re);
				cartList.add(cart);
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}
	/**
	 * 通过ID删除购物车信息
	 * @param cart
	 */
	public void deleteInfo(int cartId){
		try {
			this.getConnection();
			String sql="delete from m_cart where cart_id=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1,cartId);
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 添加到购物车
	 * @param cart
	 */
	public void addCart(Cart cart){
		try {
			this.getConnection();
			String sql="insert into m_cart(user_id,goods_id,buy_number) values(?,?,?)";
			pre=con.prepareStatement(sql);
			pre.setString(1, cart.getUser_id());
			pre.setInt(2, cart.getGoods_id());
			pre.setInt(3, cart.getBuy_number());
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	/**
	 * 修改购买数量
	 * @param cart_id
	 * @param buy_number
	 */
	public void updateCartNumber(int cart_id,int buy_number){
		try {
			this.getConnection();
			String sql="update m_cart set buy_number=? where cart_id=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, buy_number);
			pre.setInt(2, cart_id);
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
}
