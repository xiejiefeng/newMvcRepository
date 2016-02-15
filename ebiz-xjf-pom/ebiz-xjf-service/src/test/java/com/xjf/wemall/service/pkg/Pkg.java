package com.xjf.wemall.service.pkg;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

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
	
}
