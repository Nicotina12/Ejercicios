package jugueteslol;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Jugueteria{
	private ArrayList <Empleado> empleados = new ArrayList<Empleado>();
	private Set<String> nombres = new TreeSet <String>();
	private Queue<Empleado> listaDeEspera = new ArrayDeque<Empleado>();
	
	public void agregarEmpleado(Empleado e) {
		empleados.add(e);
		agregarNombre(e);
		
	}
	private void agregarNombre(Empleado e) {
		nombres.add(e.getNombreCompleto());
	}
	public Empleado elegirEmpleadoAlAzar() {
		Random random = new Random();
		int idx = random.nextInt(empleados.size());
		return empleados.get(idx);
	}
	public List<String> nombresDeNuevosJuguetes(){
		return new ArrayList<>(nombres);
		
	}
	public void ponerEnListaDeEspera (Empleado e) {
		listaDeEspera.add(e);
		}
	public void entregarEntradas() {
		while (!listaDeEspera.isEmpty()) {
			Empleado e = listaDeEspera.poll();
			System.out.println("Entrada entragada a" + e);
			
		}
	}
		public void listarNombres(List<String> nombres) throws IOException {
			FileWriter fr = new FileWriter("nombreDeJuguetes.out");
			PrintWriter br = new PrintWriter(fr);
			for (String n : nombres) {
			 br.println(n);
			}
			br.close();
			
		}
	
	}


	


