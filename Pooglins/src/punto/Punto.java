package punto;



public class Punto {
 
	private int posicionx;
	 
	private int posiciony;
	 
	
	public Punto(){
		this.posicionx=0;
		this.posiciony=0;
	}
	
	public Punto(int x, int y){
		this.posicionx=x;
		this.posiciony=y;		
	}
	
	public int getx(){
		return this.posicionx;	
	}
	
	public int getY(){
		return this.posiciony;
	}
	
	public void setx(int x){
		this.posicionx=x;	
	}
	
	public void sety(int y){
		this.posiciony=y;
	}
	 
	public void copiar(Punto punto) {
		this.posicionx=punto.posicionx;
		this.posiciony=punto.posiciony;
	}
	
	public boolean equals(Object otroObjeto){
		//poner el codigo que siempre va aca 
		//comparar los x y los y
		return true;
	}
	
	 
}
 
