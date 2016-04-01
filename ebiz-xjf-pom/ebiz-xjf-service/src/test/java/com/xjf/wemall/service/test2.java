package com.xjf.wemall.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;

public class test2 {

	public static void main(String[] args) {

		String aa = "119";
		String bb = "1119.1";
		String CC = "1119.12";
		System.out.println(new DecimalFormat("#.00").format(new Double(aa)));
		System.out.println(new DecimalFormat("#.00").format(new Double(bb)));
		System.out.println(new DecimalFormat("#.00").format(new Double(CC)));

		loop: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 3 && j == 4) {
					System.out.println();
					continue loop;
				}
				System.out.print(i + "*" + j + "=" + i * j + "    ");
			}
			System.out.println();
		}
		
		loop: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 3 && j == 4) {
					System.out.println();
					break loop;
				}
				System.out.print(i + "*" + j + "=" + i * j + "    ");
			}
			System.out.println();
		}
	}

}
