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
					System.out.println("7. Volver");
					break;
				case 2:
					System.out.println("1. Top 10 Mejores Hechizos");
					System.out.println("2. Top 3 Mejores Magos");
					System.out.println("3. Mostrar todos los hechizos");
					System.out.println("4. Mostrar todos los magos");
					System.out.println("5 Mostrar todos los Hechizos junto a su puntuación");
					System.out.println("6. Mostrar todos los magos junto a su puntuación");
					System.out.println("7. Volver");
					System.out.print("> ");
					int opcionAnalista = Integer.valueOf(lector.nextLine());
					switch (opcionAnalista) {
					case 1:
						sistema.mostrarTopHechizos();
						break;
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
