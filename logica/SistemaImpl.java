package logica;

import dominio.Hechizo;
import dominio.Mago;
import java.util.ArrayList;

public class SistemaImpl implements ISistema {
	private ArrayList<Hechizo> listaGlobalHechizos;
	private ArrayList<Mago> listaGlobalMagos;
	
	public SistemaImpl() {
		this.listaGlobalHechizos = new ArrayList<>();
		this.listaGlobalMagos = new ArrayList<>();
	}

	@Override
	public void cargarHechizos() {
		
	}

	@Override
	public void cargarMagos() {
	
	}
}
