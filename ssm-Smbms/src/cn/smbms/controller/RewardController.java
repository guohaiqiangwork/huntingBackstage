package cn.smbms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.smbms.service.RewardService;

@Controller
@RequestMapping("/reward")
public class RewardController {
	
	
	@Resource
	private RewardService rewardService;

	@RequestMapping("rewards")
	@ResponseBody
	public Object rewards() {
		return JSONArray.toJSONString(rewardService.getRewards());
	}
}
