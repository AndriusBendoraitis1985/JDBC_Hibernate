package programs.JDBC.executeQueries.Fundamentals;

import java.sql.*;

public class InsertData {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testDB";
        String userName = "root";
        String password = "root";
        String queryInser = "insert into persons (first_name , last_name ) values ('Ceslava', 'Cerniuk'),('Aleksandr', 'Cerniuk');";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        Statement st = con.createStatement();
        int count = st.executeUpdate(queryInser);
        // DDL - data definition language - create table/change structure of DB
        // DML - edit value/ add value
        // DQL - data query language - fetch data

        System.out.println(count + " row/s affected");

        st.close();
        con.close();
    }
}
