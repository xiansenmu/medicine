package cn.xiwangxueyuan.model;

public class Region {
	
	private int regionId;
	private String regionName;
	private int regionUpId;
	private int regionState;
	
	
	public Region(){
		
		
	}
	
	public Region(int regionId, String regionName, int regionUpId,int regionState) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionUpId = regionUpId;
		this.regionState = regionState;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public int getRegionUpId() {
		return regionUpId;
	}
	public void setRegionUpId(int regionUpId) {
		this.regionUpId = regionUpId;
	}
	public int getRegionState() {
		return regionState;
	}
	public void setRegionState(int regionState) {
		this.regionState = regionState;
	}
	
	
	
}
