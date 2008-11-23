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

	 
	 private JLabel shagLabel;

	// private JPanel barra;
	 
	 private JLabel[][] labelMatrix;

	 private Planeta fl;
	 
	 private Pooglin unPooglin;
	 
	 private JPanel newPanel;// = new JPanel();

	 private char[][] scrapMatrix; 

	 
	 private int timeLeft;
	 
	 private  Timer timely; 
	 
	 private JPanel progBarPanel;
	 
	 private  JProgressBar progressBar;
	 
	 private AcumuladorDeTiempos timeCalc;
	
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

		
		
		
		
		test.createPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );
		
		TaladroUltrasonico unTaladro;
		 unTaladro=new TaladroUltrasonico(unPooglin);
		 
		 unPooglin.definirHabilidad(unTaladro);
		
	
		 for (int i=0; i<=4; i++){
			
			unPooglin.interactuar();
			System.out.println(i);
			
			test.createPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );

		}
		
			
   	  unPooglin.definirHabilidad(new RayoLaser(unPooglin));  

			
			 for (int i=0; i<=4; i++){
				 	
					
					unPooglin.interactuar();
					System.out.println(unPooglin.estaMuerto());
					System.out.println(i);
					
					test.createPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );

				} 
			 
			 unPooglin.definirHabilidad(null);
		      
		test.setTimer();
    }

    
    public Gui(Planeta plan, Pooglin unP)
    {
        super("THE POOGLINS: THE BEGGINING"); 
         
        cp=getContentPane();
        
        shagLabel = new JLabel("",new ImageIcon("yeababyyea.jpg"),JLabel.LEFT);//GUI background for initial load
       
        cp.add(shagLabel);
       
       
        timeCalc=new AcumuladorDeTiempos();
        timeCalc.calcTimeforMaze(10, 10, 10);
        ix=timeCalc.getSeconds();//get the seconds allowed for the level;
        timeLeft=timeCalc.getMinutes();
       
        this.unPooglin=unP;
        
        jx=0;//reset the variable used for keeping time to zero since its a new level
        //OJO
        timely = new Timer(1000,updateCursorAction);//create a timer to update the progress bar
        timely.start();//start the timer
        progBarPanel = new JPanel();//panel for progress bar
        progressBar = new JProgressBar(0, timeCalc.getMinutes()*100);//minutes returns a single digit, we have to multiply it for Bar.
        progressBar.setStringPainted(true);
        progBarPanel.add(progressBar);
        cp.add(progBarPanel,BorderLayout.NORTH);
        
         
	    
        
        newPanel = new JPanel();
       
        fl=plan;
        
        loadMatrixGui("new");
        
        
      
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
			createPoo("new", unPooglin.getPosicion().getX(), unPooglin.getPosicion().getY() );
			System.out.println(unPooglin.estaMuerto());
	      }
	   };
    
    
    public void createPoo(String event, int x, int y){
    
    	if (event == "new")
        {       
    		remove(newPanel);
    		//newPanel = new JPanel();

            char[][] temp = fl.getCTerreno();      
            
            scrapMatrix = new char [fl.getAlto()][fl.getAncho()];   
            
            for (int i = 0; i < fl.getAlto(); i++){
               for (int j = 0; j < fl.getAncho(); j++){
                   scrapMatrix[i][j]= temp[i][j];
             }}
            
            scrapMatrix[x][y] = 'Y';
           
            
            newPanel = new JPanel();
            
            newPanel.setLayout(new GridLayout(fl.getAlto(),fl.getAncho()));
            
            labelMatrix=new JLabel[fl.getAlto()][fl.getAncho()];
            

       }
       
       
         for (int i = 0; i < labelMatrix.length; i++){
             for (int j = 0; j < labelMatrix[i].length; j++){
                 labelMatrix[i][j] = new objetoDeTerreno(scrapMatrix[i][j]);
                   
             }}
        
      
       
       
        cp.add(newPanel);
        
        remove(shagLabel);
  
        System.gc();
        
        pack();
        
        setVisible (true);
        
        newPanel.grabFocus(); 
    	
    	
    	
    }
    
     public void loadMatrixGui(String event)
     {
        if (event == "new")
         {       
        	remove(newPanel);
    		//newPanel = new JPanel();

             char[][] temp = fl.getCTerreno();       
             
             scrapMatrix = new char [fl.getAlto()][fl.getAncho()];   
             
             for (int i = 0; i < fl.getAlto(); i++){
                for (int j = 0; j < fl.getAncho(); j++){
                    scrapMatrix[i][j]= temp[i][j];
              }}
                   
             newPanel = new JPanel();
             
             newPanel.setLayout(new GridLayout(fl.getAlto(),fl.getAncho()));
             
             labelMatrix=new JLabel[fl.getAlto()][fl.getAncho()];     

        }
        
        
          for (int i = 0; i < labelMatrix.length; i++){
              for (int j = 0; j < labelMatrix[i].length; j++){
                  labelMatrix[i][j] = new objetoDeTerreno(scrapMatrix[i][j]);
                  
              }}
         
          
         cp.add(newPanel);
         remove(shagLabel);
         System.gc();
         pack();
         setVisible (true);
         newPanel.grabFocus();  
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
           
            
            newPanel.add(label);
            
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
            remove(newPanel);
            remove(progBarPanel);
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



