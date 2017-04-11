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
	
	/*//调用hibernate api执行数据库操作
	  //1.创建configuration 对象解析配置文件
	 Configuration configuration=new Configuration().configure();
	 System.out.println(configuration);
	 //2.创建注册服务对象
	 ServiceRegistry  serviceRegistry=new  StandardServiceRegistryBuilder().configure().build();
	  
	 //3.session连接对象工厂
	 SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	 //4.创建连接对象，类似于jdbc的Connection
	 Session session=sessionFactory.openSession();
	*/
	 Session session= HibernateUtil.getInstance().getSession();
	 VoteUser voteUser=new VoteUser();
	 voteUser.setVuusername("admin");
	 voteUser.setVupassword("123");
	 	
	 //6.开启事务
	 Transaction transaction =session.beginTransaction();
	 try {
		 //返回添加的ID
//		 session.save(voteUser);
//       String hql="from VoteUser v where v.vuuserid=:id";
//		 String hql="from VoteUser v where v.vuuserid=?";
//		 String hql="from VoteUser v order by v.vuuserid desc";
//	     String hql="select v.vuusername,count(v.vuusername) from VoteUser v group by v.vuusername";
		 //创建Query对象 org/hibernate
//		 Query query=session.createQuery(hql);
//		 query.setInteger("id", 2);
//		 query.setInteger(0, 2);
//		 query.setParameter("id", 2);
//		 query.setParameter(0, 2);
//       QBC查询 对象查询
		 Criteria c=session.createCriteria(VoteUser.class);
//      	 c.add(Restrictions.and(Restrictions.eq("vuusername", "小明"),Restrictions.between("vuuserid", 1, 6)));
	      c.setProjection(Projections.projectionList().add(Projections.count("vuusername")));

		 //执行语句
		 List<VoteUser> list=c.list();
		 System.out.println(JSON.toJSONString(list,true));
		
	} catch (Exception e) {
		//回滚事务
		transaction.rollback();
		e.printStackTrace();
	}
	
	 //7.提交事务
	 transaction.commit();
	 session.close();
	 
	 
	 
	 
}
}