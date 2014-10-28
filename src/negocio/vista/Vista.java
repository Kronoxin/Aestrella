package negocio.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Vista extends JFrame implements ActionListener{
	
	
	private Container contenedorPrincipal;
        

        Panel_Menu panel_menu = new Panel_Menu();
        Panel_Matriz panel_matriz_botones = new Panel_Matriz();
	
	
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
		

                panel_menu.entrada_datos.getBoton_crear().addActionListener(this);
		
		
	}
	
	public void actionPerformed( ActionEvent evt ) {
            
            //Se obtiene la cantidad de filas y columnas a crear
            String f = panel_menu.entrada_datos.getTxt_filas().getText();
            String c = panel_menu.entrada_datos.getTxt_columnas().getText();
        
            //Parseamos el String a Int
            int filas = Integer.parseInt(f);
            int columnas = Integer.parseInt(c);
		

            //generamos la matriz con los datos introducidos
            panel_matriz_botones.generarMatrizDeBotones(filas, columnas);
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
