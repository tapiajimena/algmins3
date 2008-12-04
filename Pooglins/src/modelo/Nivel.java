package modelo;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.FactoryHabilidades.AbstractFactoryHabilidad;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Nivel {

	private int ronda = 0;
	private ArrayList<Pooglin> pooglins;
	private int cantMuertos;
	private int cantidadSalvados;
	private int cantInicialPooglins;
	private String nombre;
	private Planeta planeta;
	private ArrayList<AbstractFactoryHabilidad> fabricasHabilidades;
	private AbstractFactoryHabilidad habilidadSeleccionada = null;
	private int maxRondas;

	public Nivel() {
		this.pooglins = new ArrayList<Pooglin>();
	}

	public Nivel(ArrayList<AbstractFactoryHabilidad> fabricas,
			int cantidadDePooglins, Planeta planeta, int min) {
		this.planeta = planeta;
		this.pooglins = new ArrayList<Pooglin>();
		this.cantInicialPooglins = cantidadDePooglins;
		this.fabricasHabilidades = fabricas;
		this.maxRondas = min;
	}

	public ArrayList<Pooglin> getPooglinsVivos() {
		return pooglins;
	}

	public ArrayList<AbstractFactoryHabilidad> getFabricasHabilidad() {
		return this.fabricasHabilidades;
	}

	public void siguienteRonda() {
		if (maxRondas >= ronda) {
			if (pooglins.size() < cantInicialPooglins
					- (cantidadSalvados + cantMuertos)
					&& ronda % 4 == 0) {
				Punto puntoEntrada = planeta.getPuntoEntrada();
				Pooglin unPooglin = new Pooglin(puntoEntrada, this);
				unPooglin.setId(pooglins.size());
				pooglins.add(unPooglin);
			}
			for (int i = 0; i < pooglins.size(); i++) {
				pooglins.get(i).interactuar();
			}
			ronda++;
		}
	}

	public void asignarHabilidad(int numeroHabilidad, int numeroPooglin) {
		try {
			AbstractFactoryHabilidad fabrica = fabricasHabilidades
					.get(numeroHabilidad);
			if (fabrica.cantidadDisponible() > 0) {
				fabrica.asignarHabilidad(pooglins.get(numeroPooglin));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

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

	public int cantidadDePooglinsVivos() {
		return this.pooglins.size();
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
		return 0;
	}

	public int getTiempoTotal() {
		return maxRondas;
	}

	public int getTiempo() {
		return ronda;
	}

	public Element serializar() {
		Element nivelXML = DocumentHelper.createElement("Nivel");
		nivelXML.addAttribute("cantMuertos", String.valueOf(cantMuertos));
		nivelXML.addAttribute("cantidadSalvados", String
				.valueOf(cantidadSalvados));
		nivelXML.addAttribute("cantidadInicialPooglins", String
				.valueOf(cantInicialPooglins));
		nivelXML.addAttribute("ronda", String.valueOf(ronda));
		nivelXML.addAttribute("maxRondas", String.valueOf(maxRondas));
		nivelXML.addAttribute("nombre", nombre);
		nivelXML.add(planeta.serializar());
		Element fabricasXML = DocumentHelper.createElement("Habilidades");
		for (int i = 0; i < fabricasHabilidades.size(); i++) {
			Element fabrica = fabricasHabilidades.get(i).serializar();
			fabricasXML.add(fabrica);
		}
		nivelXML.add(fabricasXML);
		Element listaPooglinsXML = DocumentHelper
				.createElement("ListaPooglins");
		for (int i = 0; i < pooglins.size(); i++) {
			Element unPooglinXML = pooglins.get(i).serializar();
			listaPooglinsXML.add(unPooglinXML);
		}
		nivelXML.add(listaPooglinsXML);
		return nivelXML;
	}

	public void recuperarEstado(Element nivelXML) {
		/* recupero Atributos simples */
		cantMuertos = Integer.parseInt(nivelXML.attributeValue("cantMuertos"));
		cantidadSalvados = Integer.parseInt(nivelXML
				.attributeValue("cantidadSalvados"));
		cantInicialPooglins = Integer.parseInt(nivelXML
				.attributeValue("cantidadInicialPooglins"));
		ronda = Integer.parseInt(nivelXML.attributeValue("ronda"));
		maxRondas = Integer.parseInt(nivelXML.attributeValue("maxRondas"));
		nombre = nivelXML.attributeValue("nombre");
		planeta.recuperarEstado(nivelXML.element("Planeta"));
		/* Recupero las fabricas de las habilidades */
		Iterator<?> iterador = nivelXML.element("Habilidades")
				.elementIterator();
		this.fabricasHabilidades = new ArrayList<AbstractFactoryHabilidad>();
		while (iterador.hasNext()) {
			try {
				Element fabricaXML = (Element) iterador.next();
				Class<?> claseFabrica = Class.forName(fabricaXML.getName());
				Constructor<?> constructor = claseFabrica
						.getDeclaredConstructor(int.class);
				AbstractFactoryHabilidad fabricaHabilidad = (AbstractFactoryHabilidad) constructor
						.newInstance(0);
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

	}

	public boolean estaFinalizado() {
		if (ronda >= maxRondas)
			return true;
		return (this.cantidadSalvados + this.cantMuertos) == (this.cantInicialPooglins);
	}

	public int getCantSalvados() {
		return cantidadSalvados;
	}

	public boolean estaBloqueado() {
		return (this.cantMuertos == this.cantInicialPooglins);
	}

	public void seleccionarHabilidad(String nombre) {

		int i = 0;
		boolean esIgual = false;
		while (i < this.fabricasHabilidades.size() && !esIgual) {
			if (nombre.equals(fabricasHabilidades.get(i).toString())) {
				habilidadSeleccionada = fabricasHabilidades.get(i);
				esIgual = true;
			} else
				i++;
		}

	}

	public AbstractFactoryHabilidad getHabilidadSeleccionada() {

		return habilidadSeleccionada;
	}

	public void salvarATodos() {

		for (int i = 0; i < this.pooglins.size(); i++) {
			pooglins.get(i).salvar();
		}
	}
}
