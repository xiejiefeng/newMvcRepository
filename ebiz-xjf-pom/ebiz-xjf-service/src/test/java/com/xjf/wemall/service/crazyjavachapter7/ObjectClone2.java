package com.xjf.wemall.service.crazyjavachapter7;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.BeanUtils;

import org.apache.commons.beanutils.BeanUtils;
import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;
import com.xjf.wemall.api.entity.user.CustomInfoVo;

/**
 * Clone<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ObjectClone2 {
	
	public static void main(String[] args) {
		CustomInfoVo vo = new CustomInfoVo();
		List<CarModelInfoVo> carInfo = new ArrayList<CarModelInfoVo>();
		CarModelInfoVo car = new CarModelInfoVo();
		car.setAssetId("11111");
		carInfo.add(car);
		vo.setCarInfo(carInfo);
		
		
		CustomInfoVo2 vo2 = new CustomInfoVo2();
//		BeanUtils.copyProperties(vo, vo2);
		try {
			
			BeanUtils.copyProperties(vo2, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.identityHashCode(vo.getCarInfo()) == System.identityHashCode(vo2.getCarInfo()));
		System.out.println(vo2.getCarInfo().get(0).getAssetId());
		CarModelInfoVo t = new CarModelInfoVo();
		t.setCarName("car");
		vo.getCarInfo().add(t);
		
		System.out.println(vo2.getCarInfo().get(1).getCarName());
		
	}
}

