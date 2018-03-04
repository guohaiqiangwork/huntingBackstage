package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.RelevantDao;
import cn.smbms.dao.StandardDao;
import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Detail;
import cn.smbms.pojo.Relevant;
import cn.smbms.pojo.Standard;
import cn.smbms.service.StandardService;
import cn.smbms.utils.Tool;

/**
 * 代办资质实现类
 * 
 * @author 若水一涵
 *
 */
@Service("standardService")
public class StandardServiceImpl implements StandardService {

	@Resource
	private StandardDao standardDao;
	@Resource
	private RelevantDao relevantDao;

	@Override
	public int add(Standard standard) {
		// TODO Auto-generated method stub
		int result = standardDao.insert(standard);
		if (result > 0) {
			Relevant relevant = new Relevant();
			relevant.setIdRelevant(standard.getIdStandard());
			relevant.setArticleId(standard.getIdStandard());
			relevant.setArticleTitle(standard.getTitle());
			relevant.setRelevantModule(2);
			result = relevantDao.insert(relevant);
		}
		return result;
	}

	@Override
	public int update(Standard standard) {
		// TODO Auto-generated method stub
		return standardDao.update(standard);
	}

	@Override
	public int delete(String idStandard) {
		// 获得图片路径
		Standard standard = standardDao.standard(idStandard);
		String htmlUrl = standard.getHtmlUrl();
		int result = standardDao.delete(idStandard);
		if (result > 0) {
			result = relevantDao.delete(idStandard);
			if (htmlUrl != null && !htmlUrl.isEmpty()) {
				Tool.deFolder(htmlUrl);
			}
		}
		return result;
	}

	@Override
	public Detail<Standard> standard(String idStandard) {
		// TODO Auto-generated method stub
		Detail<Standard> standard = new Detail<Standard>();
		// 获取当前文章
		standard.setCurrent(standardDao.standard(idStandard));
		// 获取前一篇
		standard.setPrevious(standardDao.previous(standard.getCurrent()));
		// 获取下一篇
		standard.setNext(standardDao.next(standard.getCurrent()));
		// 关联文章
		Relevant relevant = new Relevant();
		relevant.setRelevantId(idStandard);
		relevant.setRelevantModule(2);
		standard.setRelevant(relevantDao.relevants(relevant));
		return standard;
	}

	@Override
	public List<Standard> standards(Currency<Standard> currency) {
		// TODO Auto-generated method stub
		return standardDao.standards(currency.getData(), currency.getPagination());
	}

}
