package config;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static Properties properties = new Properties();  


    public AppConfig() {
        gitinit();
    }


    private void gitinit() {

        try (InputStream prop = AppConfig.class.getClassLoader().getResourceAsStream("config.properties")) {

            properties.load(prop);
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo config.properties: " + e.getMessage());
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}