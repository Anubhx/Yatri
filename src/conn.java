import java.sql.*;

public class conn {

    Connection c;
    Statement s;
    public conn () {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "12345");
            s = c.createStatement();

         } catch(Exception e) {
            e.printStackTrace();
         }
        
    }
    
}

