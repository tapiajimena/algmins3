package juego;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import abstractFactoryHabilidades.AbstractFactoryHabilidad;
import pooglin.Pooglin;
import punto.Punto;

public class Nivel extends Observable {
	/*
	 * En esta clase falta la implementacion de algunos metodos que van a estar
	 * para la segunda entrega cuando decimos bien como realizar el motor del
	 * juego y cuestiones relacionadas con el mismo y su interaccion con la
	 * clase Nivel.
	 */

	/*
	 * @SuppressWarnings("unused") //Todavia no lo vamos a usar al tiempo, para
	 * mas adelante private Tiempo cantTiempo;
	 * 
	 * @SuppressWarnings("unused") private Tiempo tiempoTranscurrido;
	 */
	private int ronda = 0;
	private ArrayList<Pooglin> pooglins;
	private int cantMuertos;
	private int cantidadSalvados;
	private int cantInicialPooglins;
	private String nombre;
	private Planeta planeta;
	private ArrayList<AbstractFactoryHabilidad> fabricasHabilidades;
	@SuppressWarnings("unused")
	private AbstractFactoryHabilidad habilidadSeleccionada;
	private TiempoNivel tiempo;

	/*
	 * --------------------------------------------------------------------------
	 * ----------------------------
	 */
	public ArrayList<Pooglin> getPooglinsVivos() {
		return pooglins;
	}

	public ArrayList<AbstractFactoryHabilidad> getFabricasHabilidad() {
		/*
		 * int cantHabilidades=fabricasHabilidades.size(); String[]
		 * habilidades=null; if(cantHabilidades>0){ habilidades=new
		 * String[cantHabilidades]; for(int i=0;i<cantHabilidades;i++){
		 * habilidades[i]=fabricasHabilidades.get(i).toString(); } } return
		 * habilidades;
		 */
		return this.fabricasHabilidades;
	}

	/*
	 * public void crearMatrizPooglins(){ for (int i=0;
	 * i<this.cantInicialPooglins;i++){
	 * 
	 * this.pooglins.add(i, new Pooglin(new Punto(0,0),this));
	 * 
	 * } }
	 */

	public void siguienteRonda() {
		// definir mas adelante el punto de Partida
		Punto puntoEntrada = new Punto(1, 1);
		// agregar un Contador Para asegurar intervalo entre pooglins
		if (pooglins.size() < (cantInicialPooglins - (this.cantidadSalvados + this.cantMuertos))
				&& ronda % 4 == 0) {
			Pooglin unPooglin = new Pooglin(puntoEntrada, this);
			unPooglin.setId(pooglins.size());
			pooglins.add(unPooglin);

		}
		for (int i = 0; i < pooglins.size(); i++) {
			pooglins.get(i).interactuar();
		}
		super.notifyObservers();
		ronda++;
	}

	public void asignarHabilidad(int numeroHabilidad, int numeroPooglin) {
		try {
			AbstractFactoryHabilidad fabrica = fabricasHabilidades
					.get(numeroHabilidad);
			if (fabrica.cantidadDisponible() > 0) {
				fabrica.asignarHabilidad(pooglins.get(numeroPooglin));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// nada
		}
	}

	public void pooglinMuerto(Pooglin elMuerto) {
		if (pooglins != null) {
			cantMuertos++;
			pooglins.remove(elMuerto);
		}
	};

	public void pooglinSalvado(Pooglin elSalvado) {
		if (pooglins != null) {
			this.cantidadSalvados++;
			pooglins.remove(elSalvado);
		}
	};

	public Nivel(ArrayList<AbstractFactoryHabilidad> fabricas,
			int cantidadDePooglins, Planeta planeta, int min) {
		this.planeta = planeta;
		this.pooglins = new ArrayList<Pooglin>();
		this.cantInicialPooglins = cantidadDePooglins;
		this.fabricasHabilidades = fabricas;
		this.tiempo = new TiempoNivel();
		this.tiempo.setMinutosRestantes(min);

	}

	/*------------------------------------------------------------------------------------------------------*/
	public Nivel() {
		this.pooglins = new ArrayList<Pooglin>();
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantMuertos() {
		return cantMuertos;
	}

	public int getCantInicialPooglins() {
		return cantInicialPooglins;
	}

	public void setCantInicialPooglins(int cantidad) {
		this.cantInicialPooglins = cantidad;
	}

	public ArrayList<Pooglin> getListaPooglin() {
		return pooglins;

	}

	public int getPooglinALanzar() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setTiempo(int min, int seg) {
		this.tiempo.setMinutosRestantes(min);
		this.tiempo.setSegundosRestantes(seg);
	}

	public TiempoNivel getTiempo() {
		return tiempo;
	}

	public Element serializar() {
		Element nivelXML = DocumentHelper.createElement("Nivel");
		nivelXML.addAttribute("cantMuertos", String.valueOf(cantMuertos));
		nivelXML.addAttribute("cantidadSalvados", String.valueOf(cantidadSalvados));
		nivelXML.addAttribute("cantidadInicialPooglins", String.valueOf(cantInicialPooglins));
		nivelXML.addAttribute("ronda", String.valueOf(ronda));
		nivelXML.addAttribute("nombre", nombre);
		nivelXML.add(planeta.serializar());
		Element fabricasXML = DocumentHelper.createElement("Habilidades");
		for (int i = 0; i < fabricasHabilidades.size(); i++) {
			Element fabrica = fabricasHabilidades.get(i).serializar();
			fabricasXML.add(fabrica);
		}
		Element listaPooglinsXML = DocumentHelper.createElement("ListaPooglins");
		for (int i = 0; i < pooglins.size(); i++) {
			Element unPooglinXML = pooglins.get(i).serializar();
			listaPooglinsXML.add(unPooglinXML);
		}
		return nivelXML;
	}

	public void recuperarEstado(Element nivelXML) {
		/* recupero Atributos simples */
		cantMuertos = Integer.parseInt(nivelXML.attributeValue("cantMuertos"));
		cantidadSalvados = Integer.parseInt(nivelXML.attributeValue("cantidadSalvados"));
		cantInicialPooglins = Integer.parseInt(nivelXML.attributeValue("cantidadInicialPooglins"));
		ronda = Integer.parseInt(nivelXML.attributeValue("ronda"));
		nombre = nivelXML.attributeValue("nombre");
		/* Recupero las fabricas de las habilidades */
		Iterator<?> iterador = nivelXML.element("Habilidades").elementIterator();
		this.fabricasHabilidades = new ArrayList<AbstractFactoryHabilidad>();
		while (iterador.hasNext()) {
			try {
				Element fabricaXML = (Element) iterador.next();
				Class<?> claseFabrica = Class.forName("abstractFactoryHabilidades."+ fabricaXML.getName());
				Constructor<?> constructor = claseFabrica.getDeclaredConstructor(int.class);
				AbstractFactoryHabilidad fabricaHabilidad = (AbstractFactoryHabilidad) constructor.newInstance(0);
				fabricaHabilidad.recuperarEstado(fabricaXML);
				this.fabricasHabilidades.add(fabricaHabilidad);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/* Recupero La lista de Pooglin */
		iterador = nivelXML.element("ListaPooglins").elementIterator();
		this.pooglins = new ArrayList<Pooglin>();
		while (iterador.hasNext()) {
			Element pooglinXML = (Element) iterador.next();
			Pooglin pooglin = new Pooglin();
			pooglin.recuperarEstado(pooglinXML);
			pooglin.setNivel(this);
			this.pooglins.add(pooglin);
		}
		/* listo el pollo, pelada la gallina */
	}
}
