package VistaVentana;

public class Programa{
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new VistaNivel().crearMostrarGUI();
			}
		});
	}
}