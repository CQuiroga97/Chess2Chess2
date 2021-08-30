/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Cuadricula.cliente;
import static dao.Cuadricula.entrada;
import static dao.Cuadricula.salida;
import static dao.Cuadricula.teclado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JLabel;

/**
 *
 * @author Cristhian Quiroga
 */
public class serverListener implements Runnable{
    private Thread t;
   private JLabel buffLbl;
   public static Socket cliente;
    public static PrintStream salida;
    public static BufferedReader entrada, teclado;
   public serverListener( JLabel name) {
      buffLbl = name;
   }
   
   public void run() {
       /*
       System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
       */
       while(true){
           try {
            cliente = new Socket("192.168.0.26", 9000);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println("ASDASDASDASDAS");
            System.out.println(entrada.readLine());
            System.out.println("A22222DASDAS");
            //buffLbl.setText();
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
           } catch (Exception e) {
           }
           
       }
      
   }
   
   public void start () {
     
      if (t == null) {
         t = new Thread (this, "");
         t.start ();
      }
   }
}


