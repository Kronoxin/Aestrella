/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.vista;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author Ruben
 */
public class ToolBar_Entrada extends JToolBar{
    
    private JButton boton_crear = new JButton("Crear");
    private final JLabel label_filas = new JLabel("Filas");
    private final JLabel label_columnas = new JLabel("Columnas");
    private  JTextField txt_filas = new JTextField();
    private  JTextField txt_columnas = new JTextField();
    
     public ToolBar_Entrada(){
         
         boton_crear.setName("Crear");
         
        txt_filas.setPreferredSize(new Dimension(50, 25));
	txt_columnas.setPreferredSize(new Dimension(50, 25));

	this.add(label_filas);
	this.add(txt_filas);
	this.add(label_columnas);
	this.add(txt_columnas);
	this.add(boton_crear);
         
         
     }

    public JTextField getTxt_filas() {
        return txt_filas;
    }

    public void setTxt_filas(JTextField txt_filas) {
        this.txt_filas = txt_filas;
    }

    public JTextField getTxt_columnas() {
        return txt_columnas;
    }

    public void setTxt_columnas(JTextField txt_columnas) {
        this.txt_columnas = txt_columnas;
    }

    public JButton getBoton_crear() {
        return boton_crear;
    }

    public void setBoton_crear(JButton boton_crear) {
        this.boton_crear = boton_crear;
    }
    
}
