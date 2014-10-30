/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Ruben
 */
public class Boton_Empezar extends JButton{
    Font fuente = new Font("Verdana", Font.BOLD,14);
    
        public Boton_Empezar(){
        setText("GO!");
        setFont(fuente);
        
        setBackground(Color.BLACK);
        setForeground(Color.RED);
    
    }


    
}
