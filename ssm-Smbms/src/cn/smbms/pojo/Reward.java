package cn.smbms.pojo;

import java.util.Date;

public class Reward {

	private Integer idreward;
	
	private Date time;
	
	private String periods;
	
	private String number;
	
	private Integer total;
	
	private String size;
	
	private String singleAndDouble;

	public Integer getIdreward() {
		return idreward;
	}

	public void setIdreward(Integer idreward) {
		this.idreward = idreward;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPeriods() {
		return periods;
	}

	public void setPeriods(String periods) {
		this.periods = periods;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSingleAndDouble() {
		return singleAndDouble;
	}

	public void setSingleAndDouble(String singleAndDouble) {
		this.singleAndDouble = singleAndDouble;
	}
}
