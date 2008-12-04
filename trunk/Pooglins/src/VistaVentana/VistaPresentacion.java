package VistaVentana;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaPresentacion extends JFrame {
	private static final long serialVersionUID = 1L;
	ImageIcon imagen = new ImageIcon("lemmings.jpg");
	JLabel etiqueta2 = new JLabel(imagen);

	public VistaPresentacion() {
		super("Bienvenidos");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// AGREGAMOS LA ETIQUETA QUE CONTIENE LA IMAGEN AL FRAME
		etiqueta2.setSize(1050, 500);
		getContentPane().add(etiqueta2);
		this.setSize(1050, 500);
		this.pack();
		this.setVisible(true);
	}
}