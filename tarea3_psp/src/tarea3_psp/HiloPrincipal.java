/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3_psp;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jairo
 */
public class HiloPrincipal {
    public static void main(String[] args) {

        //Create the object HiloPrincipal in which we'll execute the method iniciar.
         //Creamos un objeto HiloPrincipal con el que ejecutaremos el metodo iniciar.
        HiloPrincipal padre = new HiloPrincipal();
        
        /**Create an object EscribirFichero with which we'll execute the method to indicate
         * the file creation.
         * 
         * Creamos un objeto EscribirFichero con el que ejecutaremos el método
         * para indicar la creación del fichero.
        */
        EscribirFichero fich = new EscribirFichero();
        
        fich.crearFichero();
        fich.escribirCabecera();
        padre.iniciar();
    }
    /**
     * Indicate the program execution that will modify the priorities and inicialize the threads.
     * 
     * Iniciamos la ejecución del programa que modificará las prioridades
     * e iniciará los hilos.
     */
    public void iniciar(){
        ArrayList<TablaMultiplicar> tablasM = new ArrayList<>();
        EscribirFichero fich = new EscribirFichero();
        
        /**
         * Create a new thread for each reaiteration and we set the corresponding property
         * depending the value of the variable i.
         * 
         *Creamos un nuevo hilo por cada iteración y le asignamos la propiedad correspondiente
         * según el valor de la variable i.
        */
         
         for(int i =1; i<=10; i++){
             tablasM.add(new TablaMultiplicar(i, fich));
             if(i<3 || i==10){
                 tablasM.get(i-1).setPriority(Thread.MIN_PRIORITY);
             
             }else if(i>6){
                 tablasM.get(i-1).setPriority(Thread.MAX_PRIORITY);
             }
             /**
              * The others tables are created with NORM_PRIORITY, what is means
              * that we don't need to modify their priority.
              * 
              * El resto de tablas de multiplicar son creadas
              * de por sí con NORM_PRIORITY por lo que no necesitamos
              * modificar su prioridad.
             */
        }
         
         //Indicate the threads inside tablasM
         //Iniciamos los hilos dentro tablasM
         for(TablaMultiplicar tablaM: tablasM){
             tablaM.start();
        }
    }
}
