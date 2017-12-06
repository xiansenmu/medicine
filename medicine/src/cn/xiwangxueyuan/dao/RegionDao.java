package cn.xiwangxueyuan.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;









import cn.xiwangxueyuan.model.Region;

public class RegionDao extends BaseDao{
	
	public List<Region> queryList(int id){
		List<Region> regionList=new ArrayList<Region>();
		try {
			this.getConnection();
			String sql="select * from region where r_up_id=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, id);
			re=pre.executeQuery();
			while(re.next()){
				Region region=this.queryByRe(re);
				regionList.add(region);
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return regionList;
	}
	
	public List<Region> querySonList(){
			
			List<Region> regionList=new ArrayList<Region>();
			try {
				this.getConnection();
				String sql="select * from region where r_up_id=2";
				pre=con.prepareStatement(sql);
				re=pre.executeQuery();
				while(re.next()){
					Region region=this.queryByRe(re);
					regionList.add(region);
				}
				this.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return regionList;
		}
	//查找结果集
	public Region queryByRe(ResultSet re) throws SQLException{
		int regionId=re.getInt("r_id");
		String regionName=re.getString("r_name");
		int regionUpId=re.getInt("r_up_id");
		int regionState=re.getInt("r_state");
		Region region=new Region(regionId, regionName, regionUpId, regionState);
		return region;
		
	}
}
