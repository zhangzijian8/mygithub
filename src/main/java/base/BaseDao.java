package base;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import util.HibernateUtil;


public class BaseDao<T> {

	
	  private Class cla;
	
	 public void setCla(Class cla) {
		this.cla = cla;
	 }

	

	/**
	 * 分页查询记录总数
	 * 
	 * @param criterions 查询条件列表
	 * @param cls
	 * @return
	 */
	 public int findCountByPage(List<Criterion> criterions, Class cls) {
			Session session = HibernateUtil.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			Criteria c = session.createCriteria(cls);
			int num;
			try {
				if (criterions != null && criterions.size() > 0) {
					for (Criterion criterion : criterions) {
						c.add(criterion);
					}
				}
				c.setProjection(Projections.rowCount());
				num = Integer.parseInt(c.uniqueResult().toString());
				tx.commit();
				return num;
			} catch (Exception e) {
				e.printStackTrace();	
				tx.rollback();
			}
			return -1;

		}

	 /**
		 * 分页查询数据列表
		 * 
		 * @param criterions 条件列表
		 * @param orderList 排序列表
		 * @param pageNo 页码
		 * @param pageSize 页显示行数
		 * @param cls 类实例
		 * @return
		 */
	public List<T> findByPage(List<Criterion> criterions, List<Order> orderList , int pageNo, int pageSize,
			Class cls) {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(cls);
		List<T> list;
		try {
			if (criterions != null && criterions.size() > 0) {
				for (Criterion criterion : criterions) {
					c.add(criterion);
				}
			}
			if (orderList!= null&& orderList.size() > 0) {
				for (Order order : orderList) {
					c.addOrder(order);
				}
			}
			c.setFirstResult((pageNo - 1) * pageSize);
			c.setMaxResults(pageSize);
			list = c.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		return null;
	 }
	

/**添加方法
 * @author zhangzijian
 * @ Date 2016年12月28日 下午2:47:01
 * @param <T> 
 */
	
	public int add(T t) {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		int id = 0;
		try {
			id = Integer.parseInt(session.save(t).toString());
			tx.commit();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			tx.rollback();
		} 
		return id;
	}
	
	/**
	 * @author zhangzijian
	 * @ Date 2016年12月28日 下午2:48:50
	 * @param <T> 
	 */
	public List<T> findAll() {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		Query query;
		try {
			query = session.createQuery("from " + cla);
			tx.commit();
			return query.list();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			
		}
		 return null;
	}

	/**批量增加
	 * @author zhangzijian
	 * @ Date 2016年12月28日 下午2:48:50
	 * @param <T> 
	 */
	public int addBath(List <T>list) {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = session.beginTransaction();
		int count;
		try {
			count = 0;
			for (int i = 0; i < list.size(); i++) {
				session.save(list.get(i));
				count++;
				// 定期刷新缓存
				if (i % 20 == 0) {
					session.flush();
					session.clear();
				}
			}
			transaction.commit();
			return count;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return -1;
		}

	}

	
	/**批量更新
	 * @author zhangzijian
	 * @ Date 2016年12月28日 下午2:48:50
	 * @param <T> 
	 */
	
	public int updateBath(){
		//开连接
		Session session=HibernateUtil.getInstance().getSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//创建查询对象
		Query query=session.createQuery("from"+cla.getName());
		//获得可滚动的结果集
		ScrollableResults  scrollableResults= query.scroll();
		try {
			int count=0;
			while(scrollableResults.next()){
				Object object =scrollableResults.get(0);
				session.update(object);
				//定期刷新
				if((count++)%20==0){
					session.flush();
					session.clear();
				}
				
			 }
			tx.commit();
			return count;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return -1;
		}
		
		

		
		
	}
	
	
	
	}
