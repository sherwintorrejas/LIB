/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONFIG;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;

public class DBCONNECTOR {
      public Connection connection;
    
    public DBCONNECTOR (){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }
        
        
    }
    
    public ResultSet getData(String sql) throws SQLException {
        java.sql.Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

 public void insertData(String sql){
            try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
           
            pstmt.executeUpdate();
            System.out.println("Inserted Successfully!");
            pstmt.close();
            }catch(SQLException e){
                System.out.println("Connection Error: "+e);
            }
    }
    
    
      public void deleteData(int id) {
    try {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM student_details WHERE ID = ?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows were deleted.");
        } else {
            System.out.println("No rows were deleted.");
        }
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}
       public void deleteData1(int ISBN) {
    try {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM book_details WHERE ISBN = ?");
        stmt.setInt(1, ISBN);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows were deleted.");
        } else {
            System.out.println("No rows were deleted.");
        }
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}  
      
   
       public int updateData(String sql){
        int num = 0;
        try {
       
            String query = sql;
            PreparedStatement stmt = connection.prepareStatement(query);
            int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                num = 1;
            } else {
                System.out.println("Data update failed!");
                num = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return num;
    }
   
}
