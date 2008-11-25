package VistaVentana;

import juego.CreadorNiveles;
import juego.Nivel;

public class Programa{
	public static void main(String[] args){
		Nivel nivel=CreadorNiveles.crearNivel();
		
	
		
		
		VistaNivel vista=new VistaNivel(nivel);
		
		vista.setVisible(true);
		while(true){			
			nivel.siguienteRonda();
			vista.actualizarVista();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		
	}
}
