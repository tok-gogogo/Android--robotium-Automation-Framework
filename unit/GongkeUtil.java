package gaorui.com.smartlight.gongke_test.unit;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.robotium.solo.Solo;
import com.robotium.solo.Solo.Config;
import com.robotium.solo.Solo.Config.ScreenshotFileType;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import gaorui.com.smartlight.Activity.logo;

@SuppressWarnings("rawtypes")
public class GongkeUtil extends ActivityInstrumentationTestCase2 {

    public static Solo solo;
    public static Activity activity;
    private static Class<?> launchActivityClass;
    private static String mainActiviy = "gaorui.com.smartlight.";// 主页面类名
    private static String packageName = "gaorui.com.smartlight";// 应用包名
    private static boolean isTakePicture = true;
    private static final Logger logger = Logger.getLogger(GongkeUtil.class);
    private static Test_wifi test_wifi;
    private static String script_path = "F:\\robotium.xls";
//	static {// 由于没有源码，只能通过反射主类名，获取实例。
//		try {
//			launchActivityClass = Class.forName(mainActiviy);
//
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
//	}

    @SuppressWarnings({"deprecation", "unchecked"})
    public GongkeUtil() {// 构造函数，传递包名和类名，供测试框架进行监控其状态，好对其进行模拟操作
//		super(packageName, launchActivityClass);
        super(logo.class);

    }

