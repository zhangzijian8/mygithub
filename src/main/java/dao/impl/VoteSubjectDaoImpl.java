package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import base.BaseDao;
import base.DbHelper;
import dao.VoteSubjectDao;
import entity.VoteSubject;
import util.HibernateUtil;

public class VoteSubjectDaoImpl extends BaseDao<VoteSubject> implements VoteSubjectDao {
	private  VoteSubject voteSubject=new VoteSubject();
	@Override
	public int addVoteSubject(VoteSubject voteSubject) {
	
				return 0;
	}

  //分页
	public List<VoteSubject> findByPage(List<Criterion> tiaojianList,List<Order> orderList,int pageSize, int pageNo, String searchText) {
		
		List<VoteSubject> list=super.findByPage( tiaojianList,orderList, pageNo, pageSize,VoteSubject.class);
		return list;
		
	}
	
	
	//总记录数
	public int findByPageCount(String searchText) {
		Session session=HibernateUtil.getInstance().getSession();
		Transaction tx= session.beginTransaction();
		int i;
		try {
			Criteria criteria= session.createCriteria(VoteSubject.class);
			criteria.add(Restrictions.like("vstitle", "%"+searchText+"%"));
			criteria.setProjection(Projections.count("vstitle"));
			 i=Integer.parseInt(criteria.uniqueResult().toString());
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			 return -1;
		} 
	     	return i;
	}


	@Override
	public int updateVoteSubject(VoteSubject voteSubject) {
		
				return 0;
	}


	public VoteSubject findVoteSubjectDetail(int id) {
		
		return null;
	}


	@Override
	public int deleteById(int id) {
	
		return 0;
	}

	
}
