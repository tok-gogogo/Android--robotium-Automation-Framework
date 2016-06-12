package gaorui.com.smartlight.gongke_test.script;



import gaorui.com.smartlight.gongke_test.pageobject.MainActivity;
import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;

public class Main_script extends GongkeUtil {
	MainActivity ma = new MainActivity();//实例化主页面
	public void test_main() {
		ma.main_test();
	}

}
