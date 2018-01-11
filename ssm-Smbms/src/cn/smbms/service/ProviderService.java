package cn.smbms.service;

import java.util.List;

import cn.smbms.pojo.Provider;

public interface ProviderService {
	
	public Integer findAllCount(Provider pro) throws Exception;
	
	public List<Provider> getAllProvider(Provider pro, Integer pageNum,Integer pageSize) throws Exception;

	public Provider findProviderInfo(String proId);

	public boolean updateProvider(Provider pro);

	public boolean addProvider(Provider pro);

	public boolean deleteProvider(String pro);

}
