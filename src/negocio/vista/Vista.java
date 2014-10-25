package negocio.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Vista extends JFrame implements ActionListener{
	
	
	private Container contenedorPrincipal;
        
        ToolBar_Entrada entrada_datos = new ToolBar_Entrada();
	
	JPanel panel_menu = new JPanel();
	JPanel panel_matriz_botones = new JPanel();
        
        Boton_Inicio boton_inicio = new Boton_Inicio();
        Boton_Meta boton_meta = new Boton_Meta();
        Boton_Prohibidas boton_prohibidas = new Boton_Prohibidas();
        Boton_Restrictivas boton_restrictivas = new Boton_Restrictivas();
        Boton_Reset boton_reset = new Boton_Reset();
	

	
	
	public Vista(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contenedorPrincipal = new JPanel();
		contenedorPrincipal = this.getContentPane();
		contenedorPrincipal.setLayout(new BorderLayout(0,0));
		setContentPane(contenedorPrincipal);
                this.setLocationRelativeTo(null);
		setVisible(true);
		
		//añador al container, el panel_menu y el panel_matriz_botones
		contenedorPrincipal.add(panel_menu, BorderLayout.NORTH);
		contenedorPrincipal.add(panel_matriz_botones, BorderLayout.CENTER);
		

                //añado el toolbar y le pongo el acionlistener
		panel_menu.add(entrada_datos, BorderLayout.PAGE_START);
                entrada_datos.getBoton_crear().addActionListener(this);
		
		
		//añado los botones Inicio, Meta, Prohibidas y Restrictivas al panel_menu
		panel_menu.add(boton_inicio);
		panel_menu.add(boton_meta);
		panel_menu.add(boton_prohibidas);
		panel_menu.add(boton_restrictivas);
		panel_menu.add(boton_reset);
		
	
		
	}
	
	public void actionPerformed( ActionEvent evt ) {
            //Se obtiene la cantidad de filas a crear como una cadena de caracter
            String f = entrada_datos.getTxt_filas().getText();
 
            //Se obtiene la cantidad de columnas a crear como una cadena de caracter
            String c = entrada_datos.getTxt_columnas().getText();
        
            //Se cambia de cadena de caracteres a numeros
            int filas = Integer.parseInt(f);
            int columnas = Integer.parseInt(c);
		
            //Eliminamos los anteriores botones
            panel_matriz_botones.removeAll();
 
            //Se crea una matriz de botones segun las filas y columnas entrantes
            generarMatrizDeBotones(filas,columnas);
	}
	
	
	public void generarMatrizDeBotones (int filas, int columnas){
            if(filas >0 || columnas >0){
		Boton_Matriz[][] matriz = new Boton_Matriz[filas][columnas];
		
		panel_matriz_botones.setLayout(new GridLayout(filas,columnas));
		
                for(int y=0; y<columnas; y++){ 
                    for(int x=0; x<filas; x++){

                    
                        //Se crea el boton y se agrega a las celda de la matriz
                        matriz[x][y] = new Boton_Matriz();
                    
                        //Se da el nombre en forma de coordenada enviando la fila y columna
                        matriz[x][y].setNombre(x, y);
                    
                        panel_matriz_botones.add(matriz[x][y]); //agrega boton a la grilla
                        panel_matriz_botones.updateUI();
                    }
                }
            }
            else{
                    System.out.println("Filas y columnas deben ser > 0");
            }
	}
	
	public static void main(String[] args) {
            try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex) {
			ex.printStackTrace();
            }
		
		Vista vista = new Vista();
        }

}
