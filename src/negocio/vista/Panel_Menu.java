/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Observable;
import javax.swing.JPanel;

/**
 *
 * @author Ruben
 */
public class Panel_Menu extends JPanel implements InterfazObservadorVista{
    
        ToolBar_Entrada entrada_datos = new ToolBar_Entrada();
        Boton_Inicio boton_inicio = new Boton_Inicio();
        Boton_Meta boton_meta = new Boton_Meta();
        Boton_Prohibidas boton_prohibidas = new Boton_Prohibidas();
        Boton_Restrictivas boton_restrictivas = new Boton_Restrictivas();
        Boton_Reset boton_reset = new Boton_Reset();
        Boton_Empezar boton_empezar = new Boton_Empezar();
        
        public Panel_Menu(){
            
            //Añado el toolbar
            this.add(entrada_datos, BorderLayout.PAGE_START);
            
            //añado los botones Inicio, Meta, Prohibidas y Restrictivas al panel_menu
            
            this.add(boton_inicio);
            this.add(boton_meta);
            this.add(boton_prohibidas);
            this.add(boton_restrictivas);
            this.add(boton_reset);
            this.add(boton_empezar);
        }

    @Override
    public void asignarControlador(EventListener controlador) {
       boton_inicio.addActionListener((ActionListener)controlador); //agregamos el ActionListener al boton_inicio
       boton_meta.addActionListener((ActionListener)controlador);   //ActionListener del boton_meta
       boton_prohibidas.addActionListener((ActionListener)controlador);     //ActionListener del boton_prohibidas
       boton_restrictivas.addActionListener((ActionListener)controlador);   //del boton_restrictivas
       boton_reset.addActionListener((ActionListener)controlador);          //actionlistener de boton_reset
       boton_empezar.addActionListener((ActionListener)controlador);        //actionlistener de boton_empezar
       entrada_datos.getBoton_crear().addActionListener((ActionListener)controlador);   //actionlistener boton_crear
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
