/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import dao.Jugador;
import operaciones.ImpOpJugador;
/**
 *
 * @author Cristhian Quiroga
 */
public class Registro {
    public void guardar(Jugador jugador){
        ImpOpJugador op = new ImpOpJugador();
        op.registrar(jugador);
    }
    public void modificar(Jugador jugador){
        ImpOpJugador op = new ImpOpJugador();
        op.modificar(jugador);
    }
}
