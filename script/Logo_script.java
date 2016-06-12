package gaorui.com.smartlight.gongke_test.script;

import gaorui.com.smartlight.gongke_test.pageobject.LogoActivity;
import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;

/**
 * Created by dell on 16-2-17.
 */
public class Logo_script extends GongkeUtil {
    LogoActivity  logoActivity = new LogoActivity();
    public void testlogo()
    {
        logoActivity.logo_waiting();
    }
}
