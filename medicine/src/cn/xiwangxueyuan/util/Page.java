package cn.xiwangxueyuan.util;

public class Page {
	
	private int nowPage;
	private int pageSize;
	private int totalNumber;
	private int totalPage;
	private String preLink;
	private String nextLink;
	private String firstLink;
	private String lastLink;
	
	public Page(){

	}
	
	public Page(int nowPage, int pageSize, int totalNumber, int totalPage,String preLink, String nextLink) {
		this.nowPage = nowPage;
		this.pageSize = pageSize;
		this.totalNumber = totalNumber;
		this.totalPage = totalPage;
		this.preLink = preLink;
		this.nextLink = nextLink;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getPreLink() {
		return preLink;
	}
	public void setPreLink(String preLink) {
		this.preLink = preLink;
	}
	public String getNextLink() {
		return nextLink;
	}
	public void setNextLink(String nextLink) {
		this.nextLink = nextLink;
	}
	public String getFirstLink() {
		return firstLink;
	}
	public void setFirstLink(String firstLink) {
		this.firstLink = firstLink;
	}
	public String getLastLink() {
		return lastLink;
	}
	public void setLastLink(String lastLink) {
		this.lastLink = lastLink;
	}
	
	
}
