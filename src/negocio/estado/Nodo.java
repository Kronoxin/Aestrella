/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.estado;

public class Nodo 
{
	private int x;
	private int y;
	
	
	public Nodo(int x, int y) 
	{
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
        public boolean equals(Nodo a)
        {
            return a.getX() == this.getX() && a.getY() == this.getY();
        }
	
	
}
