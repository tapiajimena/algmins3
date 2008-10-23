package juego;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import punto.Punto;
import bloque.AgujeroNegro;
import bloque.Aire;
import bloque.Bloque;
import bloque.Fuego;
import bloque.Hielo;
import bloque.NaveDePartida;
import bloque.PuertaDeEscape;
import bloque.Roca;
import bloque.Tierra;


public class Planeta {
	private int ancho;
	private int alto;
	private Bloque[][] terreno;
	/*Devuelve el bloque representado por el caracter,lo inicializa en el punto dado
	 * MUY FEO CAMBIARLO MAS ADELANTE
	*/
	private Bloque transformarABloque(char caracter,Punto punto){
		Bloque bloque;
		switch(caracter){
			case 'A' :/*Aire*/bloque=new Aire(punto);break;
			case 'T' :/*Tierra*/bloque=new Tierra(punto);break;
			case 'R' :/*Roca*/bloque=new Roca(punto);break;
			case 'F' :/*Fuego*/bloque=new Fuego(punto);break;
			case 'O' :/*HoyoNegro*/bloque=new AgujeroNegro(punto);break;
			case 'H' :/*Hielo*/bloque=new Hielo(punto);break;
			case 'P' :/*NavePartida*/bloque=new NaveDePartida(punto);break;
			case 'E' :/*NaveEntrada*/bloque=new PuertaDeEscape(punto);break;
			case 'B' :/*TunelElectromagentico(Bridge)*/bloque=new PuertaDeEscape(punto);break;
			default : bloque=new Aire(punto);
		}
		return bloque;
	}
	/*carga el terreno de una archivo MUY PRECARIAMENTE, 
	PUEDE TIRAR ERROR SI EL ARCHIVO NO ESTA BIEN CARGADO*/
	public Planeta(String archivoTerreno,int ancho,int alto) throws IOException{
		this.alto=alto;
		this.ancho=ancho;
		this.terreno=new Bloque[alto][ancho];
		BufferedReader inputStream = null;
        String linea;
        inputStream = new BufferedReader(new FileReader(archivoTerreno));
        for(int i=0;((linea = inputStream.readLine())!= null)&&(i<alto) ;i++){
        	for(int j=0;j<ancho;j++){
        		terreno[i][j]=transformarABloque(linea.charAt(j),new Punto(i,j));
        	}
        }
        inputStream.close();
	}
	
	public Planeta(int alto, int ancho, Bloque[][] terreno ){
		this.alto=(alto);
		this.ancho=(ancho);
		this.terreno=terreno;
	}
		
	public Planeta(int alto, int ancho, char[][] terreno ){
		this.alto=alto;
		this.ancho=ancho;
		this.terreno=new Bloque[alto][ancho];
		
        for(int i=0;i<alto;i++){
        	for(int j=0;j<ancho;j++){
        		
        		this.terreno[i][j]=transformarABloque(terreno[i][j],new Punto(i,j));
        	}
        }
     
		
	}
	
	public void agregarObstaculo(Bloque bloque) {
		this.terreno[bloque.getPosicionX()][bloque.getPosicionY()] = bloque;	 
	}
	
	public void quitarObstaculo(Punto punto) {
	    if(punto.getX()<this.alto && punto.getY()<this.ancho)
	    	this.terreno[punto.getX()][punto.getY()] = new Aire(punto);
	}
	
	public Bloque getBloque(Punto punto){
	    	if(punto.getX()<this.alto && punto.getY()<this.ancho)
	    	    return terreno[punto.getX()][punto.getY()];
	    	return null;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}	
	
}