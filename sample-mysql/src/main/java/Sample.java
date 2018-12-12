import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = System.getenv("MYSQL_URL");
        String user = System.getenv("MYSQL_USER");
        String password = System.getenv("MYSQL_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select id, text_field from sample_data");

        while (rs.next()) {
            System.out.print(rs.getLong("id"));
            System.out.print(" ");
            System.out.println(rs.getString("text_field"));
        }

        rs.close();
        statement.close();
        connection.close();
    }

}