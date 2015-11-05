package th.ac.kmitl.ce.ooad;


import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Created by Administrator on 14/10/2558.
 */
public class ConnectionConfuguration {
    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://203.151.92.175:3306/pin_up","database","1234");

        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
