package pooglin;

import java.lang.reflect.Constructor;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import punto.Punto;
import juego.Nivel;
import habilidad.Habilidad;

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
	public void setNivel(Nivel nivel){
		this.nivel=nivel;
	}
	public void interactuar() {

		if (habilidad != null) {
			
			if (!(nivel.getPlaneta().getBloque(this.getPosicion()).esMatable())){
				this.habilidad.interactuar(nivel.getPlaneta());	
			}
			else{
				nivel.getPlaneta().getBloque(this.getPosicion()).interactuar(this);	
			}
	
		} else {
			nivel.getPlaneta().getBloque(this.getPosicion()).interactuar(this);
		}
	}

	public void morir() {

		estaMuerto = true;
		if(nivel!=null) nivel.pooglinMuerto(this);
	}

	public void caminar() {
		letraHabilidad='W';//W de walk
		int direccion = this.vectorDireccion;
		
		if ((!estaMuerto) && (!estaSalvado)) {

			// Si de entrada abajo no hay nada...
			if ((nivel.getPlaneta().getBloque(
					this.getPosicion().puntoRelativo(1, 0)).esTraspasable())) {
				// System.out.println("Cae para abajo");
				this.caer();
			}
			// Si abajo a la derecha no hay bloque no transpasable el pooglin
			// cae.
			// No puede haber un bloque tierra si abajo hay aire.
			else if ((nivel.getPlaneta().getBloque(
					this.getPosicion().puntoRelativo(0, direccion))
					.esTraspasable())
					&& (nivel.getPlaneta().getBloque(
							this.getPosicion().puntoRelativo(1, direccion))
							.esTraspasable())) {

				// System.out.println("Cae en diagonal");
				this.posicion.setY(this.getPosicion().getY() + direccion);
				this.posicion.setX(this.getPosicion().getX() + 1);

			}
			// Adelante normal...
			else if ((nivel.getPlaneta().getBloque(
					this.getPosicion().puntoRelativo(0, direccion))
					.esTraspasable())
					&& !(nivel.getPlaneta().getBloque(
							this.getPosicion().puntoRelativo(1, direccion))
							.esTraspasable())) {
				if ((nivel.getPlaneta().getBloque(this.getPosicion()))
						.esDerretible()) {
					// System.out.println("Me resbalo, hay hielo");
					this.posicion.setY(this.getPosicion().getY() + direccion);
				} else {
					// System.out.println("Avanzo hacia adelante");
					this.posicion.setY(this.getPosicion().getY() + direccion);
				}
			} else if (!(nivel.getPlaneta().getBloque(
					this.getPosicion().puntoRelativo(0, direccion))
					.esTraspasable())) {
				if (!(nivel.getPlaneta().getBloque(
						this.getPosicion().puntoRelativo(-1, direccion))
						.esTraspasable())) {
					// System.out.println("Doy la vuelta");
					this.darVuelta();
				} else {
					this.posicion.setY(this.getPosicion().getY() + direccion);
					this.posicion.setX(this.getPosicion().getX() - 1);
				}
			}
		}
	}

	public void darVuelta() {

		this.vectorDireccion *= -1;

	}

	public void caer() {
		letraHabilidad='F';// f de fall
		if (bloquesCaidos >= 4) {
			this.morir();
		}
		if (bloquesCaidos <= 4) {
			bloquesCaidos++;
			this.posicion.setX(this.getPosicion().getX() + 1);
		}
		if (!(nivel.getPlaneta().getBloque(
				this.getPosicion().puntoRelativo(1, 0)).esTraspasable())) {
			bloquesCaidos = 0;
		}

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
		this.id=id;
		
	}
	public Element serializar(){
		Element elementPooglin=DocumentHelper.createElement("Pooglin");
		elementPooglin.addAttribute("id",new Integer(this.id).toString());
		elementPooglin.addAttribute("bloquesCaidos",new Integer(this.bloquesCaidos).toString());
		elementPooglin.addAttribute("vectorDireccion",new Integer(this.vectorDireccion).toString());
		elementPooglin.addAttribute("estaMuerto",new Boolean(this.estaMuerto).toString());
		elementPooglin.addAttribute("estaSalvado",new Boolean(this.estaSalvado).toString());
		elementPooglin.add(this.posicion.serializar());
		//hago un nodo de 2 niveles para la habilidad, por razones de polimorfismo
		Element elemHabilidad=DocumentHelper.createElement("Habilidad");
		elemHabilidad.add(this.habilidad.serializar());
		elementPooglin.add(elemHabilidad);
		/*falta serializar las referencias y nivel*/
		return elementPooglin;
	}
	public void recuperarEstado(Element elementoPooglin){
		this.id=Integer.parseInt(elementoPooglin.attributeValue("id"));
		this.bloquesCaidos=Integer.parseInt(elementoPooglin.attributeValue("bloquesCaidos"));
		this.vectorDireccion=Integer.parseInt(elementoPooglin.attributeValue("vectorDireccion"));
		this.estaMuerto=Boolean.parseBoolean(elementoPooglin.attributeValue("estaMuerto"));
		this.estaSalvado=Boolean.parseBoolean(elementoPooglin.attributeValue("estaSalvado"));
		this.posicion.recuperarEstado(elementoPooglin.element("Punto"));
		
		//que feo pero no me importa por q son las 4 am
		Element elemHabilidad=(Element)elementoPooglin.element("Habilidad").elementIterator().next();
		try {
			Class<?> claseHabilidad=Class.forName("habilidad."+elemHabilidad.getName());
			if(claseHabilidad.getSuperclass().equals(Habilidad.class)){
				Constructor<?> constructor=claseHabilidad.getDeclaredConstructor(Pooglin.class);
				Habilidad habilidad=(Habilidad)constructor.newInstance(this);
				habilidad.recuperarEstado(elemHabilidad);
				this.definirHabilidad(habilidad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public char getHabilidad() {
		if(habilidad!=null)letraHabilidad=habilidad.getLetra();
		return letraHabilidad;
	}

}
