package gaorui.com.smartlight.gongke_test.pageobject;

import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;

/**
 * Created by dell on 16-2-18.
 */
public class IpportActivity {

    public void type_ipport()
    {
        GongkeUtil.ActionWord.typeTextById("ip_et", "115.238.40.242");
        GongkeUtil.ActionWord.typeTextById("port_et","8010");
    }

    public void clickonbutton()
    {
        GongkeUtil.ActionWord.clickById("ip_port_button");
    }
    public void clickonback()
    {
        GongkeUtil.ActionWord.clickById("title_area_back");
    }
    public void clearedit()
    {
        GongkeUtil.ActionWord.ClearText("ip_et");
        GongkeUtil.ActionWord.ClearText("port_et");
    }
}

