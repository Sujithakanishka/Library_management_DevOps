package com.library.dao;

import java.sql.*;
import com.library.util.DBConnection;

public class AdminDao implements AdminDaoInterface{
      public boolean login(String username, String password){
        boolean flag=false;
        try{
          Connection con=DBConnection.getConnection();  

          String query = "SELECT * FROM Admin WHERE username = ? AND password = ?";

          PreparedStatement pst =con.prepareStatement(query);
          pst.setString(1, username);
          pst.setString(2, password);
          ResultSet rs=pst.executeQuery();

          if(rs.next())
          {
            flag = true;
          }
          rs.close();
          pst.close();
          con.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        
        return flag;
      }

}