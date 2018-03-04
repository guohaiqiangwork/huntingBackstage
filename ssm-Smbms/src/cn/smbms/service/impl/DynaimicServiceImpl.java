package cn.smbms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.DynamicDao;
import cn.smbms.dao.RelevantDao;
import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Detail;
import cn.smbms.pojo.Dynamic;
import cn.smbms.pojo.Relevant;
import cn.smbms.service.DynamicService;
import cn.smbms.utils.Tool;

/**
 * 资质动态实现类
 * 
 * @author 若水一涵
 *
 */
@Service("dynamicService")
public class DynaimicServiceImpl implements DynamicService {

	@Resource
	private DynamicDao dynamicDao;
	@Resource
	private RelevantDao relevantDao;

	@Override
	public int addDynamic(Dynamic dynamic) {
		// TODO Auto-generated method stub
		int result = dynamicDao.insert(dynamic);
		if (result > 0) {
			Relevant relevant = new Relevant();
			relevant.setIdRelevant(dynamic.getIdDynamic());
			relevant.setArticleId(dynamic.getIdDynamic());
			relevant.setArticleTitle(dynamic.getTitle());
			relevant.setRelevantModule(1);
			result = relevantDao.insert(relevant);
		}
		return result;
	}

	@Override
	public int update(Dynamic dynamic) {
		// TODO Auto-generated method stub
		return dynamicDao.update(dynamic);
	}

	@Override
	public int delete(String idDynamic) {
		// 获得图片路径
		Dynamic dynamic = dynamicDao.dynamic(idDynamic);
		String htmlUrl = dynamic.getHtmlUrl();

		int result = dynamicDao.delete(idDynamic);
		if (result > 0) {
			result = relevantDao.delete(idDynamic);
			if (htmlUrl != null && !htmlUrl.isEmpty()) {
				Tool.deFolder(htmlUrl);
			}
		}
		return result;
	}

	@Override
	public Detail<Dynamic> dynamic(String idDynamic) {
		// TODO Auto-generated method stub
		Detail<Dynamic> dynamic = new Detail<Dynamic>();
		// 获取当前文章
		dynamic.setCurrent(dynamicDao.dynamic(idDynamic));
		// 获取前一篇
		dynamic.setPrevious(dynamicDao.previous(dynamic.getCurrent()));
		// 获取下一篇
		dynamic.setNext(dynamicDao.next(dynamic.getCurrent()));
		// 关联文章
		Relevant relevant = new Relevant();
		relevant.setRelevantId(idDynamic);
		relevant.setRelevantModule(1);
		dynamic.setRelevant(relevantDao.relevants(relevant));
		return dynamic;
	}

	@Override
	public List<Dynamic> dynamics(Currency<Dynamic> currency) {
		// TODO Auto-generated method stub
		return dynamicDao.dynamics(currency.getData(), currency.getPagination());
	}

	@Override
	public ArrayList<String> dynamicMenu() {
		// TODO Auto-generated method stub
		return dynamicDao.dynamicMenu();
	}

}
