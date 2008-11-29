package tests;
import org.dom4j.Element;

import Modelo.Punto;

import junit.framework.TestCase;


public class TestPunto extends TestCase {
    
    public void testGetSetCopiarPunto() {
	Punto punto=new Punto(1,100);
	Punto otroPunto=new Punto(punto);
	
	assertEquals(1,punto.getX());
	assertEquals(100,punto.getY());
	
	assertEquals(1,otroPunto.getX());
	assertEquals(100,otroPunto.getY());
	
	punto.setX(20);
	punto.setY(11);
	
	assertEquals(20,punto.getX());
	assertEquals(11,punto.getY());
	
	punto.copiar(otroPunto);
	
	assertEquals(1,punto.getX());
	assertEquals(100,punto.getY());
    }

    public void testEqualsObject() {
	Punto puntoX=new Punto(1,100);
	Punto puntoY=new Punto(puntoX);
	Punto puntoZ=new Punto(puntoY);
	
	/*Pruebo : reflexibidad,simetria,transitibidad*/
	assertTrue(puntoX.equals(puntoX));
	assertEquals(puntoX.equals(puntoY),puntoY.equals(puntoX));
	assertTrue(puntoX.equals(puntoZ));
	
	/*Pruebo la comparacion vectorial*/
	assertFalse(puntoX.equals(new Punto(1,1)));
	assertFalse(puntoX.equals(new Punto(0,100)));
	assertFalse(puntoX.equals(new Punto(2,8)));
	
    }

    public void testDistancia() {
	Punto puntoX=new Punto(1,1);
	Punto puntoY=new Punto(0,0);
	/*Pruebo el valor de distancia usando cambiando los punto arbitrariamente*/
	double distancia=Math.pow(2,1/2);
	assertEquals(distancia,puntoX.distancia(puntoY));
	
	puntoY.setX(1);
	distancia=Math.pow(1,1/2);
	assertEquals(distancia,puntoX.distancia(puntoY));
	
	puntoY.setY(1);
	distancia=0;
	assertEquals(0.0,puntoX.distancia(puntoY));

    }

    public void testPuntoRelativo() {
	Punto punto1=new Punto(1,1);
	Punto punto2;
	
	assertTrue(punto1.puntoRelativo(0,0).equals(punto1));
	
	punto2=new Punto(punto1);
	punto2.setX(punto1.getX()+1);
	assertTrue(punto1.puntoRelativo(1,0).equals(punto2));
	
	punto2=new Punto(punto1);
	punto2.setY(punto1.getY()+1);
	assertTrue(punto1.puntoRelativo(0,1).equals(punto2));
	
	punto2=new Punto(punto1);
	punto2.setY(punto1.getY()+1);
	punto2.setX(punto1.getX()+1);
	assertTrue(punto1.puntoRelativo(1,1).equals(punto2));
	
    }

    public void testSumar() {
	Punto punto=new Punto(1,1);
	Punto otroPunto=new Punto(7,23);
	punto.sumar(otroPunto);
	assertTrue(punto.equals(new Punto(8,24)));
    }
    public void testSerializacion(){
    	Punto punto=new Punto(0,7);
    	Element elemento=punto.serializar();
    	assertEquals(0,Integer.parseInt(elemento.attributeValue("posicionX")));
    	assertEquals(7,Integer.parseInt(elemento.attributeValue("posicionY")));
    	Punto otroPunto= new Punto(0,0);
    	otroPunto.recuperarEstado(elemento);
    	assertEquals(0,otroPunto.getX());
    	assertEquals(7,otroPunto.getY());
    }
}
