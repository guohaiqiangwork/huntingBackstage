package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.RelevantDao;
import cn.smbms.dao.TrainDao;
import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Detail;
import cn.smbms.pojo.Relevant;
import cn.smbms.pojo.Train;
import cn.smbms.service.TrainService;
import cn.smbms.utils.Tool;

/**
 * 资质动态实现类
 * 
 * @author 若水一涵
 *
 */
@Service("trainService")
public class TrainServiceImpl implements TrainService {

	@Resource
	private TrainDao trainDao;

	@Resource
	private RelevantDao relevantDao;

	@Override
	public int add(Train train) {
		// TODO Auto-generated method stub
		int result = trainDao.insert(train);
		if (result > 0) {
			Relevant relevant = new Relevant();
			relevant.setIdRelevant(train.getIdTrain());
			relevant.setArticleId(train.getIdTrain());
			relevant.setArticleTitle(train.getTitle());
			relevant.setRelevantModule(3);
			result = relevantDao.insert(relevant);
		}
		return result;
	}

	@Override
	public int update(Train train) {
		// TODO Auto-generated method stub
		return trainDao.update(train);
	}

	@Override
	public int delete(String idTrain) {
		// 获得图片路径
		Train train = trainDao.train(idTrain);
		String htmlUrl = train.getHtmlUrl();
		int result = trainDao.delete(idTrain);
		if (result > 0) {
			result = relevantDao.delete(idTrain);
			if (htmlUrl != null && !htmlUrl.isEmpty()) {
				Tool.deFolder(htmlUrl);
			}
		}
		return result;
	}

	@Override
	public Detail<Train> train(String idTrain) {
		// TODO Auto-generated method stub
		Detail<Train> train = new Detail<Train>();
		// 获取当前文章
		train.setCurrent(trainDao.train(idTrain));
		// 获取前一篇
		train.setPrevious(trainDao.previous(train.getCurrent()));
		// 获取下一篇
		train.setNext(trainDao.next(train.getCurrent()));
		// 关联文章
		Relevant relevant = new Relevant();
		relevant.setRelevantId(idTrain);
		relevant.setRelevantModule(3);
		train.setRelevant(relevantDao.relevants(relevant));
		return train;
	}

	@Override
	public List<Train> trains(Currency<Train> currency) {
		// TODO Auto-generated method stub
		return trainDao.trains(currency.getData(), currency.getPagination());
	}

}
