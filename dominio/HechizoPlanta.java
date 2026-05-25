package dominio;

public class HechizoPlanta extends Hechizo {
	private int DuracionStun;
	private int CantPlanta;
	public HechizoPlanta(String nombre, String tipo, int dano, int DuracionStun, int CantPlanta) {
		super(nombre, tipo, dano);
		this.DuracionStun = DuracionStun;
		this.CantPlanta = CantPlanta;
	}

	@Override
	public double calcularPuntuacion() {
		return this.dano + (this.DuracionStun*this.CantPlanta);
	}

}
