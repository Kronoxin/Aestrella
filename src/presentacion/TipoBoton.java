/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Color;

/**
 *
 * @author Krnx
 */
public enum TipoBoton 
{
    INICIO,META,PROHIBIDA,RESTRICTIVA,WAYPOINT, NINGUNO;
    
    public static Color getColorFondo(TipoBoton tipo)
    {
        Color color = null;
        
        switch(tipo)
        {
            case INICIO:
                color = Color.YELLOW;
            break;
                
            case META:
                color = Color.GREEN;
            break;
                
            case PROHIBIDA:
                color = Color.BLACK;
            break;
                
            case RESTRICTIVA:
                color = Color.GRAY;
            break;
                
            case WAYPOINT:
                color = Color.PINK;
            break;
        }
        
        return color;
    }
    
    public static Color getColorTexto(TipoBoton tipo)
    {
        Color color = null;
        
        switch(tipo)
        {
            case PROHIBIDA:
                color = Color.WHITE;
            break;
        }
        
        return color;
    }
}
