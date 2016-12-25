/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Анюта
 */
public class Dao {
    DataSource ds;
    Connection con;
    
    public Dao() {
        
    }
    
    public void initConnection() {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/book");
        } catch (NamingException ex) {
            
        }
    }
    
    public void connect() {
        initConnection();
        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            
        }
    }
    
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            
        }
    }
}
