package programs.JDBC.executeQueries.Fundamentals;

import java.sql.*;


public class FetchDataOne {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testDB";
        String userName = "root";
        String password = "root";
        String queryOneId = "select * from persons where id_person=3;";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password );
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(queryOneId);
        rs.next();

        String name = rs.getString("first_name");
        String surname = rs.getString(3);

        System.out.println(name+" "+surname);

        st.close();
        con.close();

    }

}
