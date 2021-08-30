/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Cristhian Quiroga
 */
public class Cuadricula {
    public static Socket cliente;
    public static PrintStream salida;
    public static BufferedReader entrada, teclado;
    private String nombre;
    private JPanel panel;

    public Cuadricula() {

    }

    public String getNombre() {
        return nombre;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void enviarASV(String jugada, JLabel buffLbl){
        try {
            cliente = new Socket("192.168.0.26", 9000);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            salida = new PrintStream(cliente.getOutputStream());
            salida.println(jugada);
            buffLbl.setText(entrada.readLine());
            
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
        } catch (Exception e) {
        }
        
    }
    public void setPanel(JPanel panel, JLabel buffLbl, JPanel tablero, peon[] p, Cuadricula[] c) {
        panel.addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            for(int i = 0; i<p.length; i++){
                if(p[i].getPosicion() == buffLbl.getText()){
                    p[i].setMovimeintos();
                    
                    for(int n = 0; n<p[i].getMovimeintos().length;n++){
                        
                        if(p[i].getMovimeintos()[n].equals(nombre)){
                            enviarASV(p[i].getJugador().getNickname()+ ": " + p[i].getTipo() + " va desde " + p[i].getPosicion() + " hasta " + nombre, buffLbl);
                            panel.add(p[i].getFicha());
                            p[i].setPrimerMovimiento(true);
                            p[i].setPosicion(nombre);
                            int cont = 0;
                            int letra = 97;
                            for(int m = 0; m<64; m++){

                            if(cont%2 == 0)c[m].getPanel().setBackground(new java.awt.Color(255, 255, 255));
                            else c[m].getPanel().setBackground(new java.awt.Color(0, 0, 0));
                            cont++;
                            letra++;
                            if(letra > 104){
                                letra = 97;
                                cont++;
                            } 
                            }
                        }
                    }
                    
                }
            }
            SwingUtilities.updateComponentTreeUI(tablero);
        }
        
        });
        this.panel = panel;
    }
    
}
