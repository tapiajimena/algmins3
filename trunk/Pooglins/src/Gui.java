import habilidad.RayoLaser;
import habilidad.TaladroUltrasonico;

import javax.swing.*;

import pooglin.Pooglin;
import punto.Punto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import juego.Nivel;
import juego.Planeta;


@SuppressWarnings("serial")
public class Gui extends JFrame implements MouseListener 
{

	 private Container cp;

	 
	 private JLabel unLabel;

	// private JPanel barra;
	 
	 private JLabel[][] matrizGui;

	 private Planeta fl;
	 
	 private Pooglin unPooglin;
	 
	 private JPanel nuevoPanel;// = new JPanel();

	 private char[][] matrizChars; 

	 
	 private int timeLeft;
	 
	 private  Timer timely; 
	 
	 private JPanel progPanel;
	 
	 private  JProgressBar progressBar;
	 
	 private AcumuladorDeTiempos contadorDeTiempo;
	
     private int ix;
		private int jx;
		
		
	
    public static void main(String[] args)
    {
    	   
    	
    	Nivel nivel=new Nivel();
    	
    	char[][] matriz={{'A','T','T','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R'},{'T','T','T','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','R','R','R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','R','R','R','R','R','R','R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','T','T','T','T','A','A','A','A','A','A','R'},{'R','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','A','T','T','F','F','F','F','F','F','F','F','R'},{'R','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T','T'}};
	
		Planeta unPlaneta=new Planeta(matriz.length,matriz[0].length,matriz);
		
		Punto punto=new Punto(0,0);
		
		Pooglin unPooglin=new Pooglin(punto,nivel);
		
		Gui test=new Gui(unPlaneta,unPooglin);
		
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nivel.setPlaneta(unPlaneta);

		
		
		
		
		test.crearPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );
		
		TaladroUltrasonico unTaladro;
		 unTaladro=new TaladroUltrasonico(unPooglin);
		 
