package VistaVentana;

import juego.CreadorNiveles;
import juego.Nivel;

public class Programa{
	public static void main(String[] args){
		Nivel nivel=CreadorNiveles.crearNivel();
		VistaNivel vista=new VistaNivel(nivel);
		vista.setVisible(true);
		/*for(int i=0;i<10;i++){			
			nivel.siguienteRonda();
			vista.actualizarVista();
		}*/
	}
}
