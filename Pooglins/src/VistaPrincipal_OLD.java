import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import pooglin.Pooglin;

import juego.Nivel;
import juego.Planeta;



@SuppressWarnings("serial")
public class VistaPrincipal_OLD extends JFrame {
	
	//Atributos
	
	private JPanel nuevoPanel;

	private Nivel nivel;

	private Planeta planeta;

	private char[][] matrizChars;
	
	private JLabel[][] matrizGui;

	private Container contenedor;

	private ArrayList<Pooglin> lista;

	private JLabel unLabel;
		
	public VistaPrincipal_OLD(Nivel unNivel){
		super("THE POOGLINS: THE BEGGINING");
	
		contenedor = getContentPane();
		
		unLabel = new JLabel("", new ImageIcon("inicio.jpg"), JLabel.LEFT);// GUI
		
		contenedor.add(unLabel);
		
		this.nivel=unNivel;
		this.planeta=unNivel.getPlaneta();
		this.lista=unNivel.getListaPooglin();
		
		
		
		nuevoPanel = new JPanel();
		
		
		
		this.cargarMatrizVista("nuevo","none");
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
	 public void cargarMatrizVista(String event,String event2) {
			if (event == "nuevo") {

				this.remove(nuevoPanel);
				
			    // nuevoPanel = new JPanel();
			
			    char[][] temp = planeta.getCTerreno();
			    
			    matrizChars = new char[planeta.getAlto()][planeta.getAncho()];
			    for (int i = 0; i < planeta.getAlto(); i++) {
				for (int j = 0; j < planeta.getAncho(); j++) {
				    matrizChars[i][j] = temp[i][j];
				}
			    }
			    
				if (event2=="crearpoo"){
					//Iterator unIterador= nivel.getListaPooglin().iterator();
					int x,y;
					int index=0;
					while(index<lista.size()){
						
						x=lista.get(index).getPosicion().getX();
						y=lista.get(index).getPosicion().getY();				
						matrizChars[x][y] = 'Y';
						index++;					
					}
				}
				
			    nuevoPanel = new JPanel();
			    nuevoPanel.setLayout(new GridLayout(planeta.getAlto(), planeta.getAncho()));
			    matrizGui = new JLabel[planeta.getAlto()][planeta.getAncho()];
			}
			
			
			for (int i = 0; i < matrizGui.length; i++) {
			    for (int j = 0; j < matrizGui[i].length; j++) {
				matrizGui[i][j] = new objetoDeTerreno(matrizChars[i][j]);

			    }
			}

			contenedor.add(nuevoPanel);
			
		

			System.gc();
			
			this.pack();
			this.setResizable(false);
			this.setVisible(true);
			
			nuevoPanel.grabFocus();
		
	 }
	    public class objetoDeTerreno extends JLabel {
	    	JLabel label;

	    	public objetoDeTerreno(char file) {
	    	    label = new JLabel("", new ImageIcon(file + ".png"), JLabel.LEFT);

	    	    nuevoPanel.add(label);

	    		}
	    	}
	    
	    public void setTimer() {
	    	Timer timer = new Timer(500, actionC);
	    	timer.start();
	        }

	        Action actionC = new AbstractAction() {

	    	public void actionPerformed(ActionEvent evt) {
	    		nivel.getListaPooglin().get(0).interactuar();
	    		cargarMatrizVista("nuevo2", "crearpoo");
	    	   
	    	}
	        };
	    
}


