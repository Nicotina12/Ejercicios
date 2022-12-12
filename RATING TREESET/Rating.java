package recuperatorio2doParcial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class Rating {
	private Set<Programa> programas = new TreeSet<Programa>();
	
	public void leerRatings(String archivoDeEntrada) throws IOException{
		FileReader fr = new FileReader (new File(archivoDeEntrada));
		BufferedReader br = new BufferedReader(fr);
		
		String datos[];
		int numeroDeCanal;
		String programa;
		double rating;
		String linea;
		while((linea = br.readLine()) != null){
			try {
			datos = linea.split(",");
			numeroDeCanal = Integer.parseInt(datos[0]);
			programa = datos[1];
			rating = Double.parseDouble(datos[2]);
			Programa p = new Programa(numeroDeCanal, programa, rating);
			programas.add(p);
			System.out.println(programas);
			br.readLine();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			br.readLine();
	}
	fr.close();
			
		}
	public void escribirMasVistos(String salida) throws IOException{
		PrintWriter pr = new PrintWriter(new FileWriter(salida));

	for (Programa programa : programas) {
		if(programa.getRating() >=5) {
			pr.println(programa);
		}
	}
	pr.close();
	
	
	
	}
	public static void main(String[] args) throws IOException {
	Rating rating = new Rating();
	rating.leerRatings("src/recuperatorio2doParcial/ratings.in");
	rating.escribirMasVistos("src/recuperatorio2doParcial/masVistos.out");
	System.out.println(rating);

	}

}
