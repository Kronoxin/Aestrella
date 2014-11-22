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
        ArrayList<Nodo> waypoints;
	
	Tabla tabla;
	
	Nodo inicio;
	Nodo meta;
        Nodo metaActual;
	
	public Aestrella(Nodo inicio, Nodo meta, ArrayList<Nodo> casillasProhibidas,ArrayList<Nodo> casillasRestrictivas,ArrayList<Nodo> waypoints, int sizeX,int sizeY)
	{
                this.sizeX = sizeX;
                this.sizeY = sizeY;
                
		campo = new int[sizeX][sizeY];
                this.waypoints = waypoints;
		
                this.casillasProhibidas = casillasProhibidas;
                tabla = new Tabla();
                numeroCasillasCerradas = 0;
                
		for (Nodo nodo : casillasProhibidas)
                {
			campo[nodo.getX()][nodo.getY()] = -1;
                        numeroCasillasCerradas++;
                }
                
                for (Nodo nodo : casillasRestrictivas)
                {
                    campo[nodo.getX()][nodo.getY()] = nodo.getValor();
                }
		
		campo[inicio.getX()][inicio.getY()] = 1;
		campo[meta.getX()][meta.getY()] = 2;
		this.inicio = inicio;
		this.meta = meta;
		
	}
        public double distanciaEuclidea(Nodo a, Nodo b)
        {
            return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        }
	
	public void generarPosibles(Nodo nodo, Nodo metaActual)
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
                                        disDest = distanciaEuclidea(nodoNuevo,metaActual) + campo[nodoNuevo.getX()][nodoNuevo.getY()];


                                        // Instanciamos un nuevo estado abierto, con el nodo actual, el nodo padre y las distancias.
                                        Estado estado = new Estado(true,new Nodo(fila,columna),new Nodo(nodo.getX(),nodo.getY()),disOr,disDest,disOr+disDest);
                                        // Lo agregamos a la tabla.
                                        if (!(nodoNuevo.equals(meta) && !metaActual.equals(meta)))
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
	// Seleccionar el mejor de los estados abiertos.
        
        public Nodo seleccionarNodoOptimo(Nodo nodoOrigen)
        {
            double fmin = 0;
            Nodo nodoOptimo = null;
            ArrayList<Estado> listaAbiertos = new ArrayList<>();
            // Cambiar
            listaAbiertos = tabla.getEstadosAbiertos();
            
            Estado primerEstado = devolverEstadoAbierto(listaAbiertos);
            
            if (primerEstado != null)
            {
                fmin = primerEstado.getDistanciaTotal();
                nodoOptimo = primerEstado.getNodoActual();
                
                for (Estado estadoActual : listaAbiertos)
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
            
                //this.waypoints.add(meta);
		
                Estado estado;
               
                
                Nodo nodoActual = inicio;
                Nodo nodoTemp;
                ArrayList<Nodo> caminoElegido = new ArrayList<>();
                Nodo metaAnterior = null;
                
                
                
                for (Nodo metaActual: this.waypoints)
                {
                    if (metaAnterior != null)
                        inicio = metaAnterior;
                    
                    estado = new Estado(false,inicio,inicio,0,distanciaEuclidea(inicio,metaActual),distanciaEuclidea(inicio,metaActual));
                    this.tabla.getTabla().add(estado);
                    
            
                    generarPosibles(nodoActual,metaActual);
                    
                    
                    while(!tabla.todosEstadosCerrados() && !nodoActual.equals(metaActual))
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
                            generarPosibles(nodoActual,metaActual);
                        }
                    }
                
                    if (nodoActual.equals(metaActual))
                    {
                        for (Nodo nodoAdd: invertirLista(tabla.getRecorridoDelNodo(nodoActual)))
                            caminoElegido.add(nodoAdd);
                        
                        ArrayList<Estado> estadosYaCerrados = tabla.getEstadosDeListaDeNodos(caminoElegido);
                        
                        this.tabla = new Tabla();
                        this.tabla.setTabla(estadosYaCerrados);
                        metaAnterior = new Nodo(metaActual);
                        
                    }                                 
                }
                
                return caminoElegido;		
	}
}
