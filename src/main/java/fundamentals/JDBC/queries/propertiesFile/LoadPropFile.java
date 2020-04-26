package fundamentals.JDBC.queries.propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadPropFile {

    public static void main(String[] args) {

        try (InputStream input = new FileInputStream("C:\\Users\\Vartotojas\\IdeaProjects\\Individual learning\\src\\main\\resources\\config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            System.out.println(properties.getProperty("db.user"));
            System.out.println(properties.getProperty("db.password"));
            System.out.println(properties.getProperty("db.url"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
