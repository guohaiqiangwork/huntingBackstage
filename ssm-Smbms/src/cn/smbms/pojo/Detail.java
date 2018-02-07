package cn.smbms.pojo;

import java.util.List;

/**
 * 详情
 * 
 * @author 若水一涵
 *
 */
public class Detail<T> {

	// 当前文章
	private T current;
	// 上一篇
	private T previous;
	// 下一篇
	private T next;
	// 关联文章
	private List<Relevant> relevant;
	public T getCurrent() {
		return current;
	}
	public void setCurrent(T current) {
		this.current = current;
	}
	public T getPrevious() {
		return previous;
	}
	public void setPrevious(T previous) {
		this.previous = previous;
	}
	public T getNext() {
		return next;
	}
	public void setNext(T next) {
		this.next = next;
	}
	public List<Relevant> getRelevant() {
		return relevant;
	}
	public void setRelevant(List<Relevant> relevant) {
		this.relevant = relevant;
	}
	
}
