package jugueteslol;

public class Empleado {
	private String nombre;
	private String apellido;
	private boolean entregaEntregada = false;
	
	public Empleado (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreCompleto() {
		return this.toString();
		}
	public String toString() {
		return this.getNombre() +" " + this.getApellido();
		}

}
