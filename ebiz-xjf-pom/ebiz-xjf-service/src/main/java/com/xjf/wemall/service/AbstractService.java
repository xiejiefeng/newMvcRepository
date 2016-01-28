/**
 * 
 */
package com.xjf.wemall.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.xjf.wemall.api.constant.api.Code;
//import com.xjf.wemall.service.log.api.LogService;
//import com.saic.wemall.service.sysreference.api.SysRefFieldService;

/**
 * @author baowenzhou
 *
 */
public abstract class AbstractService {
	/**日志类*/
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());
	
	/** Redis */
	/**微信AccessToken的KEY(2小时)*/
	protected static final String ACCESS_TOKEN_KEY = "WEMALL:ACCESS_TOKEN";
	/**微信USER:AccessToken的KEY(2小时)*/
	protected static final String USER_ACCESS_TOKEN_KEY = "WEMALL:USER_ACCESS_TOKEN:SESSION:";
	
	/**微信JS接口的临时票据的KEY(2小时)*/
	protected static final String JSAPI_TICKET_KEY = "WEMALL:JSAPI_TICKET";
	
	/**门店信息缓存KEY(无限)*/
    protected static final String STORE_LIST_KEY = "WEMALL:STORE:LIST";
    /**门店信息缓存KEY(无限)*/
    protected static final String STORE_AREA_MAP_KEY = "WEMALL:STORE:AREA_MAP_HASH";
    /**门店信息缓存KEY(无限)*/
    protected static final String STORE_ID_MAP_KEY = "WEMALL:STORE:ID_MAP_HASH";
    /**城市信息缓存KEY(无限)*/
    protected static final String AREA_LIST_KEY = "WEMALL:STORE:AREA_LIST";
    
    /**服务缓存KEY(无限)*/
	protected static final String PRODUCT_KEY = "WEMALL:SERVICE:PRODUCT:";
	/**服务价格缓存KEY(无限)*/
	protected static final String PRODUCT_PRICE_MAP_KEY = "WEMALL:SERVICE:PRICE:";
	/**车辆等级服务推荐缓存KEY(无限)*/
	protected static final String CARLEVEL_MAP_KEY = "WEMALL:SERVICE:CARLEVEL_MAP_HASH";
	
	/**商品缓存KEY(无限)*/
	protected static final String SKU_KEY = "WEMALL:SKU:SKU:";
	/**商品价格缓存KEY(无限)*/
	protected static final String SKU_PRICE_MAP_KEY = "WEMALL:SKU:PRICE:";
	/**商品区域缓存KEY(无限)*/
	protected static final String SKU_AREA_MAP_KEY = "WEMALL:SKU:AREA_MAP_HASH";
	/**商品规格缓存KEY(无限)*/
	protected static final String SKU_SPEC_MAP_KEY = "WEMALL:SKU:SPEC_MAP_HASH";
	/**商品规格缓存KEY(无限)*/
	protected static final String SKU_SPEC_LIST_KEY = "WEMALL:SKU:SPEC_LIST";
	
	/**车型缓存(车型-List)KEY(无限)*/
	protected static final String CARLEVEL_LIST_KEY = "WEMALL:CARLEVEL:LIST";
	/**车型缓存(品牌字母-Map)KEY(无限)*/
	protected static final String CARLEVEL_ALPHA_MAP_KEY = "WEMALL:CARLEVEL:ALPHA_MAP_HASH";
	/**车型缓存(品牌ID-Map)KEY(无限)*/
	protected static final String CARLEVEL_BRAND_MAP_KEY = "WEMALL:CARLEVEL:BRAND_MAP_HASH";
	/**车型缓存(品牌ID+厂家ID-Map)KEY(无限)*/
	protected static final String CARLEVEL_VENDER_MAP_KEY = "WEMALL:CARLEVEL:VENDER_MAP_HASH";
	/**车型缓存(品牌ID+厂家ID+车系ID-Map)KEY(无限)*/
	protected static final String CARLEVEL_SERIES_MAP_KEY = "WEMALL:CARLEVEL:SERIES_MAP_HASH";
	/**车型缓存(车型ID-Map)KEY(无限)*/
	protected static final String CARLEVEL_MDM_MAP_KEY = "WEMALL:CARLEVEL:MDM_MAP_HASH";
	/**车型缓存(品牌名称-Map)KEY(无限)*/
	protected static final String CARLEVEL_BRAND_NAME_MAP_KEY = "WEMALL:CARLEVEL:BRAND_NAME_MAP_HASH";
	/**车型缓存(车型名称+排量+进气方式-Map)KEY(无限)*/
	protected static final String CARLEVEL_MOULD_NAME_MAP_KEY = "WEMALL:CARLEVEL:MOULD_NAME_MAP_HASH";
	
	/**自动回复缓存KEY(1天)*/
	protected static final String REPLY_LIST_KEY = "WEMALL:REPLY:REPLY_LIST";
	/**关注回复缓存KEY(1天)*/
	protected static final String SUBSCRIBE_LIST_KEY = "WEMALL:REPLY:SUBSCRIBE_LIST";
	
	/**微信客户KEY(30分钟)*/
	protected static final String CUSTOM_INFO_KEY = "WEMALL:CUSTOM:CXID:";
	/**车享宝客户KEY(1天)*/
	protected static final String CUSTOM_CXB_INFO_KEY = "WEMALL:CUSTOM_CXB:CXID:";
	
	/**预约订单KEY(30分钟)*/
	protected static final String PREORDER_INFO_KEY = "WEMALL:PREORDER:CXID:";
	/**历史订单KEY(30分钟)*/
	protected static final String ORDER_INFO_KEY = "WEMALL:ORDER:CXID:";
	
	/**微信用户KEY(1天)*/
	protected static final String USERINFO_KEY = "WEMALL:USERINFO:OPENID:";
	/**用户信息SessionKEY(1天)*/
	public static final String USERINFO_SESSION_KEY = "WEMALL:USERINFO:SESSIONID:";
	
	/**微信用户标识(30天)*/
	protected static final String USER_KEY_KEY = "WEMALL:USER:KEY:OPENID:";
	/**微信地理位置KEY(1小时)*/
	protected static final String USER_LOCATION_KEY = "WEMALL:USER:LOCATION:KEY:";
	/**微信地理位置详细KEY(1小时)*/
	protected static final String USER_GEOCODER_KEY = "WEMALL:USER:GEOCODER:KEY:";
    /**定位城市缓存KEY(30天)*/
	protected static final String USER_AREASTORE_KEY = "WEMALL:USER:AREASTORE:KEY:";
	
	/**购物车缓存KEY(1天)*/
	protected static final String SHOPPINGCART_KEY = "WEMALL:SHOPPINGCART:KEY:";
	
    /**二维码Ticket缓存KEY(无限)*/
	protected static final String QRCODE_TICKET_KEY = "WEMALL:QRCODE:TICKET:";
	/**二维码场景缓存KEY(无限)*/
	protected static final String QRCODE_SCENE_KEY = "WEMALL:QRCODE:SCENE";
	
	/**广告图片缓存KEY(无限)*/
	protected static final String REFERENCE_BANNER_KEY = "WEMALL:REFERENCE:BANNER";
	/**促销信息缓存KEY(无限)*/
	protected static final String REFERENCE_PROMOTION_KEY = "WEMALL:REFERENCE:PROMOTION";
	/**服务信息缓存KEY(无限)*/
	protected static final String REFERENCE_SERVICE_KEY = "WEMALL:REFERENCE:SERVICE";
	
	/**保养手册缓存KEY(1天)*/
	protected static final String MAINTENANCE_LIST_KEY = "WEMALL:MAINTENANCE:LIST";
    
	/**系统参数缓存(系统参数code-Map)KEY(1天)*/
	protected static final String SYS_REFERENCE_MAP_KEY = "WEMALL:SYSREFERENCE";
	
	/**门店技师缓存KEY(无限)*/
	protected static final String STORE_ARTIFICER_MAP_KEY = "WEMALL:ARTIFICER:";
	
	/**模板-首页Menu缓存KEY(无限)*/
	protected static final String TEMPLATE_HOME_KEY = "WEMALL:TEMPLATE:HOME";
	
	/**美容卡销售缓存KEY(无限)*/
	protected static final String MRK_AREA_KEY = "WEMALL:MRK:AREA:";
	
	/**缓存刷新锁的KEY(5分钟/30秒)*/
	protected static final String COMMON_RESET_LOCK_KEY = "WEMALL:COMMON:RESET_LOCK";
	/**配置界面验证缓存(30分钟/1天)*/
	protected static final String COMMON_VERIFY_KEY = "WEMALL:COMMON:VERIFY:";
	