    /**
     * 初始化solo实例，以便调用其方法
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        activity = getActivity();
        test_wifi = new Test_wifi(activity);
        ConfigureLog4J.configure();
        Config config = new Config();//实例化配置文件
        config.screenshotFileType = ScreenshotFileType.JPEG;
        config.screenshotSavePath = "sdcard/d";
        config.timeout_small = 1000;
        config.timeout_large = 20000;
        solo = new Solo(getInstrumentation(), config, activity);//传入我们配置的参数
        logger.info("===测试开始===\n");
    }

    /**
     * 第三个运行的方法，扫尾工作，关闭所有打开的activity。
     */
    @Override
    protected void tearDown() throws Exception {
        try {
            logger.info("测试结束\n");
            solo.finishOpenedActivities();
            logger.shutdown();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        activity.finish();
        super.tearDown();
    }

    /**
     * add for keyword framework
     * 2016.5.16
     *
     * @author gongke
     */
    public void test() {
        String path = ConfigureLog4J.getScript_name();
        String packageName = GongkeUtil.class.getPackage().getName();
        ArrayList<ArrayList<String>> cmd_list = new ArrayList<ArrayList<String>>();
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
            return;
            // TODO: handle exception
        }

        String temp = null;
        try {
            while ((temp = reader.readLine()) != null) {
                if (temp.length() < 1)
                    continue;
                ArrayList<String> methodlist = new ArrayList<String>();
                System.out.println(temp);
                String[] tempstr = temp.split("\\$");//$也是正则表达式一种，需加\\
                System.out.println(tempstr.length);
                methodlist.add(tempstr[0].replaceAll("\\s", ""));//\s正则表达式匹配空格、制表符、换页符
                methodlist.add(tempstr[1].replaceAll("\\s", ""));
                cmd_list.add(methodlist);
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
            return;
        }
        Class<?> c = null;
        Object obj = null;

        try {
            c = Class.forName(packageName + ".GongkeUtil$ActionWord");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            obj = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < cmd_list.size(); i++) {
            ArrayList<String> templist = cmd_list.get(i);

            Method print1 = null;
            try {
                print1 = c.getMethod(templist.get(0), new Class[]{String.class});
            } catch (NoSuchMethodException | SecurityException | NullPointerException e) {
                e.printStackTrace();
                continue;
            }
            try {
                print1.invoke(obj, templist.get(1));
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NullPointerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                continue;
            }
        }

    }


    /**
     * solo 的api都是面向过程的，我们要把面向过程变为面向对象。
     *
     * @author gongke
     */
    public static class ActionWord {// aciton word
        public static int controlTime = 1;//统一时间管理，缩短时间写小于1的数字，反之增加大于1的数字
        private final static Logger logger = Logger.getLogger(ActionWord.class);


        /**
         * 通过id点击控件
         *
         * @param id 需要点击的控件id
         */
        public static void clickById(String id) {
            // 通过id点击控件
            solo.clickOnView(solo.getView(id));
            sleepTime(1);
            if (isTakePicture) {
                solo.takeScreenshot(getNowTime());// 截图
            }
        }

        public static void checkTextIsExist(String text) {
            boolean isExist = solo.searchText(text);
            if (isExist) {
                logger.info("验证的" + text + "存在,测试成功！\n");
            } else {
                logger.info("验证的" + text + "不存在,测试失败！\n");
            }
            assertEquals(true, isExist);
        }

        /**
         * 控件之间的延时等待
         *
         * @param time
         */
        public static void sleepTime(int time) {
            solo.sleep(controlTime * time * 1000);
        }
        public static void sleepTime(String time) {
            solo.sleep(controlTime * Integer.valueOf(time) * 1000);
        }
        public static void ClearText(String id) {
            solo.clearEditText((EditText) solo.getView(id));
            if (isTakePicture) {
                solo.takeScreenshot(getNowTime());
            }
        }

        public static void typeTextById(String id, String text) {
            // 对文本框进行输入
            solo.enterText((EditText) solo.getView(id), text);
            if (isTakePicture) {
                solo.takeScreenshot(getNowTime());
            }
        }

        public static void typeTextById(String str) {
            // 对文本框进行输入
            String[] temp = str.split(",");
            String id = temp[0];
            String text = temp[1];
            solo.enterText((EditText) solo.getView(id), text);
            if (isTakePicture) {
                solo.takeScreenshot(getNowTime());
            }
        }

        /**
         * 通过文本点击控件
         *
         * @param text 需要点击的文本内容，必须与要点击的文本完全一致，中间有标点符号的，是中文逗号还是英文的。
         */
        public static void clickByText(String text) {
            solo.clickOnText(text);
        }

        /**
         * 设置wifi状态,可能会弹出请求框
         *
         * @param flag true为打开wifi，flase反之，5.3.1后才添加
         */
        public static void setwifidata(Boolean flag) {
            solo.setWiFiData(flag);
        }

        public static void connect_wifi(String str) {
            String[] temp = str.split(",");
            String SSID = temp[0];
            String Password = temp[1];
            int Type = Integer.parseInt(temp[2]);
            if (test_wifi.checkState() == WifiManager.WIFI_STATE_DISABLED)
                setwifidata(true);
            sleepTime(1);
            ArrayList<View> arrayList = solo.getViews();
            for (int i = 0; i < arrayList.size(); i++)
                System.out.println(arrayList.get(i));
            if (solo.searchText("确定") && solo.searchText("取消"))
                clickByText("确定");
            test_wifi.addNetwork(test_wifi.CreateWifiInfo(SSID, Password, Type));
        }

        public static void connect_wifi(String SSID, String Password, int Type) {
            if (test_wifi.checkState() == WifiManager.WIFI_STATE_DISABLED)
                setwifidata(true);
            sleepTime(1);
            ArrayList<View> arrayList = solo.getViews();
            for (int i = 0; i < arrayList.size(); i++)
                System.out.println(arrayList.get(i));
            if (solo.searchText("确定") && solo.searchText("取消"))
                clickByText("确定");
            test_wifi.addNetwork(test_wifi.CreateWifiInfo(SSID, Password, Type));
        }

        /**
         * 获取当前时间戳
         *
         * @return
         */
        public static String getNowTime() {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
            return df.format(new Date());
        }

    }

    public static Gongke_Object getObject() {
        Gongke_Object ikl = new Gongke_Object();
        return ikl;
    }

    public static void sendmail(String mail_title, String mail_content) {
        String file_path = ConfigureLog4J.get_config_path();
        String filename = "gongkeke";
        if (FileToZip.fileToZip(file_path, file_path, file_path))
            file_path = file_path + File.separator + filename + ".zip";
        else
            file_path = ConfigureLog4J.get_confilename();
        System.out.println(file_path);
        boolean isSendSuccessfully = false;
        try {
            isSendSuccessfully = MailSender.sendTextMail(Gongke_Object.getMail_sender(), Gongke_Object.getMail_password(),
                    Gongke_Object.getMail_smtp(), mail_title, mail_content,
                    file_path, Gongke_Object.getMail_receives());//发送邮件的主题和内容
        } catch (Exception e) {
            isSendSuccessfully = false;
        }
        if (isSendSuccessfully) {
            System.out.println("mail send succ.");
        } else {
            System.out.println("mail send fail.");
        }
    }

}


