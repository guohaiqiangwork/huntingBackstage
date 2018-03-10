package cn.smbms.pojo;
/**
 * 账号密码
 * @author 若水一涵
 *
 */
public class Account {
	private String idAccount;

	private String userName;

	private String password;

	private String jurisdiction;
	
	private String mailbox;
	
	private String name;

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

}
