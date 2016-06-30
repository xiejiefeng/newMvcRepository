package com.xjf.wemall.service.active.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//import com.xjf.wemall.api.constant.BaseTemplateUtil;
//import com.xjf.wemall.api.constant.DistExport;
//import com.xjf.wemall.api.constant.WemallConstants;
//import com.xjf.wemall.api.entity.active.QAInfoVo;
//import com.xjf.wemall.api.entity.active.SuperActivePartInVo;
//import com.xjf.wemall.api.entity.active.SuperActiveVo;
//import com.xjf.wemall.api.entity.active.SuperQaInfo;
//import com.xjf.wemall.api.entity.coupon.CouponResultVo;
//import com.xjf.wemall.api.entity.coupon.CouponSendVo;
//import com.xjf.wemall.api.entity.useractive.UserActiveVo;
//import com.xjf.wemall.api.entity.useractiveresult.UserActiveResultVo;
//import com.xjf.wemall.api.util.JSONParser;
//import com.xjf.wemall.dal.useractiveresult.api.UserActiveResultDal;
//import com.xjf.wemall.service.AbstractService;
//import com.xjf.wemall.service.active.api.SuperActiveService;
//import com.xjf.wemall.service.coupon.api.CouponService;
//import com.xjf.wemall.service.sysreference.api.SysReferenceService;
//import com.xjf.wemall.service.useractive.api.UserActiveService;
//import com.xjf.wemall.service.useractiveresult.api.UserActiveResultService;

import com.xjf.wemall.api.util.JSONParser;

/**
 * 超级活动service
 * 
 * @author chongwenjun
 *
 */