//	/**参照信息*/
//    @Autowired
//    protected SysRefFieldService sysRefFieldService;
    
//    /**日志记录服务*/
//    @Autowired
//    private LogService logService;
    
    @Autowired
    private MessageSource messageSource;
	
	/**
	* 获取异常的堆栈信息
	* 
	* @param t
	* @return
	*/
	protected String getStackTrace(Throwable t)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try
		{
			t.printStackTrace(pw);
			return sw.toString();
		}
		finally
		{
			pw.close();
		}
	}
	
	/**
	 * 
	 * 功能描述: 执行开始时间<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
//	protected long logSTime() {
//		return logService.logStartTime();
//	}
	
	/**
	 * 
	 * 功能描述: 执行结束时间<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	protected void logETime(long sTime, Object... arguments) {
//		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
//        StackTraceElement e = stacktrace[2];
//        String className = e.getClassName();
//        String methodName = e.getMethodName();
//        logService.logEndTime(sTime, className, methodName, arguments);
	}
	
	/**
	 * 
	 * 功能描述: 获取信息<br>
	 * 〈功能详细描述〉
	 *
	 * @param code
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	protected String getMsg(String code) {
		return messageSource.getMessage(code, null, Locale.CHINA);
	}
	
	/**
	 * 
	 * 功能描述: 获取信息<br>
	 * 〈功能详细描述〉
	 *
	 * @param code
	 * @param args
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	protected String getMsg(String code, Object... args) {
		return messageSource.getMessage(code, args, Locale.CHINA);
	}
	
	/**
	 * 
	 * 功能描述: 获取信息<br>
	 * 〈功能详细描述〉
	 *
	 * @param code
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	protected String getMsgAndMethod(Code<String> code) {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
        StackTraceElement e = stacktrace[2];
        String className = e.getClassName();
        String methodName = e.getMethodName();
		StringBuffer msg = new StringBuffer();
		msg.append(this.getMsg(code.code()));
		msg.append(",class:");
		msg.append(className);
		msg.append(",method:");
		msg.append(methodName);

		return msg.toString();
	}
	
	/**
	 * 
	 * 功能描述: 获取信息<br>
	 * 〈功能详细描述〉
	 *
	 * @param code
	 * @param args
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	protected String getMsgAndMethod(Code<String> code, Object... args) {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
        StackTraceElement e = stacktrace[2];
        String className = e.getClassName();
        String methodName = e.getMethodName();
		StringBuffer msg = new StringBuffer();
		msg.append(this.getMsg(code.code(), args));
		msg.append(",class:");
		msg.append(className);
		msg.append(",method:");
		msg.append(methodName);
		
		return msg.toString();
	}
}
