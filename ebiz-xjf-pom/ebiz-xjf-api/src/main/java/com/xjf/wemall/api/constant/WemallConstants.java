/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: WemallConstants.java
 * Author:   baowenzhou
 * Date:     2015年10月08日 下午4:39:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant;

/**
 * 系统公用常量定义
 *
 * @author baowenzhou
 */
public class WemallConstants {

	/**
	 * 已删除
	 */
	public static final String IS_DELETED_TRUE = "1";

	/**
	 * 未删除且放入redis
	 */
	public static final String IS_DELETED_FALSE = "0";

	/**
	 * 未删除且不放入redis
	 */
	public static final String IS_DELETED_FALSE_NOREDIS = "2";

	/**
	 * 永久
	 */
	public static final String SYS_REFERENCE_TIME_FOREVER = "0";

	/**
	 * 有效期
	 */
	public static final String SYS_REFERENCE_TIME_LIMIT = "1";

	/**
	 * 成功
	 */
	public static final String SUCCESS = "success";

	/**
	 * 失败
	 */
	public static final String ERROR = "error";

	/**
	 * 车辆等级_A
	 */
	public static final String CAR_LEVEL_A = "A";

	/**
	 * 车辆等级_B
	 */
	public static final String CAR_LEVEL_B = "B";

	/**
	 * 车辆附加信息（生产年份：ADD3）
	 */
	public static final String CAR_ADDINFO_PRODUCT_YEAR = "ADD3";
	
	/**
	 * 车辆附加信息（前轮规格：ADD14）
	 */
	public static final String CAR_ADDINFO_FRONT_TIRE_STANDARD = "ADD14";
	
	/**
	 * 车辆附加信息（后轮规格：ADD15）
	 */
	public static final String CAR_ADDINFO_REAR_TIRE_STANDARD = "ADD15";

	/**
	 * 默认车辆等级编码
	 */
	public static final String CARLEVEL_CODE_DEFAULT = "#";

	/**
	 * 订单显示列表-已预约
	 */
	public static final String ORDER_DISPLAY_TAB_BOOKING = "0";

	/**
	 * 订单显示列表-待评价
	 */
	public static final String ORDER_DISPLAY_TAB_UNASSESS = "1";

	/**
	 * 订单显示列表-已完成
	 */
	public static final String ORDER_DISPLAY_TAB_ASSESSED = "2";

	/**
	 * 订单显示列表-已取消
	 */
	public static final String ORDER_DISPLAY_TAB_CANCEL = "3";

	/**
	 * 淘智慧预约单显示列表-已预约
	 */
	public static final String TZH_PREORDER_DISPLAY_TAB_BOOKING = "0";

	/**
	 * 淘智慧预约单显示列表-预约完成
	 */
	public static final String TZH_PREORDER_DISPLAY_TAB_BOOKED = "1";

	/**
	 * 淘智慧预约单显示列表-已取消
	 */
	public static final String TZH_PREORDER_DISPLAY_TAB_CANCEL = "2";

	/**
	 * 预约单状态-已预约
	 */
	public static final String PREORDER_STATUS_BOOKING = "1,2";

	/**
	 * 预约单状态-已取消
	 */
	public static final String PREORDER_STATUS_CANCEL = "0,3";

	/**
	 * 预约单状态-预约中
	 */
	public static final String PREORDER_STATUS_PRE_BOOK = "1";

	/**
	 * 预约单状态-预约完成
	 */
	public static final String PREORDER_STATUS_BOOKED = "2";

	/**
	 * 订单评价状态-待评价
	 */
	public static final String ORDER_UNASSESS = "0";

	/**
	 * 订单评价状态-已评价
	 */
	public static final String ORDER_ASSESSED = "1";

	/**
	 * 美容卡状态 1：可用
	 */
	public static final String CARD_STATUS_ABLE = "1";

	/**
	 * 美容卡状态 2：不可用
	 */
	public static final String CARD_STATUS_UNABLE = "2";

