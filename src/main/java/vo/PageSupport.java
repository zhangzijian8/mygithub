package vo;

import java.util.List;


/**
 * 分页工具类
 * @author tanglc
 * @Date 2016年12月13日 上午9:59:49
 * @company hzitxx
 */
public class PageSupport<T> {
	/**
	 * 当前页码
	 */
	private int pageNo;
	/**
	 * 页显示行数
	 */
	private int pageSize;
	/**
	 * 分页数据列表
	 */
	private List<T> rows;
	/**
	 * 分页总记录数
	 */
	private int total;
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public PageSupport() {
		super();
	}
	
	
	

}
