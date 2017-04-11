package service;

import entity.VoteUser;

public interface VoteUserService  {
	//µÇÂ¼
    public boolean login(String name,String pwd);
    //×¢²á
    public boolean register(VoteUser voteUser);
    
}
