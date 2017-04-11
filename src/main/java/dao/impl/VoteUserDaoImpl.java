package dao.impl;



import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import base.DbHelper;
import dao.VoteUserDao;
import entity.VoteUser;
import util.HibernateUtil;

public class VoteUserDaoImpl extends DbHelper implements VoteUserDao {
	
	
	@Override
	public int addVoteUser(VoteUser voteUser) {
		
		Session session=HibernateUtil.getInstance().getSession();
		Transaction  tx= session.beginTransaction();
		int i=0;
		try {
			String sql = "INSERT INTO `voteuser`(vuusername,vupassword)VALUES(?,?)";
			SQLQuery sqlQuery =session.createSQLQuery(sql);
			sqlQuery.setParameter(0,voteUser.getVuusername());
			sqlQuery.setParameter(1, voteUser.getVupassword());		
			i=sqlQuery.executeUpdate();
			tx.commit();			
		} catch (Exception e) {
			
			e.printStackTrace();
			tx.rollback();
		}
		   return i;
			}

	@Override
	public boolean findByLoginCode(String vuusername) {
		String sql = "SELECT * FROM `voteuser` WHERE  vuusername=?";
		// 打开连接,连接数据库
		super.openCon();
		// 实例化sql执行对象
		System.out.println("打开连接");
		try {
			VoteUser voteUser = queryRunner.query(conn, sql, new BeanHandler<VoteUser>(VoteUser.class),vuusername);
			if(voteUser!=null){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		} finally {
			super.closeAll();
		}
		
	}

	@Override
	public boolean findByLoginCodeAndPassword(String vuusername, String vupassword) {	
		
		 Session session=HibernateUtil.getInstance().getSession();
		 Transaction  tx= session.beginTransaction();
		 try {
			Criteria criteria=session.createCriteria(VoteUser.class);
			 criteria.add(Restrictions.eq("vuusername", vuusername));
			 criteria.add(Restrictions.eq("vupassword", vupassword));		 		
			 VoteUser voteUser=(VoteUser) criteria.uniqueResult();
			  tx.commit(); 
			 if(voteUser!=null){				
				 return true;				
			 }else{
				 return false;
			 }
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();			
		}
		 return false;
	}			
	
	
}
