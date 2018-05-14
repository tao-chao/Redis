package com.znsd.redis.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Main {
	public static void main(String[] args) {
		
		//���ӱ���Redis����
		Jedis jedis= new Jedis("192.168.2.190",6379);
		
		//�鿴�����Ƿ����У�������PONG�ͱ�ʾ���ӳɹ�
		System.out.println(jedis.ping());
		
		jedis.set("k1", "v1");
		
		
		
		
		String key=jedis.get("k1");
		System.out.println(key);
		
		// ��ȡ���е�key�����
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key1 = it.next();   
            System.out.println(key1);   
        }
        
        //�洢���ݵ��б���
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // ��ȡ�洢�����ݲ����
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("�б���Ϊ: "+list.get(i));
        }
        
        //��hash��ʽ�洢
        jedis.hset("student", "name","����" );
        //��ȡֵ
        String names=jedis.hget("student", "name");
        System.out.println(names);
        //��ȡ��ϣ�����ֶε�����
        Long l=jedis.hlen("student");
        System.out.println(l);
        
      
	}
}
 