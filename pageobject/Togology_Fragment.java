package gaorui.com.smartlight.gongke_test.pageobject;

import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;

/**
 * Created by dell on 16-2-18.
 */
public class Togology_Fragment {
    public void clickon_togologydevice()
    {
        GongkeUtil.ActionWord.clickById("device_togology_rl");
    }
    public void clickon_togologygateway()
    {
        GongkeUtil.ActionWord.clickById("gateway_togology_rl");
    }
    public void clickon_togologyall(){
        GongkeUtil.ActionWord.clickById("all_togology_rl");
    }
}
