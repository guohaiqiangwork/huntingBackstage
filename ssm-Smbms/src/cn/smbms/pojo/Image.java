package cn.smbms.pojo;

import java.util.Date;

/**
 * 图片实体类
 * @author 若水一涵
 *
 */
public class Image {

	private String idImages;
	// 真实存储地址
	private String realUrl;
	// 外键id
	private String imagesForeignId;
	public String getIdImages() {
		return idImages;
	}
	public void setIdImages(String idImages) {
		this.idImages = idImages;
	}
	public String getRealUrl() {
		return realUrl;
	}
	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	public String getImagesForeignId() {
		return imagesForeignId;
	}
	public void setImagesForeignId(String imagesForeignId) {
		this.imagesForeignId = imagesForeignId;
	}
	
	public Image() {
		idImages = new Date().getTime()+"";
	}
}
