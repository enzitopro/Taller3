package dominio;

public class HechizoPlanta extends Hechizo {
	private int duracionStun;
	private int cantPlanta;
	public HechizoPlanta(String nombre, String tipo, int dano, int duracionStun, int cantPlanta) {
		super(nombre, tipo, dano);
		this.duracionStun = duracionStun;
		this.cantPlanta = cantPlanta;
	}

	@Override
	public double calcularPuntuacion() {
		return this.dano + (this.duracionStun*this.cantPlanta);
	}

	@Override
	public String generarLineaArchivo() {
		return this.nombre + ";" + this.tipo + ";" + this.dano + ";" + this.duracionStun + "," + this.cantPlanta;
	}

}
