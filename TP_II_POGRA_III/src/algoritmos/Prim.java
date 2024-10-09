package algoritmos;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import controller.ClaseAuxiliar;
import grafos.Grafo;

public class Prim {
	
	public static Grafo crearGrafoPrim(Grafo grafoOriginal) {
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

	
	private static void copiarVerticesFromGrafoOriginal(Grafo grafoPrim, Grafo grafoOriginal) {
		for(String vertice : grafoOriginal.getListaDeVertices().keySet()) {
			grafoPrim.crearVertice(vertice ,grafoOriginal.getListaDeVertices().get(vertice).getCoordenadas() );
		}
	}

	private static boolean esConexo(Grafo grafo) {
		return ClaseAuxiliar.verticesAlcanzablesVerticeRandom(grafo).size() == grafo.getListaDeVertices().size();
		
	}
	
	
}
