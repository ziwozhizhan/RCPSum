package com.wsz.rcpsum.util.commons.crypto;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密工具。目前包含类型：md5
 * <pre>
 * 说明：
 *     依赖于  commons-codec-1.10.jar，在其基础上进行的封装。
 * </pre>
 * @author wsz 2017-11-14
 *
 */
public class CryptoDigest implements ICrypto{
	
	/** 当前加密算法类型 */
	private String currentType = "";
	
	public CryptoDigest(String type){
		currentType = type;
	}

	//目前只参考md5加密方式，随着加密算法的扩展可改动此方法
	@Override
	public Object encrypt(Object obj) {
		if (!(obj instanceof String)) { 
			throw new RuntimeException("不能执行加密操作，算法类型为：" + currentType);
		}
		
		String str = String.valueOf(obj);
		if (obj == null || str.length() < 1) {
			throw new RuntimeException("待加密字符串不能为空");
		}

		if(CryptoConsts.DIGEST_TYPE_MD5.equals(currentType)){
			return encryMD5(str);
		}
		
		return encryMD5(str);
	}

	//目前只参考md5加密方式，随着加密算法的扩展可改动此方法
	@Override
	public Object decrypt(Object obj) {
		if (!(obj instanceof String)) { 
			throw new RuntimeException("不能执行解密密操作，算法类型为：" + currentType);
		}
		
		String str = String.valueOf(obj);
		if (obj == null || str.length() < 1) {
			throw new RuntimeException("待解密字符串不能为空");
		}
		
		//md5加密是不可逆，只能通过比较两个字符串加密后的数据是否相等来判断原数据是否一致
		if (CryptoConsts.DIGEST_TYPE_MD5.equals(currentType)) {
			return encryMD5(String.valueOf(obj));
		}
		
		return encryMD5(str);
	}

	/**
	 * md5字符串加密
	 * @param str
	 * @return
	 */
	private static String encryMD5(String str){
		return DigestUtils.md5Hex(str);
	}
}
