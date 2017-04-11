package test;

import java.util.List;

import dao.impl.VoteUserDaoImpl;
import entity.VoteUser;
import redis.clients.jedis.Jedis;

public class TestRedis {
public static void main(String[] args) {
	Jedis jedis=new Jedis("localhost");
//	 jedis.set("小明", "25");
//	 jedis.set("小明", "26");
//	 jedis.set("小李", "25");
//	 jedis.set("ll", "25");
//	 
//	System.out.println(jedis.get("ll"));
//	
	//存储数据到列表中
//
//	jedis.lpush("白保健","yy","sss","ddd");
//	List<String> list= jedis.lrange("白保健", 0, 2);
//
//	System.out.println(list);
//	
	
//	jedis.del("dd");
	//存储对象
	jedis.select(2);
	

}
}
