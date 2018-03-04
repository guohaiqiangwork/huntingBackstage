package cn.smbms.pojo;

import java.util.Date;

/**
 * 证书培训
 * 
 * @author 若水一涵
 *
 */
public class Train {

	private String idTrain;
	// 操作时间
	private Date time;
	// 标题
	private String title;
	// 类型：1建造师培训，2工程师评审，3岗位证报名，4技工证办理
	private Integer type;
	// 来源
	private String source;
	// 浏览量
	private Integer browsingNumber;
	// 内容
	private String content;
	// 附件id
	private String idFile;
	// 图片存放路径
	private String htmlUrl;

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getIdTrain() {
		return idTrain;
	}

	public void setIdTrain(String idTrain) {
		this.idTrain = idTrain;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getBrowsingNumber() {
		return browsingNumber;
	}

	public void setBrowsingNumber(Integer browsingNumber) {
		this.browsingNumber = browsingNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

}
