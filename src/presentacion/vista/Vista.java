package presentacion.vista;

import java.awt.*;
import javax.swing.*;
import presentacion.controlador.Controlador;



public class Vista extends JFrame{
	
	
	private Container contenedorPrincipal;
        

        Panel_Menu panel_menu = new Panel_Menu();
        Panel_Matriz panel_matriz_botones = new Panel_Matriz();
	
	
	public Vista(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contenedorPrincipal = new JPanel();
		contenedorPrincipal = this.getContentPane();
		contenedorPrincipal.setLayout(new BorderLayout(0,0));
		setContentPane(contenedorPrincipal);
                this.setLocationRelativeTo(null);
		setVisible(true);
		
		//añador al container, el panel_menu y el panel_matriz_botones
		contenedorPrincipal.add(panel_menu, BorderLayout.NORTH);
		contenedorPrincipal.add(panel_matriz_botones, BorderLayout.CENTER);
		
	}

	

	public static void main(String[] args) {
            try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex) {
			ex.printStackTrace();
            }
            Controlador c = new Controlador();
	
        }

        
    public Panel_Menu getPanel_menu() {
        return panel_menu;
    }

    public void setPanel_menu(Panel_Menu panel_menu) {
        this.panel_menu = panel_menu;
    }

    public Panel_Matriz getPanel_matriz_botones() {
        return panel_matriz_botones;
    }

    public void setPanel_matriz_botones(Panel_Matriz panel_matriz_botones) {
        this.panel_matriz_botones = panel_matriz_botones;
    }
}
