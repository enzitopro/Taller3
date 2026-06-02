package logica;

public interface ISistema {
	void cargarHechizos();
	void cargarMagos();
	void mostrarTodosHechizos(boolean mostrarPuntaje);
	void mostrarTodosMagos(boolean mostrarPuntaje);
	void mostrarTopHechizos();
	void mostrarTopMagos();
	void agregarHechizoFuego(String nombre, String tipo, int dano, int duracionQuemadura);
	void agregarHechizoTierra(String nombre, String tipo, int dano, int mejoraDefensa);
	void agregarHechizoPlanta(String nombre, String tipo, int dano, int duracionStun, int cantPlanta);
	void agregarHechizoAgua(String nombre, String tipo, int dano, int cantidadHeal, int presionDeAgua);
	boolean eliminarHechizo(String nombre);
}
