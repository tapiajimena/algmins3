package modelo;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

import modelo.bloque.Bloque;

public class CreadorPlanetas {
	private static CreadorPlanetas creadorDefault = null;
	public Hashtable<Character, String> tablaCharABloqueCompleteClassName = new Hashtable<Character, String>();

	public CreadorPlanetas() {
		this.cargarTablaDefault();
	}

	private static synchronized void inicializarCreadorDefault() {
		if (creadorDefault == null)
			creadorDefault = new CreadorPlanetas();
	}

	public static Planeta crearPlaneta(int id) {
		if (creadorDefault == null)
			inicializarCreadorDefault();
		char[][] matriz = null;
		char[][] m0 = { { 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T' },
				{ 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'T', 'T', 'T' },
				{ 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T' },
				{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' } };
		char[][] m1 = {
				{ 'A', 'T', 'T', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R' },
				{ 'A', 'A', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'E', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'R', 'R', 'R', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'T', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'T', 'T', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'O', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'S', 'T', 'F', 'F', 'F',
						'F', 'F', 'F', 'F', 'F', 'R' },
				{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T' } };
		char[][] m3 = {
				{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'A', 'E', 'A', 'A', 'A',
						'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'O', 'A', 'A', 'A', 'O', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'T', 'T', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'T', 'T', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R', 'R', 'R', 'R', 'R', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'H', 'H', 'H', 'H', 'H', 'S', 'H', 'H', 'H', 'H', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T' },
				{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T' },
				{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R' } };

		char[][] m2 = {
				{ 'A', 'T', 'T', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
						'R', 'R', 'R', 'R', 'R', 'R' },
				{ 'A', 'A', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'E', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'T', 'T', 'T', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'T', 'F', 'F', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'R', 'R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'T', 'T',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'T', 'T',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'T', 'T',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'T', 'T', 'T', 'R', 'R', 'R', 'R', 'R', 'T', 'R', 'R',
						'R', 'R', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'F', 'F', 'F', 'F', 'R', 'R', 'R', 'R', 'T', 'R', 'R',
						'R', 'R', 'A', 'A', 'R', 'R', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'A', 'T', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'T', 'A', 'A', 'A', 'A', 'A', 'T', 'T', 'T', 'T', 'A',
						'A', 'A', 'A', 'A', 'A', 'R' },
				{ 'R', 'F', 'F', 'F', 'A', 'A', 'A', 'A', 'A', 'A', 'O', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
						'A', 'A', 'A', 'A', 'A', 'A', 'S', 'T', 'F', 'F', 'F',
						'F', 'F', 'F', 'F', 'F', 'R' },
				{ 'R', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',
						'T', 'T', 'T', 'T', 'T', 'T' } };

		switch (id) {
		case 1:
			matriz = m1;
			break;
		case 2:
			matriz = m2;
			break;
		case 3:
			matriz = m3;
			break;
		default:
			matriz = m0;
			break;
		}
		return creadorDefault.cargarPlaneta(matriz.length, matriz[0].length,
				matriz);
	}

	/*
	 * Carga la tabla hash con valores por defecto
	 */
	private void cargarTablaDefault() {
		tablaCharABloqueCompleteClassName.put('A', "modelo.bloque.Aire");
		tablaCharABloqueCompleteClassName.put('T', "modelo.bloque.Tierra");
		tablaCharABloqueCompleteClassName.put('R', "modelo.bloque.Roca");
		tablaCharABloqueCompleteClassName.put('F', "modelo.bloque.Fuego");
		tablaCharABloqueCompleteClassName
				.put('O', "modelo.bloque.AgujeroNegro");
		tablaCharABloqueCompleteClassName.put('H', "modelo.bloque.Hielo");
		tablaCharABloqueCompleteClassName.put('E', "modelo.bloque.Entrada");
		tablaCharABloqueCompleteClassName.put('S', "modelo.bloque.Salida");
		tablaCharABloqueCompleteClassName.put('B', "modelo.bloque.Tunel");
	}

	/*
	 * Devuelve un bloque generado a partir de la tablaHash y los parametro
	 * proporcionados
	 */
	private Bloque transformarABloque(char caracter, Punto punto) {
		if (tablaCharABloqueCompleteClassName.containsKey(caracter)) {
			String nombreCompletoClase = this.tablaCharABloqueCompleteClassName
					.get(caracter);
			try {
				Class<?> classBloque = Class.forName(nombreCompletoClase);
				Constructor<?> constructorBloque = classBloque
						.getConstructor(Punto.class);
				return (Bloque) constructorBloque.newInstance(punto);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	public Planeta cargarPlaneta(int alto, int ancho, char[][] charTerreno) {
		Bloque[][] terreno = new Bloque[alto][ancho];
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				terreno[i][j] = transformarABloque(charTerreno[i][j],
						new Punto(i, j));
			}
		}
		Planeta planeta = new Planeta(alto, ancho, terreno);
		return planeta;
	}
}
