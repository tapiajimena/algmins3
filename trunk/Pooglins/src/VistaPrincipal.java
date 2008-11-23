
	import java.awt.Container;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
import java.util.ArrayList;


	import javax.swing.AbstractAction;
	import javax.swing.Action;
	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	import javax.swing.Timer;

	import juego.Nivel;
	import juego.Planeta;
import pooglin.Pooglin;


	@SuppressWarnings("serial")
	public class VistaPrincipal extends JFrame {

	    private Container cp;

	    private JLabel[][] matrizGui;

	    private Planeta planeta;

	    private Pooglin unPooglin;

	    private JPanel nuevoPanel;

	    private char[][] matrizChars;

		private ArrayList<Pooglin> lista;



	    public VistaPrincipal (Nivel nivel) {
		super("THE POOGLINS: THE BEGGINING");

		cp = getContentPane();
		
		this.unPooglin = nivel.getListaPooglin().get(0);

		nuevoPanel = new JPanel();

		planeta = nivel.getPlaneta();
		
		lista = nivel.getListaPooglin();
		
		m("new","none");
		
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    }

	    public void setTimer() {
		Timer timer = new Timer(500, actionC);
		timer.start();
	    }

	    Action actionC = new AbstractAction() {

		public void actionPerformed(ActionEvent evt) {

		    unPooglin.interactuar();
		    m("new","poo");
		    //crearPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY());
		 
		}
	    };


	    public void m(String event,String event2) {
			if (event == "new") {
			    remove(nuevoPanel);

			    char[][] temp = planeta.getCTerreno();
			    matrizChars = new char[planeta.getAlto()][planeta.getAncho()];
			    for (int i = 0; i < planeta.getAlto(); i++) {
				for (int j = 0; j < planeta.getAncho(); j++) {
				    matrizChars[i][j] = temp[i][j];
				}
			    }
			    
			    nuevoPanel = new JPanel();
			    nuevoPanel.setLayout(new GridLayout(planeta.getAlto(), planeta.getAncho()));
			    matrizGui = new JLabel[planeta.getAlto()][planeta.getAncho()];
				if (event2 == "poo") {
					//matrizChars[unPooglin.getPosicion().getX()][unPooglin.getPosicion().getY()] = 'Y';
					int x,y;
					int index=0;
					while(index<lista.size()){
						
						x=lista.get(index).getPosicion().getX();
						y=lista.get(index).getPosicion().getY();				
						//"Y" es el pooglin
						matrizChars[x][y] = 'Y';
						index++;					
					}
				
				}
			}
			
			for (int i = 0; i < matrizGui.length; i++) {
			    for (int j = 0; j < matrizGui[i].length; j++) {
				matrizGui[i][j] = new objetoDeTerreno(matrizChars[i][j]);

			    }
			}
			cp.add(nuevoPanel);
		
			System.gc();
			this.pack();
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
	    
	    
	}
