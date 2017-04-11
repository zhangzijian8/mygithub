package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.VoteItemDao;
import dao.VoteOptionDao;
import dao.VoteSubjectDao;
import dao.impl.VoteItemDaoImpl;
import dao.impl.VoteOptionDaoImpl;
import dao.impl.VoteSubjectDaoImpl;
import entity.VoteOption;
import entity.VoteSubject;
import service.VoteSubjectService;
import vo.PageSupport;

public class VoteSubjectServiceImpl implements VoteSubjectService {
	private   VoteSubjectDao voteSubjectDao=new VoteSubjectDaoImpl();
	private   VoteOptionDao  voteOptionDao=new  VoteOptionDaoImpl();
	private   VoteItemDao   voteItemDao=new VoteItemDaoImpl();
   //��ҳ
	public PageSupport<VoteSubject> findPage(int pageNo, int pageSize, String searchText) {
		PageSupport<VoteSubject> pageSupport = new PageSupport<>();
		pageSupport.setPageSize(pageSize);
		pageSupport.setPageNo(pageNo);	
		
		//��ѯ����
		List<Criterion > tiaojianList=new ArrayList();
		tiaojianList.add(Restrictions.like("vstitle", "%"+searchText+"%"));
		
		//��������
		List<Order> orderList=new ArrayList();
		orderList.add(Order.asc("vsid"));
		orderList.add(Order.asc("vstitle"));
		List<VoteSubject> list=voteSubjectDao.findByPage(tiaojianList, orderList, pageSize, pageNo, searchText);
		
		for(VoteSubject voteSubject:list){
			//ͶƱ����
			voteSubject.setItemNum(voteItemDao.findCountByVsid(voteSubject.getVsid()));
			//ѡ����
			voteSubject.setOptionNum(voteOptionDao.findCountByVsid(voteSubject.getVsid()));
		}
		pageSupport.setRows(list);
		//�ܼ�¼��
		pageSupport.setTotal(voteSubjectDao.findByPageCount(searchText));
		return pageSupport;
	}

	
	

	public boolean addSubject(VoteSubject voteSubject) {
	    if(voteSubjectDao.addVoteSubject(voteSubject)>0){
	    	
	    	return true;
	    }else{
	    	
	    	return false;
	    }	
		
	}


	public boolean UpdateSubject(VoteSubject voteSubject) {
		if(voteSubjectDao.updateVoteSubject(voteSubject)>0){
			return true;		
		}else{
			return false;
		}
		
	}

//����id
	public VoteSubject findById(int id) {
		VoteSubject	voteSubject	=voteSubjectDao.findVoteSubjectDetail(id);
		//ͶƱ����
		voteSubject.setItemNum(voteItemDao.findCountByVsid(voteSubject.getVsid()));
		//ѡ����
		voteSubject.setOptionNum(voteOptionDao.findCountByVsid(voteSubject.getVsid()));
		//ͶƱ�������б�
		List<VoteOption> options=this.voteOptionDao.findListByVsid(id);
		voteSubject.setOptions(options);
		return voteSubject;
	}


	public VoteSubject findVoteSubjectDetail(int id) {
		
		return voteSubjectDao.findVoteSubjectDetail(id);
	}


	@Override
	public int delete(int id) {
		
		return voteSubjectDao.deleteById(id);
	}


	@Override
	public int findId() {
		// TODO Auto-generated method stub
		return 0;
	}


	



}
