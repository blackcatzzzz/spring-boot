package com.zhangchi.redis.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;
    
    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        //HashOperations ops1 = this.template.opsForHash();
        //String s = ops1.get("runoobkey", "name").toString();
        return ops.get(key);
    }

    public void setHash(String key, Map<String, String> map){
        HashOperations ops = this.template.opsForHash();
        template.setHashValueSerializer(template.getDefaultSerializer());
        ops.putAll(key, map);
    }
}