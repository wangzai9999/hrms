package com.util;

import java.io.Serializable;
import java.util.List;

public class PageBean  implements Serializable {
	private int currpage;//当前页
	private int pageSize=5;//一页显示的条数
	private int totalNum;//总条数
	private int totalPage;//总页码
	private List  list;//装  翻页数据
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		
		/*if (totalNum%totalNum==0) {
			totalPage=totalNum/pageSize;
		}else {
			totalPage=totalNum/pageSize+1;
		}*/

		totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}


}
