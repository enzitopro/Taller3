package logica;

// Integrante 1: Elliot Bravo de Rodt - enzitopro
// Integrante 2: Enzo Salvatore Cornieles Medina - justamago
// Link repositorio: https://github.com/enzitopro/Taller3

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
					boolean volverAdmin = false;
					while (!volverAdmin) {
						System.out.println("1. Agregar Mago");
						System.out.println("2. Modificar Mago");
						System.out.println("3. Eliminar Mago");
						System.out.println("4. Agregar Hechizo");
						System.out.println("5. Modificar Hechizo");
						System.out.println("6. Eliminar Hechizo");
						System.out.println("0. Volver.");
						System.out.print("> ");
						int opcionAdmin = Integer.valueOf(lector.nextLine());
						switch (opcionAdmin) {
						case 1:
							System.out.print("Ingrese el nombre del nuevo mago: ");
							String nombreMagoNuevo = lector.nextLine();
							sistema.agregarMago(nombreMagoNuevo);
							break;
						case 2:
							System.out.println("Ingrese el nombre del mago a modificar: ");
							String nombreMagoModificar = lector.nextLine();
							System.out.println("Que desea modificar de " + nombreMagoModificar + "?");
							System.out.println("1) Cambiar el nombre.");
							System.out.println("2) Aprender nuevo hechizo.");
							System.out.println("3) Eliminar un hechizo");
							System.out.print("> ");

							int opcionMod = Integer.valueOf(lector.nextLine());
							switch (opcionMod) {
							case 1:
								System.out.print("Ingrese el nuevo nombre del mago: ");
								String nuevoNombre = lector.nextLine();
								sistema.modificarNombreMago(nombreMagoModificar, nuevoNombre);
								break;
							case 2:
								sistema.mostrarTodosHechizos(false);
								System.out.print("Ingrese el nombre del hechizo que aprenderá: ");
								String hechizoAprender = lector.nextLine();
								sistema.aprenderHechizoMago(nombreMagoModificar, hechizoAprender);
								break;
							case 3:
								String listaHechizosMagoMod = sistema.mostrarHechizosMago(nombreMagoModificar);
								System.out.println("Hechizos de " + nombreMagoModificar);
								System.out.println(listaHechizosMagoMod);

								if (!listaHechizosMagoMod.contains("posee")
										&& !listaHechizosMagoMod.contains("Error")) {
									System.out.println("Ingrese el nombre del hechizo a eliminar: ");
									String hechizoEliminar = lector.nextLine();

									if (sistema.olvidarHechizoMago(nombreMagoModificar, hechizoEliminar)) {
										System.out.println("Se elimino el hechizo correctamente.");
									} else {
										System.out.println("No se pudo eliminar. Verifique que el nombre sea correcto");
									}

								} else {
									System.out.println("Operacion cancelada. Volviendo al menu principal...");
								}
								break;
							}
							break;
						case 3:
							System.out.print("Ingrese el nombre del mago a eliminar: ");
							String nombreMagoEliminar = lector.nextLine();
							sistema.eliminarMago(nombreMagoEliminar);
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
							} else if (tipoNuevo.equalsIgnoreCase("tierra")) {
								System.out.print("Ingrese el aumento de defensa: ");
								int mejora = Integer.valueOf(lector.nextLine());
								sistema.agregarHechizoTierra(nombreNuevo, tipoNuevo, danoNuevo, mejora);
							} else if (tipoNuevo.equalsIgnoreCase("agua")) {
								System.out.print("Ingrese la cantidad de heal: ");
								int heal = Integer.valueOf(lector.nextLine());
								System.out.print("Ingrese la presion de agua: ");
								int presion = Integer.valueOf(lector.nextLine());
								sistema.agregarHechizoAgua(nombreNuevo, tipoNuevo, danoNuevo, heal, presion);
							} else if (tipoNuevo.equalsIgnoreCase("planta")) {
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
								System.out.println("Se modifico con exito el hechizo " + nombreMod + "!");
							} else {
								System.out.println("No se pudo modificar el hechizo " + nombreMod + "!");
							}
							break;
						case 6:
							System.out.print("Ingrese el nombre del hechizo a eliminar: ");
							String nombreDel = lector.nextLine();
							if (sistema.eliminarHechizo(nombreDel)) {
								System.out.println("Se eliminó el hechizo " + nombreDel + "!");
							} else {
								System.out.println("No se pudo eliminar el hechizo " + nombreDel + "!");
							}
							break;
						case 0:
							volverAdmin = true;
							System.out.println("Volviendo al menu principal.");
							break;
						default:
							volverAdmin = true;
							System.out.println("ERROR. Input inválido");
							break;
						}
						break;
					}
					break;
				case 2:
					boolean volverAnalista = false;
					while (!volverAnalista) {
						System.out.println("1. Top 10 Mejores Hechizos");
						System.out.println("2. Top 3 Mejores Magos");
						System.out.println("3. Mostrar todos los hechizos");
						System.out.println("4. Mostrar todos los magos");
						System.out.println("5. Mostrar todos los Hechizos junto a su puntuación");
						System.out.println("6. Mostrar todos los magos junto a su puntuación");
						System.out.println("0. Volver");
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
						case 0:
							volverAnalista = true;
							System.out.println("Volviendo al menu principal...");
							break;
						default:
							System.out.println("ERROR. Opcion no valida");
						}
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
