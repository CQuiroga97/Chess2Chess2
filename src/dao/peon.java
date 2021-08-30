/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javafx.geometry.HorizontalDirection;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Cristhian Quiroga
 */


public class peon extends Ficha{
    private JLabel lblPeon;
    private String[] movimientos;
    private boolean primerMovimiento;
    public peon(Jugador jugador, String tipo, String posicion, JLabel lbl) {
        super(jugador, tipo, posicion, lbl);
        primerMovimiento = false;
    }
    public JLabel crearFicha(JLabel buffLbl, Cuadricula[] cuadriculas){
        lblPeon = new JLabel("", new javax.swing.ImageIcon(getClass().getResource("/assets/Peon.png")), JLabel.CENTER);
        lblPeon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPeon.addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int cont = 0;
            int letra = 97;
            for(int i = 0; i<64; i++){
            
            if(cont%2 == 0)cuadriculas[i].getPanel().setBackground(new java.awt.Color(255, 255, 255));
            else cuadriculas[i].getPanel().setBackground(new java.awt.Color(0, 0, 0));
            cont++;
            letra++;
            if(letra > 104){
                letra = 97;
                cont++;
            } 
            }
            getLbl().setText(getPosicion());
            setMovimeintos();
            for(int i = 0; i<cuadriculas.length;i++){
                for(int n = 0; n<getMovimeintos().length;n++){
                    if(cuadriculas[i].getNombre().equals(getMovimeintos()[n])){
                        if(n==2 || n ==3){
                            if(cuadriculas[i].getPanel().getComponents().length == 1){
                                cuadriculas[i].getPanel().setBackground(new java.awt.Color(51,51,255));
                            }
                        }else if(n == 1){
                            if(!primerMovimiento){
                                cuadriculas[i].getPanel().setBackground(new java.awt.Color(51,51,255));
                            }
                        }else{
                            cuadriculas[i].getPanel().setBackground(new java.awt.Color(51,51,255));
                        }
                        
                    }
                }
            }
        }
        
        });
        
        return lblPeon;
    }

    public boolean isPrimerMovimiento() {
        return primerMovimiento;
    }

    public void setPrimerMovimiento(boolean primerMovimiento) {
        this.primerMovimiento = primerMovimiento;
    }
    
    public JLabel getFicha(){
            return lblPeon;
        }
   
    public void setMovimeintos(){
        
        char letra = getPosicion().charAt(0);
        int numero = Integer.parseInt(getPosicion().split("")[1]);
        movimientos = new String[4];
        movimientos[0] = letra+""+ (numero-1);
        movimientos[1] = letra+""+ (numero-2);
        movimientos[2] = (char)(letra - 1)+""+ (numero-1);
        movimientos[3] = (char)(letra + 1)+""+ (numero-1);
    }
    public String[] getMovimeintos(){
        return movimientos;
    }
    
}
