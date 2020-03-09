package com.woniu.tools;

public class PageBean {
	//当前页
	private Integer nowPage = 1;
	//每页行数
	private Integer pageRow = 5;
	//总行数
	private Integer countRow;
	//总页数
	private Integer countPage;
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	public Integer getPageRow() {
		return pageRow;
	}
	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}
	public Integer getCountRow() {
		return countRow;
	}
	public void setCountRow(Integer countRow) {
		this.countRow = countRow;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	
}
