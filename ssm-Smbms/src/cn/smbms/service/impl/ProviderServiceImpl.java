package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.service.ProviderService;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
	
	@Resource(name="providerMapper")
	private ProviderMapper providerMapper;
	
	
	@Override
	public List<Provider> getAllProvider(Provider pro,Integer pageNum,Integer pageSize) throws Exception{
		// TODO Auto-generated method stub
		return providerMapper.selectAllProviderInfo(pro,pageNum,pageSize);
	}


	@Override
	public Integer findAllCount(Provider pro) throws Exception {
		return providerMapper.selectCount(pro);
	}


	@Override
	public Provider findProviderInfo(String proId) {
		return providerMapper.selectByPrimaryKey(proId);
	}


	@Override
	public boolean updateProvider(Provider pro) {
		return providerMapper.updateByPrimaryKeySelective(pro)>0;
	}


	@Override
	public boolean addProvider(Provider pro) {
		return providerMapper.insertSelective(pro)>0;
	}


	@Override
	public boolean deleteProvider(String pro) {
		return providerMapper.deleteByPrimaryKey(pro)>0;
	}

}
