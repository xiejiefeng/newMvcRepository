package com.xjf.wemall.api.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * RSA非对称加密算法
 * 
 * @author chongwenjun
 *
 */
public class RSAUtil {
	/**
	 * 公钥常量
	 */
	public static final String RSA_PUBLIC_KEY = "RSA_PUBLIC_KEY";

	/**
	 * 私钥钥常量
	 */
	public static final String RSA_PRIVATE_KEY = "RSA_PRIVATE_KEY";

	/**
	 * RSA签名加密结果常量
	 */
	public static final String RSA_WEB_SIGN_RESULT = "RSA_WEB_SIGN_RESULT";

	/**
	 * 签名算法
	 */
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	/**
	 * 默认字符集编码UTF-8
	 */
	public static final String DEFAULT_CHAR_UTF_8 = "utf-8";

	/**
	 * 内部keyInfo对象
	 * 
	 * @author chongwenjun
	 *
	 */
	public class KeyInfo {
		// 公钥
		private String publicKey;
		// 私钥
		private String privateKey;

		public KeyInfo() {
			this.publicKey = "";
			this.privateKey = "";
		}

		public String getPublicKey() {
			return publicKey;
		}

		public void setPublicKey(String publicKey) {
			this.publicKey = publicKey;
		}

		public String getPrivateKey() {
			return privateKey;
		}

