package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final String PATH =
            "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "configs" + File.separator +
                    "config.properties";

    public static String getProperty(String property) {
        FileReader reader;
        Properties p = new Properties();
        try {
            reader = new FileReader(PATH);
            p.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(property);
    }
}
