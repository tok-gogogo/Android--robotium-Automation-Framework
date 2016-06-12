package gaorui.com.smartlight.gongke_test.pageobject;


import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;

public class LoginActivity {
	
	public void clickOnLogin(){
		GongkeUtil.ActionWord.clickById("login_activity_login");
	}
	
	public void enterUsername(){
		GongkeUtil.ActionWord.typeTextById("login_account", GongkeUtil.getObject().getUserName());
	}
	public void enterPassword(){
		GongkeUtil.ActionWord.typeTextById("login_password", GongkeUtil.getObject().getPassWord());
	}
	public void click_ip_port(){
		GongkeUtil.ActionWord.clickById("current_ip_tv");
	}

}
