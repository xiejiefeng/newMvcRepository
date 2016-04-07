package com.xjf.wemall.service.crazyjavachapter6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjf.wemall.api.util.JSONParser;


/**
 * 缓存不可变类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CacheImmutale {
   private static final int MAX_SIZE = 10;
   private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];
   
   // 缓存计数
   private static int pos = 0;
   private final String name;
   private CacheImmutale(String name) {
	   this.name = name;
   }
   
   public String getName() {
	   return this.name;
   }
   
   public static CacheImmutale valueOf(String name) {
	   // 遍历所有
	   for (int i = 0; i < MAX_SIZE; i++) {
		   if (cache[i] != null && cache[i].getName().equals(name)) {
			   return cache[i];
		   }
	   }
	   
	   // 如果缓存池已经满了
	   if (pos == MAX_SIZE) {
		   cache[0] = new CacheImmutale(name);
		   pos = 1;
	   } else {
		   cache[pos++] = new CacheImmutale(name);
	   }
	   return cache[pos-1];
   }
   
   public boolean equals(Object obj) {
	   if(this == obj) {
		   return true;
	   }
	   
	   if (obj != null && obj.getClass() == CacheImmutale.class) {
		   CacheImmutale ci = (CacheImmutale) obj;
		   return name.equals(ci.getName());
	   }
	   
	   return false;
   }
}

class CacheImmutaleTest {
	public static void main(String[] args) {
		CacheImmutale s1 = CacheImmutale.valueOf("hello");
		CacheImmutale s2 = CacheImmutale.valueOf("hello");
		
		System.out.println(s1 == s2);// true
	}
}

