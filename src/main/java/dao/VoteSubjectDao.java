package dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import entity.VoteSubject;
import entity.VoteUser;

public interface VoteSubjectDao  {
	//新增的方法
	public int addVoteSubject(VoteSubject voteSubject);
	//分页查找
	public List<VoteSubject> findByPage(List<Criterion> tiaojianList, List<Order> orderList,int pageSize, int pageNo, String searchText);
	//查询总记录数
	public int findByPageCount(String searchText);
	
	//修改方法
    public int updateVoteSubject(VoteSubject voteSubject);
	public VoteSubject findVoteSubjectDetail(int id);
	//删除方法
	public int deleteById(int id);
}
