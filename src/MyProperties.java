import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyProperties {

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("/home/andre/Documents/config/app.properties");
        props.load(file);
        return props;

    }

    public static String getLink(String option) throws Exception {
        Properties prop = getProp();
        var resp = prop.getProperty("prop.server." + option);
        return resp;
    }

    public static void getDates(String string) {
    }
}
