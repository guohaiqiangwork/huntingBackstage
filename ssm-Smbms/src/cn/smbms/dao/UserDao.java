package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public interface UserDao {
	
	public List<User> getAllUser(@Param("user")User user,@Param("pageNo")Integer pageNo,@Param("size")Integer size);
	
	public int getUserCount(@Param("user")User user);
	
	
	public int addUser(User user);
	
	public int updateUserInof(User user);

	public User isExists(String userCode);

	public int updateUserPwd(@Param("newPwd")String newPwd, @Param("userCode")String userCode);
	
	
	
	public List<Role> getAllRole();
	
}
