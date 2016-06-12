package gaorui.com.smartlight.gongke_test.unit;

import com.robotium.solo.Solo;

/**
 * Created by dell on 16-5-16.
 */
public class Test_gg {
    public static Solo solo;
    public Test_gg(Solo msolo)
    {
        solo = msolo;
    }
    public static void clickById(String id) {
        solo.sleep(5 * 1000);
        // 通过id点击控件
        solo.clickOnView(solo.getView(id));
        solo.sleep(5 * 1000);
    }
}
