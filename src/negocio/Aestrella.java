/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import java.util.ArrayList;
import negocio.estado.Estado;
import negocio.estado.Nodo;
import negocio.tabla.Tabla;

public class Aestrella 
{
	int campo[][];
        int numeroCasillasCerradas;
	
	private final int sizeX = 10;
	private final int sizeY = 10;
	
	ArrayList<Nodo> casillasProhibidas;
	
	ArrayList<Estado> tabla;
	
	Nodo inicio;
	Nodo meta;
	
	public Aestrella(Nodo inicio, Nodo meta, ArrayList<Nodo> casillasProhibidas)
	{
		campo = new int[sizeX][sizeY];
		
                this.casillasProhibidas = casillasProhibidas;
                tabla = new ArrayList<>();
                numeroCasillasCerradas = 0;
                
		for (Nodo nodo : casillasProhibidas)
			campo[nodo.getX()][nodo.getY()] = -1;
		
		campo[inicio.getX()][inicio.getY()] = 1;
		campo[meta.getX()][meta.getY()] = 2;
		this.inicio = inicio;
		this.meta = meta;
		
	}
        public double distanciaEuclidea(Nodo a, Nodo b)
        {
            return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        }
	
	public void generarPosibles(Tabla tabla, Nodo nodo)
	{
                // Recorro las posiciones adyacentes al nodo.
		for (int fila=Math.max(0, nodo.getX()-1);fila < Math.min(sizeX,nodo.getX()+2);fila++)
		{
			for (int columna=Math.max(0,nodo.getY()-1);columna < Math.min(sizeY,nodo.getY()+2);columna++)
			{
                            if ((nodo.getX() != fila || nodo.getY() != columna )&& campo[fila][columna] >=0)//&& campo[fila][columna] >=0
                            {
                                double disOr,disDest;
                                // Calculamos la distancia desde el nodo actual al padre.
				disOr = distanciaEuclidea(nodo,new Nodo(fila,columna));
                                // Le sumamos la distancia ya recorrida por el padre para tener el recorrido total.
                                disOr += tabla.getEstadoDelNodoPadre(nodo).getDistanciaOrigen();
                                // Calculamos la distancia entre el nodo actual y el nodo final.
				disDest = distanciaEuclidea(new Nodo(fila,columna),meta);
                                
                                
                                // Instanciamos un nuevo estado abierto, con el nodo actual, el nodo padre y las distancias.
				Estado estado = new Estado(true,new Nodo(fila,columna),new Nodo(nodo.getX(),nodo.getY()),disOr,disDest,disOr+disDest);
				// Lo agregamos a la tabla.
                                tabla.getTabla().add(estado);
                            }
			}
		}
	}
	
	
        
        public void recorrer()
	{
		
		
		
	}
        // PRUEBA GITHUB
	
	public static void main(String args[])
	{
                ArrayList<Nodo> casillasProhibidas = new ArrayList<>();
                casillasProhibidas.add(new Nodo(4,4));
                casillasProhibidas.add(new Nodo(4,5));
                casillasProhibidas.add(new Nodo(4,6));
                casillasProhibidas.add(new Nodo(4,7));
                
		Aestrella prueba = new Aestrella(new Nodo(3,4),new Nodo(6,6),casillasProhibidas);
		Tabla tabla = new Tabla();
		
		prueba.generarPosibles(tabla, new Nodo(3,4));
		
		System.out.println();
	}
	
	
	
}
