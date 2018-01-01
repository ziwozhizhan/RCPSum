package com.wsz.rcpsum.core.factory;

import com.wsz.rcpsum.util.commons.crypto.CryptoConsts;
import com.wsz.rcpsum.util.commons.crypto.CryptoDigest;
import com.wsz.rcpsum.util.commons.crypto.ICrypto;

/**
 * 加密管理工厂。
 * @author wsz 2017-11-14
 *
 */
public class CryptoFactory {
	
	private CryptoFactory instance;
	private ICrypto loginManager; // 登录加密管理策略
	
	public CryptoFactory getInstance(){
		if (instance == null) {
			instance = new CryptoFactory();
		}
		
		return instance;
	}

	/**
	 * 用户登录密码加密
	 */
	public ICrypto getLoginManager() {
		if (loginManager == null) {
			loginManager = new CryptoDigest(CryptoConsts.DIGEST_TYPE_MD5);
		}
		return loginManager;
	}
	
	/**
	 * 数据通信加密
	 */
}
