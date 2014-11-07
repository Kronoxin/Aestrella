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
	
	private int sizeX;
	private int sizeY;
	
	ArrayList<Nodo> casillasProhibidas;
	
	Tabla tabla;
	
	Nodo inicio;
	Nodo meta;
	
	public Aestrella(Nodo inicio, Nodo meta, ArrayList<Nodo> casillasProhibidas,int sizeX,int sizeY)
	{
                this.sizeX = sizeX;
                this.sizeY = sizeY;
                
		campo = new int[sizeX][sizeY];
		
                this.casillasProhibidas = casillasProhibidas;
                tabla = new Tabla();
                numeroCasillasCerradas = 0;
                
		for (Nodo nodo : casillasProhibidas)
                {
			campo[nodo.getX()][nodo.getY()] = -1;
                        numeroCasillasCerradas++;
                }
		
		campo[inicio.getX()][inicio.getY()] = 1;
		campo[meta.getX()][meta.getY()] = 2;
		this.inicio = inicio;
		this.meta = meta;
                // Incrementamos una casilla cerrada para contabilizar la meta
                numeroCasillasCerradas++;
		
	}
        public double distanciaEuclidea(Nodo a, Nodo b)
        {
            return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        }
	
	public void generarPosibles(Nodo nodo)
	{
            Nodo nodoNuevo;
                // Recorro las posiciones adyacentes al nodo.
		for (int fila=Math.max(0, nodo.getX()-1);fila < Math.min(sizeX,nodo.getX()+2);fila++)
		{
			for (int columna=Math.max(0,nodo.getY()-1);columna < Math.min(sizeY,nodo.getY()+2);columna++)
			{
                            if ((nodo.getX() != fila || nodo.getY() != columna )&& campo[fila][columna] >=0)//&& campo[fila][columna] >=0
                            {
                                nodoNuevo = new Nodo(fila,columna);
                                
                                // Si no existe ya en la tabla el nodo Nuevo, se inserta.
                                if (tabla.getEstadoDelNodo(nodoNuevo) == null)
                                {
                                    double disOr,disDest;
                                    // Calculamos la distancia desde el nodo actual al padre.
                                    disOr = distanciaEuclidea(nodo,nodoNuevo);
                                    // Le sumamos la distancia ya recorrida por el padre para tener el recorrido total.
                                    disOr += this.tabla.getEstadoDelNodo(nodo).getDistanciaOrigen();
                                    // Calculamos la distancia entre el nodo actual y el nodo final.
                                    disDest = distanciaEuclidea(nodoNuevo,meta);


                                    // Instanciamos un nuevo estado abierto, con el nodo actual, el nodo padre y las distancias.
                                    Estado estado = new Estado(true,new Nodo(fila,columna),new Nodo(nodo.getX(),nodo.getY()),disOr,disDest,disOr+disDest);
                                    // Lo agregamos a la tabla.
                                    tabla.getTabla().add(estado);
                                }
                            }
			}
		}
	}
	
        private Estado devolverEstadoAbierto(ArrayList<Estado> listaEstados)
        {
            Estado estado = null;
            int i = 0;
            
            while(i != listaEstados.size() && estado == null)
            {
                if (listaEstados.get(i).isEstaAbierto())
                    estado = listaEstados.get(i);
                i++;
            }
            
            return estado;
        }
	
        public Nodo seleccionarNodoOptimo(Nodo nodoOrigen)
        {
            double fmin = 0;
            Nodo nodoOptimo = null;
            ArrayList<Estado> listaHijos = new ArrayList<>();
            listaHijos = tabla.getHijosDelNodo(nodoOrigen);
            
            Estado primerEstado = devolverEstadoAbierto(listaHijos);
            
            if (primerEstado != null)
            {
                fmin = primerEstado.getDistanciaTotal();
                nodoOptimo = primerEstado.getNodoActual();
                
                for (Estado estadoActual : tabla.getHijosDelNodo(nodoOrigen))
                {
                    if (estadoActual.isEstaAbierto() && estadoActual.getDistanciaTotal() < fmin)
                    {
                        nodoOptimo = estadoActual.getNodoActual();
                        fmin = estadoActual.getDistanciaTotal();
                    }
                
                 }
            }
            return nodoOptimo;
            
        }
        public ArrayList<Nodo> invertirLista(ArrayList<Nodo> lista)
        {
            Nodo temp;
            for (int i = 0; i < lista.size()/2; i++)
            {
                temp = lista.get(i);
                lista.set(i, lista.get(lista.size() - i -1));
                lista.set(lista.size() - i -1, temp);
            }
            return lista;
        }
        
        public ArrayList<Nodo> recorrer()
	{
		Estado estado = new Estado(false,inicio,inicio,0,distanciaEuclidea(inicio,meta),distanciaEuclidea(inicio,meta));
                
                this.tabla.getTabla().add(estado);
                
                numeroCasillasCerradas++;
                
                Nodo nodoActual = inicio;
                Nodo nodoTemp;
                ArrayList<Nodo> caminoElegido = null;
                
                generarPosibles(nodoActual);
                
                while((numeroCasillasCerradas != sizeX*sizeY) && !nodoActual.equals(meta))
                {  
                    
                    nodoTemp = seleccionarNodoOptimo(nodoActual);
                    
                    // No se puede escoger ningun hijo de este nodo
                    if (nodoTemp == null)
                    {// Cogemos el nodo padre
                        nodoActual = tabla.getEstadoDelNodo(nodoActual).getNodoPadre();
                    }
                    else
                    {
                        nodoActual = nodoTemp;
                        tabla.getEstadoDelNodo(nodoActual).setEstaAbierto(false);
                        numeroCasillasCerradas++;
                        generarPosibles(nodoActual);
                    }
                }
                if (nodoActual.equals(meta))
                {
                    caminoElegido = tabla.getRecorridoDelNodo(nodoActual);
                    caminoElegido = invertirLista(caminoElegido);
                }
                
                if(numeroCasillasCerradas == sizeX*sizeY)
                    System.out.println("NO ENCONTRE LA META");
		return caminoElegido;
		
	}
}
