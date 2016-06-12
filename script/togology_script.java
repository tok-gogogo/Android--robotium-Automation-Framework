package gaorui.com.smartlight.gongke_test.script;



import gaorui.com.smartlight.gongke_test.pageobject.IpportActivity;
import gaorui.com.smartlight.gongke_test.pageobject.LoginActivity;
import gaorui.com.smartlight.gongke_test.pageobject.Togology_Fragment;
import gaorui.com.smartlight.gongke_test.pageobject.User_Fragment;
import gaorui.com.smartlight.gongke_test.pageobject.FirstActivity;
import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;

public class togology_script extends GongkeUtil {
	FirstActivity firstActivity = new FirstActivity();//实例化主页面
	LoginActivity la = new LoginActivity();
	User_Fragment user_fragment = new User_Fragment();
	IpportActivity ipportActivity = new IpportActivity();
	Togology_Fragment togology_fragment = new Togology_Fragment();
	public void test_main() {
		GongkeUtil.ActionWord.sleepTime(5);
        firstActivity.init_success();
		firstActivity.clickonarea();
		firstActivity.clickonuserinfo();
		user_fragment.clickon_ipport();
		ipportActivity.clearedit();
		ipportActivity.type_ipport();
		ipportActivity.clickonbutton();
		firstActivity.clickontogology();
		togology_fragment.clickon_togologyall();
		//GongkeUtil.ActionWord.setwifi(false);

	}

}
