/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class koneksi {
    
    public Connection con = null;

    public String Driver;
    public String url;
    public String user;
    public String pass;

    public koneksi() {
        Driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/restoran";
        user = "root";
        pass = "";
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Connection getconnection(){
        return this.con;
    }

    public static void main(String[] args) {
        koneksi kon = new koneksi();
        System.out.println(kon.getconnection());
        
        
    }
    
    
}