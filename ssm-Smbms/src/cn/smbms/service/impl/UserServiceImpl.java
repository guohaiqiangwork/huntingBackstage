package cn.smbms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<User> findAllUser(User user,Integer pageNo,Integer size) {
		return userDao.getAllUser(user,pageNo,size);
		
	}






	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public int findUserCount(User user) {
		return userDao.getUserCount(user);
	}






	@Override
	public boolean savaUser(User user) {
		
		if(userDao.addUser(user)>0){
			return true;
		}
		return false;
	}






	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public User checkIsExists(String userCode) {
		
		return userDao.isExists(userCode);
	}






	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public User login(String userCode, String userPassword) throws Exception {
		
		User user  = userDao.isExists(userCode);
		if(null == user){
			throw new Exception("系统繁忙！！！！！");
		}
		if(! user.getUserPassword().equals(userPassword)){
			return null;
		}
		
		return user;
	}






	@Override
	public int modifyUserPwd(String newPwd, String userCode) {
		return userDao.updateUserPwd(newPwd,userCode);
	}






	@Override
	public boolean modifyUserInfo(User user) {
		return userDao.updateUserInof(user)>0;
	}






	@Override
	public List<Role> findAllRole() {
		return userDao.getAllRole();
	}

}
