package negocio.vista;



import javax.swing.JButton;


public class Boton_Matriz extends JButton{
	
	public Boton_Matriz(){
		
            setName("Matriz");
		
	}
	public void setNombre( int x, int y ){
        setText("("+x+","+y+")");
    }

}
