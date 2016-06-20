package com.xjf.wemall.service.active.api;

import java.util.List;
import java.util.Set;

import com.xjf.wemall.api.entity.active.SuperActivePartInVo;
import com.xjf.wemall.api.entity.active.SuperActiveVo;
import com.xjf.wemall.api.entity.useractiveresult.UserActiveResultVo;

/**
 * 超级活动service
 * 
 * @author chongwenjun
 *
 */
public interface SuperActiveService {
	/**
	 * 检查Active是否已经参与
	 * 
	 * @param SuperActiveVo
	 *            superActiveVo
	 * @see 检查精度（1：cxId检查，2：equId检查，4：openId检查，默认为1）
	 * @see 若需要检查多个条件，可进行复合查询
	 * @see 示例：cxId与equId同时检查，则checkFlag为1+2=3
	 * @see 示例：cxId与openId同时检查，则checkFlag为1+4=5
	 * @see 示例：cxId、openId、equId同时检查，则checkFlag为1+2+4=7
	 * @see 以此类推
	 * 
	 * @return int 返回
	 * 
	 * @see 返回1：cxid已参与过活动
	 * @see 返回2；equId已参与过活动
	 * @see 返回4：openId已参与过活动
	 * @see 返回多个check，进行复合返回
	 * @see 示例：返回3，则cxId与equId已参与过活动
	 * @see 示例：返回5，则cxId与equId已参与过活动
	 * @see 示例：返回7，则cxId、openId、equId已参与过活动
	 * @see 返回0为未参加过活动
	 * @see 返回-1为系统异常
	 *
	 */
	public int checkActiveIsGot(SuperActiveVo superActiveVo);

	/**
	 * 从数据库中获得可用checkFlag
	 * 
	 * @return String
	 */
	public String getCheckFlagByDB();

	/**
	 * 获得所有合法的checkFlag
	 * 
	 * @return Set<Integer>
	 */
	public Set<Integer> getCanUseCheckFlag();

	/**
	 * 通过code获得javascript规则引擎（用于调用存储的javascript-随机规则信息）头部
	 * 
	 * @param String
	 *            code 大类code
	 * @return String<javascript>
	 */
	public String getJavaScriptRuleHead(String code);

	/**
	 * 通过code获得javascript规则引擎内容（必须包含主方法名和参数名）
	 * 
	 * @param String
	 *            code 大类code
	 * @return String<javascript>
	 */
	public String getJavaScriptRuleBody(String code);

	/**
	 * 通过code及传入value参数获得javascript规则引擎执行结果
	 * 
	 * @param String
	 *            code 大类code
	 * @param String
	 *            value 传入参数
	 * @return String
	 */
	public String execJavaScriptEngine(String code, String value);

	/**
	 * 用户参与活动
	 * 
	 * @param SuperActivePartInVo
	 *            partInVo
	 * @return boolean
	 */
	public boolean partInActive(SuperActivePartInVo partInVo);

	/**
	 * 根据活动code检查该活动是否有效
	 * 
	 * @param String
	 *            activeCode
	 * @return boolean
	 */
	public boolean checkActiveCanUsed(String activeCode);

	/**
	 * 查询用户已参与活动的活动记录
	 * 
	 * @param UserActiveResultVo
	 *            userActiveResultVo
	 * @return List<UserActiveResultVo>
	 */
	public List<UserActiveResultVo> queryPartInActiveInfo(UserActiveResultVo userActiveResultVo);

	/**
	 * 答题活动-自动匹配结果并跟新结果
	 *
	 * @param SuperActiveVo
	 *            superActiveVo
	 * @return int
	 */
	int updateQaActiveResult(SuperActiveVo superActiveVo);

}
