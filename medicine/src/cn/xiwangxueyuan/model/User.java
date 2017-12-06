package cn.xiwangxueyuan.model;

public class User {
	private String user_id;
	private String user_name;
	private String user_pass;
	private int user_state;//1是管理员，2是普通用户
	
	public User(){
		
		
	}
	
	public User(String user_id, String user_name, String user_pass,	int user_state) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.user_state = user_state;
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public int getUser_state() {
		return user_state;
	}

	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}
	
}