		public void setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
		}

	}

	/**
	 * 创建RSA密钥配对
	 * 
	 * @return KeyInfo
	 */
	public static KeyInfo createKeyPairs() {
		RSAUtil.KeyInfo keyInfo = new RSAUtil().new KeyInfo();
		try {
			// create the keys
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			// 初始化密钥对生成器，密钥大小为96-1024位
			keyPairGen.initialize(1024, new SecureRandom());
			// 生成一个密钥对，保存在keyPair中
			KeyPair keyPair = keyPairGen.generateKeyPair();
			// 得到私钥
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
			// 得到公钥
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

			keyInfo.setPrivateKey(new String(Base64.encodeBase64(privateKey.getEncoded())));
			keyInfo.setPublicKey(new String(Base64.encodeBase64(publicKey.getEncoded())));
			return keyInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return keyInfo;
		}
	}

	/**
	 * 从字符串中加载公钥
	 * 
	 * @param publicKeyStr
	 *            公钥数据字符串
	 * @retrun RSAPublicKey
	 */
	public static RSAPublicKey loadPublicKeyByStr(String publicKeyStr) {
		try {
			byte[] buffer = Base64.decodeBase64(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 从字符串中加载私钥
	 * 
	 * @param privateKeyStr
	 *            私钥数据字符串
	 * @retrun RSAPrivateKey
	 */
	public static RSAPrivateKey loadPrivateKeyByStr(String privateKeyStr) {
		try {
			byte[] buffer = Base64.decodeBase64(privateKeyStr);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 公钥加密过程
	 * 
	 * publicKeyEncode方法对应privateKeyDecode方法
	 * 
	 * @param publicKey
	 *            公钥
	 * @param plainTextData
	 *            明文数据
	 * @return
	 * @throws Exception
	 *             加密过程中的异常信息
	 */
	// public static byte[] encrypt(RSAPublicKey publicKey, byte[]
	// plainTextData) {
	public static byte[] publicKeyEncode(RSAPublicKey publicKey, byte[] plainTextData) {
		if (publicKey == null) {
			return null;
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] output = cipher.doFinal(plainTextData);
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 公钥解密过程
	 * 
	 * privateKeyEncode方法对应publicKeyDecode方法
	 * 
	 * @param publicKey
	 *            公钥
	 * @param cipherData
	 *            密文数据
	 * @return 明文
	 * @throws Exception
	 *             解密过程中的异常信息
	 */
	// public static byte[] decrypt(RSAPublicKey publicKey, byte[] cipherData) {
	public static byte[] publicKeyDecode(RSAPublicKey publicKey, byte[] cipherData) {
		if (publicKey == null) {
			return null;
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			// cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			byte[] output = cipher.doFinal(cipherData);
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 私钥加密过程
	 * 
	 * privateKeyEncode方法对应publicKeyDecode方法
	 * 
	 * @param privateKey
	 *            私钥
	 * @param plainTextData
	 *            明文数据
	 * @return
	 * @throws Exception
	 *             加密过程中的异常信息
	 */
	// public static byte[] encrypt(RSAPrivateKey privateKey, byte[]
	// plainTextData) {
	public static byte[] privateKeyEncode(RSAPrivateKey privateKey, byte[] plainTextData) {
		if (privateKey == null) {
			return null;
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] output = cipher.doFinal(plainTextData);
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 私钥解密过程
	 * 
	 * publicKeyEncode方法对应privateKeyDecode方法
	 * 
	 * @param privateKey
	 *            私钥
	 * @param cipherData
	 *            密文数据
	 * @return 明文
	 * @throws Exception
	 *             解密过程中的异常信息
	 */
	// public static byte[] decrypt(RSAPrivateKey privateKey, byte[] cipherData)
	// {
	public static byte[] privateKeyDecode(RSAPrivateKey privateKey, byte[] cipherData) {
		if (privateKey == null) {
			return null;
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			// cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] output = cipher.doFinal(cipherData);
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * RSA签名(私钥签名)
	 * 
	 * signByPrivateKey方法对应doCheckByPublicKey方法
	 * 
	 * @param content
	 *            待签名数据
	 * @param privateKey
	 *            私钥
	 * @param encode
	 *            字符集编码
	 * @return 签名值
	 */
	public static String signByPrivateKey(String content, String privateKey, String encode) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));

			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);

			if (StringUtils.isEmpty(encode) || StringUtils.isEmpty(encode.trim())) {
				encode = DEFAULT_CHAR_UTF_8;
			}
			signature.update(content.getBytes(encode));

			byte[] signed = signature.sign();

			return Base64.encodeBase64String(signed);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * RSA验签名检查(公钥签名检查)
	 * 
	 * signByPrivateKey方法对应doCheckByPublicKey方法
	 * 
	 * @param content
	 *            待签名数据
	 * @param sign
	 *            签名数据
	 * @param publicKey
	 *            公钥
	 * @param encode
	 *            字符集编码
	 * @return 布尔值
	 */
	public static boolean doCheckByPublicKey(String content, String sign, String publicKey,
			String encode) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			byte[] encodedKey = Base64.decodeBase64(publicKey);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);

			if (StringUtils.isEmpty(encode) || StringUtils.isEmpty(encode.trim())) {
				encode = DEFAULT_CHAR_UTF_8;
			}
			signature.update(content.getBytes(encode));

			boolean bverify = signature.verify(Base64.decodeBase64(sign));
			return bverify;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据用户id及webUserKey，渠道生成私钥、公钥对及加密信息
	 * 
	 * 
	 * @param Sring
	 *            cxId 用户ID
	 * @param String
	 *            webUserKey
	 * @param String
	 *            sourceType 渠道
	 * @return Map<String, String>
	 */
	public Map<String, String> setUserRSAKey(String cxId, String webUserKey, String sourceType) {
		// 以下空CHECK
		if (StringUtils.isEmpty(cxId) || StringUtils.isEmpty(cxId.trim())) {
			return new HashMap<String, String>();
		}
		if (StringUtils.isEmpty(webUserKey) || StringUtils.isEmpty(webUserKey.trim())) {
			return new HashMap<String, String>();
		}
		if (StringUtils.isEmpty(sourceType) || StringUtils.isEmpty(sourceType.trim())) {
			return new HashMap<String, String>();
		}
		
		// 创建RSA密钥配对
		RSAUtil.KeyInfo keyInfo = RSAUtil.createKeyPairs();

		if (StringUtils.isEmpty(keyInfo.getPrivateKey())
				|| StringUtils.isEmpty(keyInfo.getPrivateKey().trim())) {
			return new HashMap<String, String>();
		}
		if (StringUtils.isEmpty(keyInfo.getPublicKey())
				|| StringUtils.isEmpty(keyInfo.getPublicKey().trim())) {
			return new HashMap<String, String>();
		}
		Map<String, String> rsaKeyInfo = new HashMap<String, String>();
		// 私钥
		rsaKeyInfo.put(RSAUtil.RSA_PRIVATE_KEY, keyInfo.getPrivateKey());
		// 公钥
		rsaKeyInfo.put(RSAUtil.RSA_PUBLIC_KEY, keyInfo.getPublicKey());
		// 利用私钥加密webUserKey生成签名串
		String userSignKey = Base64.encodeBase64String(RSAUtil.privateKeyEncode(
				RSAUtil.loadPrivateKeyByStr(keyInfo.getPrivateKey()), webUserKey.getBytes()));
		if (StringUtils.isEmpty(userSignKey) || StringUtils.isEmpty(userSignKey.trim())) {
			return new HashMap<String, String>();
		}
		rsaKeyInfo.put(RSAUtil.RSA_WEB_SIGN_RESULT, userSignKey);
//		if (Boolean.parseBoolean(sysReferenceService.querySysReferenceValue(
//				WemallConstants.RSAKEYFILTER, WemallConstants.RSAKEYFILTER_IGSOURCETYPE))) {
//			// 忽略渠道：一个用户ID所有渠道及所有情况下只能在一个地方使用一次
//			// 设置redis
//			redisClientService.set(USER_RSA_KEY + ":" + cxId, rsaKeyInfo, TimeToLive.HALFHOUR);
//		} else {
//			// 不忽略渠道：一个用户ID每个渠道及所有情况下只能在一个地方使用一次
//			// 设置redis
//			redisClientService.set(USER_RSA_KEY + ":" + cxId + ":" + sourceType, rsaKeyInfo,
//					TimeToLive.HALFHOUR);
//		}

		return rsaKeyInfo;
	}
	
	/************************************************************/

	public static void main(String[] args) throws Exception {

		RSAUtil.KeyInfo keyInfo = createKeyPairs();
		System.out.println("公钥Base64编码:" + keyInfo.getPublicKey());
		System.out.println("私钥Base64编码:" + keyInfo.getPrivateKey());
		System.out.println("");
		/************************************************************/
		byte[] b = null;
		String sign = "";
		String msg = "-=+~O(∩_∩)O哈哈~Hello+=-?><,./;':\"\\_)(0987654321`~!@#$%^&*()_+	|";
		System.out.println("");
		/************************************************************/
		// 私钥加密公钥解密
		System.out.println("原文: " + msg);
		System.out.println("");
		sign = signByPrivateKey(msg, keyInfo.getPrivateKey(), "");
		System.out.println("加密: " + sign);
		System.out.println(
				"验证sign数据结果: " + doCheckByPublicKey(msg, sign, keyInfo.getPublicKey(), ""));
		System.out.println("");
		/************************************************************/
		// 私钥加密&公钥解密
		b = privateKeyEncode(loadPrivateKeyByStr(keyInfo.getPrivateKey()), msg.getBytes());
		System.out.println("私钥加密：" + Base64.encodeBase64String(b));
		System.out.println("公钥解密："
				+ new String(publicKeyDecode(loadPublicKeyByStr(keyInfo.getPublicKey()), b)));
		System.out.println("");
		/************************************************************/
		// 公钥加密&私钥解密
		b = publicKeyEncode(loadPublicKeyByStr(keyInfo.getPublicKey()), msg.getBytes());
		System.out.println("公钥加密：" + Base64.encodeBase64String(b));
		System.out.println("私钥解密："
				+ new String(privateKeyDecode(loadPrivateKeyByStr(keyInfo.getPrivateKey()), b)));
	}
}