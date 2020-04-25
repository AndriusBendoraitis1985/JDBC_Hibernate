package exercises.JDBC.Exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Person> personList = getPersonsList();

        uploadToDataBase(personList);
    }

    private static List<Person> getPersonsList() {
        List<Person> personList = new ArrayList<Person>();
        Person p1 = new Person("Miroslav", "Cerniuk");
        Person p2 = new Person("Inga", "Cerniuk");
        personList.add(p1);
        personList.add(p2);
        return personList;
    }

    private static void uploadToDataBase(List<Person> personList) throws Exception {
        String url = "jdbc:mysql://localhost:3306/testDB";
        String userName = "root";
        String password = "root";
        String querry = "Insert into persons (first_name, last_name) values (?,?);";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, password);
        java.sql.PreparedStatement st = con.prepareStatement(querry);
        int count = 0;

        for (Person person : personList) {
            st.setString(1, person.getName());
            st.setString(2, person.getSurname());
            st.executeUpdate();
            count++;
        }

        System.out.println(count + " row/s affected");
        st.close();
        con.close();
    }
}
