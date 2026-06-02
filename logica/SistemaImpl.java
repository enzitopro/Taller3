package logica;

import dominio.Hechizo;
import dominio.HechizoFuego;
import dominio.HechizoAgua;
import dominio.HechizoPlanta;
import dominio.HechizoTierra;
import dominio.Mago;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
		// System.out.println("EXITO: Se han cargado "+listaGlobalHechizos.size()+ " hechizos en el sistema");
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
		// System.out.println("EXITO: Se han cargado:"+listaGlobalMagos.size()+" magos en el sistema");
	}
	
	private Hechizo buscarHechizo(String nombreBuscado) {
		for (Hechizo hechizo : listaGlobalHechizos) {
			if (hechizo.getNombre().equalsIgnoreCase(nombreBuscado)) {
				return hechizo;
			}
		}
		return null;
	}

	@Override
	public void mostrarTodosHechizos(boolean mostrarPuntaje) {
		System.out.println("--- LISTA DE HECHIZOS ---");
		for (Hechizo hechizo : listaGlobalHechizos) {
			if (mostrarPuntaje) {
				System.out.println("Nombre: " + hechizo.getNombre() + " - Puntaje: " + hechizo.calcularPuntuacion());
			} else {
				System.out.println("Nombre: " + hechizo.getNombre());
			}
		}
		System.out.println("-------------------");
	}

	@Override
	public void mostrarTodosMagos(boolean mostrarPuntaje) {
		System.out.println("--- LISTA DE MAGOS ---");
		for (Mago mago : listaGlobalMagos) {
			if (mostrarPuntaje) {
				System.out.println("Nombre: " + mago.getNombre() + " - Puntaje: "+ mago.calcularPuntajeTotal());
			} else {
				System.out.println("Nombre: " + mago.getNombre());
			}
		}
		System.out.println("-------------------");
	}

	@Override
	public void mostrarTopHechizos() {
		for (int i=0; i<listaGlobalHechizos.size()-1;i++) {
			for (int j=0;j<listaGlobalHechizos.size();j++) {
				Hechizo hechizo1 = listaGlobalHechizos.get(i);
				Hechizo hechizo2 = listaGlobalHechizos.get(j);
				
				if (hechizo1.calcularPuntuacion() > hechizo2.calcularPuntuacion()) {
					Hechizo temp = hechizo1;
					listaGlobalHechizos.set(i, hechizo2);
					listaGlobalHechizos.set(j, temp);
				}
			}
		}
		System.out.println("--- TOP 10 HECHIZOS ---");
		int limite = Math.min(10, listaGlobalHechizos.size());
		for (int i=0; i<limite;i++) {
			Hechizo h = listaGlobalHechizos.get(i);
			System.out.println((i+1)+ ". "+h.getNombre()+" - Puntos: "+h.calcularPuntuacion());
		}
		System.out.println("-------------------");
	}

	@Override
	public void mostrarTopMagos() {
		for (int i=0; i<listaGlobalMagos.size()-1;i++) {
			for (int j=0; j<listaGlobalMagos.size();j++) {
				Mago mago1 = listaGlobalMagos.get(i);
				Mago mago2 = listaGlobalMagos.get(j);
				if (mago1.calcularPuntajeTotal()>mago2.calcularPuntajeTotal()) {
					Mago temp = mago1;
					listaGlobalMagos.set(i, mago2);
					listaGlobalMagos.set(j, temp);
				}
			}
		}
		System.out.println("--- TOP 3 MAGOS ---");
		int limite = Math.min(3, listaGlobalHechizos.size());
		for (int i=0; i<limite;i++) {
			Mago m = listaGlobalMagos.get(i);
			System.out.println((i+1)+". "+m.getNombre()+" - Puntos: "+m.calcularPuntajeTotal());
		}
		System.out.println("-------------------");
	}
	
	private void actualizarArchivoHechizos() {
		try {
			FileWriter archivo = new FileWriter("Hechizos.txt");
			BufferedWriter escritor = new BufferedWriter(archivo);
			
			for (Hechizo h : listaGlobalHechizos) {
				escritor.write(h.generarLineaArchivo()); 
				escritor.newLine();
			}
			
			escritor.close();
			System.out.println("Archivo de hechizos actualizado correctamente.");
			
		} catch (Exception e) {
			System.out.println("Error al intentar escribir en el archivo.");
		}
	}
	
	private void actualizarArchivoMagos() {
		try {
			FileWriter archivo = new FileWriter("Magos.txt");
			BufferedWriter escritor = new BufferedWriter(archivo);
			
			for (Mago m : listaGlobalMagos) {
				escritor.write(m.generarLineaArchivo());
				escritor.newLine();
			}
			
			escritor.close();
		} catch (Exception e) {
			System.out.println("Error al intentar escribir en el archivo.");
		}
	}

	@Override
	public void agregarHechizoFuego(String nombre, String tipo, int dano, int duracionQuemadura) {
		Hechizo nuevoHechizoFuego = new HechizoFuego(nombre, tipo, dano, duracionQuemadura);
		listaGlobalHechizos.add(nuevoHechizoFuego);
		actualizarArchivoHechizos();
	}

	@Override
	public void agregarHechizoTierra(String nombre, String tipo, int dano, int mejoraDefensa) {
		Hechizo nuevoHechizoTierra = new HechizoTierra(nombre, tipo, dano, mejoraDefensa);
		listaGlobalHechizos.add(nuevoHechizoTierra);
		actualizarArchivoHechizos();
	}

	@Override
	public void agregarHechizoPlanta(String nombre, String tipo, int dano, int duracionStun, int cantPlanta) {
		Hechizo nuevoHechizoPlanta = new HechizoPlanta(nombre, tipo, dano, duracionStun, cantPlanta);
		listaGlobalHechizos.add(nuevoHechizoPlanta);
		actualizarArchivoHechizos();
	}

	@Override
	public void agregarHechizoAgua(String nombre, String tipo, int dano, int cantidadHeal, int presionDeAgua) {
		Hechizo nuevoHechizoAgua = new HechizoAgua(nombre, tipo, dano, cantidadHeal, presionDeAgua);
		listaGlobalHechizos.add(nuevoHechizoAgua);
		actualizarArchivoHechizos();
	}

	@Override
	public boolean eliminarHechizo(String nombre) {
		for (int i=0; i < listaGlobalHechizos.size(); i++) {
			Hechizo hechizoActual = listaGlobalHechizos.get(i);
			if (hechizoActual.getNombre().equalsIgnoreCase(nombre)) {
				listaGlobalHechizos.remove(i);
				actualizarArchivoHechizos();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modificarHechizo(String nombre, int nuevoDano) {
		for (int i=0; i < listaGlobalHechizos.size(); i++) {
			Hechizo hechizoActual = listaGlobalHechizos.get(i);
			if (hechizoActual.getNombre().equalsIgnoreCase(nombre)) {
				hechizoActual.setDano(nuevoDano);
				actualizarArchivoHechizos();
				return true;
			}
		}
		return false;
	}

	@Override
	public void agregarMago(String nombre) {
		Mago nuevoMago = new Mago(nombre);
		listaGlobalMagos.add(nuevoMago);
		actualizarArchivoMagos();
	}

	@Override
	public boolean eliminarMago(String nombre) {
		for (int i=0; i<listaGlobalMagos.size();i++) {
			Mago magoActual = listaGlobalMagos.get(i);
			
			if (magoActual.getNombre().equalsIgnoreCase(nombre)) {
				listaGlobalMagos.remove(i);
				actualizarArchivoMagos();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modificarMago(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
