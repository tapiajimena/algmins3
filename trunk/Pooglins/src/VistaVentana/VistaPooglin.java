package VistaVentana;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import modelo.Pooglin;

public class VistaPooglin extends JComponent {
	private static final long serialVersionUID = 1L;
	private volatile static boolean esPrimeraInstancia = true;
	private Rectangle rectanguloImpresion;
	private Rectangle rectanguloImagen;
	private Pooglin pooglin;
	private char ultimaLetra;
	private static BufferedImage imagen;

	public VistaPooglin(Pooglin modelo) {
		super();
		this.pooglin = modelo;
		ultimaLetra = pooglin.getHabilidad();
		this.rectanguloImpresion = new Rectangle(pooglin.getPosicion().getX(),
				pooglin.getPosicion().getY(), 20, 20);
		this.rectanguloImagen = new Rectangle(0, 0, 50, 50);

		if (esPrimeraInstancia) {
			try {
				imagen = ImageIO.read(new File("pooglin.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			;
			esPrimeraInstancia = false;
		}
		/* Defino el tamaño del componente */
		super.setBounds(rectanguloImpresion);
		/* Fuerzo un unico tamaño para el componente */
		Dimension dim = new Dimension(rectanguloImpresion.width,
				rectanguloImpresion.height);// se podria hacer sola la primera
											// vez
		super.setPreferredSize(dim);
		super.setMaximumSize(dim);
		super.setMinimumSize(dim);
		/* lo hago transparente */
		super.setOpaque(false);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, rectanguloImpresion.width,
				rectanguloImpresion.height, rectanguloImagen.x,
				rectanguloImagen.y,
				rectanguloImagen.x + rectanguloImagen.width, rectanguloImagen.y
						+ rectanguloImagen.height, null);
	}

	public void actualizar() {
		Random generador = new Random();
		int numero = generador.nextInt(10);
		rectanguloImpresion.x = pooglin.getPosicion().getY()
				* rectanguloImpresion.width + numero;
		rectanguloImpresion.y = pooglin.getPosicion().getX()
				* rectanguloImpresion.height;
		cambiarCuadro();
		super.setBounds(rectanguloImpresion);
	}

	public void cambiarCuadro() {
		switch (pooglin.getHabilidad()) {
		case 'F':
			rectanguloImagen.y = 100;
			if (ultimaLetra != 'F')
				rectanguloImagen.x = 0;
			if (rectanguloImagen.x < 350)
				rectanguloImagen.x += 50;
			break;
		case 'T':
			rectanguloImagen.y = 150;
			if (ultimaLetra != 'T')
				rectanguloImagen.x = 0;
			if (rectanguloImagen.x < 200)
				rectanguloImagen.x += 50;
			break;
		case 'L':
			if (ultimaLetra != 'L')
				rectanguloImagen.x = 200;
			rectanguloImagen.y = 200;
			if (rectanguloImagen.x < 350)
				rectanguloImagen.x += 50;
			else
				rectanguloImagen.x = 250;
			break;
		case 'C':
			rectanguloImagen.y = 250;
			if (ultimaLetra != 'C')
				rectanguloImagen.x = 0;
			if (rectanguloImagen.x < 200)
				rectanguloImagen.x += 50;
			else
				rectanguloImagen.x = 0;
			break;
		case 'U':
			rectanguloImagen.y = 200;
			if (ultimaLetra != 'U')
				rectanguloImagen.x = 0;
			if (rectanguloImagen.x < 200)
				rectanguloImagen.x += 50;
			else
				rectanguloImagen.x = 0;
			break;
		default:
			if (pooglin.getVectorDireccion() > 0)
				rectanguloImagen.y = 0;
			else
				rectanguloImagen.y = 50;
			if (rectanguloImagen.x > 350)
				rectanguloImagen.x = 0;
			else
				rectanguloImagen.x += rectanguloImagen.width;
			break;
		}
		;
		ultimaLetra = pooglin.getHabilidad();
	}

	public void borrar() {
		super.setVisible(false);
	}

	public Pooglin getPooglin() {
		return this.pooglin;
	}
}
