package com.xjf.wemall.service.pkg;

import java.util.HashMap;
import java.util.Map;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.xjf.wemall.service.AllServiceTest;
import com.xjf.wemall.service.index.api.IndexService;


/**
 * Unit test for simple App.
 */
public class Pkg extends AllServiceTest {
	@Autowired
	private IndexService indexService;
	
	@Test
	public void index() {
		// 不可以
//		Cat cat = new Cat();
	}
	
	public static void main(String[] arg) {
		Map<String, String> hm = new HashMap<String, String>();
//	    hm.put("pkReferenceRule", "XSFW");
	    RestTemplate rest = new RestTemplate();
        System.out.println(rest.postForObject("http://home.chexiang.com/wxRestFul/queryServicePriceInfoForRestFul", hm, String.class));
	}
}
