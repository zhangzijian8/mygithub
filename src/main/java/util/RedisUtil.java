package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	//私有化属性
    private static RedisUtil redisUtil=null;
    private static JedisPool jedisPool=null;
    //私有化构造方法
    private RedisUtil(){
    	
    }
    
    //公共访问方法
    public static synchronized RedisUtil getInstance(){
    	if(redisUtil==null){
    		synchronized(RedisUtil.class){
    			if(redisUtil==null){
    				redisUtil=new RedisUtil();
    				
    			}
    		}
    		
    	}   	  	
    	return redisUtil;
    	  	
    }
    
    //静态代码块
    //池的基本配置
    static{
    	JedisPoolConfig config=new JedisPoolConfig();
    	config.setMaxTotal(20);
    	config.setMaxIdle(5);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);
    	jedisPool=new JedisPool(config,"192.168.1.128");
   	   	
    }
    
    public static String getValue(String key){
    	 Jedis jedis=jedisPool.getResource();
    	 String value = null ;
    	 try {
			value=jedis.get(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			
			jedisPool.returnResource(jedis);
		}
    	    	
		return value;   	   	
    }
    
    
    
    
    
     public static void getValue(String key,String obj,int liveTime){
    	 Jedis jedis=jedisPool.getResource();
    	 String value = null ;
    	 try {
			value=jedis.set(key, value);
			//设置生命周期
			if(liveTime>0){
				jedis.expire(key, liveTime);
			}
		} catch (Exception e) {
			 
			e.printStackTrace();
		}finally{
			
			jedisPool.returnResource(jedis);
		}
    	
     }
    
     
     
}
