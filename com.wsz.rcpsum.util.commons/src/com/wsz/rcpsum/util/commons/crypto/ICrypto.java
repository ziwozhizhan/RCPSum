package com.wsz.rcpsum.util.commons.crypto;

/**
 * 加解密接口规范。所有加密方式的扩展都要实现此类，统一规范。
 * @author wsz 2017-11-13
 *
 */
public interface ICrypto {

	/**
	 * 加密方法
	 * @param obj 要加密的数据
	 */
	Object encrypt(Object obj);
	
	/**
	 * 解密方法
	 * @param obj 要解密的数据
	 */
	Object decrypt(Object obj);
}
