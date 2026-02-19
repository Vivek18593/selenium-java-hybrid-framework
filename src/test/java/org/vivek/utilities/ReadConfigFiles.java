package org.vivek.utilities;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFiles {

    protected static Properties prop = new Properties();

    public ReadConfigFiles() {
        try {
            InputStream configFile = getClass().getClassLoader().getResourceAsStream("config/config.properties");
            prop.load(configFile);
        } catch (Exception ex) {
            throw new RuntimeException("Config file loading failed!", ex);
        }
    }

    // READING CONFIG FILE DATA
    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}
