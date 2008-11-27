package VistaVentana;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VistaPresentacion extends JFrame {
	/*	CREAMOS UN OBJETO QUE PUEDA CONTENER LA IMAGEN. ESTA IMAGEN
		PUEDE SER UN ARCHIVO .GIF O .JPG. PARA ESTO UTILIZAMOS LA CLASE
		ImageIcon. AL INSTANCIAR, DEBEMOS
		PASARLE COMO PARAMETRO UNA CADENA QUE ESPECIFICA EL NOMBRE O LA
		RUTA EN DONDE SE ENCUENTRA LA IMAGEN.
		Ej.:SI LA IMAGEN SE LLAMA "logotipo.gif", Y LA MISMA SE ENCUENTRA
		EN EL MISMO DIRECTORIO EN DONDE ESTOY HACIENDO MI PROGRAMA,
		INVOCO AL CONTRUCTOR DE LA SIGUIENTE MANERA:
		ImageIcon img = new ImageIcon("logotipo.gif").
		
	Ej.:EL OTRO CASO SERÍA, QUE LA MISMA IMAGEN "logotipo.gif", SE
		ENCUENTRE EN UN DIRECTORIO QUE NO SEA EN DONDE ESTA MI PROGRAMA.
		SUPONGAMOS QUE LA RUTA EN DONDE ESTA LA IMAGEN SEA:
		"C:/IMAGENES/logotipo.gif", PARA ELLO INVOCAMOS AL CONSTRUCTOR
		DE ImageIcon DE IGUAL MANERA QUE EN EL EJEMPLO ANTERIOR, SOLO QUE 
		AHORA COLOCAMOS LA RUTA COMPLETA.
		ImageIcon img = new ImageIcon("C:/IMAGENES/logotipo.gif");
	*/ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	ImageIcon imagen = new ImageIcon("lemmings.jpg");


	/*	COMO LAS IMAGENES, SE DEBEN COLOCAR DENTRO DE COMPONENTES
		(ETIQUETAS, BOTONES, ETC..), LO QUE HARÉ SERÁ UNA ETIQUETA (LABEL)
		SIN TEXTO, (AUNQUE TAMBIÉN SE LE PUEDE AGREGAR TEXTO) Y EN ELLA
		COLOCO LA IMAGEN.
		PARA COLOCAR LA IMAGEN, LE PASAMOS COMO PARAMETRO A LA ETIQUETA
		EL OBJETO QUE CONTIENE LA IMAGEN.
	*/

	JLabel etiqueta2 = new JLabel(imagen);		
	
	public VistaPresentacion()
	{
		super("Bienvenidos");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//AGREGAMOS LA ETIQUETA QUE CONTIENE LA IMAGEN AL FRAME
		getContentPane().add(etiqueta2);
		this.setSize(500, 500);
		this.pack();
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		VistaPresentacion pre=new VistaPresentacion();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pre.dispose();
		//new VistaNivel(CreadorNiveles.crearNivel()).setVisible(true);
		
	}
		
}