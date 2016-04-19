package com.xjf.wemall.service.crazyjavachapter6;

import org.junit.Test;
import com.xjf.wemall.service.AllServiceTest;


/**
 * Unit test for simple App.
 */
public class enumTest extends AllServiceTest {
	
	@Test
	public void test1() {
		// values方法返回所有枚举实例
		for(SeasonEnum season : SeasonEnum.values()) {
			System.out.println(getSeason(season));
		}
		System.out.println(getSeason(SeasonEnum.SPRING));
		
		// -1
		System.out.println(SeasonEnum.SPRING.compareTo(SeasonEnum.SUMMER));
		// SPRING
		System.out.println(SeasonEnum.SPRING.name());
		// SPRING
		System.out.println(SeasonEnum.valueOf(SeasonEnum.class, SeasonEnum.SPRING.name()));
	}
	
	private String getSeason(SeasonEnum season) {
		switch(season) {
		case SPRING:
			return "春天";
		case SUMMER:
			return "夏天";
		case FALL:
			return "秋天";
		case WINTER:
			return "冬天";
		}
		return null;
	}

	/****************************Gender*************************/
	
	@Test
	public void test2() {
		// 通过Enum的valueOf获取指定枚举型的实例
		Gender f = Enum.valueOf(Gender.class, "FAMALE");
		Gender m = Gender.MALE;

		System.out.println(f+"代表"+f.getName());
		System.out.println(m+"代表"+m.getName());
	}
}
