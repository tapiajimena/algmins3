public class Programa {

	
	public static void main(String[] args) {
	
	
	Punto punto=new Punto(1,2);
	Pooglin unPooglin=new Pooglin(punto);
	

	System.out.println(unPooglin.getPosicionX()+" "+unPooglin.getPosicionY());
	
	unPooglin.caminar();
	
	System.out.println(unPooglin.getPosicionX()+" "+unPooglin.getPosicionY());
	
	/*
	 
	Bloque[][] terreno = new  Fuego[3][3];
	
	//terreno[1][1]=new Aire(punto);
	
	Punto punto1=new Punto(1,1);
	
	terreno[0][0]=new Fuego(punto1);
		
	Planeta plan=new Planeta(3,3,terreno);
	
	
	
	Fuego test=(Fuego) plan.getBloque(0,0);
	
	test.queES();*/
	
	
	
	}

}