	/**
	 * 预约单可见状态 1：门店可见
	 */
	public static final String PREORDER_DISPLAY_STATUS_YES = "1";

	/**
	 * 预约单可见状态 0：门店不可见
	 */
	public static final String PREORDER_DISPLAY_STATUS_NO = "0";
	
	/**
	 * 价格类型 0：固定价格
	 */
	public static final String PRICE_TYPE_FIXED = "0";
	
	/**
	 * 支付栏状态 -1：到店支付
	 */
	public static final String PAY_BOX_DISPALY_STORE = "-1";
	
	/**
	 * 支付栏状态 0：在线支付、到店支付
	 */
	public static final String PAY_BOX_DISPALY_ONLINE_STORE = "0";
	
	/**
	 * 支付栏状态 1：在线支付
	 */
	public static final String PAY_BOX_DISPALY_ONLINE = "1";
	
	/**
	 * 支付状态 0：可付可不付
	 */
	public static final String NEED_PAY_CAN = "0";
	
	/**
	 * 支付状态 1：必须付
	 */
	public static final String NEED_PAY_MUST = "1";
	
	/** 
	 * 淘智慧来源
	 */
	public static final String TZH_SOURCE = "1";
    
    /** 
     * 其他来源 
     */
	public static final String OTHER_SOURCE = "0";
	
	/**
     * 单项类型-服务
     */
    public static final String SSTYPE_SERVIE = "1";

    /**
     * 单项类型-精品
     */
    public static final String SSTYPE_GOODS = "2";
	
    /**
     * 单项类型-配件
     */
    public static final String SSTYPE_SKU = "3";
    
    /**
     * 单项类型-托外
     */
    public static final String SSTYPE_OUT_SERVIE = "4";
    
    /**
     * 轮胎服务-默认
     */
    public static final String TIRE_DEFAULT = "1";
    
    /**
     * 通用FLG-YES
     */
    public static final String FLG_YES = "1";

    /**
     * 通用FLG-NO
     */
    public static final String FLG_NO = "0";

	/**
	 * 默认规格
	 */
	public static final String SPEC_DEFAULT = "#";
	
	/**
     * 绩提种类-开单
     */
    public static final String EMP_MONEY_CREATE = "1";

    /**
     * 绩提种类-施工
     */
    public static final String EMP_MONEY_DONE = "2";
    
    /**
     * 绩提接口显示类型-绩提
     */
    public static final String MONEY_DISP_TYPE_MONEY = "0";

    /**
     * 绩提接口显示类型-评价
     */
    public static final String MONEY_DISP_TYPE_ASSES = "1";

	/**************************************************** 系统参照 ***********************************************************************/
	/**
	 * 系统参数CODE(微信)
	 */
	public static final String REFERENCE_CODE_WEIXIN = "WEIXIN";

	/**
	 * 系统明细参数CODE(微信--微信appid)
	 */
	public static final String REFERENCE_DETAIL_CODE_WEIXIN_APPID = "WEIXIN_APPID";

	/**
	 * 系统明细参数CODE(微信--微信appkey)
	 */
	public static final String REFERENCE_DETAIL_CODE_WEIXIN_APPSECRET = "WEIXIN_APPSECRET";

	/**
	 * 系统明细参数CODE(微信--微信appToken)
	 */
	public static final String REFERENCE_DETAIL_CODE_WEIXIN_TOKEN = "WEIXIN_TOKEN";

	/**
	 * 系统明细参数CODE(微信--微信用户浏览器版本)
	 */
	public static final String REFERENCE_DETAIL_CODE_WEIXIN_USER_AGENT = "WEIXIN_USER_AGENT";

	/**
	 * 系统参数CODE(域地址)
	 */
	public static final String REFERENCE_CODE_DOMAIN = "DOMAIN";

	/**
	 * 系统明细参数CODE(域地址--微信域)
	 */
	public static final String REFERENCE_DETAIL_CODE_DOMAIN_WXDOMAIN = "WXDOMAIN";

