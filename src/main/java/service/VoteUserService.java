package service;

import entity.VoteUser;

public interface VoteUserService  {
	//��¼
    public boolean login(String name,String pwd);
    //ע��
    public boolean register(VoteUser voteUser);
    
}
