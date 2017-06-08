package com.daoIface;

import com.domain.Account;
import com.domain.Profile;
import com.domain.Signon;

public interface RegisterDaoIface {
	
	/**
	 * 保存账户和密码 -->> Sigon表
	 */
	public void saveSigon(Signon signon1);
	
	
	/**
	 * 保存信息-->> account表
	 * @param account1
	 */
	public void saveAccount(Account account1);
	
	
	/**
	 * 保存喜好 -->> profile表
	 * @param profile1
	 */
	public void saveProfile(Profile profile1);
	
}
