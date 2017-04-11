package vo;

import java.util.List;


/**
 * ��ҳ������
 * @author tanglc
 * @Date 2016��12��13�� ����9:59:49
 * @company hzitxx
 */
public class PageSupport<T> {
	/**
	 * ��ǰҳ��
	 */
	private int pageNo;
	/**
	 * ҳ��ʾ����
	 */
	private int pageSize;
	/**
	 * ��ҳ�����б�
	 */
	private List<T> rows;
	/**
	 * ��ҳ�ܼ�¼��
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
