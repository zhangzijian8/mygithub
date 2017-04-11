package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
     //懒汉模式
	private static HibernateUtil  hibernateUtil=null;
	//二级缓存
	private static SessionFactory sessionFactory=null;
	private Session session=null;
	//私有化构造方法
	private HibernateUtil(){}
	
	public static synchronized HibernateUtil getInstance(){
		 if(hibernateUtil==null){
			 //实现同步
			  synchronized(HibernateUtil.class){
				  if(hibernateUtil==null){
					  hibernateUtil=new HibernateUtil();
				  }
			  }
			
		 }
		 return hibernateUtil;		
	}
	
	//静态代码
	static{
		
		  //1.创建配置对象
		Configuration configuration=new Configuration().configure();
		 //2.创建服务注册对象
		 ServiceRegistry  serviceRegistry=new  StandardServiceRegistryBuilder().configure().build();		  
		 //3.session工厂对象，Hibernate对象二级缓存，进程级缓存
		 sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
	}
	
	public Session getSession(){
		if(session==null||!session.isOpen()){
			session=sessionFactory.getCurrentSession();
					
		}
		  return session;
		
	}

	public void closeSession() {
		if(session!=null){
		session.close();
	}
		
}	

}
