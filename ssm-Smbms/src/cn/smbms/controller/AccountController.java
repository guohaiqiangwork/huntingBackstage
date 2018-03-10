package cn.smbms.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smbms.pojo.Account;
import cn.smbms.service.AccountService;

/**
 * 证书培训控制器
 * 
 * @author 若水一涵
 *
 */
@MultipartConfig
@Controller
@RequestMapping("/account")
@CrossOrigin
public class AccountController extends BaseController {

	@Resource
	private AccountService accountService;

	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object addTrain(@RequestBody Account account) {
		Date date = new Date();
		account.setIdAccount(date.getTime() + "");
		Account resultAccount = accountService.login(account);
		if (resultAccount == null) {
			int result = accountService.add(account);
			resultAccount = accountService.login(account);
			return retContent(200, resultAccount);
		}
		return retContent(201, "手机号已注册");
	}

	/**
	 * 修改
	 * 
	 * @param train
	 * @return
	 */
	@RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestBody Account account) {

		int result = accountService.update(account);

		return retContent(200, result);
	}

	/**
	 * 删除
	 * 
	 * @param train
	 * @return
	 */
	@RequestMapping(value = "/deleteTrain", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestBody Account account) {

		int result = accountService.delete(account.getIdAccount() + "");

		return retContent(200, result);
	}

	/**
	 * 查询详情
	 * 
	 * @param train
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object train(@RequestBody Account account) {

		Account result = accountService.login(account);
		if (null != result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}
}
