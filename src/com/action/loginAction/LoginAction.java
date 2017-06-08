package com.action.loginAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.LoginDao;
import com.dao.MyProfileDao;
import com.domain.Signon;

public class LoginAction {
	
	private Signon signon;

	private String errMsg;
	
	
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	
	public String judge(){
		
		
		
		
		
		
		System.out.println("µ«¬º»°÷µ---’ ∫≈£∫"+signon.getUserid()+"::"+signon.getPassword());
		
		
		
		LoginDao loginDao=new LoginDao();
		//Õ®π˝’ ∫≈≤È—Ø√‹¬Î   dao
		String password=loginDao.judge(signon);
		
		
		//≈–∂œ√‹¬Î «∑Ò’˝»∑ 
		if(password.equals(signon.getPassword())){
			
			
			HttpServletRequest request=ServletActionContext.getRequest();
			
			HttpSession session=request.getSession();
			
			session.setAttribute("username", signon.getUserid());
			
			
			//∆Ù∂ØMyprofileDao
			MyProfileDao myProfileDao=new MyProfileDao();
			myProfileDao.profile();
			
			
			return "success";
			
		}else{
			
			errMsg="’ ∫≈ªÚ√‹¬Î¥ÌŒÛ";
			return "error";
		}
		
		
	}
	
	
}
