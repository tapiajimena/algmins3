package punto;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Punto {
 
	private int posicionX;
	private int posicionY;
	
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
	public double distancia(Punto punto){		
	    double distanciaX=this.posicionX-punto.posicionX;
	    double distanciaY=this.posicionY-punto.posicionY;
	    if(distanciaX==0) return Math.abs(distanciaY);
	    if(distanciaY==0) return Math.abs(distanciaX);
	    return Math.pow(Math.pow(distanciaX,2)+ Math.pow(distanciaY,2),1/2);
	}
	
	public Punto puntoRelativo(int x,int y){
		return new Punto(x+this.posicionX,y+this.posicionY);
	}
		
	public void sumar(Punto otroPunto){
		this.setX(this.getX()+otroPunto.getX());
		this.setY(this.getY()+otroPunto.getY());
	}
	 
	public String toString(){
	    return new String("X="+this.posicionX+" Y="+this.posicionY);
	}
	
	public Element serializar(){
		Element elemento=DocumentHelper.createElement("Punto");
		elemento.addAttribute("posicionX",new Integer(posicionX).toString());
		elemento.addAttribute("posicionY",new Integer(posicionY).toString());
		return elemento;
	}
	public void recuperarEstado(Element estadoPunto){
		posicionX=Integer.parseInt(estadoPunto.attributeValue("posicionX"));
		posicionY=Integer.parseInt(estadoPunto.attributeValue("posicionY"));
	}
}
 
