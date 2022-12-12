package repasosegundoparcial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CuentaMapeada {

	private Map<Integer, ArrayList<Consumo>> cuenta;
	private double cubierto;
	int cantComensales;

	public CuentaMapeada(int n, double cubierto) {
		this.cuenta = new HashMap<Integer, ArrayList<Consumo>>();
		this.cubierto = cubierto;
		this.cantComensales = n;
	}

	// Se pueden agregar consumos a la CuentaCompartida.
	// Cada consumo agregado se imputa al comensal que lo solicita.
	public void agregarConsumo(int comensal, String descripcion, double precio) {
		ArrayList<Consumo> listaAux;
		if (comensal >= this.cantComensales)
			throw new Error("Excede la cantidad de comensales");

		if (cuenta.containsKey(comensal)) {
			listaAux = cuenta.get(comensal);
		} else {
			listaAux = new ArrayList<Consumo>();

		}
		
		listaAux.add(new Consumo(descripcion, precio));
		cuenta.put(comensal, listaAux);
	}
	
	//Se deben poder consultar por pantalla los consumos de cada comensal.
	public String consultasConsumosDelComensal(int comensal) {
		String s = "Consumo del comensal: " + comensal;
		for(Consumo c : cuenta.get(comensal)) {
			s += c.getDescripcion();
			s += " ";
			s += c.getPrecio();
		}
		
		return s;
	}
	
	public void imprimirFactura(String archivo) throws FileNotFoundException{
		double importe, total = 0;
		PrintWriter pr = new PrintWriter(new File(archivo));
		
		//recorrer un mapa
		for(Map.Entry<Integer, ArrayList<Consumo>> entry : cuenta.entrySet()) {
			Integer key = entry.getKey(); //obtener la clave
			ArrayList<Consumo> val = entry.getValue(); //obtener el valor
			
			importe = 0;
			pr.println("Consumos del comensal " + key);
			
			for(Consumo consumo : val) {
				pr.println(consumo);
				importe += consumo.getPrecio();
			}
			
			pr.println("Importe comensal " + key + ": " + importe);
			
			total += importe;
		}
	}
	
	public static void main(String[] args) {
		CuentaMapeada cm = new CuentaMapeada(2, 50);
		cm.agregarConsumo(1, "Sopa", 300);
		cm.agregarConsumo(2, "Flan", 600);
		cm.agregarConsumo(1, "Grande de muzza", 2000);
		cm.agregarConsumo(2, "Ensalada", 700);
		
		System.out.println(cm.consultasConsumosDelComensal(1));
	}

}
