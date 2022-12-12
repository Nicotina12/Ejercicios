package modeloSeParcial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
public class ProcesarPersonas {
	
	public List<Persona> getPersonas(String archivo){
		List<Persona> personas = new LinkedList<Persona>();
		
		try {
			FileReader fr = new FileReader (new File(archivo));
			BufferedReader br = new BufferedReader (fr);
			
			int dni;
			String apellido;
			int edad;
			String linea;
			String datos[];
			Persona p;
			linea = br.readLine();
			while (linea != null) {
				datos = linea.split(" ");
				dni = Integer.parseInt(datos[0]);
				apellido = datos[1];
				edad = Integer.parseInt(datos[2]);
				p = new Persona (dni,apellido,edad);
				personas.add(p);
				linea = br.readLine();				
			}
			fr.close();
			
		} 
		catch (FileNotFoundException e) {
			System.err.print("Archivo no encontrado");
		}catch(IOException e) {
			e.printStackTrace();
			}
		return personas;
		
	}

	public static List<Persona> getPersonasMayoresAEdad(List<Persona> personas,int edad){
	LinkedList<Persona> aux = new LinkedList<Persona>();
	for (Persona persona : personas)
		if (persona.getEdad() >= edad) {
			aux.add(persona);
			
		}
		return aux;
	}
public static void listadoDePersonas(List<Persona>personas , String archivo) throws FileNotFoundException {
	PrintWriter pw = new PrintWriter (new File(archivo));
	for(Persona persona : personas ) {
		pw.print(persona);
		
}
	pw.close();
	
}
}
