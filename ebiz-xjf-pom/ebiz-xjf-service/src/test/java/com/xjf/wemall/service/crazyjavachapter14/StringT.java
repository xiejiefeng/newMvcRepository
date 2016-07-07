package com.xjf.wemall.service.crazyjavachapter14;

import com.xjf.wemall.api.entity.shoppingcart.CartVo;

public class StringT {
	
	public void ret(CartVo cart) {
		cart.setServiceCodes("4321");
	}
	
	public static void main(String[] a) {
		CartVo cart = new CartVo();
		cart.setServiceCodes("1234");
		StringT T = new StringT();
		String tt = cart.getServiceCodes();

		System.out.println(cart.getServiceCodes().equals(tt));
		System.out.println(tt == cart.getServiceCodes());
		T.ret(cart);
		System.out.println(cart.getServiceCodes());
	}
}
