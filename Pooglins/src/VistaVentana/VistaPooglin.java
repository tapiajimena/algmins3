package VistaVentana;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class VistaPooglin extends JComponent{
	private static final long serialVersionUID = 1L;
	private volatile static boolean esPrimeraInstancia=true;
	private Rectangle rectanguloImpresion;
	private Rectangle rectanguloImagen;
	Object modelo;
	private static BufferedImage imagen;

	public VistaPooglin(Object modelo,int x,int y){
		super();
		this.modelo=modelo;
		this.rectanguloImpresion=new Rectangle(x,y,60,80);
		this.rectanguloImagen=new Rectangle(50,0,60,80);
		/*Me parece medio sonso crear una imagen para cada instancia  
		 * debo sincronizar esto? o alcanza con q sea volatile `esPrimeraInstancia´ ?
		 */
		if(esPrimeraInstancia){
			try{
				imagen= ImageIO.read(new File("akuma.png"));
			}catch(IOException e){
				e.printStackTrace();
			};
			esPrimeraInstancia=false;
		}
		/*Defino el tamaño del componente*/
		super.setBounds(rectanguloImpresion);
		/*Fuerzo un unico tamaño para el componente*/
		Dimension dim=new Dimension(100,100);// se podria hacer sola la primera vez
		super.setPreferredSize(dim);
		super.setMaximumSize(dim);
		super.setMinimumSize(dim);
		/*lo hago transparente*/
		super.setOpaque(false);
	}
	/*------------------------------------------------------*/
	public void paintComponent(Graphics g){
		   /*llamada al padre para habilitar look n feel , es necesario?*/
		   super.paintComponent(g);
		   g.drawImage(imagen, 0, 0,rectanguloImpresion.width,rectanguloImpresion.height,
				rectanguloImagen.x, rectanguloImagen.y,rectanguloImagen.x+rectanguloImagen.width ,rectanguloImagen.y+rectanguloImagen.height, null);
	}
	/*------------------------------------------------------*/
	public void mover(){}
	public void cambiarCuadro(){}
}
