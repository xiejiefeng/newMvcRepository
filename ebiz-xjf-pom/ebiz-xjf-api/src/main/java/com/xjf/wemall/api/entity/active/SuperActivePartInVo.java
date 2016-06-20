package com.xjf.wemall.api.entity.active;

import java.util.List;

import com.xjf.wemall.api.entity.useractive.UserActiveVo;
import com.xjf.wemall.api.entity.useractiveresult.UserActiveResultVo;

public class SuperActivePartInVo extends UserActiveVo {

	private static final long serialVersionUID = 1L;

	private List<UserActiveResultVo> userActiveResultList;

	public List<UserActiveResultVo> getUserActiveResultList() {
		return userActiveResultList;
	}

	public void setUserActiveResultList(List<UserActiveResultVo> userActiveResultList) {
		this.userActiveResultList = userActiveResultList;
	}

}
