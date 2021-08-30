/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import dao.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Cristhian Quiroga
 */
public class ImpOpJugador implements OperacionesJugador{

    @Override
    public int registrar(Jugador dato) {
        Conexion con = new Conexion();
        Connection conActiva = con.conectarse();
        if(conActiva != null){
            try{
                String sql = "insert into jugador (nickname, correo, pass, nivel) values (?, ?, ?, ?)";
                PreparedStatement ps = conActiva.prepareStatement(sql);
                ps.setString(1, dato.getNickname());
                ps.setString(2, dato.getCorreo());
                ps.setString(3, dato.getPass());
                ps.setInt(4, dato.getNivel());
                int rta = ps.executeUpdate();
                return rta;
                
            }catch(SQLException ex){
                System.out.println("error: " + ex);
            }
        }
        return 0;
    }

    @Override
    public int modificar(Jugador dato) {
        Conexion con = new Conexion();
        Connection conActiva = con.conectarse();
        if(conActiva != null){
            try{
                String sql = "update jugador set nickname = ?, correo = ?, pass = ?, nivel = ? where nickname = " + dato.getNickname();
                PreparedStatement ps = conActiva.prepareStatement(sql);
                ps.setString(1, dato.getNickname());
                ps.setString(2, dato.getCorreo());
                ps.setString(3, dato.getPass());
                ps.setInt(4, dato.getNivel());
                int rta = ps.executeUpdate();
                return rta;
                
            }catch(SQLException ex){
                System.out.println("error: " + ex);
            }
        }
        return 0;
    }

    @Override
    public int Eliminar(Jugador dato) {
        return 0;
    }

    @Override
    public Jugador Buscar(String nickn, String passw) {
        Conexion con = new Conexion();
        Connection conActiva = con.conectarse();
        if(conActiva != null){
            try{
                String sql = "select * from jugador where nickname = '"+nickn+"' and pass = '"+passw+"'";
                PreparedStatement ps = conActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String nick = rs.getString("nickname");
                    String pass = rs.getString("pass");
                    String correo = rs.getString("correo");
                    int nivel = rs.getInt("nivel");
                    Jugador p1 = new Jugador(nick, pass, correo, nivel);
                    return p1;
                }
                return null;
               
                
            }catch(SQLException ex){
                System.out.println("error: " + ex);
            }
        }
        return null;
    }
    
}
