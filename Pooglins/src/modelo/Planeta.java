package modelo;

import java.lang.reflect.Constructor;
import java.util.Iterator;

import modelo.bloque.AgujeroNegro;
import modelo.bloque.Aire;
import modelo.bloque.Bloque;
import modelo.bloque.Entrada;
import modelo.bloque.Fuego;
import modelo.bloque.Hielo;
import modelo.bloque.Roca;
import modelo.bloque.Salida;
import modelo.bloque.Tierra;
import modelo.bloque.Tunel;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class Planeta {
	private int ancho;
	private int alto;
	private Bloque[][] terreno;
	private char[][] CTerreno;

	public Planeta(int alto, int ancho, Bloque[][] terreno) {
		this.alto = (alto);
		this.ancho = (ancho);
		this.terreno = terreno;
		//this.cargarMatrizCaracteres();
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
	/*
	 * Devuelve el bloque representado por el caracter,lo inicializa en el punto
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
	
	private void cargarMatrizCaracteres() {
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				this.CTerreno[i][j] = terreno[i][j].getLetra();
			}
		}
	}
	public void agregar(Bloque bloque) {
		if (bloque.getPosicion().getX() < this.alto && bloque.getPosicion().getY() < this.ancho)
			this.terreno[bloque.getPosicionX()][bloque.getPosicionY()] = bloque;
	}

	public void quitarBloque(Punto punto) {
		if (punto.getX() < this.alto && punto.getY() < this.ancho) {
			if (this.terreno[punto.getX()][punto.getY()] != null) {
				this.terreno[punto.getX()][punto.getY()].destruir();
				this.terreno[punto.getX()][punto.getY()] = new Aire(punto);
			}
		}
	}

	public Bloque getBloque(Punto punto) throws ArrayIndexOutOfBoundsException {
		if (punto.getX() < this.alto && punto.getY() < this.ancho)
			return terreno[punto.getX()][punto.getY()];
		else
			throw new ArrayIndexOutOfBoundsException();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public char[][] getCTerreno() {
		return this.CTerreno;
	}
	/*
	 * Serializacion
	 */
	public Element serializar() {
		Element planetaXML = DocumentHelper.createElement("Planeta");
		planetaXML.addAttribute("alto", String.valueOf(this.alto));
		planetaXML.addAttribute("ancho", String.valueOf(this.ancho));
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				Element bloqueXML = this.terreno[i][j].serializar();
				planetaXML.add(bloqueXML);
			}
		}
		return planetaXML;
	}

	public void recuperarEstado(Element planetaXML) {
		this.alto = Integer.parseInt(planetaXML.attributeValue("alto"));
		this.ancho = Integer.parseInt(planetaXML.attributeValue("ancho"));
		this.terreno = new Bloque[alto][ancho];
		Iterator<?> iteradorDeXML = planetaXML.elementIterator();
		while (iteradorDeXML.hasNext()) {
			Element bloqueXML = (Element) iteradorDeXML.next();
			try {
				Class<?> claseBloque = Class.forName("bloque."
						+ bloqueXML.getName());
				if (claseBloque.getSuperclass().equals(Bloque.class)) {
					Constructor<?> constructor = claseBloque
							.getDeclaredConstructor(Punto.class);
					Punto punto = new Punto(0, 0);
					Bloque bloque = (Bloque) constructor.newInstance(punto);
					bloque.recuperarEstado(bloqueXML);
					this.agregar(bloque);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}