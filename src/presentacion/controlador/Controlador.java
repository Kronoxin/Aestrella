/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.JButton;
import negocio.Aestrella;
import negocio.estado.Nodo;
import presentacion.vista.Boton_Matriz;
import presentacion.vista.Vista;

/**
 *
 * @author Ruben
 */
public class Controlador implements ActionListener{
     Vista vista = new Vista();
    JButton boton_seleccionado;
    ActionEvent evento;
    Boton_Matriz boton_matriz_seleccionado;
    
    boolean boton_inicio_seleccionado=false;
    boolean boton_meta_seleccionado = false;
    
    private ArrayList<Nodo> listaNodosProhibidos;
    private Nodo inicio;
    private Nodo meta;

     
    public Controlador(){
        super();
        listaNodosProhibidos = new ArrayList<>();
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
        Aestrella algoritmo = new Aestrella(this.inicio,this.meta,this.listaNodosProhibidos);
        ArrayList<Nodo> recorrido = algoritmo.recorrer();
        
        if (recorrido != null && recorrido.size() > 0)
                {
                    for (Nodo nodo : recorrido)
                        System.out.println("Recorro el nodo " + nodo.getX() + "," + nodo.getY());
                }
        
    }
    
    public void marcarReset(){
        System.out.println("He marcado Reset");
        generarMatriz();
        boton_inicio_seleccionado = false;
        boton_meta_seleccionado = false;
        this.inicio = null;
        this.meta = null;
        this.listaNodosProhibidos = new ArrayList<>();
    }
    
    
    //metodo para acivar_desactivar los botones del panel_menu una vez se hayan pinchado
    public void activar_desactivar_boton (){
         if(boton_seleccionado != null){
            boton_seleccionado.setEnabled(true);
        }
         boton_seleccionado = ((JButton)evento.getSource());
         boton_seleccionado.setEnabled(false);
    }
    
    //Aqui es donde cojo cada boton_matriz que utilizo
    public void verloquetengoquehacer(){
        
        if(boton_seleccionado == null){
            System.out.println("No has seleccionado ninguna opción del menu");
        }
        else{
        
            switch (boton_seleccionado.getText()) 
                {
                    //actionlistener de los Botones_Matriz
                    case "Inicio":
                        if(boton_inicio_seleccionado == false){
                            boton_matriz_seleccionado.setBackground(Color.YELLOW);
                            boton_inicio_seleccionado = true;
                            this.inicio = new Nodo(boton_matriz_seleccionado.getXpos(), boton_matriz_seleccionado.getYpos());
                        }
                        
           
                        break;

                    case "Meta":
                        if(boton_meta_seleccionado == false){
                            boton_matriz_seleccionado.setBackground(Color.GREEN);
                            boton_meta_seleccionado = true;
                            this.meta = new Nodo(boton_matriz_seleccionado.getXpos(), boton_matriz_seleccionado.getYpos());
                        }
                        
                        break;

                    case "Prohibidas":
                        boton_matriz_seleccionado.setBackground(Color.BLACK);
                        boton_matriz_seleccionado.setForeground(Color.WHITE);
                        this.listaNodosProhibidos.add(new Nodo(boton_matriz_seleccionado.getXpos(),boton_matriz_seleccionado.getYpos()));
                        break;

                    case "Restrictivas":
                        
                        boton_matriz_seleccionado.setBackground(Color.GRAY);
                        boton_matriz_seleccionado.setForeground(Color.BLACK);
                        break;

            }
        
        }
    }
    
}
