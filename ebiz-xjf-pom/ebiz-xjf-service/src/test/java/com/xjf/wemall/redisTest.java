package com.xjf.wemall;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.iterators.LoopingIterator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.xjf.wemall.api.entity.SampleVo;
import com.xjf.wemall.api.entity.mail.MailVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.PropertyUtil;
import com.xjf.wemall.comparator.sampleComparator;
import com.xjf.wemall.redis.client.IRedisClient;
import com.xjf.wemall.service.AllServiceTest;
import com.xjf.wemall.service.Animal;
import com.xjf.wemall.service.Cat;
import com.xjf.wemall.service.OutInnerClass;
import com.xjf.wemall.service.index.api.IndexService;
import com.xjf.wemall.service.redis.api.RedisJobService;
import com.xjf.wemall.service.redis.impl.RedisJobServiceImpl;


/**
 * Unit test for simple App.
 */
public class redisTest extends AllServiceTest {
	
	@Autowired
	@Qualifier("redisClient")
    protected IRedisClient redisClient;
	
	
	@Test
	public void index() {
		System.out.print(redisClient.get("lu"));
	}
	

}
