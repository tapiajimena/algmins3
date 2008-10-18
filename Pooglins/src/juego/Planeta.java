package juego;
import punto.Punto;
import habilidad.Habilidad;
import bloque.Aire;
import bloque.Bloque;

public class Planeta {
 
	private int ancho;
	 
	private int alto;
	 
	private Bloque[][] Terreno;
	 
	private Nivel nivel;
	 
	// private Bloque[] bloque;
	
	@SuppressWarnings("unused")
	private Habilidad habilidad;

	
	Planeta(int alto, int ancho, Bloque[][] terreno ){
		this.alto=(alto);
		this.ancho=(ancho);
		this.Terreno=terreno;
	}
	 
	public void agregarObstaculo(Bloque bloque, int x, int y) {
		
		this.Terreno[bloque.getPosicionX()][bloque.getPosicionY()] = bloque;
		
		//this.Terreno[x][y] = bloque;
	 
	}
	 
	public void quitarObstaculo(int x, int y) {
		Punto punto=new Punto(x,y);
		this.Terreno[x][y] = new Aire(punto);
	}

	public Bloque getBloque(int x, int y){
		return Terreno[x][y];
	}
	
	public void setTerreno(Bloque[][] terreno) {
		Terreno = terreno;
	}

	public Bloque[][] getTerreno() {
		return Terreno;
	}


	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public Nivel getNivel() {
		return nivel;
	}
	 
}