package com.zhangchi.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangchi.redis.dao.RedisDao;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {
	@Autowired
	private RedisDao redisDao;
	
	@RequestMapping("/set")
	public String set(String key,String value){
		redisDao.setKey(key, value);
		return "success";
	}
	@RequestMapping("/get")
	public String get(String key){
		return redisDao.getValue(key);
	}

	@RequestMapping("/setHash")
	public String setHash(){
		String key = "setHash";
		Map<String, String> map = new HashMap<>();
		map.put("name", null);
		redisDao.setHash(key, map);
		return "success";
	}
}
