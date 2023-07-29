package airline_reservation_system;
import java.sql.*;
public class conn 
{
    Connection con;
    Statement st;
    public conn()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_reservation","root","Sikka@1122");
        st=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);}            
    }
    public static void main(String[] args) {
        new conn();
    }
}
