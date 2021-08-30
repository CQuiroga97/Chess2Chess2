/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JLabel;
import dao.Jugador;
/**
 *
 * @author Cristhian Quiroga
 */
public class Ficha {
    private Jugador jugador;
    private String tipo;
    private String posicion;
    private JLabel lbl;

    public Ficha(Jugador jugador, String tipo, String posicion, JLabel lbl) {
        this.jugador = jugador;
        this.tipo = tipo;
        this.posicion = posicion;
        this.lbl = lbl;
    }

    public JLabel getLbl() {
        return lbl;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }
    
    public void calcularPosiciones(){
        
    }
}