	/**
	 * 系统明细参数CODE(域地址--网站域)
	 */
	public static final String REFERENCE_DETAIL_CODE_DOMAIN_WEBDOMAIN = "WEBDOMAIN";

	/**
	 * 系统参数CODE(live800)
	 */
	public static final String REFERENCE_CODE_LIVE800 = "LIVE800";

	/**
	 * 系统明细参数CODE(live800--live800链接)
	 */
	public static final String REFERENCE_DETAIL_CODE_LIVE800_URL = "LIVE800_URL";

	/**
	 * 系统明细参数CODE(live800--live800token)
	 */
	public static final String REFERENCE_DETAIL_CODE_LIVE800_TOKEN = "LIVE800_TOKEN";

	/**
	 * 系统参数CODE(百度)
	 */
	public static final String REFERENCE_CODE_BAIDU = "BAIDU";

	/**
	 * 系统明细参数CODE(百度--百度key)
	 */
	public static final String REFERENCE_DETAIL_CODE_BAIDU_AK = "BAIDU_AK";

	/**
	 * 系统明细参数CODE(百度--百度统计)
	 */
	public static final String REFERENCE_DETAIL_CODE_BAIDU_TONGJI = "BAIDU_TONGJI";
	
	/**
	 * 系统明细参数CODE(百度--百度统计-淘智汇)
	 */
	public static final String REFERENCE_DETAIL_CODE_BAIDU_TONGJI_TZH = "BAIDU_TONGJI_TZH";

	/**
	 * 系统参数CODE(高德)
	 */
	public static final String REFERENCE_CODE_GAODE = "GAODE";

	/**
	 * 系统明细参数CODE(高德--高德key)
	 */
	public static final String REFERENCE_DETAIL_CODE_GAODE_AMAP_AK = "AMAP_AK";

	/**
	 * 系统参数CODE(默认区域)
	 */
	public static final String REFERENCE_CODE_AREA = "AREA";

	/**
	 * 系统明细参数CODE(默认区域--默认区域code)
	 */
	public static final String REFERENCE_DETAIL_CODE_AREA_CODE = "AREA_CODE_DEFAULT";

	/**
	 * 系统明细参数CODE(默认区域--默认区域名称)
	 */
	public static final String REFERENCE_DETAIL_CODE_AREA_NAME = "AREA_NAME_DEFAULT";

	/**
	 * 系统参数CODE(模板消息)
	 */
	public static final String REFERENCE_CODE_TEMPLATE = "TEMPLATE";

	/**
	 * 系统明细参数CODE(模板消息--模板消息ID)
	 */
	public static final String REFERENCE_DETAIL_CODE_TEMPLATE_ID = "TEMPLATE_ORDER_ID";

	/**
	 * 系统明细参数CODE(模板消息--模板消息订单推送1)
	 */
	public static final String REFERENCE_DETAIL_CODE_TEMPLATE_FIRST = "TEMPLATE_ORDER_FIRST";

	/**
	 * 系统明细参数CODE(模板消息--模板消息订单推送2)
	 */
	public static final String REFERENCE_DETAIL_CODE_TEMPLATE_REMARK = "TEMPLATE_ORDER_REMARK";

	/**
	 * 系统明细参数CODE(模板消息--模板消息订单推送3)
	 */
	public static final String REFERENCE_DETAIL_CODE_TEMPLATE_ADVISER = "TEMPLATE_ORDER_ADVISER";

	/**
	 * 系统参数CODE(订单来源)
	 */
	public static final String REFERENCE_CODE_OPENTYPE = "OPENTYPE";

	/**
	 * 系统明细参数CODE(订单来源--微信)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYPE_CXJ = "CXJ";

	/**
	 * 系统明细参数CODE(订单来源--车享宝)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYPE_CXB = "CXB";

	/**
	 * 系统明细参数CODE(订单来源--车享汇)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYPE_CXH = "CXH";

	/**
	 * 系统明细参数CODE(订单来源--车享汇)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYPE_MZ = "MZ";

	/**
	 * 系统明细参数CODE(订单来源--其他)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYPE_OTHER = "OTHER";
	
	/**
	 * 系统明细参数CODE(订单来源--百度)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYPE_BAIDU = "BAIDU";

	/**
	 * 系统参数CODE(保养里程)
	 */
	public static final String REFERENCE_CODE_MAINTENANCE = "MAINTENANCE";

