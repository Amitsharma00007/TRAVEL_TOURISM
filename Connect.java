import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    Connection c;
    /**
     *
     */
    java.sql.Statement s;

    Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "mysql123");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
