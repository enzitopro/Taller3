package dominio;

import java.util.ArrayList;

public class Mago {
	private String nombre;
	private ArrayList<Hechizo> listaHechizos;
	
	public Mago(String nombre) {
		this.nombre = nombre;
		listaHechizos = new ArrayList<>();
	}
	
	public double calcularPuntajeTotal() {
		double puntajeTotal = 0;
		for (Hechizo hechizoActual : listaHechizos) {
			puntajeTotal += hechizoActual.calcularPuntuacion();
		}
		return puntajeTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Hechizo> getListaHechizos() {
		return listaHechizos;
	}

	public void setListaHechizos(ArrayList<Hechizo> listaHechizos) {
		this.listaHechizos = listaHechizos;
	}
	
	public String generarLineaArchivo() {
		String linea = this.nombre + ";";
		for (int i=0; i < this.listaHechizos.size(); i++) {
			linea += this.listaHechizos.get(i).getNombre();
			
			if (i < this.listaHechizos.size() - 1) {
				linea += "|";
			}
		}
		return linea;
	}
}
