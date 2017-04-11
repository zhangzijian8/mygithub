package dao;

import java.util.List;

import entity.VoteOption;

public interface VoteOptionDao {

	public int addVoteOption(VoteOption voteOption); 
	public int findCountByVsid(int vsid);
	public  List<VoteOption> findListByVsid(int vsid);
}
