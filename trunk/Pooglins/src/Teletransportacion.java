public class Teletransportacion extends Habilidad {
	private int contadorPasos=5;
	@Override
	public void interactuar(Pooglin pooglin, Planeta planeta) {
		if(contadorPasos>0){
			Punto punto=pooglin.getPosicionX();
			punto.setx(punto.getx()+ 20);
			pooglin.definirInteraccion(null);
			//pooglin.definirInteraccion(new Caminar());
		}else{
			contadorPasos--;
			//pooglin.caminar(planeta);
		}
		
	}
	 
}
 
