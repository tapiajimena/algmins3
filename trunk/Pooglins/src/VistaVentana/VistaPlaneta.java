package VistaVentana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VistaPlaneta extends JPanel {
    /**
	 * 
	 */
    private BufferedImage fondo;
    private BufferedImage frente;
    private static final long serialVersionUID = 1L;

    public VistaPlaneta() {
	try {
	    fondo = ImageIO.read(new File("fondoAzul.png"));
	} catch (IOException e) {
	    e.printStackTrace();
	};
	
	Dimension dim = new Dimension(400, 400);
	super.setPreferredSize(dim);
	super.setMaximumSize(dim);
	super.setMinimumSize(dim);
    }

    public void paintComponent(Graphics g) {
	/* llamada al padre para habilitar look n feel , es necesario? */
	super.paintComponent(g);
	g.drawImage(fondo, 0, 0, 500, 500, 0, 0, 500, 500, null);
	BufferedImage img;
	img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
	Graphics2D gra=img.createGraphics();
	gra.setColor(Color.black);
	gra.fillRect(0,0, 50,50);
	g.drawImage(img, 100, 100, 150, 150, 0, 0, 60,80, null);
	
	
    }
}