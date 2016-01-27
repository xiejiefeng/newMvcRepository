/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AllCoreTest.java
 * Author:   wanglijun
 * Date:     2014年8月15日 上午10:50:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Service总的测试类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-service-test.xml")
public abstract class AllServiceTest extends AbstractJUnit4SpringContextTests {
    /**日志*/
    protected final Logger logger=LoggerFactory.getLogger(super.getClass());
}
