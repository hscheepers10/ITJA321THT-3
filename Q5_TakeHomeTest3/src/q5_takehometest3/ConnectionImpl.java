/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package q5_takehometest3;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * @author User
 */

public class ConnectionImpl implements Sales{

    @Override
    public List<Province> getProvince() throws Exception {
        List<Province> list =  new ArrayList<Province>();
        
        //The name of the database URL and driver.  
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql//localhoast:3306/details";
        
        //DB credentials. 
        String user = "user1";
        String pwd = "password";
        
        Connection con = null;
        Statement stm = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        //Oppening a connection.  
        System.out.println("Connecting to the selected DB ");
        con = DriverManager.getConnection(dbUrl,user,pwd);
        System.out.println("The DB is successfully connected! ");
        System.out.println("Creating statement.  ");
        
        stm = (Statement) con.createStatement();
        String sql = "SELECT * FROM sales";
        ResultSet rs = stm.executeQuery(sql);
        
        //Extracting data from rs.  
        while(rs.next()){
            String id = rs.getString("SaleID");
            String name = rs.getString("Province");
            String litres = rs.getString("litres");  
        }
        rs.close();
        return list;
    }

    
    
}
