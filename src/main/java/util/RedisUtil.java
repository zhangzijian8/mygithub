package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	//˽�л�����
    private static RedisUtil redisUtil=null;
    private static JedisPool jedisPool=null;
    //˽�л����췽��
    private RedisUtil(){
    	
    }
    
    //�������ʷ���
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
    
    //��̬�����
    //�صĻ�������
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
			//������������
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
