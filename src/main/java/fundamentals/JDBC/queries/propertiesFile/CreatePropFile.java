package fundamentals.JDBC.queries.propertiesFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CreatePropFile {

    public static void main(String[] args) {

        try (OutputStream output = new FileOutputStream("C:\\Users\\Vartotojas\\IdeaProjects\\Individual learning\\src\\main\\resources\\config.properties")){
            Properties properties = new Properties();

            properties.setProperty("db.url", "jdbc:mysql://localhost:3306/testDB");
            properties.setProperty("db.user", "root");
            properties.setProperty("db.password", "root");

            properties.store(output,null);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
