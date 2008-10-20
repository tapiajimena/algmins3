package punto;

public class Punto {
 
	private int posicionX;
	 
	private int posicionY;
	 
	
	public Punto(){
		this.posicionX=0;
		this.posicionY=0;
	}
	
	public Punto(Punto unPunto){
		this.posicionX=unPunto.posicionX;
		this.posicionY=unPunto.posicionY;
	}
	public Punto(int x, int y){
		this.posicionX=x;
		this.posicionY=y;		
	}
	
	public int getX(){
		return this.posicionX;	
	}
	
	public int getY(){
		return this.posicionY;
	}
	
	public void setX(int x){
		this.posicionX=x;	
	}
	
	public void setY(int y){
		this.posicionY=y;
	}
			 
	public void copiar(Punto punto) {
		this.posicionX=punto.posicionX;
		this.posicionY=punto.posicionY;
	}
	
	public boolean equals(Object otroObjeto){
		boolean salida = false;
        if (otroObjeto != null && otroObjeto instanceof Punto) {
           Punto otroPunto = (Punto)otroObjeto;
           salida  = (this.posicionX == otroPunto.posicionX) && (this.posicionY == otroPunto.posicionY);
        }
        return salida;

	}
	public int distancia(Punto P){
		int maximo=Math.abs(this.posicionY-P.posicionY);
		if(maximo<Math.abs(this.posicionX-P.posicionX))
			maximo=Math.abs(this.posicionX-P.posicionX);
		return maximo;
	}
	
	public Punto puntoRelativo(int x,int y){
		return new Punto(x+this.posicionX,y+this.posicionY);
	}
	 
	//USO INTERNO: Equivalente al toString, solo se usa para ver el punto.
	public void quePuntoEs(){
		System.out.println("("+this.posicionX+","+this.posicionY+")");
	}
}
 
