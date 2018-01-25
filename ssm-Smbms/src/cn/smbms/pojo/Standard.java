package cn.smbms.pojo;

import java.util.Date;
/**
 * 资质动态实体类
 * @author 若水一涵
 *
 */
public class Standard {

	private String idStandard;
	// 操作时间
	private Date time;
	// 标题
	private String title;
	// 类型：1代表政策，2代表公告，3代表行业新闻
	private Integer type;
	// 来源
	private String source;
	// 浏览量
	private Integer browsingNumber;
	// 内容
	private String content;
	// 附件id
	private String idFile;
	
	public String getIdStandard() {
		return idStandard;
	}
	public void setIdStandard(String idStandard) {
		this.idStandard = idStandard;
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
