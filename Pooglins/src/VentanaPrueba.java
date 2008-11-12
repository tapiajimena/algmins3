import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;




public class VentanaPrueba {
	private static void crearGUI(){
		JFrame ventana=new JFrame("Programa");
		VistaPooglin pooglin=new VistaPooglin(null,0,0);
		ventana.getContentPane().add(pooglin);
		VistaPooglin pooglin1=new VistaPooglin(null,100,100);
		ventana.getContentPane().add(pooglin1);
		ventana.getContentPane().add(new JButton("botton"));
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//defino es la forma en que se acomodan los componentes
		ventana.getContentPane().setLayout(null);//new BoxLayout(ventana.getContentPane(),BoxLayout.LINE_AXIS)
		//tamaño de la ventana
		ventana.setPreferredSize(new Dimension(400,400));
		//preparo la venta
		ventana.pack();
		//muestro la ventana
		ventana.setVisible(true);
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearGUI();
            }
        });
	}
}


class VistaPooglin extends JComponent implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Rectangle rectanguloImpresion;
	private Rectangle rectanguloImagen;
	Object modelo;
	BufferedImage imagen;
	private static int contador=0;
	public int id;
	
	public VistaPooglin(Object modelo,int x,int y){
		super();
		this.modelo=modelo;
		this.rectanguloImpresion=new Rectangle(x,y,60,80);
		this.rectanguloImagen=new Rectangle(50,0,60,80);
		/*levanto la imagen sprite*/
		try{
			imagen= ImageIO.read(new File("akuma.png"));
		}catch(IOException e){
			e.printStackTrace();
		};
		Dimension dim=new Dimension(100,100);
		/*Defino el tamaño del componente*/
		super.setBounds(rectanguloImpresion);
		/*en caso de q cambie el tamño de la ventana*/
		super.setPreferredSize(dim);
		super.setMaximumSize(dim);
		super.setMinimumSize(dim);
		/*lo hago transparente*/
		super.setOpaque(false);
		/**/
		super.addMouseListener(this);
		id=contador;
		contador++;
	}
	/*------------------------------------------------------*/
	   public void paintComponent(Graphics g){
		   /*llamada al padre para habilitar look n feel , es necesario?*/
		   super.paintComponent(g);
		   g.drawImage(imagen, 0, 0,rectanguloImpresion.width,rectanguloImpresion.height,
				rectanguloImagen.x, rectanguloImagen.y,rectanguloImagen.x+rectanguloImagen.width ,rectanguloImagen.y+rectanguloImagen.height, null);
	   }
	/*------------------------------------------------------*/
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource()instanceof VistaPooglin)
			System.out.println(((VistaPooglin)arg0.getSource()).id);
		rectanguloImpresion.x+=20;
		rectanguloImpresion.y+=20;
		super.setBounds(rectanguloImpresion);
		//super.revalidate();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		rectanguloImagen.x+=60;
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		rectanguloImagen.x-=60;
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
}

