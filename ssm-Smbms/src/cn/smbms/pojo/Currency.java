package cn.smbms.pojo;

/**
 * 通用类
 * @author 若水一涵
 *
 * @param <T>
 */
public class Currency<T> {

	private T data;
	
	private Pagination pagination;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
