package logica;

import logica.ISistema;
import logica.SistemaImpl;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ISistema sistema = new SistemaImpl();
		sistema.cargarHechizos();
		sistema.cargarMagos();
		try {
			Scanner lector = new Scanner(System.in);
			boolean salirMenu = false;
			while (!salirMenu) {
				System.out.println("1. Panel Administrador");
				System.out.println("2. Panel Analista");
				System.out.println("3. Salir");
				System.out.print("> ");
				int opcion = Integer.valueOf(lector.nextLine());
				switch (opcion) {
				case 1:
					System.out.println("1. Agregar Mago");
					System.out.println("2. Modificar Mago");
					System.out.println("3. Eliminar Mago");
					System.out.println("4. Agregar Hechizo");
					System.out.println("5. Modificar Hechizo");
					System.out.println("6. Eliminar Hechizo");
					System.out.print("> ");
					int opcionAdmin = Integer.valueOf(lector.nextLine());
					switch (opcionAdmin) {
					case 1:
						//agregarMago();
						break;
					case 2:
						//modificarMago();
						break;
					case 3:
						//eliminarMago();
						break;
					case 4:
						System.out.println("--- AGREGAR NUEVO HECHIZO ---");
						System.out.print("Ingrese el nombre del hechizo: ");
						String nombreNuevo = lector.nextLine();
						
						System.out.print("Ingrese el tipo (Fuego, Agua, Planta, Tierra): ");
						String tipoNuevo = lector.nextLine();
						
						System.out.print("Ingrese el daño base: ");
						int danoNuevo = Integer.valueOf(lector.nextLine());
						
						if (tipoNuevo.equalsIgnoreCase("fuego")) {
							System.out.print("Ingrese la duracion de la quemadura: ");
							int duracion = Integer.valueOf(lector.nextLine());
							sistema.agregarHechizoFuego(nombreNuevo, tipoNuevo, danoNuevo, duracion);
						}
						else if (tipoNuevo.equalsIgnoreCase("tierra")) {
							System.out.print("Ingrese el aumento de defensa: ");
							int mejora = Integer.valueOf(lector.nextLine());
							sistema.agregarHechizoTierra(nombreNuevo, tipoNuevo, danoNuevo, mejora);
						}
						else if (tipoNuevo.equalsIgnoreCase("agua")) {
							System.out.print("Ingrese la cantidad de heal: ");
							int heal = Integer.valueOf(lector.nextLine());
							System.out.print("Ingrese la presion de agua: ");
							int presion = Integer.valueOf(lector.nextLine());
							sistema.agregarHechizoAgua(nombreNuevo, tipoNuevo, danoNuevo, heal, presion);
						}
						else if (tipoNuevo.equalsIgnoreCase("planta")) {
							System.out.print("Ingrese la duracion del stun: ");
							int stun = Integer.valueOf(lector.nextLine());
							System.out.print("Ingrese la cantidad de planta: ");
							int planta = Integer.valueOf(lector.nextLine());
							sistema.agregarHechizoPlanta(nombreNuevo, tipoNuevo, danoNuevo, stun, planta);
						}
						break;
					case 5:
						System.out.print("Ingrese el nombre del hechizo a modificar: ");
						String nombreMod = lector.nextLine();
						System.out.print("Ingrese el nuevo valor de daño: ");
						int nuevoDano = Integer.valueOf(lector.nextLine());
						if (sistema.modificarHechizo(nombreMod, nuevoDano)) {
							System.out.println("Se modifico con exito el hechizo "+nombreMod+"!");
						} else {
							System.out.println("No se pudo modificar el hechizo "+nombreMod+"!");
						}
						break;
					case 6:
						System.out.print("Ingrese el nombre del hechizo a eliminar: ");
						String nombreDel = lector.nextLine();
						if (sistema.eliminarHechizo(nombreDel)) {
							System.out.println("Se eliminó el hechizo "+nombreDel+"!");
						} else {
							System.out.println("No se pudo eliminar el hechizo "+nombreDel+"!");
						}
						break;
					}
					break;
				case 2:
					System.out.println("1. Top 10 Mejores Hechizos");
					System.out.println("2. Top 3 Mejores Magos");
					System.out.println("3. Mostrar todos los hechizos");
					System.out.println("4. Mostrar todos los magos");
					System.out.println("5. Mostrar todos los Hechizos junto a su puntuación");
					System.out.println("6. Mostrar todos los magos junto a su puntuación");
					System.out.print("> ");
					int opcionAnalista = Integer.valueOf(lector.nextLine());
					switch (opcionAnalista) {
					case 1:
						sistema.mostrarTopHechizos();
						break;
					case 2:
						sistema.mostrarTopMagos();
						break;
					case 3:
						sistema.mostrarTodosHechizos(false);
						break;
					case 4:
						sistema.mostrarTodosMagos(false);
						break;
					case 5:
						sistema.mostrarTodosHechizos(true);
						break;
					case 6:
						sistema.mostrarTodosMagos(true);
						break;
					default:
						System.out.println("ERROR. Opcion no valida");
					}
					break;
				case 3:
					System.out.println("Saliendo del programa...");
					salirMenu = true;
					break;
				default:
					System.out.println("ERROR. Opción no válida");
				}
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR. Input inválido");
		}
	}
}
