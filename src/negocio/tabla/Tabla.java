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
            if (estado.getNodoPadre().equals(nodoPadre))
                hijos.add(estado);
        }
        
        return hijos;
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

    public ArrayList<Estado> getTabla() 
    {
        return tabla;
    }

    public void setTabla(ArrayList<Estado> tabla) 
    {
        this.tabla = tabla;
    }
    
    
}
