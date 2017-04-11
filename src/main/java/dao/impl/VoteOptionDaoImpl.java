package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import base.DbHelper;
import dao.VoteOptionDao;
import entity.VoteOption;
import entity.VoteSubject;
import util.HibernateUtil;

public class VoteOptionDaoImpl implements VoteOptionDao {

	public int addVoteOption(VoteOption voteOption) {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction tx = session.getTransaction();
		try {
			String sql = "INSERT INTO `voteoption`(vooption,vsid,voorder)VALUES(?,?,?)";
			Query query = session.createQuery(sql);
			query.setParameter(0, voteOption.getVooption());
			query.setParameter(1, voteOption.getVsid());
			query.setParameter(2, voteOption.getVoorder());
			tx.commit();
			if (query != null) {
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		}
		return 0;
	}

	// 得到投票数
	@Override
	public int findCountByVsid(int vsid) {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		int num;
		try {
			Criteria criteria = session.createCriteria(VoteSubject.class);
			criteria.setProjection(Projections.count("vsid"));
			criteria.add(Restrictions.eq("vsid", vsid));
			num = Integer.parseInt(criteria.uniqueResult().toString());
			tx.commit();
			return num;
		} catch (Exception e) {	
			e.printStackTrace();
			tx.rollback();
				
		}
		  return -1;
	}

	@Override
	public List<VoteOption> findListByVsid(int vsid) {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction tx = session.getTransaction();
		try {
			String sql = "from VoteOption o where o.vsid=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, vsid);
			List<VoteOption> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return null;

	}

}
