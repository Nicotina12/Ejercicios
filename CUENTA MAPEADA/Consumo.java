package repasosegundoparcial;

public class Consumo {
	
	private String descripcion;
	private double precio;
	
	public Consumo(String descripcion, double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Consumo [descripcion=" + descripcion + ", precio=" + precio + "]";
	}

}
