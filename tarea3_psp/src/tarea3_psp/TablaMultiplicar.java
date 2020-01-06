/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3_psp;

/**
 *
 * @author Jairo
 */
public class TablaMultiplicar extends Thread{
    //Atributo que almacenará el multiplicador
    private int tabla;
    EscribirFichero escribir;
    
    /**
     * 
     * @param tabla parámetro que recoge el valor correspondiente al número de
     *              tabla que se va a realizar.
     * @param escribir variable que almacena un objeto de tipo EscribriFichero.
     */
    TablaMultiplicar (int tabla, EscribirFichero escribir){
        this.tabla=tabla;
        this.escribir = escribir;
        
    }
    public void run(){
        escribir.escrituraTabla(tabla);
            
        }
}


