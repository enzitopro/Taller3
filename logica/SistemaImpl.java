package logica;

import dominio.Hechizo;
import dominio.HechizoFuego;
import dominio.HechizoAgua;
import dominio.HechizoPlanta;
import dominio.HechizoTierra;
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
				if (tipo.equalsIgnoreCase("fuego")) {
					int duracionQuemadura = Integer.valueOf(partes[3]);
					HechizoFuego hechizoFuego = new HechizoFuego(nombre, tipo, dano, duracionQuemadura);
					listaGlobalHechizos.add(hechizoFuego);
				}
				if (tipo.equalsIgnoreCase("tierra")) {
					int mejoraDefensa = Integer.valueOf(partes[3]);
					HechizoTierra hechizoTierra = new HechizoTierra(nombre, tipo, dano, mejoraDefensa);
					listaGlobalHechizos.add(hechizoTierra);
				}
				if (tipo.equalsIgnoreCase("planta")) {
					String[] partesPlanta = partes[3].split(",");
					int duracionStun = Integer.valueOf(partesPlanta[0]);
					int cantPlantas = Integer.valueOf(partesPlanta[1]);
					HechizoPlanta hechizoPlanta = new HechizoPlanta(nombre, tipo, dano, duracionStun, cantPlantas);
					listaGlobalHechizos.add(hechizoPlanta);
				}
				if (tipo.equalsIgnoreCase("agua")) {
					String[] partesAgua = partes[3].split(",");
					int cantidadHeal = Integer.valueOf(partesAgua[0]);
					int presionDeAgua = Integer.valueOf(partesAgua[1]);
					HechizoAgua hechizoAgua = new HechizoAgua(nombre, tipo, dano, cantidadHeal, presionDeAgua);
					listaGlobalHechizos.add(hechizoAgua);
				}
				
			}
		lectorHechizos.close();
		} catch (Exception e) {
			System.out.println("Archivo no encontrado");
		}
		
	}

	@Override
	public void cargarMagos() {
		try {
			File magos = new File("Magos.txt");
			Scanner lectorMagos = new Scanner(magos);
			while (lectorMagos.hasNextLine()) {
				String linea = lectorMagos.nextLine();
				String[] partesMago = linea.split(";");
				String nombre = partesMago[0];
				Mago nuevoMago = new Mago(nombre);	
				String magoHechizos = partesMago[1];
				String[] nombresHechizos = magoHechizos.split("\\|");
				for (int i=0; i < nombresHechizos.length; i++) {
					Hechizo hechizoEncontrado = buscarHechizo(nombresHechizos[i]);
					if (hechizoEncontrado != null) {
						nuevoMago.getListaHechizos().add(hechizoEncontrado);
					}
				}
				listaGlobalMagos.add(nuevoMago);
			}
			lectorMagos.close();
		} catch (Exception e) {
			System.out.println("Archivo no encontrado");
		}
	}
	
	private Hechizo buscarHechizo(String nombreBuscado) {
		for (Hechizo hechizo : listaGlobalHechizos) {
			if (hechizo.getNombre().equalsIgnoreCase(nombreBuscado)) {
				return hechizo;
			}
		}
		return null;
	}
}
