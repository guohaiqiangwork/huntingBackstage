package cn.smbms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.AccountsDao;
import cn.smbms.pojo.Account;
import cn.smbms.service.AccountService;

/**
 * 资质动态实现类
 * 
 * @author 若水一涵
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountsDao accountDao;

	@Override
	public int add(Account account) {
		return accountDao.insert(account);
	}

	@Override
	public int update(Account account) {
		return accountDao.update(account);
	}

	@Override
	public int delete(String idAccount) {
		// TODO Auto-generated method stub
		return accountDao.delete(idAccount);
	}

	@Override
	public Account login(Account account) {
		// TODO Auto-generated method stub
		return accountDao.login(account);
	}

}
