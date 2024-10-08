package algoritmos;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import controller.ClaseAuxiliar;
import grafos.Grafo;

public class Prim {
	
	public Grafo crearGrafoPrim(Grafo grafoOriginal) {
		ArrayList<String> listaDeVertices = new ArrayList<String>(grafoOriginal.getListaDeVertices().keySet());
		HashSet<String> verticesVisitados = new HashSet<String>();
		Grafo grafoPrim = new Grafo();	
		copiarVerticesFromGrafoOriginal(grafoPrim, grafoOriginal);
		verticesVisitados.add(listaDeVertices.get(0));
		while (verticesVisitados.size() < listaDeVertices.size()){
			int peso = 100;
			String verticeDestino = "";
			String verticeOrigen = "";
			for(String vertice: verticesVisitados) {
				
				for(String arista: grafoOriginal.getListaDeVertices().get(vertice).getListaDeAristas().keySet()) {
					if(grafoOriginal.getListaDeVertices().get(vertice).getListaDeAristas().get(arista) < peso && !verticesVisitados.contains(arista) ) {
						peso = grafoOriginal.getListaDeVertices().get(vertice).getListaDeAristas().get(arista);
						verticeDestino = arista;
						verticeOrigen = vertice;
					}
				}
			}
			grafoPrim.agregarArista(verticeOrigen, verticeDestino, peso);
			verticesVisitados.add(verticeDestino);
			System.out.println(verticeOrigen + " --"+ peso + "--> " + verticeDestino);
		}		
		return grafoPrim;
	}

	private String getVerticeDestinoAristaMenorPeso(Grafo grafoOriginal, String verticeActual) {
		return grafoOriginal.getVerticeConAristaMenorPeso(verticeActual);
	}



	private boolean esVerticeActualYaEnlazadoConVerticeAnterior(Grafo grafoOriginal, Grafo grafoPrim, String verticeActual) {
		String verticeDestino = grafoOriginal.getListaDeVertices().get(verticeActual).getVerticeConAristaMenorPeso();
		return grafoPrim.getListaDeVertices().get(verticeActual).contieneArista(verticeDestino);
	}

	private void agregarAristaToGrafoPrim(Grafo grafoOriginal, Grafo grafoPrim, String verticeActual) {
		String verticeDestino = getVerticeDestinoAristaMenorPeso(grafoOriginal, verticeActual);
		int peso = grafoOriginal.getListaDeVertices().get(verticeActual).getListaDeAristas().get(verticeDestino);
		grafoPrim.agregarArista(verticeActual, verticeDestino, peso);
		
	}

	private void copiarVerticesFromGrafoOriginal(Grafo grafoPrim, Grafo grafoOriginal) {
		for(String s : grafoOriginal.getListaDeVertices().keySet()) {
			grafoPrim.crearVertice(s,null);
		}
	}

	private  void buscarNuevaAristaConMenorPeso(Grafo grafoOriginal, Grafo grafoPrim, String verticeActual) {
		for(String verticeAlcanzable: ClaseAuxiliar.verticesAlcanzables(grafoPrim, getVerticeDestinoAristaMenorPeso(grafoOriginal, verticeActual))) {
			if(grafoOriginal.getListaDeVertices().get(verticeActual).contieneArista(verticeAlcanzable)) {
				grafoOriginal.quitarArista(verticeActual, verticeAlcanzable);
			}
		}	
	}





/*private static boolean seFormaCircuito(Grafo grafoActual, Grafo grafoNuevoPrim, String verticeActual,
			String nuevaArista, int nuevaAristaPeso) {
		Grafo grafoPrimDePrueba = grafoNuevoPrim;
		grafoPrimDePrueba.getListaDeVertices().get(verticeActual).agregarArista(nuevaArista, nuevaAristaPeso);
		return grafoPrimDePrueba.buscarCantidadAristas() >= grafoPrimDePrueba.getListaDeVertices().size();
	}
 */

/*
			// SI LA ARISTA DE MENOR PESO ES HACIA UN VERTICE QUE YA FUE ENLAZADO CON EL
			// ACTUAL. BUSCAR OTRO VERTICE
			if (grafoActual.getListaDeVertices().get(verticeActual).getNombreMenorPeso() == grafoActual
					.getListaDeVertices().get(verticeAnterior).getNombreMenorPeso()) {
				grafoActual.getListaDeVertices().get(verticeActual).quitarArista(verticeAnterior);

			}
			// ASIGNAR LA NUEVA ARISTA DE MENOR PESO, TOMANDO LA REFERENCIA DEL GRAFO
			// ORIGINAL
			String nuevaArista = grafoActual.getListaDeVertices().get(verticeActual).getNombreMenorPeso();
			int nuevaAristaPeso = grafoActual.getListaDeVertices().get(verticeActual).getMenorPeso();

			if (!seFormaCircuito(grafoActual, grafoNuevoPrim, verticeActual, nuevaArista, nuevaAristaPeso)) {
				grafoNuevoPrim.getListaDeVertices().get(verticeActual).agregarArista(nuevaArista, nuevaAristaPeso);
			} else {

			}

	public static Set<String> alcanzables(Grafo grafo) {

		Set<String> setAlcanzables = new HashSet<String>();
		inicializarAlcanzables();
		while (listaVertices.size() > 0) {
			verticesVisitados.add(listaVertices.get(0));
			setAlcanzables.add(listaVertices.get(0));
			System.out.println(listaVertices.get(0));
			agregarVecinosPendientes(grafo, listaVertices.get(0));
			listaVertices.remove(0);
		}
		return setAlcanzables;
	}
 */
}
