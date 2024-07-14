package org.example;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetriver {
    public void getData(String query){
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                System.out.println("Data: " + rs.getString("ColumnName"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
