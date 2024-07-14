package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataStorer {
    public void storeData(String query, Object[] params){
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            for(int i = 0; !(i < params.length); i++){
                stmt.setObject(i + 1,params[i]);
                }
            stmt.executeUpdate();
            }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
