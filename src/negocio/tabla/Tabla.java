/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.tabla;
import java.util.ArrayList;
import negocio.estado.Estado;
import negocio.estado.Nodo;

/**
 *
 * @author Krnx
 */
public class Tabla 
{
    private ArrayList<Estado> tabla;
    
    public Tabla()
    {
        tabla = new ArrayList<>();
    }
    
    public ArrayList<Estado> getHijosDelNodo(Nodo nodoPadre) 
    {
        ArrayList<Estado> hijos = new ArrayList<>();
        
        for (Estado estado : tabla)
        {
            if (estado.getNodoPadre().equals(nodoPadre) && !estado.getNodoActual().equals(nodoPadre))
                hijos.add(estado);
        }
        
        return hijos;
    }
    
    public ArrayList<Nodo> getRecorridoDelNodo(Nodo nodo) 
    {
        Nodo nodoActual = nodo;
        ArrayList<Nodo> recorrido = new ArrayList<>();
        Estado estadoNodoActual = getEstadoDelNodo(nodoActual);
        boolean continuar = true;
        
        while(!estadoNodoActual.getNodoActual().equals(estadoNodoActual.getNodoPadre()))
        {
            recorrido.add(nodoActual);
            nodoActual = estadoNodoActual.getNodoPadre();
            estadoNodoActual = getEstadoDelNodo(nodoActual);
        }
        if(estadoNodoActual.getNodoActual().equals(estadoNodoActual.getNodoPadre()))
            recorrido.add(nodoActual);
        
        return recorrido;
    }
    
    public Estado getEstadoDelNodo(Nodo nodoABuscar)
    {
        Estado estadoDevolver = null;
        
        for (Estado estado : tabla)
        {
            if (estado.getNodoActual().equals(nodoABuscar))
                estadoDevolver = estado;
        }
        return estadoDevolver;
    }
    
    public boolean todosEstadosCerrados()
    {
        int nEstadosCerrados = 0;
        for (Estado estado : this.tabla)
            if (!estado.isEstaAbierto())
                nEstadosCerrados++;
        
        return nEstadosCerrados == this.tabla.size();
    }
    
    public ArrayList<Estado> getEstadosAbiertos()
    {
        ArrayList<Estado> abiertos = new ArrayList<>();
        
        for (Estado estado : tabla)
        {
            if (estado.isEstaAbierto())
                abiertos.add(estado);
        }
        
        return abiertos;
    }

    public ArrayList<Estado> getTabla() 
    {
        return tabla;
    }

    public void setTabla(ArrayList<Estado> tabla) 
    {
        this.tabla = tabla;
    }
    
    
}
