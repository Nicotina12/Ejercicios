package profesional;

public abstract class Profesional implements Comparable <Profesional>{
	private String nombre;
	private String apellido;
	private static double SUELDO_MENSUAL= 100000;
	
	
	public Profesional (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}


	public double getSueldo() {
		return SUELDO_MENSUAL;
	}
	public int compareTo(Profesional p) {
		return (-1) * Double.compare(this.getSueldo(), p.getSueldo());
	}

}
