package cn.xiwangxueyuan.dao;

import java.util.ArrayList;
import java.util.List;

import cn.xiwangxueyuan.model.OrderGoods;

public class OrderGoodsDao extends BaseDao{
	
	public void add(OrderGoods og){
		try {
			this.getConnection();
			String sql="insert into order_goods(order_sn,goods_name,goods_type,goods_price,goods_number,buy_number) values(?,?,?,?,?,?)";
			pre=con.prepareStatement(sql);
			pre.setString(1, og.getOrder_sn());
			pre.setString(2, og.getGoods_name());
			pre.setString(3, og.getGoods_type());
			pre.setInt(4, og.getGoods_price());
			pre.setInt(5, og.getGoods_number());
			pre.setInt(6, og.getBuy_number());
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public List<OrderGoods> queryBySn(String orderSn){
		List<OrderGoods> ogList=new ArrayList<OrderGoods>();
		try {
			this.getConnection();
			String sql="select * from order_goods where order_sn=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, orderSn);
			re=pre.executeQuery();
			while(re.next()){
				String goodsName=re.getString("goods_name");
				int goodsPrice=re.getInt("goods_price");
				int buyNumber=re.getInt("buy_number");
				OrderGoods og=new OrderGoods(orderSn, goodsName, goodsPrice, buyNumber);
				ogList.add(og);
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ogList;
	}
}
