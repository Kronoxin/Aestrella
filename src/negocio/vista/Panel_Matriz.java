/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.vista;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Ruben
 */
public class Panel_Matriz extends JPanel{
    

    public Panel_Matriz(){
        super();
    }
    
    
    public void generarMatrizDeBotones (int filas, int columnas){
        this.removeAll();
        
            if(filas >0 && columnas >0){
		Boton_Matriz[][] matriz = new Boton_Matriz[filas][columnas];
		
		this.setLayout(new GridLayout(filas,columnas));
                
              //Recorrido que debe hacer el for para invertir la matriz de la forma que queremos
                
                for(int x=filas-1; x>=0; x--){ 
                    for(int y=0; y<columnas; y++){
                      
                    
                        //Se crea el boton y se agrega a las celda de la matriz
                        matriz[x][y] = new Boton_Matriz();
                    
                        //Se da el nombre en forma de coordenada enviando la fila y columna
                        matriz[x][y].setNombre(x, y);
                        
                        
                        this.add(matriz[x][y]); //agrega boton a la matriz ("grila")
                        this.updateUI();
                    }
                }
            }
            else{
                this.updateUI();
                System.out.println("Filas y columnas deben ser > 0");
            }
    }
    
}
