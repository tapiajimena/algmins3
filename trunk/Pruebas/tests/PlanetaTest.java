package tests;
import java.io.FileOutputStream;
import junit.framework.TestCase;
import modelo.CreadorPlanetas;
import modelo.Planeta;
import modelo.Punto;
import modelo.bloque.Aire;
import modelo.bloque.Bloque;
import modelo.bloque.Tierra;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class PlanetaTest extends TestCase {
	
	Punto posTierra;
	Bloque[][] unTerreno;
	Planeta unPlaneta;
	Tierra unaTierra ;
	Aire unAire ;
	
	public void setUp(){
		posTierra = new Punto (2,2);
		this.unTerreno = new Bloque[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++) {
				Tierra tierra=new Tierra(new Punto(i,j));
				this.unTerreno[i][j]=tierra;
			}
		}
		unPlaneta = new Planeta(4,4, unTerreno);
		unaTierra = new Tierra(posTierra);
		unAire = new Aire(posTierra);
		
	}
	
	public void testDimensiones(){
		/*
		 * Corroboro las dimensiones del Planeta creado.
		 */
		assertEquals(4,unPlaneta.getAlto());
		assertEquals(4,unPlaneta.getAncho());
	}
	
	
	public void testAgregarObstaculo(){	
		/*
		 * Agrego un bloque Tierra al Planeta y verifico las posiciones.
		 */
		unPlaneta.agregar(unaTierra);
		assertEquals(2,unPlaneta.getBloque(new Punto(2,2)).getPosicion().getX());
		assertEquals(2,unPlaneta.getBloque(new Punto(2,2)).getPosicion().getY());
	}
	
	
	public void testQuitarObstaculo(){	
		/*
		 * Elimino un bloque Tierra al Planeta y verifico que en la posicion
		 * donde estaba el bloque Tierra ahora hay Aire.
		 * Para esto compruebo que ese bloque sea traspasable.
		 */
		unPlaneta.quitarBloque(new Punto(2,2));
		assertTrue(unPlaneta.getBloque(new Punto(2,2)).esTraspasable());
	}
	
	public void testSerializacionIOXML(){
		/*Prueba donde escribo un planeta en xml y luego recupero desde el documento*/
		Planeta planetaOriginal=CreadorPlanetas.crearPlaneta(0);
		Element planetaXML=planetaOriginal.serializar();
		/*Escribiendo a xml*/
		Document doc=DocumentHelper.createDocument();
		doc.add(planetaXML);
		try {
			OutputFormat formato=OutputFormat.createPrettyPrint();
			FileOutputStream archivo = new FileOutputStream("planetaTest.xml");
			XMLWriter writer = new XMLWriter(archivo,formato);
			writer.write(doc);
			writer.flush();
			writer.close();
			archivo.close();
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
		
		/*Leyendo de XML*/
		Planeta planetaRecuperado=new Planeta(1,1,new Bloque[1][1]);
		SAXReader xmlReader = new SAXReader();
		try {
			doc = xmlReader.read("planetaTest.xml");
			planetaXML=doc.getRootElement();
			planetaRecuperado.recuperarEstado(planetaXML);
			assertEquals(planetaOriginal.getAlto(),planetaRecuperado.getAlto());
			assertEquals(planetaOriginal.getAncho(),planetaRecuperado.getAncho());
			for(int i=0;i<planetaOriginal.getAlto();i++){
				for(int j=0;j<planetaOriginal.getAncho();j++){
					assertTrue(planetaOriginal.getBloque(new Punto(i,j)).equals(planetaRecuperado.getBloque(new Punto(i,j))));
				}
			}
		} catch (DocumentException e) {
			assertTrue(false);
			e.printStackTrace();
		}
}
	public void testSerializacion(){
		Planeta planetaOriginal=CreadorPlanetas.crearPlaneta(0);
		Planeta planetaRecuperado=new Planeta(0,0,new Bloque[1][1]);
		Element planetaXML=planetaOriginal.serializar();
		planetaRecuperado.recuperarEstado(planetaXML);
		assertEquals(planetaOriginal.getAlto(),planetaRecuperado.getAlto());
		assertEquals(planetaOriginal.getAncho(),planetaRecuperado.getAncho());
		for(int i=0;i<planetaOriginal.getAlto();i++){
			for(int j=0;j<planetaOriginal.getAncho();j++){
				assertTrue(planetaOriginal.getBloque(new Punto(i,j)).equals(planetaRecuperado.getBloque(new Punto(i,j))));
			}
		}	
	}
}
