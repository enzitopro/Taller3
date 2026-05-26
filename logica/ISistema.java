package logica;

public interface ISistema {
	void cargarHechizos();
	void cargarMagos();
	void mostrarTodosHechizos(boolean mostrarPuntaje);
	void mostrarTodosMagos(boolean mostrarPuntaje);
	void mostrarTopHechizos();
	void mostrarTopMagos();
}
