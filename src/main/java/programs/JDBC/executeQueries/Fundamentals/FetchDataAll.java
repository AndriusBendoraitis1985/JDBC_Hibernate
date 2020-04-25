package programs.JDBC.executeQueries.Fundamentals;

import java.sql.*;

public class FetchDataAll {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testDB";
        String userName = "root";
        String password = "root";
        String queryAll = "select * from persons";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password );
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(queryAll);

        String personData = "";
        while (rs.next()) {
            personData = rs.getInt(1) + " : " + rs.getString(2) + " " + rs.getString(3);
            System.out.println(personData);
        }
        st.close();
        con.close();
    }

}