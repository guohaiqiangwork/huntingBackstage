package cn.smbms.pojo;
/**
 * 关联文章
 * @author 若水一涵
 *
 */
public class Relevant {

	private String idRelevant;
	// 关联模块：1资讯动态，2代办资质，3证书培训，4资质流程
	private Integer relevantModule;
	// 当前文章关联id
	private String relevantId;
	// 关联文章id
	private String articleId;
	// 关联文章标题
	private String articleTitle;
	public String getIdRelevant() {
		return idRelevant;
	}
	public void setIdRelevant(String idRelevant) {
		this.idRelevant = idRelevant;
	}
	public Integer getRelevantModule() {
		return relevantModule;
	}
	public void setRelevantModule(Integer relevantModule) {
		this.relevantModule = relevantModule;
	}
	public String getRelevantId() {
		return relevantId;
	}
	public void setRelevantId(String relevantId) {
		this.relevantId = relevantId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	
}
