package dominio;

public class HechizoTierra extends Hechizo {
	private int MejoraDefensa;
	public HechizoTierra(String nombre, String tipo, int dano, int MejoraDefensa) {
		super(nombre, tipo, dano);
		this.MejoraDefensa = MejoraDefensa;
	}
	@Override
	public double calcularPuntuacion() {
		return (this.dano*this.MejoraDefensa)/2;
	}

}
