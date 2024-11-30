package br.com.screenmatch.principal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BuscaConfig {
    public static String getApiKey() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            return properties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
