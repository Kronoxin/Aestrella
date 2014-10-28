/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Ruben
 */
public class Panel_Menu extends JPanel{
    
        ToolBar_Entrada entrada_datos = new ToolBar_Entrada();
        Boton_Inicio boton_inicio = new Boton_Inicio();
        Boton_Meta boton_meta = new Boton_Meta();
        Boton_Prohibidas boton_prohibidas = new Boton_Prohibidas();
        Boton_Restrictivas boton_restrictivas = new Boton_Restrictivas();
        Boton_Reset boton_reset = new Boton_Reset();
        
        public Panel_Menu(){
            
            //Añado el toolbar
            this.add(entrada_datos, BorderLayout.PAGE_START);
            
            //añado los botones Inicio, Meta, Prohibidas y Restrictivas al panel_menu
            this.add(boton_inicio);
            this.add(boton_meta);
            this.add(boton_prohibidas);
            this.add(boton_restrictivas);
            this.add(boton_reset);
        }
    
    
    
}
