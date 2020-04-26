package fundamentals.JDBC.queries;

import java.sql.Connection;
import java.sql.DriverManager;

public class PreparedStatement {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testDB";
        String userName = "root";
        String password = "root";
        String name = "Alvydas";
        String surname = "Bendoraitis";
        String queryInsert = "insert into persons (first_name , last_name ) values (?, ?);";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        java.sql.PreparedStatement st = con.prepareStatement(queryInsert);
        st.setString(1, name);
        st.setString(2,surname);
        int count = st.executeUpdate();
        // DDL - data definition language - create table/change structure of DB
        // DML - edit value/ add value
        // DQL - data query language - fetch data

        System.out.println(count + " row/s affected");

        st.close();
        con.close();
    }
}
