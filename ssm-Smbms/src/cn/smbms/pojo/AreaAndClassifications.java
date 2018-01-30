package cn.smbms.pojo;

import java.util.List;

/**
 * 所有地区和分类集合类
 * @author 若水一涵
 *
 */
public class AreaAndClassifications {
	
	private List<Area> area;
	
	private List<Classification> classification;

	public List<Area> getArea() {
		return area;
	}

	public void setArea(List<Area> area) {
		this.area = area;
	}

	public List<Classification> getClassification() {
		return classification;
	}

	public void setClassification(List<Classification> classification) {
		this.classification = classification;
	}

}
