/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;


import javax.swing.JOptionPane;


/**
 *
 * @author Ruben
 */
public class Ventana_Error{

    
    public Ventana_Error(){
        

		
        
    }
    
    public static void mostrarErrorMetaInalcanzable(){

      JOptionPane.showMessageDialog(null, "Meta Inalcanzable","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void mostrarErrorParametrosIncorrectos()
    {

      JOptionPane.showMessageDialog(null, "Parametros Incorrectos","Error",JOptionPane.WARNING_MESSAGE);
      
    }

    
    	public static void main(String[] args){
            mostrarErrorMetaInalcanzable();
            mostrarErrorParametrosIncorrectos();

        }
        
    
}
