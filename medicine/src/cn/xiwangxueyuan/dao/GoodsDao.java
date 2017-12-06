package cn.xiwangxueyuan.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xiwangxueyuan.model.Goods;

public class GoodsDao extends BaseDao{
	/**
	 * 分页查询
	 * @param nowPage
	 * @param pageSize
	 * @return
	 */
	
	public List<Goods> queryByPage (int nowPage,int pageSize){
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			this.getConnection();
			String sql="select * from m_goods limit ?,?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, (nowPage-1)*pageSize);
			pre.setInt(2, pageSize);
			re=pre.executeQuery();
			while(re.next()){
				Goods goods=getGoods(re);
				goodsList.add(goods);
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	//通过ID查询商品信息
	public Goods queryById(int goods_id){
		Goods goods=null;
		try {
			this.getConnection();
			String sql="select * from m_goods where goods_id=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, goods_id);
			re=pre.executeQuery();
			if(re.next()){
				goods=this.getGoods(re);
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
		
	}
	public Goods getGoods(ResultSet re) throws Exception{
		int goods_id=re.getInt("goods_id");
		String goods_name=re.getString("goods_name");
		String goods_type=re.getString("goods_type");
		String goods_mdl=re.getString("goods_mdl");
		int goods_price=re.getInt("goods_price");
		int goods_number=re.getInt("goods_number");
		String Goods_pic=re.getString("goods_pic");
		Goods goods=new Goods(goods_id, goods_name, goods_type, goods_mdl, goods_price, goods_number);
		goods.setGoods_pic(Goods_pic);
		return goods;
	}
	
	/**
	 * 查询商品总数
	 * @return
	 */
	public int getCount(){
		int count=0;
		try {
			this.getConnection();
			String sql="select count(goods_id) from m_goods";
			pre=con.prepareStatement(sql);
			re=pre.executeQuery();
			if(re.next()){
				count=re.getInt(1);				
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 添加商品信息
	 * @param goods
	 */
	public void add(Goods goods){
		try {
			this.getConnection();
			String sql="insert into m_goods(goods_name,goods_type,goods_mdl,goods_price,goods_number) values(?,?,?,?,?)";
			pre=con.prepareStatement(sql);
			pre.setString(1, goods.getGoods_name());
			pre.setString(2, goods.getGoods_type());
			pre.setString(3, goods.getGoods_mdl());
			pre.setInt(4, goods.getGoods_price());
			pre.setInt(5, goods.getGoods_number());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * 修改图片信息
	 * @param goods_id
	 * @param goods_pic
	 */
	public void update(int goods_id,String goods_pic){
		try {
			this.getConnection();
			String sql="update m_goods set goods_pic=? where goods_id=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, goods_pic);
			pre.setInt(2, goods_id);
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	/**
	 * 修改基本信息
	 * @param goods
	 */
	public void updateInfo(Goods goods){
		try {
			this.getConnection();String sql="update m_goods set goods_name=?,goods_type=?,goods_mdl=?,goods_price=?,goods_number=? where goods_id=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, goods.getGoods_name());
			pre.setString(2, goods.getGoods_type());
			pre.setString(3, goods.getGoods_mdl());
			pre.setInt(4, goods.getGoods_price());
			pre.setInt(5, goods.getGoods_number());
			pre.setInt(6, goods.getGoods_id());
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 删除商品信息
	 * @param goods
	 */
	public void deleteInfo(Goods goods){
		try {
			this.getConnection();
			String sql="delete from m_goods where goods_id=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, goods.getGoods_id());
			pre.executeUpdate();
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
