/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author Анюта
 */
public class DAOUser extends Dao {

    /**
     *
     * @author Анюта
     */
    static String tb_name = "roles";

    static Statement stmt;
    static PreparedStatement pstmt;
    static ResultSet result;
    static Logger log = Logger.getLogger(DAOVisitor.class.getName());

    public User getUserByUsername(String name) throws SQLException {

        connect();
        User vs = null;
        try {

            String query = "select * from " + tb_name + " where login=\"" + name + "\"";
            stmt = con.createStatement();

            result = stmt.executeQuery(query);
            while (result.next()) {
                int id = result.getInt(1);
                String login = result.getString(3);
                String role = result.getString(2);
                vs = new User(id, role, login);
            }

        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            disconnect();
            return vs;
        }
    }

    public void Create(User u)
    {
        connect();
    try {
            String query = "INSERT INTO " + tb_name + " (id_visitor,role,login) VALUES(?, ?, ?)";
            pstmt = con.prepareStatement(query);

            pstmt.setString(3, u.getLogin());
            pstmt.setString(2, u.getRole());
            pstmt.setInt(1, u.getId_visitor());
            pstmt.executeUpdate();
            log.info("Created user");
        } catch (SQLException ex) {
            log.severe(ex.getLocalizedMessage());
        } finally {disconnect();}
    }
}
