package com.woniu.tools;

public class PageBean {
	//��ǰҳ
	private Integer nowPage = 1;
	//ÿҳ����
	private Integer pageRow = 5;
	//������
	private Integer countRow;
	//��ҳ��
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
