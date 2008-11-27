package juego;

public class CreadorPlanetas {
    static public Planeta crearPlaneta(int id){
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
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },	
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','T', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'T', 'T', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','T', 'O', 'A', 'A', 'A', 'A', 'S', 'T', 'F', 'F', 'F','F', 'F', 'F', 'F', 'F', 'R' },
		{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'T', 'T', 'T', 'T' } 
	};
	char[][] m2={
		{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A','R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R' },
		{ 'A', 'A', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'T', 'T', 'T', 'T', 'T', 'T', 'T','T', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','O', 'A', 'A', 'A', 'O', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A','T', 'T', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'R', 'R', 'R', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'T', 'T', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
		{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'R', 'R','R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A','A', 'A', 'A', 'A', 'A', 'R' },
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
	
	/*char[][] m3;
	char[][] m4;
	char[][] m5;
	char[][] m6;*/
	
	switch(id){
		case 1:matriz=m1;break;
		case 2:matriz=m2;break;
		/*case 3:matriz=m3;break;
		case 4:matriz=m4;break;
		case 5:matriz=m5;break;
		case 6:matriz=m6;break;*/
		default :matriz=m0;break;
	}
	return new Planeta(matriz.length, matriz[0].length, matriz);
    }
}
