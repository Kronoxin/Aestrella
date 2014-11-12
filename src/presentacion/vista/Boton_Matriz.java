package presentacion.vista;



import javax.swing.JButton;
import presentacion.TipoBoton;


public class Boton_Matriz extends JButton
{
	
        private int x,y;
        
        private TipoBoton tipo = TipoBoton.NINGUNO;
        
	public Boton_Matriz()
        {
		
            setName("Matriz");
		
	}
	public void setNombre( int x, int y )
        {
            setText("("+x+","+y+")");
            this.x = x;
            this.y = y;
        }
       
        public int getXpos()
        {
            return this.x;
        }
        public int getYpos()
        {
            return this.y;
        }

        public TipoBoton getTipo() 
        {
            return tipo;
        }

        public void setTipo(TipoBoton tipo) 
        {
            this.tipo = tipo;
        }
    
        
}