	/**
	 * 系统明细参数CODE(保养里程--保养里程间隔)
	 */
	public static final String REFERENCE_DETAIL_CODE_MILEAGEUNIT = "MAINTENANCE_MILEAGEUNIT";
	/**
	 * 系统明细参数CODE(保养里程--保养里程最大值)
	 */
	public static final String REFERENCE_DETAIL_CODE_MILEAGEMAX = "MAINTENANCE_MILEAGEMAX";

	/**
	 * 系统参数CODE(分页数)
	 */
	public static final String REFERENCE_CODE_PAGECOUNT = "PAGECOUNT";

	/**
	 * 系统明细参数CODE(分页数--车型查询记录起始)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_CAR_START = "PAGECOUNT_CAR_ROW_START";
	/**
	 * 系统明细参数CODE(分页数--车型查询每页记录数)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_CAR_COUNT = "PAGECOUNT_CAR_ROW_COUNT";
	/**
	 * 系统明细参数CODE(分页数--早期历史订单每页记录数)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_BMSORDER_COUNT = "PAGECOUNT_BMSORDER_ROW_COUNT";
	/**
	 * 系统明细参数CODE(分页数--历史订单每页记录数)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_ORDER_COUNT = "PAGECOUNT_ORDER_ROW_COUNT";
	/**
	 * 系统明细参数CODE(分页数--预约单每页记录数)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_PREORDER_COUNT = "PAGECOUNT_PREORDER_ROW_COUNT";
	/**
	 * 系统参数CODE(分享)
	 */
	public static final String REFERENCE_CODE_SHARE = "SHARE";

	/**
	 * 系统明细参数CODE(分享--分享标题)
	 */
	public static final String REFERENCE_DETAIL_CODE_SHARE_TITLE = "SHARE_TITLE";
	/**
	 * 系统明细参数CODE(分享--分享内容)
	 */
	public static final String REFERENCE_DETAIL_CODE_SHARE_DESC = "SHARE_DESC";
	/**
	 * 系统明细参数CODE(分享--分享链接)
	 */
	public static final String REFERENCE_DETAIL_CODE_SHARE_LINK = "SHARE_LINK";
	/**
	 * 系统明细参数CODE(分享--分享图片地址)
	 */
	public static final String REFERENCE_DETAIL_CODE_SHARE_IMGURL = "SHARE_IMGURL";

	/**
	 * 系统参数CODE(服务推荐)
	 */
	public static final String REFERENCE_CODE_FWTJ = "FWTJ";

	/**
	 * 系统参数CODE(等级推荐)
	 */
	public static final String REFERENCE_CODE_DJTJ = "DJTJ";

	/**
	 * 系统参数CODE(广告)
	 */
	public static final String REFERENCE_CODE_GG = "GG";

	/**
	 * 系统参数CODE(促销)
	 */
	public static final String REFERENCE_CODE_CX = "CX";

	/**
	 * 系统参数CODE(线上服务/保养手册)
	 */
	public static final String REFERENCE_CODE_XSFW = "XSFW";
	/**
	 * 系统参数CODE(客服热线)
	 */
	public static final String REFERENCE_CODE_CRMTEL = "CRMTEL";

	/**
	 * 系统明细参数CODE(客服热线--400电话)
	 */
	public static final String REFERENCE_DETAIL_CODE_CRMTEL_400HOTLINE = "CRMTEL_400HOTLINE";

	/**
	 * 系统参数CODE(横幅配置)
	 */
	public static final String REFERENCE_CODE_BANNER = "BANNER";

	/**
	 * 系统参数CODE(升级推荐)
	 */
	public static final String REFERENCE_CODE_SJTJ = "SJTJ";