		 unPooglin.definirHabilidad(unTaladro);
		
	
		 for (int i=0; i<=4; i++){
			
			unPooglin.interactuar();
			System.out.println(i);
			
			test.crearPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );

		}
		
			
   	  unPooglin.definirHabilidad(new RayoLaser(unPooglin));  

			
			 for (int i=0; i<=4; i++){
				 	
					
					unPooglin.interactuar();
					System.out.println(unPooglin.estaMuerto());
					System.out.println(i);
					
					test.crearPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );

				} 
			 
			 unPooglin.definirHabilidad(null);
		      
		test.setTimer();
    }

    
    public Gui(Planeta plan, Pooglin unP)
    {
        super("THE POOGLINS: THE BEGGINING"); 
         
        cp=getContentPane();
        
        unLabel = new JLabel("",new ImageIcon("yeababyyea.jpg"),JLabel.LEFT);//GUI background for initial load
       
        cp.add(unLabel);
       
       
        contadorDeTiempo=new AcumuladorDeTiempos();
        contadorDeTiempo.calcTimeforMaze(10, 10, 10);
        ix=contadorDeTiempo.getSeconds();//get the seconds allowed for the level;
        timeLeft=contadorDeTiempo.getMinutes();
       
        this.unPooglin=unP;
        
        jx=0;//reset the variable used for keeping time to zero since its a new level
        //OJO
        timely = new Timer(1000,updateCursorAction);//create a timer to update the progress bar
        timely.start();//start the timer
        progPanel = new JPanel();//panel for progress bar
        progressBar = new JProgressBar(0, contadorDeTiempo.getMinutes()*100);//minutes returns a single digit, we have to multiply it for Bar.
        progressBar.setStringPainted(true);
        progPanel.add(progressBar);
        cp.add(progPanel,BorderLayout.NORTH);
        
         
	    
        
        nuevoPanel = new JPanel();
       
        fl=plan;
        
        cargarMatriz("new");
        
        
      
        pack();
        
        setVisible (true);
        
       
        
        
    }

    public void setTimer(){
    	Timer timer = new Timer(500, actionC);
	    timer.start();
    }
    
    Action actionC = new AbstractAction() {
    	
	      public void actionPerformed(ActionEvent evt) {
	    	  
	  		unPooglin.interactuar();
			crearPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );
			System.out.println(unPooglin.estaMuerto());
	      }
	   };
    
    
    public void crearPoo(String event, int x, int y){
    
    	if (event == "new")
        {       
    		remove(nuevoPanel);
    		//newPanel = new JPanel();

            char[][] temp = fl.getCTerreno();      
            
            matrizChars = new char [fl.getAlto()][fl.getAncho()];   
            
            for (int i = 0; i < fl.getAlto(); i++){
               for (int j = 0; j < fl.getAncho(); j++){
                   matrizChars[i][j]= temp[i][j];
             }}
            
            matrizChars[x][y] = 'Y';
           
            
            nuevoPanel = new JPanel();
            
            nuevoPanel.setLayout(new GridLayout(fl.getAlto(),fl.getAncho()));
            
            matrizGui=new JLabel[fl.getAlto()][fl.getAncho()];
            

       }
       
       
         for (int i = 0; i < matrizGui.length; i++){
             for (int j = 0; j < matrizGui[i].length; j++){
                 matrizGui[i][j] = new objetoDeTerreno(matrizChars[i][j]);
                   
             }}
        
      
       
       
        cp.add(nuevoPanel);
        
        remove(unLabel);
  
        System.gc();
        
        pack();
        
        setVisible (true);
        
        nuevoPanel.grabFocus(); 
    	
    	
    	
    }
    
     public void cargarMatriz(String event)
     {
        if (event == "new")
         {       
        	remove(nuevoPanel);
    		//newPanel = new JPanel();

             char[][] temp = fl.getCTerreno();       
             
             matrizChars = new char [fl.getAlto()][fl.getAncho()];   
             
             for (int i = 0; i < fl.getAlto(); i++){
                for (int j = 0; j < fl.getAncho(); j++){
                    matrizChars[i][j]= temp[i][j];
              }}
                   
             nuevoPanel = new JPanel();
             
             nuevoPanel.setLayout(new GridLayout(fl.getAlto(),fl.getAncho()));
             
             matrizGui=new JLabel[fl.getAlto()][fl.getAncho()];     

        }
        
        
          for (int i = 0; i < matrizGui.length; i++){
              for (int j = 0; j < matrizGui[i].length; j++){
                  matrizGui[i][j] = new objetoDeTerreno(matrizChars[i][j]);
                  
              }}
         
          
         cp.add(nuevoPanel);
         remove(unLabel);
         System.gc();
         pack();
         setVisible (true);
         nuevoPanel.grabFocus();  
     }
 
    public class objetoDeTerreno extends JLabel implements MouseListener
    {
        JLabel label;

        public objetoDeTerreno(char file)
        {
            label = new JLabel("",new ImageIcon(file+".png"),JLabel.LEFT);
           
            if (file=='Y'){
            label.addMouseListener(this);	
            }
           
            
            nuevoPanel.add(label);
            
        }

		public void mouseClicked(MouseEvent e) {
			System.out.println("Estas cliqueando al pooglin");	
			
			unPooglin.definirHabilidad(new RayoLaser(unPooglin));
			
			//objetoDeTerreno o=new objetoDeTerreno('Y');
			//labelMatrix[0][0]= o.label;
			//newPanel.add(label);
			
		}

		public void mouseEntered(MouseEvent e) {
			System.out.println("Estas sobre el boton");			
		}

		public void mouseExited(MouseEvent e) {
			System.out.println("Estas sobre el boton");			
		}

		public void mousePressed(MouseEvent e) {
			System.out.println("Estas sobre el boton");			
		}

		public void mouseReleased(MouseEvent e) {
			System.out.println("Estas sobre el boton");			
		}
    }
        
    
    
    Action updateCursorAction = new AbstractAction() {
 

		public void actionPerformed(ActionEvent e) //this inner class generates an exeption if the player takes to long to finish a level 
        {
            ix-=1;
            jx+=1;
            if(ix<0)
            {
                ix=60;
                timeLeft-=1;
            }
        if(timeLeft==0 && ix==0)
        {
            timely.stop();
            System.out.println("Game Over!");
            remove(nuevoPanel);
            remove(progPanel);
            pack();
            setVisible (true);
            timely.stop();
            
        }//end first if
            progressBar.setValue(jx);
            progressBar.setString(timeLeft+":"+ix);
        }//end actionPerformed
    };//end class

    
    

	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Estas sobre el boton");
		
	}


	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Estas sobre el boton");
		
	}


	public void mouseExited(MouseEvent arg0) {
		System.out.println("Estas sobre el boton");
		
	}


	public void mousePressed(MouseEvent arg0) {
		System.out.println("Estas sobre el boton");
		
	}


	public void mouseReleased(MouseEvent arg0) {
		System.out.println("Estas sobre el boton");
		
	}
    
}












