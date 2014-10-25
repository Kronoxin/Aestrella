package negocio.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Boton_Matriz extends JButton implements ActionListener{
	
	public Boton_Matriz(){
		
		
		addActionListener( this );
	}
	public void setNombre( int x, int y ){
        setText("("+x+","+y+")");
    }
	
	public void actionPerformed( ActionEvent e ){
        //Se asigna el color de fondo azul
        setBackground(Color.BLACK);
        //Se asigna un color de letra color blanco
        setForeground(Color.WHITE);
    }

}
