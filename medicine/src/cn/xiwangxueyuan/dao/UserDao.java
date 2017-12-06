package cn.xiwangxueyuan.dao;

import cn.xiwangxueyuan.model.User;

public class UserDao extends BaseDao{
	
	public User queryById(String userId){
		User user=null;
		try {
			this.getConnection();
			String sql="select * from m_user where user_id=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, userId);
			re=pre.executeQuery();
			if(re.next()){
				String user_name=re.getString("user_name");
				String user_pass=re.getString("user_pass");
				int user_state=re.getInt("user_state");
				user=new User(userId, user_name, user_pass, user_state);
				
			}
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}

}
