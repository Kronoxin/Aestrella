/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

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
        Boton_Borrar boton_borrar = new Boton_Borrar();
        
        public Panel_Menu(){
            
            //Añado el toolbar
            this.add(entrada_datos, BorderLayout.PAGE_START);
            
            //añado los botones Inicio, Meta, Prohibidas y Restrictivas al panel_menu
            
            this.add(boton_inicio);
            this.add(boton_meta);
            this.add(boton_prohibidas);
            this.add(boton_restrictivas);
            this.add(boton_borrar);
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
       boton_borrar.addActionListener((ActionListener)controlador);
       
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ToolBar_Entrada getEntrada_datos() {
        return entrada_datos;
    }

    public void setEntrada_datos(ToolBar_Entrada entrada_datos) {
        this.entrada_datos = entrada_datos;
    }

    public Boton_Inicio getBoton_inicio() {
        return boton_inicio;
    }

    public void setBoton_inicio(Boton_Inicio boton_inicio) {
        this.boton_inicio = boton_inicio;
    }

    public Boton_Meta getBoton_meta() {
        return boton_meta;
    }

    public void setBoton_meta(Boton_Meta boton_meta) {
        this.boton_meta = boton_meta;
    }

    public Boton_Prohibidas getBoton_prohibidas() {
        return boton_prohibidas;
    }

    public void setBoton_prohibidas(Boton_Prohibidas boton_prohibidas) {
        this.boton_prohibidas = boton_prohibidas;
    }

    public Boton_Restrictivas getBoton_restrictivas() {
        return boton_restrictivas;
    }

    public void setBoton_restrictivas(Boton_Restrictivas boton_restrictivas) {
        this.boton_restrictivas = boton_restrictivas;
    }

    public Boton_Reset getBoton_reset() {
        return boton_reset;
    }

    public void setBoton_reset(Boton_Reset boton_reset) {
        this.boton_reset = boton_reset;
    }

    public Boton_Empezar getBoton_empezar() {
        return boton_empezar;
    }

    public void setBoton_empezar(Boton_Empezar boton_empezar) {
        this.boton_empezar = boton_empezar;
    }

    public void setBoton_borrar(Boton_Borrar boton_borrar) {
        this.boton_borrar = boton_borrar;
    }
    
     
    
    
    
    
    
}
