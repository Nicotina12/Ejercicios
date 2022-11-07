package modeloSeParcial;

public class Persona {
	private int dni;
	private String apellido;
	private int edad;
	
	public Persona(int dni, String apellido, int edad) {
		this.dni = dni;
		this.apellido = apellido;
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;

}
}
