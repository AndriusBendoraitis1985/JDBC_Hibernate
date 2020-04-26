package fundamentals.JDBC.designPaterns.Dao;

public class JdbcDao {

    public static void main(String[] args) throws Exception {

        PersonDao dao = new PersonDao();
        Person p1 = dao.getPerson(1);
        System.out.println(p1.first_name+" " + p1.last_name);
    }
}
