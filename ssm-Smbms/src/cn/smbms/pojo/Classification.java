package cn.smbms.pojo;

/**
 * 职业分类
 * 
 * @author 若水一涵
 *
 */
public class Classification {

	private String idClassification;

	private String className;

	private Integer classType;

	private String relation;

	public String getIdClassification() {
		return idClassification;
	}

	public void setIdClassification(String idClassification) {
		this.idClassification = idClassification;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassType() {
		return classType;
	}

	public void setClassType(Integer classType) {
		this.classType = classType;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
}
