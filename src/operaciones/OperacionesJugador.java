/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;
import dao.Jugador;
/**
 *
 * @author Cristhian Quiroga
 */
public interface OperacionesJugador {
    public int registrar(Jugador dato);
    public int modificar(Jugador dato);
    public int Eliminar(Jugador dato);
    public Jugador Buscar(String nick, String pass);
}
