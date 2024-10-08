package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import grafos.Grafo;

public class ClaseAuxiliar {
	

	
	
	public static Set<String> verticesAlcanzables(Grafo grafo, String vertice) {
		Set<String> setAlcanzables = new HashSet<String>();
		ArrayList<String> vertices = new ArrayList<String>();
		vertices.add(vertice);
		ArrayList<String> visitados = new ArrayList<String>();
		while (vertices.size() > 0) {
			visitados.add(vertices.get(0));
			setAlcanzables.add(vertices.get(0));
			agregarVecinosPendientes(grafo, vertices.get(0), visitados, vertices);
			vertices.remove(0);
		}
		return setAlcanzables;
	}
	
	private static void agregarVecinosPendientes(Grafo grafo, String vertice, ArrayList<String> verticesVisitados, ArrayList<String> listaDeVertices) {
			for (String verticeVecino : grafo.getListaDeVertices().get(vertice).listaDeVecinos()) {
				if (!verticesVisitados.contains(verticeVecino) && !listaDeVertices.contains(verticeVecino)) {
					listaDeVertices.add(verticeVecino);
					verticesVisitados.add(verticeVecino);}
			}
		}
	
	public static Set<String> verticesAlcanzablesPrim(Grafo grafo, String vertice) {
		Set<String> setAlcanzables = new HashSet<String>();
		ArrayList<String> vertices = new ArrayList<String>();
		vertices.add(vertice);
		ArrayList<String> visitados = new ArrayList<String>();
		while (vertices.size() > 0) {
			visitados.add(vertices.get(0));
			setAlcanzables.add(vertices.get(0));
			agregarVecinosPendientesPrim(grafo, vertices.get(0), visitados, vertices);
			vertices.remove(0);
		}
		return setAlcanzables;
	}
	
	private static void agregarVecinosPendientesPrim(Grafo grafo, String vertice, ArrayList<String> verticesVisitados, ArrayList<String> listaDeVertices) {
			for (String verticeVecino : grafo.getListaDeVertices().get(vertice).getVerticesEnlazados().keySet()) {
				if (!verticesVisitados.contains(verticeVecino) && !listaDeVertices.contains(verticeVecino)) {
					listaDeVertices.add(verticeVecino);
					verticesVisitados.add(verticeVecino);}
			}
		}
	
	
	
	
	}



