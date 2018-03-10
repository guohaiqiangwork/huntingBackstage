package cn.smbms.dao;

import cn.smbms.pojo.Account;

/**
 * 账号密码
 * 
 * @author 若水一涵
 *
 */
public interface AccountsDao {
	// 插入
	int insert(Account account);

	// 修改
	int update(Account account);

	// 删除
	int delete(String idAccount);

	// 登录
	Account login(Account account);
}
