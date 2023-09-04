package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static javax.swing.UIManager.getString;

public class proutils {
    private static Properties props = new Properties();
    private static Map<String, String> PROPER_MAP = new ConcurrentHashMap();
        static {
            InputStream is = null;
            try {
                is = proutils.class.getResourceAsStream("/application.properties");
                props.load(is);
                Iterator<Object> iterator = props.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    PROPER_MAP.put(key, props.getProperty(key));
                }
            } catch (IOException e) {

            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    public static String getProperty(String key) {
        return PROPER_MAP.get(key);
    }
    public static void main(String[] args) {
        System.out.println(getProperty("spring.redis.host"));
    }
}