	/**
	 * 系统参数CODE(来源渠道)
	 */
	public static final String REFERENCE_CODE_LYQD = "LYQD";

	/**
	 * 系统参数CODE(评价)
	 */
	public static final String REFERENCE_CODE_PJ = "PJ";

	/**
	 * 系统参数CODE(活动)
	 */
	public static final String REFERENCE_CODE_ACTIVITY = "ACTIVITY";

	/**
	 * 活动后缀-查询相关链接项目
	 */
	public static final String ACTIVITY_SUFFIX_VIEW = "_V";

	/**
	 * 活动后缀-更新相关链接项目
	 */
	public static final String ACTIVITY_SUFFIX_UPD = "_U";

	/**
	 * 活动后缀-变量项目
	 */
	public static final String ACTIVITY_SUFFIX_PARAM = "_P";
	/**
	 * 活动后缀-报名开始时间
	 */
	public static final String ACTIVITY_SUFFIX_STARTTIME = "_STARTTIME";
	/**
	 * 活动后缀-报名结束时间
	 */
	public static final String ACTIVITY_SUFFIX_ENDTIME = "_ENDTIME";

	/**
	 * 系统参数CODE(车型相关)
	 */
	public static final String REFERENCE_CODE_CARRELATION = "CARRELATION";

	/**
	 * 系统明细参数CODE(车型相关-车型等级)
	 */
	public static final String REFERENCE_DETAIL_CODE_CARRELATION_GUIDEPRICE_LEVEL_1 = "CARRELATION_GUIDEPRICE_LEVEL_1";

	/**
	 * 系统明细参数CODE(车型相关-未知车型显示名称)
	 */
	public static final String REFERENCE_DETAIL_CODE_CARRELATION_UNKNOW_CAR_NAME = "UNKNOW_CAR_NAME";

	/**
	 * 系统参数CODE(订单相关)
	 */
	public static final String REFERENCE_CODE_ORDERRELATION = "ORDERRELATION";

	/**
	 * 系统明细参数CODE(订单相关-订单车型显示时间线)
	 */
	public static final String REFERENCE_DETAIL_CODE_ORDERRELATION_CAR_DISPLAY_DATELINE = "ORDER_CAR_DISPLAY_DATELINE";

	/**
	 * 系统参数CODE(短信相关)
	 */
	public static final String REFERENCE_CODE_MSG = "MSG";

	/**
	 * 系统明细参数CODE(短信相关-短信发送手机号码)
	 */
	public static final String REFERENCE_DETAIL_CODE_MSG_MOBILE_NUMBER = "MOBILE_NUMBER";

	/**
	 * 系统明细参数CODE(短信相关-车型同步失败信息短信通知)
	 */
	public static final String REFERENCE_DETAIL_CODE_MSG_CAR_SYC_ERROR = "CAR_SYC_ERROR";

	/**
	 * 系统明细参数CODE(短信相关-门店同步失败信息短信通知)
	 */
	public static final String REFERENCE_DETAIL_CODE_MSG_STORE_SYC_ERROR = "STORE_SYC_ERROR";

	/**
	 * 系统明细参数CODE(车型相关-车型图片路径)
	 */
	public static final String REFERENCE_DETAIL_CODE_CARRELATION_PIC_PATH_URL = "CAR_PIC_URL_PATH";

	/**
	 * 系统明细参数CODE(评价-技师默认评分)
	 */
	public static final String REFERENCE_DETAIL_CODE_PJ_ARTIFICER_DEFAULT_POINT = "ARTIFICER_DEFAULT_POINT";

	/**
	 * 系统明细参数CODE(分页数-技师分页抽取门店数)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_ARTIFICER_ROW_COUNT = "PAGECOUNT_ARTIFICER_ROW_COUNT";

	/**
	 * 系统参数CODE(美容卡相关)
	 */
	public static final String REFERENCE_CODE_CARD = "CARD";

	/**
	 * 系统明细参数CODE(美容卡相关-卡模板编号)
	 */
	public static final String REFERENCE_DETAIL_CODE_CARD_TEMPLATE_NO = "CARD_TEMPLATE_NO";

