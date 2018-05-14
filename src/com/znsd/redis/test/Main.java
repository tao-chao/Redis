package com.znsd.redis.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Main {
	public static void main(String[] args) {
		
		//连接本地Redis服务
		Jedis jedis= new Jedis("192.168.2.190",6379);
		
		//查看服务是否运行，如果输出PONG就表示连接成功
		System.out.println(jedis.ping());
		
		jedis.set("k1", "v1");
		
		
		
		
		String key=jedis.get("k1");
		System.out.println(key);
		
		// 获取所有的key并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key1 = it.next();   
            System.out.println(key1);   
        }
        
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
        
        //以hash方式存储
        jedis.hset("student", "name","张三" );
        //获取值
        String names=jedis.hget("student", "name");
        System.out.println(names);
        //获取哈希表中字段的数量
        Long l=jedis.hlen("student");
        System.out.println(l);
        
      
	}
}
 