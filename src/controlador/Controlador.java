/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

/**
 *
 * @author Ruben
 */
public class Controlador implements ActionListener{
    
            public void hacerCambiosEnModelo(Component fuente)
        {
            switch (fuente.getName()) 
            {
                case "Crear":
                    generarMatriz();
                    break;
                    
                case "Inicio":
                    marcarInicio();
                    break;
                
                case "Meta":
                    marcarMeta();
                    break;
                    
                case "Prohibidas":
                    marcarProhibidas();
                    break;
   
                 case "Restrictivas":
                    marcarRestrictivas();
                    break;
                     
                case "Empezar":
                    empezar();
                    break;     
                     
                     
                default:
                  
                    break;
                    
            }
        }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        tratarEventoGenerico(e);
    }
    
    
    private void tratarEventoGenerico(EventObject event)
    {
        Component fuente = (Component) event.getSource();
	
        hacerCambiosEnModelo(fuente);
    }
    
    
    public void marcarInicio(){
        
    }
    
    public void marcarMeta(){
        
    }
    
    public void marcarProhibidas(){
        
    }
    
    public void marcarRestrictivas(){
        
    }
    
    public void generarMatriz(){
        
    }
    
    public void empezar(){
        
    }
    
}
