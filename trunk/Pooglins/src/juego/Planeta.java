package juego;

import java.lang.reflect.Constructor;
import java.util.Iterator;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import punto.Punto;
import bloque.AgujeroNegro;
import bloque.Aire;
import bloque.Bloque;
import bloque.Entrada;
import bloque.Fuego;
import bloque.Hielo;
import bloque.Roca;
import bloque.Salida;
import bloque.Tierra;
import bloque.Tunel;

public class Planeta {
	private int ancho;
	private int alto;
	private Bloque[][] terreno;
	private char[][] CTerreno;

	/*
	 * Devuelve el bloque representado por el caracter,lo inicializa en el punto
	 * dado MUY FEO CAMBIARLO MAS ADELANTE
	 */
	private Bloque transformarABloque(char caracter, Punto punto) {
		Bloque bloque;
		switch (caracter) {
		case 'A':/* Aire */
			bloque = new Aire(punto);
			break;
		case 'T':/* Tierra */
			bloque = new Tierra(punto);
			break;
		case 'R':/* Roca */
			bloque = new Roca(punto);
			break;
		case 'F':/* Fuego */
			bloque = new Fuego(punto);
			break;
		case 'O':/* HoyoNegro */
			bloque = new AgujeroNegro(punto);
			break;
		case 'H':/* Hielo */
			bloque = new Hielo(punto);
			break;
		case 'E':/* Entrada */
			bloque = new Entrada(punto);
			break;
		case 'S':/* Salida */
			bloque = new Salida(punto);
			break;
		case 'B':/* TunelElectromagentico(Bridge) */
			bloque = new Tunel(punto);
			break;
		default:
			bloque = new Aire(punto);
		}
		return bloque;
	}

	/*
	 * AGREGADO Este metodo va actualizando una matriz de char a partir de la
	 * matriz de bloques
	 */

	/*
	 * public char transformarBloqueAMatriz(Bloque unBloque){
	 * 
	 * char aux;
	 * 
	 * switch(unBloque.getLetra()){ case 'A' :Aire aux='A' ;break; case 'T'
	 * :Tierraaux= 'T' ;break; case 'R' :Rocaaux= 'R' ;break; case 'F'
	 * :Fuegoaux= 'F' ;break; case 'O' :HoyoNegroaux= 'O' ;break; case 'H'
	 * :Hieloaux= 'H' ;break; case 'E' :Entradaaux= 'E' ;break; case 'S'
	 * :Salidaaux= 'S' ;break; case 'B' :TunelElectromagentico(Bridge)aux= 'B'
	 * ;break; default : return 'A' ; } return aux;
	 * 
	 * }
	 */
	public char[][] bloqueAmatriz() {
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				this.CTerreno[i][j] = terreno[i][j].getLetra();
			}
		}
		return CTerreno;
	}

	/*
	 * carga el terreno de una archivo MUY PRECARIAMENTE, PUEDE TIRAR ERROR SI
	 * EL ARCHIVO NO ESTA BIEN CARGADO public Planeta(String archivoTerreno,int
	 * ancho,int alto) throws IOException{ this.alto=alto; this.ancho=ancho;
	 * this.terreno=new Bloque[alto][ancho]; BufferedReader inputStream = null;
	 * String linea; inputStream = new BufferedReader(new
	 * FileReader(archivoTerreno)); for(int i=0;((linea =
	 * inputStream.readLine())!= null)&&(i<alto) ;i++){ for(int
	 * j=0;j<ancho;j++){ terreno[i][j]=transformarABloque(linea.charAt(j),new
	 * Punto(i,j)); } } inputStream.close(); }
	 */

	public Planeta(int alto, int ancho, Bloque[][] terreno) {
		this.alto = (alto);
		this.ancho = (ancho);
		this.terreno = terreno;
	}

	public Planeta(int alto, int ancho, char[][] terreno) {
		this.alto = alto;
		this.ancho = ancho;
		this.terreno = new Bloque[alto][ancho];
		this.CTerreno = terreno;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {

				this.terreno[i][j] = transformarABloque(terreno[i][j],
						new Punto(i, j));
			}
		}

	}

	public void agregarObstaculo(Bloque bloque) {
		if (bloque.getPosicion().getX() < this.alto
				&& bloque.getPosicion().getY() < this.ancho)
			this.terreno[bloque.getPosicionX()][bloque.getPosicionY()] = bloque;
	}

	public void quitarObstaculo(Punto punto) {
		if (punto.getX() < this.alto && punto.getY() < this.ancho) {
			if (this.terreno[punto.getX()][punto.getY()] != null) {
				this.terreno[punto.getX()][punto.getY()].destruir();
				this.terreno[punto.getX()][punto.getY()] = new Aire(punto);
			}
		}
	}

	public Bloque getBloque(Punto punto) {
		if (punto.getX() < this.alto && punto.getY() < this.ancho)
			return terreno[punto.getX()][punto.getY()];
		return new Roca(punto);
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public char[][] getCTerreno() {
		return this.bloqueAmatriz();
	}

	public Element serializar() {
		Element planetaXML = DocumentHelper.createElement("Planeta");
		planetaXML.addAttribute("alto", String.valueOf(this.alto));
		planetaXML.addAttribute("ancho", String.valueOf(this.ancho));
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				Element bloqueXML=this.terreno[i][j].serializar();
				planetaXML.add(bloqueXML);
			}
		}
		return planetaXML;
	}

	public void recuperarEstado(Element planetaXML) {
		this.alto = Integer.parseInt(planetaXML.attributeValue("alto"));
		this.ancho = Integer.parseInt(planetaXML.attributeValue("ancho"));
		this.terreno=new Bloque[alto][ancho];
		Iterator<?> iteradorDeXML = planetaXML.elementIterator();
		while (iteradorDeXML.hasNext()) {
			Element bloqueXML = (Element) iteradorDeXML.next();
			try {
				Class<?> claseBloque=Class.forName("bloque."+bloqueXML.getName());
				if(claseBloque.getSuperclass().equals(Bloque.class)){
					Constructor<?> constructor=claseBloque.getDeclaredConstructor(Punto.class);
					Punto punto=new Punto(0,0);
					Bloque bloque=(Bloque)constructor.newInstance(punto);
					bloque.recuperarEstado(bloqueXML);
					this.agregarObstaculo(bloque);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}