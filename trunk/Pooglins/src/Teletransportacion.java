public class Teletransportacion extends Habilidad {
	private int contadorPasos=5;
	@Override
	public void interactuar(Pooglin pooglin, Planeta planeta) {
		if(contadorPasos>0){
			pooglin.setPosicionX(pooglin.getPosicionX()+ 20);
			pooglin.definirInteraccion(null);
			pooglin.caminar();
		}else{
			contadorPasos--;
			pooglin.caminar();
		}
		
	}
	 
}
 
