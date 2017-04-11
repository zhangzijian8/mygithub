package service.impl;

import action.BaseAction;
import dao.VoteUserDao;
import dao.impl.VoteUserDaoImpl;
import entity.VoteUser;
import service.VoteUserService;

public class VoteUserServiceImpl  implements VoteUserService  {
	private  VoteUserDao voteUserDao = new VoteUserDaoImpl();
	
	@Override
	public boolean login(String name, String pwd) {
		if(voteUserDao.findByLoginCodeAndPassword(name, pwd)==true){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean register(VoteUser voteUser) {
		if(voteUserDao.findByLoginCode(voteUser.getVuusername())!=true){
			if(voteUserDao.addVoteUser(voteUser)>0){
				return true;
			}else{
				return false;
			}
		}else{
			  return false;
		}
		
	}

}
