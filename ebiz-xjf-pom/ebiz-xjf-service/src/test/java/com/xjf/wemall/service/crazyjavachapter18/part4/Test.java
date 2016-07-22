package com.xjf.wemall.service.crazyjavachapter18.part4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import com.xjf.wemall.api.util.DateUtil;

public class Test {
	private Map<String , Integer> score;
	public static void main(String[] arg) throws Exception {
		
		Class<?> clazz = Class.forName("com.xjf.wemall.api.util.DateUtil");
		// 反射 静态方法 无变量
		System.out.println(clazz.getMethod("getCurrentDateTime", null).invoke(null, null));
		// 反射 静态方法 有变量
		System.out.println(clazz.getMethod("parseTimeFlag", String.class).invoke(clazz, "1"));
		// 反射 静态变量
		System.out.println(clazz.getField("FORMAT_DATETIME_YYYYMMDDHHMMSSSSS").get(clazz));
		
		// 反射 对象方法
		DateUtil ts = (DateUtil)clazz.newInstance();
		System.out.println(ts.getCurrentDateTimeNow());


		Class<?> cs = Class.forName("com.xjf.wemall.service.crazyjavachapter18.part4.Test");
		Field fd = cs.getDeclaredField("score");
		Class<?> cs2 = fd.getType();
		System.out.println(cs2);
		
		// 获得成员变量f的泛型类型
		Type gtype = fd.getGenericType();
		if(gtype instanceof ParameterizedType)
		{
			// 强制类型转换
			ParameterizedType tp = (ParameterizedType) gtype;
			// 获取原始类型
			Type rType = tp.getRawType();
			System.out.println("原始类型是：" + rType);
			// 取得泛型类型的泛型参数
			Type[] tArgs = tp.getActualTypeArguments();
			System.out.println("泛型信息是:");
			for (int i = 0; i < tArgs.length; i++)
			{
				System.out.println("第" + i + "个泛型类型是：" + tArgs[i]);
			}
		}
		
	}
}
