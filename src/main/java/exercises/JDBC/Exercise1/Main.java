package exercises.JDBC.Exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String url = "jdbc:mysql://localhost:3306/testDB";
    static String userName = "root";
    static String password = "root";


    public static void main(String[] args){

        List<Person> personList = getPersonsList();

      //  uploadToDataBase(personList);

        deleteData();
    }

    private static List<Person> getPersonsList() {
        List<Person> personList = new ArrayList<Person>();
        Person p1 = new Person("Miroslav", "Cerniuk");
        Person p2 = new Person("Inga", "Cerniuk");
        personList.add(p1);
        personList.add(p2);
        return personList;
    }

    private static void uploadToDataBase(List<Person> personList) {
        String querry = "Insert into persons (first_name, last_name) values (?,?);";
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            java.sql.PreparedStatement st = con.prepareStatement(querry);

            for (Person person : personList) {
                st.setString(1, person.getName());
                st.setString(2, person.getSurname());
                st.executeUpdate();
                count++;
            }

            System.out.println(count + " row/s affected");
            st.close();
            con.close();
        } catch (Exception e){
            System.out.println("Problem while writing in DB");
        }
    }

    private static void deleteData (){
        String queryDelete = "delete persons from persons where last_name like 'Bendoraitis';";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            int count = st.executeUpdate(queryDelete);

            System.out.printf("Deleted %s entries", count);

            st.close();
            con.close();

        } catch (Exception e){
            System.out.println("Error while deleting data from DB");
        }

    }
}
