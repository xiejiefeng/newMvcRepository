package com.xjf.wemall.api.util.pay.cxpay;

public class CxPayUtil {
	/*********************** 缓存 ******************************************/
	// 车享支付(大类)
	public static final String CXPAY = "CXPAY";

	// 车享支付私钥
	public static final String PRIVATEKEY = "PRIVATEKEY";

	// 车享支付公钥
	public static final String PUBLICKEY = "PUBLICKEY";

	// 车享支付-微信收银台URL
	public static final String WXPAYURL = "WXPAYURL";

	// 车享支付-支付宝+银联收银台URL
	public static final String ALLPAYURL = "ALLPAYURL";

	// 商户号
	public static final String PARTNER = "PARTNER";

	// 支付超时
	public static final String PAYTIMEOUT = "TIMEOUT";

	// 车享支付-回调BaseUrl
	public static final String RETURNBASEURL = "RETURNBASEURL";

	/*************************** 常量 *****************************************/

	// 支付超时
	public static final String PAYTIMEOUTCODE = "timeout";

	// 商户号
	public static final String PARTNERCODE = "partner";

	// 微信openId
	public static final String OPENID = "openId";

	// 商品名称
	public static final String MDSENAME = "mdseName";

	// 商品名称
	public static final String BODY = "body";

	// 异步回调地址
	public static final String NOTIFYURLCODE = "notifyUrl";

	// 同步回调地址
	public static final String RETURNURLCODE = "returnUrl";

	// 异步回调地址
	public static final String NOTIFYURL = "/cxpay/unSynReturnCxPay.htm";

	// 同步回调地址
	public static final String RETURNURL = "/cxpay/synReturnCxPay.htm";

	// 车享支付编码字符集
	public static final String CHARSET = "utf-8";

	// 车享支付-返回信息-支付渠道-上汽财务银联
	public static final String SAICPAY = "saic";

	// 车享支付-返回信息-支付渠道-支付宝
	public static final String ALIPAY = "alipay";

	// 车享支付-返回信息-支付渠道-腾讯微信
	public static final String TENPAY = "tenpay";

	// 车享支付-返回信息-成功
	public static final String SIGN = "sign";

	// 车享支付-返回信息-成功
	public static final String SUCCESS = "success";

	// 车享支付-返回信息-失败
	public static final String FAIL = "fail";

	// 车享支付-返回信息-状态
	public static final String STATUS = "status";

	// 车享支付-返回信息-交易时间
	public static final String TXNDATE = "txnDate";

	// 车享支付-返回信息-通知类型
	public static final String NOTIFYTYPE = "notifyType";

	// 车享支付-返回信息-支付类型-支付
	public static final String PAYMENT = "payment";

	// 车享支付-返回信息-支付编号
	public static final String PAYMENTID = "paymentId";

	// 车享支付-返回信息-订单编号
	public static final String ORDERID = "orderId";

	// 车享支付-返回信息-实付金额
	public static final String TXNAMOUNT = "txnAmount";

	// 车享支付-返回信息-支付渠道
	public static final String CHANNEL = "channel";

	// 车享支付-返回信息-第三方支付流水号
	public static final String TXNNO = "txnNo";
}
