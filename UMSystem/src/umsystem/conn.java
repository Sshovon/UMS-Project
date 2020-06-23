
package umsystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class conn {
    Connection c;
    Statement s;
    
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc::mysql://localhost:3306/newdb","root","");
            s=c.createStatement();
            
        }catch(ClassNotFoundException e){
            System.out.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
