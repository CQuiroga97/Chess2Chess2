/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import operaciones.ImpOpJugador;
import dao.Jugador;
/**
 *
 * @author Cristhian Quiroga
 */
public class inicioSesion {
    public Jugador iniciarSesion(String nickn, String passw){
        ImpOpJugador im = new ImpOpJugador();
        return im.Buscar(nickn, passw);
    }
}
