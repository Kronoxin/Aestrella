/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.JButton;
import negocio.vista.Boton_Matriz;

import negocio.vista.Vista;

/**
 *
 * @author Ruben
 */
public class Controlador implements ActionListener{
     Vista vista = new Vista();
    JButton boton_seleccionado;
    ActionEvent evento;
    Boton_Matriz boton_matriz_seleccionado;

     
    public Controlador(){
        super();
        vista.getPanel_menu().asignarControlador(this);
    }
    
    
            public void hacerCambiosEnModelo(Component fuente)
        {
            
            
            switch (fuente.getName()) 
            {
                //actionlistener de los Botones_Matriz
                case "Matriz":
                    
                    capturarBotonMatriz();

                    verloquetengoquehacer();

                    break;
                
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
                    
                case "Reiniciar":
                    marcarReset();
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
        
        evento = e;
        
        tratarEventoGenerico(e);
       
        System.out.println(e.getSource().getClass());
  
    }
    
    
    private void tratarEventoGenerico(EventObject event)
    {
        Component fuente = (Component) event.getSource();
	
        hacerCambiosEnModelo(fuente);
    }
    
    public void capturarBotonMatriz (){
        
        boton_matriz_seleccionado = ((Boton_Matriz)evento.getSource());
        
    }
        
    
    public void marcarInicio(){
        System.out.println("He marcado Inicio");
        System.out.println(evento.getSource().getClass());

        
        activar_desactivar_boton();
        
        
        
        
    }
    
    public void marcarMeta(){
        System.out.println("He marcado Meta");
        
        activar_desactivar_boton();
       
    }
    
    public void marcarProhibidas(){
        System.out.println("He marcado Prohibidas");
        
        activar_desactivar_boton();
        
    }
    
    public void marcarRestrictivas(){
        System.out.println("He marcado Restrictivas");
        
        activar_desactivar_boton();
        
    }
    
    public void generarMatriz(){
              
            //Se obtiene la cantidad de filas y columnas a crear
        String f= vista.getPanel_menu().getEntrada_datos().getTxt_filas().getText();

        String c = vista.getPanel_menu().getEntrada_datos().getTxt_columnas().getText();
        
            //Parseamos el String a Int
            int filas = Integer.parseInt(f);
            int columnas = Integer.parseInt(c);
		

            //generamos la matriz con los datos introducidos
            vista.getPanel_matriz_botones().generarMatrizDeBotones(filas, columnas, this);
        
    }
    
    public void empezar(){
        System.out.println("He marcado Empezar");
        
    }
    
    public void marcarReset(){
        System.out.println("He marcado Reset");
    }
    
    
    //metodo para acivar_desactivar los botones del panel_menu
    public void activar_desactivar_boton (){
         if(boton_seleccionado != null){
            boton_seleccionado.setContentAreaFilled(true);
        }
         boton_seleccionado = ((JButton)evento.getSource());
         boton_seleccionado.setContentAreaFilled(false);
    }
    
    //Aqui es donde cojo cada boton_matriz que utilizo
    public void verloquetengoquehacer(){
        
        switch (boton_seleccionado.getText()) 
            {
                //actionlistener de los Botones_Matriz
                case "Inicio":
                    boton_matriz_seleccionado.setBackground(Color.YELLOW);
                    break;
                
                case "Meta":
                    boton_matriz_seleccionado.setBackground(Color.RED);
                    break;
                    
                case "Prohibidas":
                    boton_matriz_seleccionado.setBackground(Color.BLACK);
                    boton_matriz_seleccionado.setForeground(Color.WHITE);
                    break;
   
                case "Restrictivas":
                    boton_matriz_seleccionado.setBackground(Color.GRAY);
                    boton_matriz_seleccionado.setForeground(Color.BLACK);
                    break;
        
        }
        
    }
    
}
