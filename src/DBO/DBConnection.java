package DBO;


import java.sql.*;

public class DBConnection {
    
  
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hungry", "root", "root");
            System.out.println("Connected to the database!");
            return con;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to connect to the database.");
            return null;
        }
     //   return getCon;
   }
}
