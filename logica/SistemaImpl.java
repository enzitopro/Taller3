package logica;

import dominio.Hechizo;
import dominio.Mago;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaImpl implements ISistema {
	private ArrayList<Hechizo> listaGlobalHechizos;
	private ArrayList<Mago> listaGlobalMagos;
	
	public SistemaImpl() {
		this.listaGlobalHechizos = new ArrayList<>();
		this.listaGlobalMagos = new ArrayList<>();
	}

	@Override
	public void cargarHechizos() {
		try {
			File hechizos = new File("Hechizos.txt");
			Scanner lectorHechizos = new Scanner(hechizos);
			while (lectorHechizos.hasNextLine()) {
				String linea = lectorHechizos.nextLine();
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String tipo = partes[1];
				int dano = Integer.parseInt(partes[2]);
				
				
			}
			
		} catch (Exception e) {
			System.out.println("Archivo no encontrado");
		}
		
	}

	@Override
	public void cargarMagos() {
	
	}
}
