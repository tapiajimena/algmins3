package pooglin;

import punto.Punto;
import juego.Nivel;
import habilidad.Habilidad;

public class Pooglin {

    private int id;
    private Punto posicion;
    private Nivel nivel;
    private Habilidad habilidad;
    private boolean estaMuerto;
    private boolean estaSalvado;
    private int bloquesCaidos;
    private int vectorDireccion;

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

    public void interactuar() {

	if (habilidad != null) {
	    this.habilidad.interactuar(nivel.getPlaneta());
	} else {
	    nivel.getPlaneta().getBloque(this.getPosicion()).interactuar(this);
	}
    }

    public void morir() {

	estaMuerto = true;

    }

    public void caminar() {

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
	estaSalvado = true;
    }

    /* Devuelve una copia de la posicion del Pooglin */
    public Punto obtenerDireccion() {
	return new Punto(this.vectorDireccion, 0);
    }

    /* Devuelve el numero identificador del Pooglin */
    public int getId() {
	return id;
    }

    /* Devuelve */
    public int getVectorDireccion() {
	return this.vectorDireccion;
    }

    public boolean EstaSalvado() {
	return estaSalvado;
    }

}
