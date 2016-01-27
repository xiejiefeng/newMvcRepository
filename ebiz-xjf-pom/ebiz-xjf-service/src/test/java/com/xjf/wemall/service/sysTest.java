package com.xjf.wemall.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.service.index.api.IndexService;

/**
 * Unit test for simple App.
 */
public class sysTest extends AllServiceTest {
	@Autowired
	private IndexService indexService;
	
	@Test
	public void index() {
		System.out.println(JSONParser.toJSONString(indexService.mapInfo()));
		
	}


}
