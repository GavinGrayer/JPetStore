package com.daoIface;

import com.domain.Account;
import com.domain.Profile;
import com.domain.Signon;

public interface RegisterDaoIface {
	
	/**
	 * �����˻������� -->> Sigon��
	 */
	public void saveSigon(Signon signon1);
	
	
	/**
	 * ������Ϣ-->> account��
	 * @param account1
	 */
	public void saveAccount(Account account1);
	
	
	/**
	 * ����ϲ�� -->> profile��
	 * @param profile1
	 */
	public void saveProfile(Profile profile1);
	
}
