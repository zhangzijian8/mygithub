package service.impl;

import dao.VoteOptionDao;
import dao.impl.VoteOptionDaoImpl;
import entity.VoteOption;
import service.VoteOptionService;

public class VoteOptionServiceImpl implements VoteOptionService {
         private  VoteOptionDao voteOptionDao=new VoteOptionDaoImpl();
      //��������
	 public boolean addVoteOption(VoteOption voteOption) {
		if(voteOptionDao.addVoteOption(voteOption)>0){
			return true;
		}else{
			return false;
		}
		
	}

}
