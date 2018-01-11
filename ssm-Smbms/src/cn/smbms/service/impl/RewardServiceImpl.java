package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.RewardMapper;
import cn.smbms.pojo.Reward;
import cn.smbms.service.RewardService;

@Service("rewardService")
public class RewardServiceImpl implements RewardService {
	
	@Resource
	private RewardMapper rewardMapper;

	@Override
	public List<Reward> getRewards() {
		// TODO Auto-generated method stub
		return rewardMapper.rewards();
	}

}
