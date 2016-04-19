/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiserve;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark
 */
public class DBconnector {

    


    public DBconnector() {

        try { 
            getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        multiserve.Server.dbStarted = true;
        System.out.println("database started");
   
    }

    private Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;
        try {
            /*
            Class.forName("com.mysql.jdbc.Driver");
            String url =  "jdbc:mysql://162.144.28.50:3306/uxastudi_space";
            String username = "uxastudi_ist411u";
            String password = "ist411u";
            */
            String url = "jdbc:derby://localhost:1527/space";
            String username = "spaceuser";
            String password = "spaceuser";
            
            
            connection = DriverManager.getConnection(url, username, password);
            return connection;

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }  //end getConnection

    public void createDatabase() {
        // code to write the database if it doesnt exist, i think we can get this to work...
    }

    ////////////////////////////////////////////////////////////////     
    ////////////////////////////////////////////////////////////////////////////
    public void writeTocrew(int id, String first, String last, String dept) throws ClassNotFoundException {

        String sql
                = "INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // counter = 1;
            ps.setInt(1, id);
            ps.setString(2, first);
            ps.setString(3, last);
            ps.setString(4, dept);
            

            ps.executeUpdate();
           

            ResultSet results = ps.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            System.out.println("crew member added (success) " + results.getInt(1)); // 

          connection.close();
        } catch (SQLException e) {
            System.err.println( e);

        }

    }  // end write tocrew

    
    public String getDepartment(String category) {
        
        ArrayList<String> temp = new ArrayList();
        
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM SPACEUSER.CREW")) {
           
           // SysSystem.out.println("these are the individuals who work in  " + category );tem.out.println("printing out now...");

            while (rs.next()) {
                String first = rs.getString("firstName");
                String last = rs.getString("lastName");
                String job = rs.getString("dept");
             
                
               System.out.println( first + "  " + last+ ",  is a " +job+ " officer,");
               temp.add(first + "  " + last+ ",  is a " +job+ " officer,");
            }
          
            
          temp.add("these are the individuals who work in  " + category );
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            
            System.out.println(e);
            
          
        }
        
        String hold = "";
        for(int i = 0; i < temp.size(); i++){
            hold = hold +  temp.get(i);
        }
        
        
        
        
        return hold; 
    }     // end get department
      



}  // end class

/*


INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (1,'mike','gentry','science');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (2,'carl','peterson','science');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (3,'elizabeth','sanders','science');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (4,'dale','estavez','science');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (5,'daisy','gonzalez','engineering');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (6,'dwight','jenkins','engineering');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (7,'dan','smith','engineering');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (8,'frank','bentliss','engineering');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (9,'carl','diego','engineering');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (10,'peter','jennings','security');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (11,'jim','carlson','security');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (12,'rachel','smith','security');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (13,'brenda','Madison','security');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (14,'sarah','adams','security');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (15,'aaron','richardson ','security');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (16,'david','smith','flight crew');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (17,'chad','sartorious','flight crew');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (18,'steve','espanenzeh','flight crew');
INSERT INTO SPACEUSER.CREW (id, firstName, lastName, dept) VALUES  (19,'saul','goodman','security');



*/