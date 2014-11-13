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
import presentacion.TipoBoton;
import presentacion.vista.Boton_Matriz;
import presentacion.vista.Ventana_Error;
import presentacion.vista.Vista;

/**
 *
 * @author Ruben
 */
public class Controlador implements ActionListener
{
     Vista vista = new Vista();
    JButton boton_seleccionado;
    ActionEvent evento;
    Boton_Matriz boton_matriz_seleccionado;
    
    boolean boton_inicio_seleccionado=false;
    boolean boton_meta_seleccionado = false;
    
    private ArrayList<Nodo> listaNodosProhibidos;
    private ArrayList<Nodo> listaNodosRestrictivos;
    private Nodo inicio;
    private Nodo meta;
    private int x,y;
    ArrayList<Nodo> recorrido;

     
    public Controlador()
    {
        super();
        listaNodosProhibidos = new ArrayList<>();
        listaNodosRestrictivos = new ArrayList<>();
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
                    
                case "Borrar":
                    borrar();
                    break;
                    
                case "Waypoints":
                    marcarWaypoints();
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
    
    public void capturarBotonMatriz ()
    {
        
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
    
    public void generarMatriz()
    {
              
            //Se obtiene la cantidad de filas y columnas a crear
        String f= vista.getPanel_menu().getEntrada_datos().getTxt_filas().getText();

        String c = vista.getPanel_menu().getEntrada_datos().getTxt_columnas().getText();
        
            //Parseamos el String a Int
            int filas = Integer.parseInt(f);
            int columnas = Integer.parseInt(c);
		
            this.x = filas;
            this.y = columnas;
            //generamos la matriz con los datos introducidos
            vista.getPanel_matriz_botones().generarMatrizDeBotones(filas, columnas, this);
            
        boton_inicio_seleccionado = false;
        boton_meta_seleccionado = false;
        this.inicio = null;
        this.meta = null;
        this.listaNodosProhibidos = new ArrayList<>();
        this.listaNodosRestrictivos = new ArrayList<>();
        this.recorrido = null;
        
    }
    
    private void rellenarValorRestrictivas(int valor)
    {
        for (Nodo nodo : this.listaNodosRestrictivos)
            nodo.setValor(valor);
    }
    
    public void empezar()
    {
        borrarRecorrido();
        System.out.println("He marcado Empezar");
        int valorRestrictiva = (int)this.vista.getPanel_menu().getSpinner_restrictivas().getValue();
        rellenarValorRestrictivas(valorRestrictiva);
        
        if (this.inicio != null && this.meta != null && this.x > 0 && this.y > 0 && valorRestrictiva >= 0)
        {
            Aestrella algoritmo = new Aestrella(this.inicio,this.meta,this.listaNodosProhibidos,this.listaNodosRestrictivos,this.x,this.y);
            recorrido = algoritmo.recorrer();
            
            if (recorrido == null)
                Ventana_Error.mostrarErrorMetaInalcanzable();
            pintarRecorrido();
        }
        else
        {
            Ventana_Error.mostrarErrorParametrosIncorrectos();
        }
        
        
        
    }
    
    private void pintarRecorrido()
    {
        if (recorrido != null && recorrido.size() > 0)
            {
                for (Nodo nodo : recorrido)
                {
                    if(!(nodo.equals(inicio) || nodo.equals(meta)))
                        vista.getPanel_matriz_botones().getMatriz()[nodo.getX()][nodo.getY()].setBackground(Color.red);
                }
            }
    }
    
    private void borrarRecorrido()
    {
        if (recorrido != null && recorrido.size() > 0)
            for (Nodo nodo : recorrido)
                vista.getPanel_matriz_botones().getMatriz()[nodo.getX()][nodo.getY()].pintate();
    }
    
    public void borrar(){
        
        System.out.println("He marcado Borrar");
        
        activar_desactivar_boton();
        
    }
    
    
    public void marcarWaypoints(){
        
        System.out.println("He marcado un Waypoint");
        activar_desactivar_boton();
        
    }
    
    public void marcarReset(){
        System.out.println("He marcado Reset");
        generarMatriz();
        
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
    public void verloquetengoquehacer()
    {
        
        if(boton_seleccionado == null){
            System.out.println("No has seleccionado ninguna opción del menu");
        }
        else{
        
            switch (boton_seleccionado.getText()) 
                {
                    //actionlistener de los Botones_Matriz
                    case "Inicio":
                        if(boton_inicio_seleccionado == false)
                        {
                            boton_inicio_seleccionado = true;
                            this.inicio = new Nodo(boton_matriz_seleccionado.getXpos(), boton_matriz_seleccionado.getYpos());
                            boton_matriz_seleccionado.setTipo(TipoBoton.INICIO);
                        }
                        
           
                        break;

                    case "Meta":
                        if(boton_meta_seleccionado == false)
                        {
                            boton_meta_seleccionado = true;
                            this.meta = new Nodo(boton_matriz_seleccionado.getXpos(), boton_matriz_seleccionado.getYpos());
                            boton_matriz_seleccionado.setTipo(TipoBoton.META);
                        }
                        
                        break;

                    case "Prohibidas":
                        // Si la casilla no es una casilla prohibida.
                        if(boton_matriz_seleccionado.getTipo().compareTo(TipoBoton.PROHIBIDA) != 0)
                        {
                            this.listaNodosProhibidos.add(new Nodo(boton_matriz_seleccionado.getXpos(),boton_matriz_seleccionado.getYpos()));
                            boton_matriz_seleccionado.setTipo(TipoBoton.PROHIBIDA);
                        }
                        break;

                    case "Restrictivas":
                       
                        if(boton_matriz_seleccionado.getTipo().compareTo(TipoBoton.RESTRICTIVA) != 0)
                        {
                            this.listaNodosRestrictivos.add(new Nodo(boton_matriz_seleccionado.getXpos(),boton_matriz_seleccionado.getYpos()));
                            boton_matriz_seleccionado.setTipo(TipoBoton.RESTRICTIVA);
                        }
                        break;
                        
                    case "Borrar":
                            switch(boton_matriz_seleccionado.getTipo())
                            {
                                case INICIO:
                                    borrarRecorrido();
                                    inicio = null;
                                    boton_inicio_seleccionado = false;
                                break;

                                case META:
                                    borrarRecorrido();
                                    meta = null;
                                    boton_meta_seleccionado = false;
                                break;

                                case PROHIBIDA:
                                    for (int i = 0; i< this.listaNodosProhibidos.size();i++)
                                    {
                                        if (this.listaNodosProhibidos.get(i).getX() == boton_matriz_seleccionado.getXpos() && this.listaNodosProhibidos.get(i).getY() == boton_matriz_seleccionado.getYpos())
                                            this.listaNodosProhibidos.remove(i);
                                    }
                                break;

                                case RESTRICTIVA:
                                    for (int i = 0; i< this.listaNodosRestrictivos.size();i++)
                                    {
                                        if (this.listaNodosRestrictivos.get(i).getX() == boton_matriz_seleccionado.getXpos() && this.listaNodosRestrictivos.get(i).getY() == boton_matriz_seleccionado.getYpos())
                                            this.listaNodosRestrictivos.remove(i);
                                    }
                                break;

                                case WAYPOINT:

                                break;

                                default:

                                break;

                            }
                            
                            boton_matriz_seleccionado.setTipo(TipoBoton.NINGUNO);
                    break;

                       
                    case "Waypoints":  
                        
                    break;
            }
            
            boton_matriz_seleccionado.pintate();
        
        }
    }
    
}
