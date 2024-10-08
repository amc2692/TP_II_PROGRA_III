package grafos;

import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Grafo {
	
	private HashMap<String, Vertice> listaDeVertices;
	
	public Grafo() {
		this.listaDeVertices = new HashMap<String, Vertice>();
	}
	
	public void crearVertice(String nombre, Coordinate coord) {
		listaDeVertices.put(nombre, new Vertice(nombre, coord));
	}
	
	public void agregarArista(String origen, String destino, int peso) {
		listaDeVertices.get(origen).agregarArista(destino, peso);
		listaDeVertices.get(destino).agregarArista(origen, peso);
	}
	
	public void enlazarVertices(String verticeOrigen, String verticeDestino) {
		listaDeVertices.get(verticeOrigen).agregarVerticeToEnlazadados(verticeDestino);
		listaDeVertices.get(verticeDestino).agregarVerticeToEnlazadados(verticeOrigen);
	}
	
	public void quitarArista(String origen, String destino) {
		listaDeVertices.get(origen).quitarArista(destino);
		listaDeVertices.get(destino).quitarArista(origen);
	}
	
	public void eliminarVertice(String origen) {
		for(String s: listaDeVertices.keySet()) {
			listaDeVertices.get(s).quitarArista(origen);
		}
		listaDeVertices.remove(origen);
	}
	
	public String getVerticeConAristaMenorPeso(String verticeOrigen) {
		return listaDeVertices.get(verticeOrigen).getVerticeConAristaMenorPeso();
	}
	
	
	public String getInfoVertices() {
		StringBuilder sb = new StringBuilder();
		for(String s: listaDeVertices.keySet()) {
			sb.append(listaDeVertices.get(s).getInfo());
			sb.append("----------------\n");
		}
		return sb.toString();
	}

	public HashMap<String, Vertice> getListaDeVertices() {
		return listaDeVertices;
	}
	
}