	/**
	 * 系统明细参数CODE(美容卡相关-洗车卡页面跳转)
	 */
	public static final String REFERENCE_DETAIL_CODE_CARD_PAGE_JUMP_PATH = "CARD_PAGE_JUMP_PATH";

	/**
	 * 系统明细参数CODE(车型相关-生产年份起始截止时间)
	 */
	public static final String REFERENCE_DETAIL_CODE_CARRELATION_MIN_PRODUCT_YEAR = "MIN_PRODUCT_YEAR";

	/**
	 * 系统参数CODE(车型过滤)
	 */
	public static final String REFERENCE_CODE_CAR_FILTER = "CAR_FILTER";

	/**
	 * 系统参数CODE(H5菜单项配置)
	 */
	public static final String REFERENCE_CODE_H5_MENU_CONFIG = "H5_MENU_CONFIG";

	/**
	 * 系统明细参数CODE(美容卡相关-洗车服务项目)
	 */
	public static final String REFERENCE_DETAIL_CODE_XC_SERVICE = "XC_SERVICE";

	/**
	 * 系统明细参数CODE(短信相关-短信发送时间)
	 */
	public static final String REFERENCE_DETAIL_CODE_MSG_SEND_TIME = "MSG_SEND_TIME";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更多)
	 */
	public static final String REFERENCE_DETAIL_CODE_MORE = "*MORE*";

	/**
	 * 系统明细参数CODE(H5菜单项配置-预约小保养)
	 */
	public static final String REFERENCE_DETAIL_CODE_YYXBY = "YYXBY";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换前刹车片)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHQS = "GHQS";

	/**
	 * 系统明细参数CODE(H5菜单项配置-燃油系统养护)
	 */
	public static final String REFERENCE_DETAIL_CODE_RYXT = "RYXT";

	/**
	 * 系统明细参数CODE(H5菜单项配置-发动机清洗与养护)
	 */
	public static final String REFERENCE_DETAIL_CODE_FDJQX = "FDJQX";

	/**
	 * 系统明细参数CODE(H5菜单项配置-空调系统养护)
	 */
	public static final String REFERENCE_DETAIL_CODE_KTYH = "KTYH";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换刹车油)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHSCY = "GHSCY";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换防冻液)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHFDY = "GHFDY";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换齿轮油)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHCLY = "GHCLY";

	/**
	 * 系统明细参数CODE(H5菜单项配置-通用无骨雨刷更换)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHYS = "GHYS";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换后刹车片)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHHS = "GHHS";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换空调滤)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHKTL = "GHKTL";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换空滤)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHKL = "GHKL";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换汽油滤)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHQYL = "GHQYL";

	/**
	 * 系统明细参数CODE(H5菜单项配置-更换4个火花塞)
	 */
	public static final String REFERENCE_DETAIL_CODE_GHHHS = "GHHHS";

	/**
	 * 系统明细参数CODE(H5菜单项配置-洗车)
	 */
	public static final String REFERENCE_DETAIL_CODE_XC = "XC";

	/**
	 * 系统明细参数CODE(H5菜单项配置-保养手册)
	 */
	public static final String REFERENCE_DETAIL_CODE_BYSC = "BYSC";

	/**
	 * 系统明细参数CODE(H5菜单项配置-我的订单)
	 */
	public static final String REFERENCE_DETAIL_CODE_WDDD = "WDDD";

	/**
	 * 系统明细参数CODE(H5菜单项配置-我的卡券)
	 */
	public static final String REFERENCE_DETAIL_CODE_WDKQ = "WDKQ";

	/**
	 * 系统明细参数CODE(H5菜单项配置-服务网点)
	 */
	public static final String REFERENCE_DETAIL_CODE_FWWD = "FWWD";

	/**
	 * 系统明细参数CODE(短信相关-门店技师同步失败信息短信通知)
	 */
	public static final String REFERENCE_DETAIL_CODE_MSG_ARTIFICER_SYC_ERROR = "ARTIFICER_SYC_ERROR";

	/**
	 * 系统明细参数CODE(短信相关-服务及价格同步失败信息短信通知)
	 */
	public static final String REFERENCE_DETAIL_CODE_MSG_SERVICE_SYC_ERROR = "SERVICE_SYC_ERROR";

	/**
	 * 系统明细参数CODE(短信相关-商品价格同步失败信息短信通知)
	 */
	public static final String REFERENCE_DETAIL_CODE_MSG_SKU_SYC_ERROR = "SKU_SYC_ERROR";

	/**
	 * 系统明细参数CODE(分页数-员工绩提每页记录数)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_EMP_MONEY_ROW_COUNT = "PAGECOUNT_EMP_MONEY_ROW_COUNT";

	/**
	 * 系统明细参数CODE(分页数-员工评分每页记录数)
	 */
	public static final String REFERENCE_DETAIL_CODE_PAGECOUNT_EMP_SCORE_ROW_COUNT = "PAGECOUNT_EMP_SCORE_ROW_COUNT";

	/**
	 * 系统参数CODE(服务支付相关)
	 */
	public static final String REFERENCE_CODE_SERVICE_PAY_INFO = "SERVICE_PAY_INFO";

	/**
	 * 系统参数CODE(线上商品)
	 */
	public static final String REFERENCE_CODE_CAR_XSSP = "XSSP";
	
	/**
	 * 系统参数CODE(收银台相关)
	 */
	public static final String REFERENCE_CODE_MONEYTYPE = "MONEYTYPE";

	/**
     * 系统参数CODE(显示配件服务)
     */
    public static final String REFERENCE_CODE_SKU_DISPLAY_SERVICE = "SKU_DISPLAY_SERVICE";
    
    /**
	 * 系统参数CODE(轮胎相关)
	 */
	public static final String REFERENCE_CODE_TYRE_RELATION = "TYRE_RELATION";
	
    /**
	 * 系统参数CODE(轮胎相关-轮胎服务)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYRE_SERVICE = "TYRE_SERVICE";
	
    /**
	 * 系统参数CODE(轮胎相关-售卖区域ID)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYRE_SALES_AREA = "SALES_AREA";
	
    /**
	 * 系统参数CODE(轮胎相关-轮胎查询每页记录数)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYRE_SKU_ROW_COUNT = "PAGECOUNT_TYRE_SKU_ROW_COUNT";
	
    /**
	 * 系统参数CODE(轮胎相关-轮胎图片Host)
	 */
	public static final String REFERENCE_DETAIL_CODE_TYRE_PIC_HOST = "PIC_HOST";
	
	/**
     * 系统参数CODE(显示区域相关)
     */
    public static final String REFERENCE_CODE_DISPLAY_AREA_RELATION = "DISPLAY_AREA_RELATION";
    
    /**
     * 系统参数CODE(显示区域相关-组合显示开关)
     */
    public static final String REFERENCE_DETAIL_CODE_CBN_DISPLAY_FLG = "CBN_DISPLAY_FLG";
	/**************************************************** 支付 ***********************************************************************/
	/**
	 * 交易状态：1：已支付
	 */
	public static final String PAY_PAID = "1";

	/**
	 * 交易状态：0：未支付
	 */
	public static final String PAY_UNPAID = "0";
	
	/**
	 * 交易状态：-1：不需要支付
	 */
	public static final String PAY_NONEED = "-1";

	/**
	 * 推送业务系统状态：-1：暂时不推送
	 */
	public static final String PUSH_NO = "-1";

	/**
	 * 推送业务系统状态：0：未推送
	 */
	public static final String PUSH_UN = "0";

	/**
	 * 推送业务系统状态：1：已推送
	 */
	public static final String PUSH_PUSHED = "0";
	
	/**
	 * 可见状态：0：门店不可见
	 */
	public static final String DISPLAY_DISABLED = "0";
	
	/**
	 * 可见状态：1：门店可见
	 */
	public static final String DISPLAY_ENABLED = "1";
	
	
}
