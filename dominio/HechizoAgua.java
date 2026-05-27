package dominio;

public class HechizoAgua extends Hechizo {
	private int cantidadHeal;
	private int presionDeAgua;
	public HechizoAgua(String nombre, String tipo, int dano, int cantidadHeal, int presionDeAgua) {
		super(nombre, tipo, dano);
		this.cantidadHeal = cantidadHeal;
		this.presionDeAgua = presionDeAgua;
	}

	@Override
	public double calcularPuntuacion() {
		return (this.dano+this.cantidadHeal+this.presionDeAgua)*2.0;
	}

	@Override
	public String generarLineaArchivo() {
		return this.nombre + ";" + this.tipo + ";" + this.dano + ";" + this.cantidadHeal + "," + this.presionDeAgua;
	}

}
