package com.xjf.wemall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjf.wemall.api.entity.SampleVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.comparator.sampleComparator;
import com.xjf.wemall.service.AllServiceTest;
import com.xjf.wemall.service.index.api.IndexService;


/**
 * Unit test for simple App.
 */
public class pkgTest extends AllServiceTest {
	@Autowired
	private IndexService indexService;
	
	@Test
	public void index() {
		// 不可以
//		Cat cat = new Cat();
	}
	
}
