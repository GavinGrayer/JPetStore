package com.action;

import com.dao.EditAccountDao;
import com.dao.MyProfileDao;
import com.domain.Account;
import com.domain.Profile;
import com.domain.Signon;

public class EditAccountAction {

	private Account account;//�ͻ�������Ϣ	
	private Profile profile;//���˰���	
	private Signon signon;//�˻���Ϣ
	
	private EditAccountDao editAccountDao=new EditAccountDao();
	
	public String update(){
		
		System.out.println(account.getAddr1());
		
		account.setUserid(signon.getUserid());
		
		editAccountDao.updateAccount(account);
		
		editAccountDao.updateSignon(signon);
		
		profile.setUserid(signon.getUserid());
		
		editAccountDao.updateProfile(profile);
		
		//����MyprofileDao
		MyProfileDao myProfileDao=new MyProfileDao();
		myProfileDao.profile();
		
		
		return "success";
		
	}
	
	


	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public Profile getProfile() {
		return profile;
	}



	public void setProfile(Profile profile) {
		this.profile = profile;
	}



	public Signon getSignon() {
		return signon;
	}



	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	
	
}	
