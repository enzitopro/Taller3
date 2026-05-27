package dominio;

public class HechizoTierra extends Hechizo {
	private int mejoraDefensa;
	public HechizoTierra(String nombre, String tipo, int dano, int mejoraDefensa) {
		super(nombre, tipo, dano);
		this.mejoraDefensa = mejoraDefensa;
	}
	@Override
	public double calcularPuntuacion() {
		return (this.dano*this.mejoraDefensa)/2.0;
	}
	@Override
	public String generarLineaArchivo() {
		return this.nombre + ";" + this.tipo + ";" + this.dano + ";" + this.mejoraDefensa;
	}

}
