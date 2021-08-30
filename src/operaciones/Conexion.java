/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristhian Quiroga
 */
public class Conexion{
    private final String URL = "C:/Users/Cristhian Quiroga/Documents/NetBeansProjects/chess2chess/chess2chess.db";
    
    public Connection conectarse(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:"+URL);
            return conexion;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public void desconectar(Connection dato){
        if(dato != null){
            try {
                dato.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
