package negocio.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



//COMENTARIO RIDICULO PARA PROBAR EL GITHUB
//hola, otro comentario buenooo!
//Y OTROOOO


public class Vista extends JFrame implements ActionListener{
	
	
	private Container contenedorPrincipal;
	
	JToolBar entrada_datos = new JToolBar();
	JLabel label_filas = new JLabel("Filas");
	JLabel label_columnas = new JLabel("Columnas");
	JTextField txt_filas = new JTextField();
	JTextField txt_columnas = new JTextField();
	JButton boton_crear = new JButton("Crear");
	
	
	JPanel panel_menu = new JPanel();
	JPanel panel_matriz_botones = new JPanel();
	
	JButton boton_inicio = new JButton("Inicio");
	JButton boton_meta = new JButton("Meta");
	JButton boton_prohibidas = new JButton("Prohibidas"); 
	JButton boton_restrictivas = new JButton("Restrictivas");
	JButton boton_reset = new JButton("Reset");
	
	
//	private int filas = 5;
//	private int columnas = 5;
//	Boton_Matriz[][] matriz = new Boton_Matriz[filas][columnas];
	
	
	public Vista(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contenedorPrincipal = new JPanel();
		contenedorPrincipal = this.getContentPane();
		contenedorPrincipal.setLayout(new BorderLayout(0,0));
		setContentPane(contenedorPrincipal);
		setVisible(true);
		
		//añador al container, el panel_menu y el panel_matriz_botones
		contenedorPrincipal.add(panel_menu, BorderLayout.NORTH);
		contenedorPrincipal.add(panel_matriz_botones, BorderLayout.CENTER);
		
		//toolbar de entrada
		txt_filas.setPreferredSize(new Dimension(50, 25));
		txt_columnas.setPreferredSize(new Dimension(50, 25));
		boton_crear.addActionListener(this);
		boton_reset.addActionListener(this);
		entrada_datos.add(label_filas);
		entrada_datos.add(txt_filas);
		entrada_datos.add(label_columnas);
		entrada_datos.add(txt_columnas);
		entrada_datos.add(boton_crear);
		
		panel_menu.add(entrada_datos, BorderLayout.PAGE_START);
		
		
		//añado los botones Inicio, Meta, Prohibidas y Restrictivas al panel_menu
		boton_inicio.setBackground(Color.YELLOW);
		boton_inicio.setForeground(Color.BLACK);
		panel_menu.add(boton_inicio);
		
		boton_meta.setBackground(Color.GREEN);
		panel_menu.add(boton_meta);
		
		boton_prohibidas.setBackground(Color.BLACK);
		boton_prohibidas.setForeground(Color.WHITE);
		panel_menu.add(boton_prohibidas);
		
		boton_restrictivas.setBackground(Color.GRAY);
		panel_menu.add(boton_restrictivas);
		
		boton_reset.setBackground(Color.WHITE);
		boton_reset.setForeground(Color.RED);
		panel_menu.add(boton_reset);
		
	
		
	}
	
	public void actionPerformed( ActionEvent evt ) {
            //Se obtiene la cantidad de filas a crear como una cadena de caracter
            String f = txt_filas.getText();
 
            //Se obtiene la cantidad de columnas a crear como una cadena de caracter
            String c = txt_columnas.getText();
        
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
                        this.setLocationRelativeTo(null); //posicion en el centro de la pantalla
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
