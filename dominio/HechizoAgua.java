package dominio;

public class HechizoAgua extends Hechizo {
	private int CantidadHeal;
	private int PresionDeAgua;
	public HechizoAgua(String nombre, String tipo, int dano, int CantidadHeal, int PresionDeAgua) {
		super(nombre, tipo, dano);
		this.CantidadHeal = CantidadHeal;
		this.PresionDeAgua = PresionDeAgua;
	}

	@Override
	public double calcularPuntuacion() {
		return (this.dano+this.CantidadHeal+this.PresionDeAgua)*2;
	}

}
