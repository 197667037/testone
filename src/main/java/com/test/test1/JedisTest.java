package com.test.test1;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: liuxl
 * @date: 2018-04-20 09:43
 * @description:
 */
public class JedisTest {

    @Test
    public void test1(){
        Jedis jedis = new Jedis();
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
        JedisPool pool = new JedisPool("192.168.64.41", 6379);

        Jedis resource = pool.getResource();
        resource.auth("feiliks0512");
        String a = resource.get("a");
        System.out.println(a);
    }

    @Test
    public  void test2(){
        Jedis j = new Jedis("139.199.68.81", 6379);
        j.auth("feiliks0512");
        String s = j.get("img:EasyLogistics:login");
        System.out.println(s);
    }
}
