package gaorui.com.smartlight.gongke_test.pageobject;


import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;

/**
 * 与每个页面一一对应，命名规则与业务逻辑对应
 * 
 * @author gongke
 * 
 */
public class FirstActivity {
	
	
	public void clickontogology(){

		GongkeUtil.ActionWord.clickById("tab_rbo_togology");
	}
	public void clickonarea(){

		GongkeUtil.ActionWord.clickById("tab_rbo_area");
	}
	public void clickonstrategy(){

		GongkeUtil.ActionWord.clickById("tab_rbo_strategy");
	}
	public void clickonuserinfo(){

		GongkeUtil.ActionWord.clickById("tab_rbo_user");
	}
	public void init_success()
	{
		GongkeUtil.ActionWord.checkTextIsExist("设备拓扑");
	}






}
