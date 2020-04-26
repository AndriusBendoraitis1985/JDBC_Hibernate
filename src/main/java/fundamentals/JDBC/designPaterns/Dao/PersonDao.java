package fundamentals.JDBC.designPaterns.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDao {

    public Person getPerson(int id_person) throws Exception {
        String url = "jdbc:mysql://localhost:3306/testDB";
        String userName = "root";
        String password = "root";
        String query = "select first_name, last_name from persons where id_person="+id_person;

        Person p = new Person();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();

        String name = rs.getString(1);
        String surname = rs.getString(2);
        p.id_person = id_person;
        p.first_name=name;
        p.last_name=surname;
        return p;
    }
}
