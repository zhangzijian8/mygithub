package test;

import java.util.List;

import dao.impl.VoteUserDaoImpl;
import entity.VoteUser;
import redis.clients.jedis.Jedis;

public class TestRedis {
public static void main(String[] args) {
	Jedis jedis=new Jedis("localhost");
//	 jedis.set("С��", "25");
//	 jedis.set("С��", "26");
//	 jedis.set("С��", "25");
//	 jedis.set("ll", "25");
//	 
//	System.out.println(jedis.get("ll"));
//	
	//�洢���ݵ��б���
//
//	jedis.lpush("�ױ���","yy","sss","ddd");
//	List<String> list= jedis.lrange("�ױ���", 0, 2);
//
//	System.out.println(list);
//	
	
//	jedis.del("dd");
	//�洢����
	jedis.select(2);
	

}
}
