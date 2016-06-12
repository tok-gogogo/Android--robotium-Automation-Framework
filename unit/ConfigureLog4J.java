package gaorui.com.smartlight.gongke_test.unit;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Environment;

import org.apache.log4j.Level;

import java.io.File;

import de.mindpipe.android.logging.log4j.LogConfigurator;

public class ConfigureLog4J {
	private static String config_path;
	private static String config_filename;
    private static String script_name;
	public static void configure() {
        final LogConfigurator logConfigurator = new LogConfigurator();//实例化配置文件，相当于log4j.properties 作用一样，只是实现形式不一样而已
        // Environment.getExternalStorageDirectory() 相当于 mnt/sdcard/
        config_path = Environment.getExternalStorageDirectory() + File.separator+"d";
        script_name =  config_path + File.separator+ "script.txt";
        config_filename =  config_path + File.separator+ "test.log";
        logConfigurator.setFileName(config_filename);
        logConfigurator.setRootLevel(Level.DEBUG);//设置错误的最高级别
        // Set log level of a specific logger
        logConfigurator.setUseFileAppender(true);//相当于org.apache.log4j.FileAppender（文件），
        logConfigurator.setLevel("org.apache", Level.ERROR);//
        logConfigurator.configure();//使上面的设置全部生效
    }
    public static String get_confilename()
    {
        return config_filename;
    }
    public static String get_config_path()
    {
        return config_path;
    }
    public static String getScript_name()
    {
        return script_name;
    }
}
