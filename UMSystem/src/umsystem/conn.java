
package umsystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class conn {
    Connection c;
    Statement s;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/newdb";
    String user="root";
    String password="";

    
    public conn(){
        try{
            Class.forName(driver);
            c=DriverManager.getConnection(url,user,password);
            s=c.createStatement();
            System.out.println("Established Connection");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
