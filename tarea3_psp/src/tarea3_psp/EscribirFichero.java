/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3_psp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Jairo
 */
public class EscribirFichero {
/**
 * Este método crea un fichero en la ruta definida como parametro en la clase File
 */
    public void crearFichero(){
        try{
        File fichero = new File("C:/Users/Jairo/Desktop/tablasM.txt");
            if(!fichero.exists()){
                fichero.createNewFile();
            }
        }catch(Exception e){
            System.out.println("Cambie la ruta donde desea crear el fichero"+"\n"+e.getMessage());
        }
    }
    /**Method that write data in a file
     * Método que escribe en fichero los datos personales del alumno
     */
    public void escribirCabecera(){
         String fichero="C:/Users/Jairo/Desktop/tablasM.txt";
        try{
            FileWriter fw = new FileWriter(fichero, true);
            PrintWriter pw = new PrintWriter(fw);
            
                    pw.println("******************************************");
                    pw.println("* PSP - Tarea 3                          *");
                    pw.println("******************************************");
                    pw.println("* Jairo Martínez Garrido                 *");
                    pw.println("******************************************");
                    pw.println("* EXERCISE 3 - Writing file with Threads *");
                    pw.println("******************************************");
            pw.close();
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * 
     * @param tablaM  Variable que almacena el multiplicador correspondiente
     * a la tabla que se va a proceder a realizar. EN: Variable that store the multiplier
     * 
     * This method writes in the file indicate the table which is next.
     * Este método se enarga de escribir en el fichero indicado la tabla
     * correspondiente.
     */
    public synchronized void escrituraTabla(int tablaM){
        //Change your path
        String fichero="C:/Users/Jairo/Desktop/tablasM.txt";
        
        try{
            FileWriter fw = new FileWriter(fichero, true);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("TABLA DEL "+tablaM);
            for(int i = 1; i<=10; i++){
                pw.println(tablaM +" x "+ i +" = "+ tablaM*i);
            }
            pw.close();
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}