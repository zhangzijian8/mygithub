package dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import dao.VoteItemDao;
import entity.VoteSubject;
import util.HibernateUtil;

/**
 * @author 张子健
 *投票实现类
 *@version 1.0
 */
public class VoteItemDaoImpl implements VoteItemDao {

	/**
	 * @param vsid
	 * @return int
	 * @see dao.VoteItemDao#findCountByVsid(int)
	 */
	@Override
	public int findCountByVsid(int vsid) {
		Session session=HibernateUtil.getInstance().getSession();
		Transaction tx=	session.beginTransaction();
		Criteria criteria= session.createCriteria(VoteSubject.class);
		int num;
		try {			
			criteria.setProjection(Projections.count("vsid"));
			criteria.add(Restrictions.eq("vsid", vsid));
			 num=Integer.parseInt(criteria.uniqueResult().toString());
			 tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		} 
		  return num;
	}

	
	
}
