package techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //Bu sinif configuration.properties file'i okumak icin kullanilir.
    //property file'i okumak icin properti objesi kullanilir.

    private static Properties properties;
    //static block (ilk calisir)
    static {
        //data cekmek istedigimiz dosyanin path'i:
        String path="configuration.properties";
        try {
            //configuration.properties dosyasini acar
            FileInputStream fileInputStream = new FileInputStream(path);
            //properties objesini instantiate ediyoruz.
            properties = new Properties();
            //configuration.properties dosyasindaki datalari yukler
            properties.load(fileInputStream);
            //file input stream dosyasi kapatilir.
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //ConfigReader.getProperty("browser"); -> chrome
    //ConfigReader.getProperty("amazon_url"); -> https://www.amazon.com
    //ConfigReader.getProperty("username"); -> ali
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
}
