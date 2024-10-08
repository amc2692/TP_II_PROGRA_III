package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import grafos.Grafo;
import visual.VentanaPrincipal;
import visual.VentanaRegistros;

public class Controller {
	
	private VentanaPrincipal interfazUsuario;
	private VentanaRegistros interfazRegistros;
	private Grafo grafo;
	private Grafo grafoPrim;
	
	
	
	public Controller() {
		this.grafo = new Grafo();
		this.grafoPrim = new Grafo();
		this.interfazUsuario = new VentanaPrincipal();
		this.interfazRegistros = new VentanaRegistros();
		inicializarBotones();
	}
	
	public void inicializarBotones() {
		interfazRegistros.buttonGuardarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(interfazRegistros.buttonRadio.isSelected()) {
					String vertice = interfazRegistros.fieldVertice.getText();
					Coordinate coord = getCoordenadasFromUbicacion();
					grafo.crearVertice(vertice, coord);
					marcarUbicacion(vertice, coord);	
				}
				else {
				
					if(interfazRegistros.fieldVertice.getText().isEmpty()
						|| interfazRegistros.fieldLongitud.getText().isEmpty()
						|| interfazRegistros.fieldLatitud.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Ingrese el nombre del vertice / coordenadas");
				}
					else {
						String vertice = interfazRegistros.fieldVertice.getText();
						double latitud = Double.parseDouble(interfazRegistros.fieldLatitud.getText());
						double longitud = Double.parseDouble(interfazRegistros.fieldLongitud.getText());
						Coordinate coord = new Coordinate(latitud, longitud);
						grafo.crearVertice(vertice, coord);
						marcarUbicacion(vertice, coord);
					}
				}
				actualizarAreaText();
				limpiarTextFields();
			}

		});
		
		interfazRegistros.buttonGuardarArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(interfazRegistros.fieldOrigen.getText().isEmpty()
						|| interfazRegistros.fieldDestino.getText().isEmpty()
						|| interfazRegistros.fieldPeso.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Ingrese el vertice destino / origen / peso");
				}else {
					String verticeOrigen = interfazRegistros.fieldOrigen.getText();
					String verticeDestino = interfazRegistros.fieldDestino.getText();
					int pesoArista = Integer.parseInt(interfazRegistros.fieldPeso.getText());
					grafo.agregarArista(verticeOrigen,verticeDestino,pesoArista);
					crearLineaEntrePuntos(grafo.getListaDeVertices().get(verticeOrigen).getCoordenadas(), 
							grafo.getListaDeVertices().get(verticeDestino).getCoordenadas());
					actualizarAreaText();
					limpiarTextFields();
				}
			}
		});
		
	
		interfazUsuario.buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazUsuario.frame.dispose();
				if(interfazRegistros.frame.isVisible()) {
					interfazRegistros.frame.dispose();
				}
			}
		});
		
		interfazRegistros.buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazRegistros.frame.dispose();
			}
		});
		agregarUbicaciones();
		
	}
	
	public void agregarUbicaciones() {
		interfazRegistros.boxUbicaciones.addItem("ARGENTINA");
		interfazRegistros.boxUbicaciones.addItem("BRASIL");
		interfazRegistros.boxUbicaciones.addItem("COLOMBIA");
		interfazRegistros.boxUbicaciones.addItem("CANADA");
		interfazRegistros.boxUbicaciones.addItem("ESTADOS UNIDOS");
		interfazRegistros.boxUbicaciones.addItem("MEXICO");
		interfazRegistros.boxUbicaciones.addItem("PARAGUAY");
		interfazRegistros.boxUbicaciones.addItem("PERU");
		interfazRegistros.boxUbicaciones.addItem("URUGUAY");
		interfazRegistros.boxUbicaciones.addItem("VENEZUELA");
	}
	
	public Coordinate getCoordenadasFromUbicacion() {
		switch(interfazRegistros.boxUbicaciones.getSelectedItem().toString()) {
		case "ARGENTINA" : return new Coordinate(-34.76, -61.92);
		case "BRASIL" : return new Coordinate(-17.88, -48.32);
		case "COLOMBIA" : return new Coordinate(2.94, -72.75);
		case "CANADA" : return new Coordinate(54.74, -100.35);
		case "ESTADOS UNIDOS" : return new Coordinate(37.33, -93.50);
		case "MEXICO" : return new Coordinate(24.19, -102.30);
		case "PARAGUAY" : return new Coordinate(-23.47, -58.24);
		case "PERU" : return new Coordinate(-10.48, -73.98);
		case "URUGUAY" : return new Coordinate(-33.20, -55.68);
		case "VENEZUELA" : return new Coordinate(7.13, -64.47);
		default:
			break;
		}
		return null;
	}
	
	private void limpiarTextFields(){
		interfazRegistros.fieldDestino.setText(null);
		interfazRegistros.fieldLatitud.setText(null);
		interfazRegistros.fieldLongitud.setText(null);
		interfazRegistros.fieldOrigen.setText(null);
		interfazRegistros.fieldPeso.setText(null);
		interfazRegistros.fieldVertice.setText(null);
	}
	
	public void crearLineaEntrePuntos(Coordinate a, Coordinate b) {
		ArrayList<Coordinate> ruta = new ArrayList<Coordinate>();
		// MAPPOLYGONIMPL UTILIZA TRES COORDENADAS PARA CREAR UN POLIGONO
		// PARA CREAR UNA LINEA ENTRE DOS COORDENADAS
		// SE LE DEBE PASAR UN ARREGLO DONDE SE REPITA UNA COORDENADA CUALQUIERA
		ruta.add(a);
		ruta.add(b);
		ruta.add(b);

		interfazUsuario.mapa.addMapPolygon(new MapPolygonImpl(ruta));

	}
	
	
	private void marcarUbicacion(String vertice, Coordinate coord) {
		MapMarker ubicacion = new MapMarkerDot(vertice, coord);
		ubicacion.getStyle().setBackColor(Color.RED);
		ubicacion.getStyle().setColor(Color.orange);
		interfazUsuario.mapa.addMapMarker(ubicacion);
	}
	
	private void actualizarAreaText() {
		interfazUsuario.textArea.setText(grafo.getInfoVertices());
	}
	

}
