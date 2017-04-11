package dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import entity.VoteSubject;
import entity.VoteUser;

public interface VoteSubjectDao  {
	//�����ķ���
	public int addVoteSubject(VoteSubject voteSubject);
	//��ҳ����
	public List<VoteSubject> findByPage(List<Criterion> tiaojianList, List<Order> orderList,int pageSize, int pageNo, String searchText);
	//��ѯ�ܼ�¼��
	public int findByPageCount(String searchText);
	
	//�޸ķ���
    public int updateVoteSubject(VoteSubject voteSubject);
	public VoteSubject findVoteSubjectDetail(int id);
	//ɾ������
	public int deleteById(int id);
}
