package dao;

import java.util.List;



import entity.VoteUser;



public interface VoteUserDao {
	/**
	 * 根据登录名和密码查询用户信息
	 * @param loginCode 登录名
	 * @param password 密码
	 * @return
	 */
	public boolean findByLoginCodeAndPassword(String vuusername, String vupassword);
	public int addVoteUser(VoteUser voteUser); 
	public boolean findByLoginCode(String vuusername);
	
}
