package juego;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

import bloque.Bloque;

public class CreadorPlanetas {
	private static CreadorPlanetas creadorDefault=null;
	public Hashtable<Character , String> tablaCharABloqueCompleteClassName=new Hashtable<Character , String>();
	
    public CreadorPlanetas(){
    	this.cargarTablaDefault();
    }
	private static synchronized void inicializarCreadorDefault(){
		if(creadorDefault==null)creadorDefault=new CreadorPlanetas();
	}
    public static Planeta crearPlaneta(int id){
    	if(creadorDefault==null)
    		inicializarCreadorDefault();
    	char[][] matriz = null;
    	char[][] m0 = {
    			{ 'A','A','A','A','A','A','A','A','A','A'},
    			{ 'A','A','A','A','A','A','A','A','A','A'},
    			{ 'A','A','A','A','A','A','A','A','A','A'},
    			{ 'A','A','A','A','A','A','A','A','A','A'},
    			{ 'A','A','T','T','T','T','T','T','T','T'},
    			{ 'T','T','T','A','A','A','A','T','T','T'},
    			{ 'T','T','T','T','T','T','T','T','T','T'},
    			{ 'A','A','A','A','A','A','A','A','A','A'},
    			{ 'A','A','A','A','A','A','A','A','A','A'},
    			{ 'A','A','A','A','A','A','A','A','A','A'}
    	};
    	char[][] m1= {
    			{ 'A', 'T', 'T', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R' },
    			{ 'A', 'A', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'R', 'R', 'R', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },	
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','T', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'T', 'T', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'S', 'T', 'F', 'F', 'F','F', 'F', 'F', 'F', 'F', 'R' },
    			{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T' } 
    	};
    	char[][] m2={
    			{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A','R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
    			{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','O', 'A', 'A', 'A', 'O', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','T', 'T', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'T', 'T', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R', 'R', 'R', 'R', 'R', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'H', 'H', 'H', 'H', 'H', 'S', 'H', 'H', 'H', 'H', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },	
				{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T' },
				{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T' },
				{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R' }
    	};
    	
    	/*
		 * char[][] m3; char[][] m4; char[][] m5; char[][] m6;
		 */

		switch (id) {
		case 1:
			matriz = m1;
			break;
		case 2:
			matriz = m2;
			break;
		/*
		 * case 3:matriz=m3;break; case 4:matriz=m4;break; case
		 * 5:matriz=m5;break; case 6:matriz=m6;break;
		 */
		default:
			matriz = m0;
			break;
		}
		return creadorDefault.cargarPlaneta(matriz.length, matriz[0].length, matriz);
	}
	/*
	 * Carga la tabla hash con valores por defecto
	*/
    private void cargarTablaDefault(){
    	tablaCharABloqueCompleteClassName.put('A', "bloque.Aire");
    	tablaCharABloqueCompleteClassName.put('T', "bloque.Tierra");
    	tablaCharABloqueCompleteClassName.put('R', "bloque.Roca");
    	tablaCharABloqueCompleteClassName.put('F', "bloque.Fuego");
    	tablaCharABloqueCompleteClassName.put('O', "bloque.AgujeroNegro");
    	tablaCharABloqueCompleteClassName.put('H', "bloque.Hielo");
    	tablaCharABloqueCompleteClassName.put('E', "bloque.Entrada");
    	tablaCharABloqueCompleteClassName.put('S', "bloque.Salida");
    	tablaCharABloqueCompleteClassName.put('B', "bloque.Tunel");
    }
    /*
     * Devuelve un bloque generado a partir de la tablaHash y los parametro proporcionados
    */
    private Bloque transformarABloque(char caracter, Punto punto) {
		if(tablaCharABloqueCompleteClassName.containsKey(caracter)){
			String nombreCompletoClase=this.tablaCharABloqueCompleteClassName.get(caracter);
			try {
				Class<?> classBloque= Class.forName(nombreCompletoClase);
				Constructor<?> constructorBloque=classBloque.getConstructor(Punto.class);
				return (Bloque)constructorBloque.newInstance(punto);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
    /*
     * */
    public Planeta cargarPlaneta(int alto, int ancho, char[][] charTerreno){
    	Bloque[][] terreno=new Bloque[alto][ancho];
    	for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				terreno[i][j] = transformarABloque(charTerreno[i][j],new Punto(i, j));
			}
		}
    	Planeta planeta=new Planeta(alto,ancho,terreno);
    	return planeta;
    }
}
