package dominio;

public abstract class Hechizo implements IPuntuable {
	protected String nombre;
	protected String tipo;
	protected int dano;
	
	public Hechizo(String nombre, String tipo, int dano) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.dano = dano;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
}
