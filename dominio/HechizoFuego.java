package dominio;

public class HechizoFuego extends Hechizo {
	private int duracionQuemadura;
	public HechizoFuego(String nombre, String tipo, int dano, int duracionQuemadura) {
		super(nombre, tipo, dano);
		this.duracionQuemadura = duracionQuemadura;
	}
	@Override
	public double calcularPuntuacion() {
		return this.dano * this.duracionQuemadura;
	}
}
