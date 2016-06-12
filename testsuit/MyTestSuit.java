package gaorui.com.smartlight.gongke_test.testsuit;




import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;

import gaorui.com.smartlight.gongke_test.script.Login_script;

import gaorui.com.smartlight.gongke_test.script.togology_script;
import gaorui.com.smartlight.gongke_test.unit.ConfigureLog4J;
import gaorui.com.smartlight.gongke_test.unit.GongkeUtil;
import gaorui.com.smartlight.gongke_test.unit.Gongke_Object;
import gaorui.com.smartlight.gongke_test.unit.MailSender;

/**
 * 测试套，添加脚本用例名称，及类名，以便达到脚本总体跑的效果
 * 
 * @author Administrator
 * 
 */
public class MyTestSuit {

	public static Test suite() {
		TestSuite suite = new TestSuite("gongke Test");
		suite.addTestSuite(Login_script.class);
		suite.addTestSuite(togology_script.class);
		//suite.
		//sendmail();
		return suite;
	}

}
