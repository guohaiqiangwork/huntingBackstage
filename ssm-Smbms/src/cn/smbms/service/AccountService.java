package cn.smbms.service;


import cn.smbms.pojo.Account;

/**
 * 账号密码
 * @author 若水一涵
 *
 */
public interface AccountService {
	/**
	 * 添加
	 * @param account
	 * @return
	 */
	public int add(Account account);
	
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public int update(Account account);
	
	/**
	 * 删除
	 * @param idAccount
	 * @return
	 */
	public int delete(String idAccount);
	
	/**
	 * 登录
	 * @param account
	 * @return
	 */
	public Account login(Account account);
}
