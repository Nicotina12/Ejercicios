package parcual2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ventas {
private Map<String, Integer> ventasPorProducto;

public Ventas() {
	this.ventasPorProducto = new HashMap<String, Integer>();
}
public void leerVentas (String archivoDeEntrada) throws IOException{
	FileReader fr = new FileReader(new File(archivoDeEntrada));
	BufferedReader  br = new BufferedReader(fr);
	
	String linea = br.readLine();
	String datos[];
	while(linea != null) {
		datos = linea.split(" ");
		String codProd = datos[0];
		
		try {
			Integer cantVendida = Integer.parseInt(datos[1]);
			if ((cantVendida <1 || cantVendida > 1000))
				throw new CantidadInvalidaException ("Dato Ingresado erroneo ");
			if (ventasPorProducto.containsKey(codProd))
			cantVendida += ventasPorProducto.get(codProd);
			ventasPorProducto.put(codProd, cantVendida);
			
		
	}catch (CantidadInvalidaException e) {
		e.printStackTrace();
	}
		br.readLine();
		}
        fr.close();
}
public void escribirVentasPorProducto(String archivoDeSalida) throws IOException {
	PrintWriter salida = new PrintWriter (new FileWriter(archivoDeSalida));
	
	for (Entry<String, Integer> cu : ventasPorProducto.entrySet()) {
		String clave = cu.getKey();
		Integer valor = cu.getValue();
		
		salida.println(clave + " " + valor);
	}
	salida.close();
}
public static void main(String [] args) throws IOException{
	Ventas ventas = new Ventas();
	ventas.leerVentas("src/parcual2/Ventas.in");
	ventas.escribirVentasPorProducto("src/parcual2/ventasPorProducto");
	
}
}
