package modelo;

import java.lang.reflect.Constructor;

import modelo.habilidad.Habilidad;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class Pooglin {

	private Punto posicion;
	private Nivel nivel;
	private Habilidad habilidad;
	private int id;
	private boolean estaMuerto;
	private boolean estaSalvado;
	private int bloquesCaidos;
	private int vectorDireccion;
	private char letraHabilidad;

	public Pooglin() {
		this.estaMuerto = false;
		this.estaSalvado = false;
		this.posicion = new Punto(0, 0);
		this.vectorDireccion = 1;
	}

	public Pooglin(Punto punto) {
		this.posicion = punto;
		this.estaSalvado = false;
		this.estaMuerto = false;
		this.vectorDireccion = 1;
	}

	public Pooglin(Punto punto, Nivel nivel) {
		this.posicion = punto;
		this.nivel = nivel;
		this.vectorDireccion = 1;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public void interactuar() {
		if (habilidad != null) {
			if (!(nivel.getPlaneta().getBloque(this.getPosicion()).esMatable())) {
				this.habilidad.interactuar(nivel.getPlaneta());
			} else {
				nivel.getPlaneta().getBloque(this.getPosicion()).interactuar(
						this);
			}

		}else{
			nivel.getPlaneta().getBloque(this.getPosicion()).interactuar(this);
		}
	}

	public void morir() {
		if (nivel != null)
			nivel.pooglinMuerto(this);
		estaMuerto = true;
	}

	public void caminar() {
		letraHabilidad = 'W';// W de walk
		int direccion = this.vectorDireccion;
		try{
		if ((!estaMuerto) && (!estaSalvado)) {
			// Si en la entrada abajo no hay nada
			if ((nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(1, 0)).esTraspasable())) {
				this.caer();
			}
			// Si abajo a la derecha no hay bloque no transpasable el pooglin
			// cae.
			// No puede haber un bloque tierra si abajo hay aire.
			else if ((nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(0, direccion)).esTraspasable())
					&& (nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(1, direccion)).esTraspasable())) {
				
				this.posicion=this.posicion.puntoRelativo(1, direccion);
			}
			// Adelante normal
			else if ((nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(0, direccion)).esTraspasable())
					&& !(nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(1, direccion)).esTraspasable())) {
				if ((nivel.getPlaneta().getBloque(this.posicion)).esDerretible()) {
					this.posicion.setY(this.posicion.getY() + direccion);
				} else {
					this.posicion.setY(this.posicion.getY() + direccion);
				}
			} else if (!(nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(0, direccion)).esTraspasable())) {
				if (!(nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(-1, direccion)).esTraspasable())) {
					this.darVuelta();
				} else {
					this.posicion=this.posicion.puntoRelativo(-1, direccion);
				}
			}
		}
		}
		catch(ArrayIndexOutOfBoundsException e){
			this.darVuelta();
			// segun por donde haya sobrepasado el terreno lo hago volver un par de casilleros
			if(posicion.getX()<=0) posicion.setX(1);
			else if(posicion.getX()>=nivel.getPlaneta().getAlto())posicion.setX(nivel.getPlaneta().getAlto()-2);
			if(posicion.getY()<=0) posicion.setY(1);
			else if(posicion.getY()>=nivel.getPlaneta().getAncho())posicion.setY(nivel.getPlaneta().getAncho()-2);
		}
	}

	public void darVuelta() {
		this.vectorDireccion *= -1;
	}

	public void caer() {
		letraHabilidad = 'F';// f de fall
		if (nivel.getPlaneta().getBloque(this.posicion.puntoRelativo(2, 0)).esTraspasable()) {
			bloquesCaidos++;
		}else {
			if(bloquesCaidos>4)this.morir();
			bloquesCaidos=0;
		}
		this.posicion.setX(this.getPosicion().getX() + 1);
	}

	public void definirHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	public Punto getPosicion() {
		return new Punto(this.posicion);
	}
	
	public void setPosicion(Punto punto) {
		this.posicion = punto;
	}

	public boolean estaMuerto() {
		return estaMuerto;
	}

	public void salvar() {
		if (nivel != null)
			this.nivel.pooglinSalvado(this);
		estaSalvado = true;
	}

	/* Devuelve una copia de la posicion del Pooglin */
	public Punto obtenerDireccion() {
		return new Punto(this.vectorDireccion, 0);
	}

	public int getId() {
		return id;
	}

	public int getVectorDireccion() {
		return this.vectorDireccion;
	}

	public boolean EstaSalvado() {
		return estaSalvado;
	}

	public void setId(int id) {
		this.id = id;

	}

	public Element serializar() {
		Element elementPooglin = DocumentHelper.createElement("Pooglin");
		elementPooglin.addAttribute("id", new Integer(this.id).toString());
		elementPooglin.addAttribute("bloquesCaidos", new Integer(
				this.bloquesCaidos).toString());
		elementPooglin.addAttribute("vectorDireccion", new Integer(
				this.vectorDireccion).toString());
		elementPooglin.addAttribute("estaMuerto", new Boolean(this.estaMuerto)
				.toString());
		elementPooglin.addAttribute("estaSalvado",
				new Boolean(this.estaSalvado).toString());
		elementPooglin.add(this.posicion.serializar());
		// hago un nodo de 2 niveles para la habilidad, por razones de
		// polimorfismo
		Element elemHabilidad = DocumentHelper.createElement("Habilidad");
		if(habilidad!=null)	{
			elemHabilidad.add(this.habilidad.serializar());
			elementPooglin.add(elemHabilidad);
		}
		return elementPooglin;
	}

	public void recuperarEstado(Element elementoPooglin) {
		this.id = Integer.parseInt(elementoPooglin.attributeValue("id"));
		this.bloquesCaidos = Integer.parseInt(elementoPooglin
				.attributeValue("bloquesCaidos"));
		this.vectorDireccion = Integer.parseInt(elementoPooglin
				.attributeValue("vectorDireccion"));
		this.estaMuerto = Boolean.parseBoolean(elementoPooglin
				.attributeValue("estaMuerto"));
		this.estaSalvado = Boolean.parseBoolean(elementoPooglin
				.attributeValue("estaSalvado"));
		this.posicion.recuperarEstado(elementoPooglin.element("Punto"));

		Element elemHabilidad = (Element) elementoPooglin.element("Habilidad");
		if (elemHabilidad != null) {
			elemHabilidad = (Element) elemHabilidad.elementIterator().next();
			try {
				Class<?> claseHabilidad = Class.forName("habilidad."
						+ elemHabilidad.getName());
				if (claseHabilidad.getSuperclass().equals(Habilidad.class)) {
					Constructor<?> constructor = claseHabilidad
							.getDeclaredConstructor(Pooglin.class);
					Habilidad habilidad = (Habilidad) constructor
							.newInstance(this);
					habilidad.recuperarEstado(elemHabilidad);
					this.definirHabilidad(habilidad);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public char getHabilidad() {
		if (habilidad != null)
			letraHabilidad = habilidad.getLetra();
		return letraHabilidad;
	}

}

