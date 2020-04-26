package fundamentals.JDBC.queries;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class UpdateData {

    public static void main(String[] args) {

        try (InputStream input = new FileInputStream("C:\\Users\\Vartotojas\\IdeaProjects\\Individual learning\\src\\main\\resources\\config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            Connection con = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));
            Statement st = con.createStatement();
            String queryInser = "update persons set last_name = 'Bendoraitis' where last_name like 'Bendor';";

            int count = st.executeUpdate(queryInser);

            System.out.println(count + " lines affected");

            st.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

