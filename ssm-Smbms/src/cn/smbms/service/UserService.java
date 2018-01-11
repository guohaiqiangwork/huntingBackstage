package cn.smbms.service;

import java.util.List;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public interface UserService {
	
	public List<User> findAllUser(User user,Integer pageNo,Integer size);
	
	public int findUserCount(User user);
	
	
	public boolean  savaUser(User user);

	public User checkIsExists(String userCode);

	public User login(String userCode, String userPassword) throws Exception;

	public int modifyUserPwd(String newPwd, String userCode);

	public boolean modifyUserInfo(User user);
	
	public List<Role> findAllRole();
	
	
}	
