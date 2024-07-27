
package connect;
import java.sql.*;

public class MyConnection 
{
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static Connection getConnection() throws SQLException
    {
        return(DriverManager.getConnection("jdbc:mysql://localhost:3306/medhub","root","root"));
    }
}
