/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Cristhian Quiroga
 */
public class Jugador {
    private String nickname;
    private String pass;
    private String correo;
    private int nivel;

    public Jugador(String nickname, String pass, String correo, int nivel) {
        this.nickname = nickname;
        this.pass = pass;
        this.correo = correo;
        this.nivel = nivel;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPass() {
        return pass;
    }

    public String getCorreo() {
        return correo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