@Service("superActiveService")
//extends AbstractService implements SuperActiveService
public class SuperActiveServiceImpl {
//	/** 参照信息 */
//	@Autowired
//	private SysReferenceService sysReferenceService;
//	@Autowired
//	private UserActiveService userActiveService;
//	@Autowired
//	private UserActiveResultService userActiveResultService;
//	@Autowired
//	private CouponService couponService;
//	@Autowired
//	private UserActiveResultDal userActiveResultDal;
//	// 长日期格式
//	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//
//	/**
//	 * 答题活动-自动匹配结果并跟新结果
//	 *
//	 * @param SuperActiveVo
//	 *            superActiveVo
//	 * @return int
//	 */
//	public int updateQaActiveResult(SuperActiveVo superActiveVo) {
//		if (superActiveVo == null) {
//			return -1;
//		}
//		if (StringUtils.isBlank(superActiveVo.getActiveCode())) {
//			return -1;
//		}
//		if (StringUtils.isBlank(superActiveVo.getCkeckId1())) {
//			return -1;
//		}
//		List<QAInfoVo> qaList = JSONParser.toStringList(superActiveVo.getCkeckId1(),
//				QAInfoVo.class);
//		if (qaList == null) {
//			return 0;
//		}
//		UserActiveResultVo uarVo = null;
//		for (QAInfoVo qaVo : qaList) {
//			if (!StringUtils.isBlank(qaVo.getTrueAnswer())) {
//				uarVo = new UserActiveResultVo();
//				// 设置编码(where条件)
//				uarVo.setActiveCode(superActiveVo.getActiveCode());
//				// 设置题目行号(where条件)
//				uarVo.setDoValue1(qaVo.getRn());
//				// 设置标准答案(where条件)
//				uarVo.setDoValue2(qaVo.getTrueAnswer());
//				// 设置标准答案(更新值)
//				uarVo.setRemark3Upd(qaVo.getTrueAnswer());
//				// 设置答对后的得分(更新值)
//				uarVo.setRemark2Upd(qaVo.getScore());
//				try {
//					userActiveResultDal.updateUserActiveResult(uarVo);
//				} catch (Exception e) {
//					logDBError("SuperActiveServiceImpl -- updateQaActiveResult -- Error !!!",
//							" 答题活动-自动匹配结果并跟新结果", JSONParser.toJSONString(uarVo),
//							super.getStackTrace(e));
//				}
//			}
//		}
//		return 0;
//	}
//
//	/**
//	 * 查询用户已参与活动的活动记录(单一活动范围)
//	 * 
//	 * @param UserActiveResultVo
//	 *            userActiveResultVo
//	 * @return List<UserActiveResultVo>
//	 */
//	public List<UserActiveResultVo> queryPartInActiveInfo(UserActiveResultVo userActiveResultVo) {
//		if (userActiveResultVo == null) {
//			logDBError(
//					"SuperActiveServiceImpl -- queryPartInActiveInfo -- userActiveResultVo is null !!!",
//					"查询用户已参与活动的活动记录失败", "", "");
//			return new ArrayList<UserActiveResultVo>();
//		}
//		// 活动编码不允许为空
//		if (StringUtils.isEmpty(userActiveResultVo.getActiveCode())
//				|| StringUtils.isEmpty(userActiveResultVo.getActiveCode().trim())) {
//			logDBError("SuperActiveServiceImpl -- queryPartInActiveInfo -- ActiveCode is null !!!",
//					"查询用户已参与活动的活动记录失败", "", "");
//			return new ArrayList<UserActiveResultVo>();
//		}
//		// 用户ID不允许为空
//		if (StringUtils.isEmpty(userActiveResultVo.getCxId())
//				|| StringUtils.isEmpty(userActiveResultVo.getCxId().trim())) {
//			logDBError("SuperActiveServiceImpl -- queryPartInActiveInfo -- CxId is null !!!",
//					"查询用户已参与活动的活动记录失败", "", "");
//			return new ArrayList<UserActiveResultVo>();
//		}
//		try {
//			return userActiveResultService.queryListForNotNull(userActiveResultVo);
//		} catch (Exception e) {
//			logDBError("SuperActiveServiceImpl -- queryPartInActiveInfo -- Error !!!",
//					"查询用户已参与活动的活动记录失败", "", super.getStackTrace(e));
//			return new ArrayList<UserActiveResultVo>();
//		}
//	}
//
//	/**
//	 * 根据活动code检查该活动是否有效
//	 * 
//	 * @param String
//	 *            activeCode
//	 * @return boolean
//	 */
//	public boolean checkActiveCanUsed(String activeCode) {
//		if (StringUtils.isEmpty(activeCode) || StringUtils.isEmpty(activeCode.trim())) {
//			logger.info("SuperActiveServiceImpl -- checkActiveCanUsed -- activeCode is null !!!");
//			return false;
//		}
//		if (activeCode.indexOf("_") > -1) {// 判断是否包含子活动编码，若包含则获取主活动编码
//			activeCode = activeCode.split("_")[0];
//		}
//		// 活动开始时间
//		String startTimeString = sysReferenceService.querySysReferenceValue(activeCode,
//				BaseTemplateUtil.PAGEPARAMAP + "_" + WemallConstants.SUPACT_START_TIME);
//		SimpleDateFormat sf = null;
//		// 判断是否需要check活动开始时间
//		if (!StringUtils.isEmpty(startTimeString) && !StringUtils.isEmpty(startTimeString.trim())) {
//			try {
//				long startTime;
//				sf = new SimpleDateFormat(TIME_FORMAT);
//				startTime = sf.parse(startTimeString).getTime();
//				if (System.currentTimeMillis() < startTime) {
//					logger.info(
//							"SuperActiveServiceImpl -- checkActiveCanUsed -- currentTime < startTime !!!");
//					return false;
//				}
//			} catch (Exception e) {
//				logger.info(
//						"SuperActiveServiceImpl -- checkActiveCanUsed -- startTime is wrong !!!");
//				logger.info(super.getStackTrace(e));
//				return false;
//			}
//		}
//		// 活动结束时间
//		String endTimeString = sysReferenceService.querySysReferenceValue(activeCode,
//				BaseTemplateUtil.PAGEPARAMAP + "_" + WemallConstants.SUPACT_END_TIME);
//		// 判断是否需要check活动结束时间
//		if (!StringUtils.isEmpty(endTimeString) && !StringUtils.isEmpty(endTimeString.trim())) {
//			try {
//				long endTime;
//				sf = new SimpleDateFormat(TIME_FORMAT);
//				endTime = sf.parse(endTimeString).getTime();
//				if (endTime < System.currentTimeMillis()) {
//					logger.info(
//							"SuperActiveServiceImpl -- checkActiveCanUsed --endTime < currentTime !!!");
//					return false;
//				}
//			} catch (Exception e) {
//				logger.info("SuperActiveServiceImpl -- checkActiveCanUsed -- endTime is wrong !!!");
//				logger.info(super.getStackTrace(e));
//				return false;
//			}
//		}
//		return true;
//	}
//
//	/**
//	 * 用户参与活动
//	 * 
//	 * @param SuperActivePartInVo
//	 *            partInVo
//	 * @return boolean
//	 */
//	public boolean partInActive(SuperActivePartInVo partInVo) {
//		try {
//			// 记录用户参与行为
//			UserActiveVo activeVo = new UserActiveVo();
//			activeVo.setActiveCode(partInVo.getActiveCode());
//			activeVo.setCxId(partInVo.getCxId());
//			activeVo.setOpenId(partInVo.getOpenId());
//			activeVo.setEquId(partInVo.getEquId());
//			activeVo.setSourceType(partInVo.getSourceType());
//			userActiveService.create(activeVo);
//			// 记录用户参与活动的结果信息表
//			if (partInVo.getUserActiveResultList() != null
//					&& partInVo.getUserActiveResultList().size() != 0) {
//				UserActiveResultVo resultVo = null;
//				for (int i = 0; i < partInVo.getUserActiveResultList().size(); i++) {
//					resultVo = (UserActiveResultVo) partInVo.getUserActiveResultList().get(i);
//					// 车享ID
//					resultVo.setCxId(partInVo.getCxId());
//					// 活动编码
//					resultVo.setActiveCode(partInVo.getActiveCode());
//					// 来源
//					resultVo.setSourceType(partInVo.getSourceType());
//					userActiveResultService.create(resultVo);
//				}
//			}
//			// 判断是否只要参加活动就发放奖品券
//			String flag = sysReferenceService.querySysReferenceValue(partInVo.getActiveCode(),
//					WemallConstants.SUPACT_ACTIVE_PARTIN_JP_COUPON);
//			if (!StringUtils.isEmpty(flag) && Boolean.parseBoolean(flag)) {
//				// 获得发放券编码map
//				String couponJsonString = this.execJavaScriptEngine(partInVo.getActiveCode(),
//						sysReferenceService.querySysReferenceValue(partInVo.getActiveCode(),
//								WemallConstants.REFERENCE_CODE_JP_TEMPLATE_NO));
//				if (StringUtils.isEmpty(couponJsonString)) {
//					logDBError("SuperActiveServiceImpl -- partInActive -- 参加活动就要发券 -- 无法获得发券信息",
//							"发放失败", "", "");
//					return true;
//				}
//				List<CouponSendVo> couponList = JSONParser.toStringList(couponJsonString,
//						CouponSendVo.class);
//				if (couponList == null || couponList.size() == 0) {
//					logDBError("SuperActiveServiceImpl -- partInActive -- 参加活动就要发券 -- 无券可发", "发放失败",
//							"", "");
//				}
//				CouponResultVo couponResult = couponService.grantCoupon(partInVo.getCxId(),
//						couponList);
//				if (couponResult != null && couponResult.isIfSuccess()) {
//					logDBInfo("SuperActiveServiceImpl -- partInActive -- 参加活动就要发券 ："
//							+ JSONParser.toJSONString(couponResult), "发放成功", "", "");
//				} else {
//					logDBInfo(
//							"SuperActiveServiceImpl -- partInActive -- 参加活动就要发券 -- 发放失败 ："
//									+ JSONParser.toJSONString(couponResult),
//							"发放失败", "", JSONParser.toJSONString(couponResult));
//				}
//			}
//			return true;
//		} catch (Exception e) {
//			logger.info("SuperActiveServiceImpl -- partInActive -- Error !!!");
//			logger.info(super.getStackTrace(e));
//			return false;
//		}
//	}
//
//	/**
//	 * 检查Active是否已经参与
//	 * 
//	 * @param SuperActiveVo
//	 *            superActiveVo
//	 * @see 检查精度（0：不做任何检查，1：cxId检查，2：equId检查，4：openId检查，
//	 *      8：预留检查位1，16：预留检查位2，32：预留检查位3，64：预留检查位4，128：预留检查位5，默认为1）
//	 * @see 若需要检查多个条件，可进行复合查询
//	 * @see 示例：cxId与equId同时检查，则checkFlag为1+2=3
//	 * @see 示例：cxId与openId同时检查，则checkFlag为1+4=5
//	 * @see 示例：cxId、openId、equId同时检查，则checkFlag为1+2+4=7
//	 * @see 以此类推
//	 * 
//	 * @return int 返回
//	 * 
//	 * @see 返回1：cxid已参与过活动
//	 * @see 返回2；equId已参与过活动
//	 * @see 返回4：openId已参与过活动
//	 * @see 返回多个check，进行复合返回
//	 * @see 示例：返回3，则cxId与equId已参与过活动
//	 * @see 示例：返回5，则cxId与equId已参与过活动
//	 * @see 示例：返回7，则cxId、openId、equId已参与过活动
//	 * @see 返回0为未参加过活动
//	 * @see 返回-1为系统异常
//	 *
//	 */
//	public int checkActiveIsGot(SuperActiveVo superActiveVo) {
//		if (superActiveVo == null) {// superActiveVo不允许为空
//			logger.info(
//					"SuperActiveServiceImpl -- checkRedPacketIsGot -- superActiveVo is null !!!");
//			return -1;
//		}
//		try {
//			if (WemallConstants.SUPACT_NOCHECK.equals(superActiveVo.getCheckFlag())) {// 不检查，直接通过
//				return 0;
//			} else {
//				boolean flag = false;
//				Set<Integer> tempSet = getCanUseCheckFlag();
//				if (tempSet == null) {
//					logger.info(
//							"SuperActiveServiceImpl -- checkRedPacketIsGot -- getCanUseCheckFlag error !!!");
//					return -1;
//				}
//				for (Integer str : tempSet) {
//					if (String.valueOf(str).equals(superActiveVo.getCheckFlag())) {
//						flag = true;
//						break;
//					}
//				}
//				if (!flag) {// 判断CheckFlag是否合法
//					logger.info(
//							"SuperActiveServiceImpl -- checkRedPacketIsGot -- superActiveVo CheckFlag is wrong !!!");
//					return -1;
//				}
//			}
//			String checkFlag = Integer
//					.toBinaryString(Integer.parseInt(superActiveVo.getCheckFlag()));// 转换二进制字符串
//			while (checkFlag.length() < this.getBinaryNums()) {
//				checkFlag = "0" + checkFlag;
//			}
//			/************************************************/
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 1, checkFlag.length()))) {// 检查cxId
//				superActiveVo.setNeedCxId(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setCxId("");
//			}
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 2, checkFlag.length() - 1))) {// 检查equId
//				superActiveVo.setNeedEquId(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setEquId("");
//			}
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 3, checkFlag.length() - 2))) {// 检查openId
//				superActiveVo.setNeedOpenId(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setOpenId("");
//			}
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 4, checkFlag.length() - 3))) {// 预留检查位1
//				superActiveVo.setNeedCkeckId1(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setCkeckId1("");
//			}
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 5, checkFlag.length() - 4))) {// 预留检查位2
//				superActiveVo.setNeedCkeckId2(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setCkeckId2("");
//			}
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 6, checkFlag.length() - 5))) {// 预留检查位3
//				superActiveVo.setNeedCkeckId3(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setCkeckId3("");
//			}
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 7, checkFlag.length() - 6))) {// 预留检查位4
//				superActiveVo.setNeedCkeckId4(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setCkeckId4("");
//			}
//			if ("1".equals(checkFlag.substring(checkFlag.length() - 8, checkFlag.length() - 7))) {// 预留检查位5
//				superActiveVo.setNeedCkeckId5(WemallConstants.FLG_YES);
//			} else {
//				superActiveVo.setCkeckId5("");
//			}
//			/************************************************/
//			if (WemallConstants.SUPACT_IGNORESOURCEFLAG
//					.equals(superActiveVo.getIgnoreSourceFlag())) {// 检查是否忽略来源
//				if (StringUtils.isEmpty(superActiveVo.getSourceType())
//						|| StringUtils.isEmpty(superActiveVo.getSourceType().trim())) {
//					logger.info(
//							"SuperActiveServiceImpl -- checkRedPacketIsGot -- superActiveVo SourceType is null !!!");
//					return -1;
//				}
//			}
//			if (WemallConstants.SUPACT_IGNOREACTIVEFLAG
//					.equals(superActiveVo.getIgnoreActiveFlag())) {// 检查是否忽略活动编码
//				if (StringUtils.isEmpty(superActiveVo.getActiveCode())
//						|| StringUtils.isEmpty(superActiveVo.getActiveCode().trim())) {
//					logger.info(
//							"SuperActiveServiceImpl -- checkRedPacketIsGot -- superActiveVo ActiveCode is null !!!");
//					return -1;
//				}
//			}
//			if (userActiveService.checkActiveIsGot(superActiveVo) > 0) {
//				// 已经参与过，不能再次参与
//				return Integer.parseInt(superActiveVo.getCheckFlag());
//			} else {
//				// 可以正常参与
//				return 0;
//			}
//		} catch (Exception e) {
//			logger.info("SuperActiveServiceImpl -- checkRedPacketIsGot -- Error !!!");
//			logger.info(super.getStackTrace(e));
//			return -1;
//		}
//
//	}
//
//	/**
//	 * 从数据库中获得可用checkFlag
//	 * 
//	 * @return String
//	 */
//	public String getCheckFlagByDB() {
//		return sysReferenceService.querySysReferenceValue(WemallConstants.PUBLICUTIL,
//				WemallConstants.SUPACT_ALLCHECKFLAG);
//	}
//
//	/**
//	 * 通过code获得javascript规则引擎（用于调用存储的javascript-随机规则信息）头部
//	 * 
//	 * @param String
//	 *            code 大类code
//	 * @return String<javascript>
//	 */
//	public String getJavaScriptRuleHead(String code) {
//		return sysReferenceService.querySysReferenceValue(code,
//				WemallConstants.SUPACT_JAVASCRIPTRULE_HEAD);
//	}
//
//	/**
//	 * 通过code获得javascript规则引擎内容（必须包含主方法名和参数名）
//	 * 
//	 * @param String
//	 *            code 大类code
//	 * @return String<javascript>
//	 */
//	public String getJavaScriptRuleBody(String code) {
//		return sysReferenceService.querySysReferenceValue(code,
//				WemallConstants.SUPACT_JAVASCRIPTRULE_BODY);
//	}
//
//	/**
//	 * 通过code及传入value参数获得javascript规则引擎执行结果
//	 * 
//	 * @param String
//	 *            code 大类code
//	 * @param String
//	 *            value 传入参数
//	 * @return String
//	 */
	@SuppressWarnings("unchecked")
	public String execJavaScriptEngine(String code, String value) {
		try {
			// 自定义的CODE
			//String jsHead = getJavaScriptRuleHead(code);
			// {"mainFuncName":"getRecommandInfo","mainParamName":"jsonParam"}
			String jsHead = "JSHEAD";
			if (StringUtils.isEmpty(jsHead) || StringUtils.isEmpty(jsHead.trim())) {
//				logDBError(
//						"SuperActiveServiceImpl -- execJavaScriptEngine -- javascript head is null",
//						"javascript规则引擎执行失败", "", "");
				return null;
			}
			Map<String, String> jsHeadMap = JSONParser.toStringObject(jsHead, HashMap.class);
			if (jsHeadMap == null
//					|| StringUtils
//							.isEmpty(jsHeadMap.get(WemallConstants.SUPACT_JAVASCRIPT_MAINFUN_NAME))
//					|| StringUtils.isEmpty(
//							jsHeadMap.get(WemallConstants.SUPACT_JAVASCRIPT_MAINFUN_NAME).trim())
//					|| StringUtils.isEmpty(
//							jsHeadMap.get(WemallConstants.SUPACT_JAVASCRIPT_MAINPARAM_NAME))
//					|| StringUtils.isEmpty(jsHeadMap
//							.get(WemallConstants.SUPACT_JAVASCRIPT_MAINPARAM_NAME).trim())
					) {
//				logDBError(
//						"SuperActiveServiceImpl -- execJavaScriptEngine -- javascript head mainFuncName or mainParamName is null",
//						"javascript规则引擎执行失败", "", "");
				return null;
			}
			// JSBODY
//			String jsBody = getJavaScriptRuleBody(code);
			String jsBody = "function getSclbTemplateNo(jsonParam){var data = JSON.parse(jsonParam);var areaCode = data.areaInfo.areaCode;var couponInfo = data.couponInfo;if (typeof couponInfo[areaCode] === 'undefined') {var code = couponInfo['*']; return JSON.stringify(couponInfo[code]);} else {var code = couponInfo[areaCode];return JSON.stringify(couponInfo[code]);}}";
			if (StringUtils.isEmpty(jsBody) || StringUtils.isEmpty(jsBody.trim())) {
//				logDBError(
//						"SuperActiveServiceImpl -- execJavaScriptEngine -- javascript body is null",
//						"javascript规则引擎执行失败", "", "");
				return null;
			}
			// 执行javascript引擎
			// 定义工具
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine se = sem.getEngineByName("javascript");
			Invocable invocableEngine = (Invocable) se;
			Compilable compEngine = (Compilable) se;
			// 预编译javascript是否合法
			CompiledScript script = compEngine.compile(jsBody);
			try {
				script.eval();
			} catch (Exception e) {
//				logDBError(
//						"SuperActiveServiceImpl -- execJavaScriptEngine -- PreCompiledScript -- Error !!!",
//						"javascript规则引擎执行失败", "", super.getStackTrace(e));
				return null;
			}
			// 调用有参数JAVASCRIPT函数
			se.eval(jsBody);
			// 方法名
//			return (String) invocableEngine.invokeFunction(
//					jsHeadMap.get(WemallConstants.SUPACT_JAVASCRIPT_MAINFUN_NAME),
//					StringUtils.isEmpty(value) ? "" : value);
			return "";
		} catch (Exception e) {
//			logDBError("SuperActiveServiceImpl -- execJavaScriptEngine -- Error !!!",
//					"javascript规则引擎执行失败", "", super.getStackTrace(e));
			return null;
		}
	}
//
//	/****** main ******/
//
//	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put(WemallConstants.SUPACT_JAVASCRIPT_MAINFUN_NAME, "getRetrunCode");
//		map.put(WemallConstants.SUPACT_JAVASCRIPT_MAINPARAM_NAME, "jsonParam");
//		System.out.println(JSONParser.toJSONString(map));
//		/***************************************************/
//		SuperActiveVo superActiveVo = new SuperActiveVo();
//		// 车享ID
//		superActiveVo.setCheckFlag("1");
//		superActiveVo.setIgnoreSourceFlag("0");
//		System.out.println(JSONParser.toJSONString(superActiveVo));
//		/***************************************************/
//		SuperActivePartInVo superActivePartInVo = new SuperActivePartInVo();
//		superActivePartInVo.setActiveCode("aaaaa");
//		superActivePartInVo.setCxId("bbbbb");
//		superActivePartInVo.setOpenId("ccccc");
//		superActivePartInVo.setEquId("ddddd");
//		superActivePartInVo.setSourceType("eeeee");
//		List<UserActiveResultVo> temp = new ArrayList<UserActiveResultVo>();
//		UserActiveResultVo userActiveResultVo = new UserActiveResultVo();
//		userActiveResultVo.setDoType("1");
//		userActiveResultVo.setDoValue1("2222");
//		userActiveResultVo.setDoValue2("3333");
//		userActiveResultVo.setDoValue3("4444");
//		userActiveResultVo.setDoValue4("5555");
//		userActiveResultVo.setRemark1("rr1111");
//		userActiveResultVo.setRemark2("rr2222");
//		userActiveResultVo.setRemark3("rr3333");
//		userActiveResultVo.setRemark4("rr4444");
//		temp.add(userActiveResultVo);
//		userActiveResultVo = new UserActiveResultVo();
//		userActiveResultVo.setDoType("2");
//		userActiveResultVo.setDoValue1("EEE2222");
//		userActiveResultVo.setDoValue2("EEE3333");
//		userActiveResultVo.setDoValue3("EEE4444");
//		userActiveResultVo.setDoValue4("EEE5555");
//		userActiveResultVo.setRemark1("EEErr1111");
//		userActiveResultVo.setRemark2("EEErr2222");
//		userActiveResultVo.setRemark3("EEErr3333");
//		userActiveResultVo.setRemark4("EEErr4444");
//		temp.add(userActiveResultVo);
//		superActivePartInVo.setUserActiveResultList(temp);
//		System.out.println(JSONParser.toJSONString(superActivePartInVo));
//		/***************************************************/
//		userActiveResultVo = new UserActiveResultVo();
//		userActiveResultVo.setActiveCode("111111");
//		System.out.println(JSONParser.toJSONString(userActiveResultVo));
//		List<UserActiveResultVo> jsonTemp = new ArrayList<UserActiveResultVo>();
//		userActiveResultVo = new UserActiveResultVo();
//		userActiveResultVo.setActiveCode("aa");
//		userActiveResultVo.setCxId("ab");
//		jsonTemp.add(userActiveResultVo);
//		userActiveResultVo = new UserActiveResultVo();
//		userActiveResultVo.setActiveCode("ba");
//		userActiveResultVo.setCxId("bb");
//		jsonTemp.add(userActiveResultVo);
//		System.out.println(JSONParser.toJSONString(jsonTemp));
//		List<String> a = new ArrayList<String>();
//		a.add("PAGEPARAMAP_Q");
//		a.add("PAGEPARAMAP_A");
//		a.add("PAGEPARAMAP_START_TIME");
//		a.add("PAGEPARAMAP_END_TIME");
//		a.add("TITLE_PIC");
//		a.add("TITLE_NAME");
//		System.out.println(JSONParser.toJSONString(a));
//
//		List<SuperQaInfo> qsList = new ArrayList<SuperQaInfo>();
//		SuperQaInfo qaInfo = null;
//		for (int i = 1; i < 7; i++) {
//			qaInfo = new SuperQaInfo();
//			qaInfo.setRn(String.valueOf(i));
//			qaInfo.setQuestion(String.valueOf(i));
//			qaInfo.setAnswerA(String.valueOf(i));
//			qaInfo.setAnswerB(String.valueOf(i));
//			qaInfo.setAnswerC(String.valueOf(i));
//			qaInfo.setAnswerD(String.valueOf(i));
//			qaInfo.setQuestion(String.valueOf(i));
//			qsList.add(qaInfo);
//		}
//		System.out.println(JSONParser.toJSONString(qsList));
//
//		List<CouponSendVo> t = new ArrayList<CouponSendVo>();
//		CouponSendVo couponSendVo = new CouponSendVo();
//		couponSendVo.setCouponTemplateNo("601601apptest001");
//		couponSendVo.setDistExport(DistExport.CXJ_APP);
//		couponSendVo.setGrantNum(1);
//		t.add(couponSendVo);
//		couponSendVo = new CouponSendVo();
//		couponSendVo.setCouponTemplateNo("601DJBYJ100");
//		couponSendVo.setDistExport(DistExport.CXJ_APP);
//		couponSendVo.setGrantNum(2);
//		t.add(couponSendVo);
//		System.out.println("t = " + JSONParser.toJSONString(t));
//	}
//
//	/************** 私有方法 *****************/
//	/**
//	 * 获得需要补位的二进制总长度
//	 * 
//	 * @return int
//	 */
//	private int getBinaryNums() {
//		try {
//			int max = 0;
//			for (Integer str : getCanUseCheckFlag()) {
//				if (str > max) {
//					max = str;
//				}
//			}
//			return Integer.toBinaryString(max).length();
//		} catch (Exception e) {
//			return 0;
//		}
//	}
//
//	/**
//	 * 获得所有合法的checkFlag
//	 * 
//	 * @return Set<Integer>
//	 */
//	public Set<Integer> getCanUseCheckFlag() {
//		// List<Integer> iL = new ArrayList<Integer>();
//		List<Integer> result = new ArrayList<Integer>();
//		String[] is = getCheckFlagByDB().split(",");
//		int temple = 0;
//		// for (int i = 1; i <= is.length; i++) {
//		for (int i = 0; i < is.length; i++) {
//			// 递归生成可用列表
//			// plzh(result, "0", iL, i, is);
//			temple = temple + Integer.parseInt(is[i]);
//		}
//		for (int i = 1; i <= temple; i++) {
//			result.add(i);
//		}
//		Set<Integer> set = new HashSet<Integer>(result);
//		return set;
//	}
//
//	/**
//	 * 排列组合
//	 * 
//	 * @param result
//	 * @param s
//	 * @param iL
//	 * @param m
//	 * @param is
//	 */
//	@SuppressWarnings("unused")
//	private void plzh(List<Integer> result, String s, List<Integer> iL, int m, String[] is) {
//		if (m == 0) {
//			result.add(Integer.parseInt(s));
//			return;
//		}
//		List<Integer> iL2;
//		for (int i = 0; i < is.length; i++) {
//			iL2 = new ArrayList<Integer>();
//			iL2.addAll(iL);
//			if (!iL.contains(i)) {
//				int str = Integer.parseInt(s) + Integer.parseInt(is[i]);
//				iL2.add(i);
//				plzh(result, String.valueOf(str), iL2, m - 1, is);
//			}
//		}
//	}
}
