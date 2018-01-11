package cn.smbms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.Provider;
import cn.smbms.service.ProviderService;

@Controller
@RequestMapping("/pro")
public class ProviderController {
	
	@Resource(name="providerService")
	private ProviderService providerService;
	
	
	@RequestMapping("/list")
	public String providerList(Model model,Provider pro,
				@RequestParam(defaultValue="0",name="pager.offset")Integer pageNum) 
						throws Exception{
		List<Provider> list = providerService.getAllProvider(pro,pageNum>=0?pageNum:0,5);
		model.addAttribute("list",list);
		
		Integer count = providerService.findAllCount(pro);
		
		model.addAttribute("total",count);
		return "provider/list";
	}
	
	
	
	
	@RequestMapping("/providerInfo/{code}")
	public String providerInfoPage(Model mode,@PathVariable(name="code")String proId){
		
		Provider pro = providerService.findProviderInfo(proId);
		
		mode.addAttribute("pro",pro);
		
		return "provider/providerInfo";
	}
	
	@RequestMapping("/updateProviderInfo")
	public String updateProviderInfo(Provider pro,Model model){
		
		pro.setModifyby(1l);
		pro.setModifydate(new Date());
		
		
		boolean boo = providerService.updateProvider(pro);
		
		if(boo){
			
			return "redirect:/pro/providerInfo/"+pro.getProcode();
		}
		model.addAttribute("updateErr","0");
		return "forward:/pro/providerInfo/"+pro.getProcode();
	}
	
	
	@RequestMapping(value="/addProvder",method=RequestMethod.GET)
	public String addProviderPage(){
		
		
		return "provider/addProvider";
	}
							
	@RequestMapping(value="/addProvder",method=RequestMethod.POST)
	public String addProvider(Provider pro,Model model){
		
		pro.setCreatedby(1l);
		pro.setCreationdate(new Date());
		
		boolean boo = providerService.addProvider(pro);
		
		if(boo){
			return "redirect:/pro/list";
		}
		model.addAttribute("err","添加失败");
		return "provider/addProvder";
	}
	
	
	@RequestMapping("/deleteProvider/{code}")
	public String removeProvider(@PathVariable(name="code") String pro,Model model){
		
		boolean res = providerService.deleteProvider(pro);
		
		if(res){
			return "redirect:/pro/list";
		}
		model.addAttribute("err","删除失败");
		return "forward:/pro/list";
		
		
		
	}
	
	
	
	
	
	
	

}
