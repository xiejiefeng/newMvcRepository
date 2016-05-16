package com.xjf.wemall.service.crazyjavachapter7;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;
import com.xjf.wemall.api.entity.user.CustomInfoVo;
import com.xjf.wemall.api.util.JSONParser;

/**
 * Clone<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ObjectClone {
	
	public static void main(String[] args) {
		CustomInfoVo vo = new CustomInfoVo();
		List<CarModelInfoVo> carInfo = new ArrayList<CarModelInfoVo>();
		CarModelInfoVo car = new CarModelInfoVo();
		car.setAssetId("11111");
		carInfo.add(car);
		vo.setCarInfo(carInfo);
		
		
		CustomInfoVo vo2 = new CustomInfoVo();
		
		try {
//			BeanUtils.copyProperties(vo, vo2);
			BeanUtils.copyProperties(vo2, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.identityHashCode(vo.getCarInfo()) == System.identityHashCode(vo2.getCarInfo()));
		
		CarModelInfoVo t = new CarModelInfoVo();
		t.setCarName("car");
		vo.getCarInfo().add(t);
		
		System.out.println(vo2.getCarInfo().get(1).getCarName());
		
		System.out.println(System.currentTimeMillis());
		
	}
}

