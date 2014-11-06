/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import java.util.EventListener;
import java.util.Observer;

/**
 *
 * @author Ruben
 */
public interface InterfazObservadorVista extends Observer {
    
     public void asignarControlador(EventListener controlador);
    
}
