package entity;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.alibaba.fastjson.JSON;

import util.HibernateUtil;

public class Test {
public static void main(String[] args) {
	
	/*//����hibernate apiִ�����ݿ����
	  //1.����configuration ������������ļ�
	 Configuration configuration=new Configuration().configure();
	 System.out.println(configuration);
	 //2.����ע��������
	 ServiceRegistry  serviceRegistry=new  StandardServiceRegistryBuilder().configure().build();
	  
	 //3.session���Ӷ��󹤳�
	 SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	 //4.�������Ӷ���������jdbc��Connection
	 Session session=sessionFactory.openSession();
	*/
	 Session session= HibernateUtil.getInstance().getSession();
	 VoteUser voteUser=new VoteUser();
	 voteUser.setVuusername("admin");
	 voteUser.setVupassword("123");
	 	
	 //6.��������
	 Transaction transaction =session.beginTransaction();
	 try {
		 //������ӵ�ID
//		 session.save(voteUser);
//       String hql="from VoteUser v where v.vuuserid=:id";
//		 String hql="from VoteUser v where v.vuuserid=?";
//		 String hql="from VoteUser v order by v.vuuserid desc";
//	     String hql="select v.vuusername,count(v.vuusername) from VoteUser v group by v.vuusername";
		 //����Query���� org/hibernate
//		 Query query=session.createQuery(hql);
//		 query.setInteger("id", 2);
//		 query.setInteger(0, 2);
//		 query.setParameter("id", 2);
//		 query.setParameter(0, 2);
//       QBC��ѯ �����ѯ
		 Criteria c=session.createCriteria(VoteUser.class);
//      	 c.add(Restrictions.and(Restrictions.eq("vuusername", "С��"),Restrictions.between("vuuserid", 1, 6)));
	      c.setProjection(Projections.projectionList().add(Projections.count("vuusername")));

		 //ִ�����
		 List<VoteUser> list=c.list();
		 System.out.println(JSON.toJSONString(list,true));
		
	} catch (Exception e) {
		//�ع�����
		transaction.rollback();
		e.printStackTrace();
	}
	
	 //7.�ύ����
	 transaction.commit();
	 session.close();
	 
	 
	 
	 
}
}