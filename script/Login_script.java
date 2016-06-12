package gaorui.com.smartlight.gongke_test.script;

import gaorui.com.smartlight.gongke_test.pageobject.IpportActivity;
import gaorui.com.smartlight.gongke_test.pageobject.LoginActivity;
import gaorui.com.smartlight.gongke_test.pageobject.FirstActivity;
import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;


/**
 * Created by dell on 16-2-17.
 */
public class Login_script extends GongkeUtil {
    LoginActivity loginActivity = new LoginActivity();
    IpportActivity ipportActivity = new IpportActivity();
    FirstActivity firstActivity = new FirstActivity();
    public void test_login()
    {

        GongkeUtil.ActionWord.sleepTime(5);
        loginActivity.click_ip_port();
        ipportActivity.clearedit();
        ipportActivity.type_ipport();
        ipportActivity.clickonbutton();
        loginActivity.enterUsername();
        loginActivity.enterPassword();
        loginActivity.clickOnLogin();
        GongkeUtil.ActionWord.sleepTime(5);
        firstActivity.init_success();
        GongkeUtil.sendmail("yiyong","sb");

    }
}
