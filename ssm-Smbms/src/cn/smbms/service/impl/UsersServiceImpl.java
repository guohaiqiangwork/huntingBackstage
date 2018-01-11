package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.UsersMapper;
import cn.smbms.pojo.Users;
import cn.smbms.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;
	
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersMapper.findAll();
	}

}
