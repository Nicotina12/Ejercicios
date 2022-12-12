package repasosegundoparcial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CuentaCompartida {

	private ArrayList<List<Consumo>> cuenta;
	private double cubierto;
	
	//Se construye a partir de la cantidad de N comensales
	//Cada comensal se distingue por un entero entre 1 y N
	public CuentaCompartida(int n, double cubierto) {
		this.cubierto = cubierto;
		this.cuenta = new ArrayList<List<Consumo>>(n);
		
		for (int i = 0; i < n; i++) {
			cuenta.add(new ArrayList<Consumo>());
		}
	}
	
	//Se pueden agregar consumos a la CuentaCompartida. 
	//Cada consumo agregado se imputa al comensal que lo solicita.
	public void agregarConsumo(int comensal, String descripcion, double precio) {
		if(comensal >= cuenta.size())
			throw new Error("Excede la cantidad de comensales");
		cuenta.get(comensal - 1).add(new Consumo(descripcion, precio));
	}
	
	//Se deben poder consultar por pantalla los consumos de cada comensal.
	public String consultasConsumosDelComensal(int comensal) {
		String s = "Consumo del comensal: " + comensal;
		for (Consumo cadaUno : cuenta.get(comensal - 1)) {
			s += cadaUno.getDescripcion();
			s += " ";
			s += cadaUno.getPrecio();
			s += " ";
		}
		
		return s;
	}
	
	//Se debe poder calcular el importe que paga cada comensal, dado que cada uno paga lo que consumió.
	public double obtenerImporteAPagarPorComensal(int comensal) {
		double total = 0;
		for (Consumo cadaUno : cuenta.get(comensal - 1)) {
			total += cadaUno.getPrecio();
		}
		
		return total + this.cubierto;
	}
	
	//Se desea poder consultar cual fue el consumo máximo y que comensal lo pidió.
	public void consultarConsumoMaximo() {
		Consumo candidato = new Consumo("", 0);
		int comensalAbusivo = 0;
		
		for (int i = 0; i < cuenta.size(); i ++) {
			for (Consumo cadaConsumo : cuenta.get(i)) {
				if(cadaConsumo.getPrecio() > candidato.getPrecio()) {
					candidato = cadaConsumo;
					comensalAbusivo = i;
				}
					
			}
		}
		
		System.out.println("El consumo maximo fue: " + candidato + " Pedido por: " + (comensalAbusivo + 1));
	}
	
	//Se exportará la cuenta a un archivo “miCena.out”
	public void exportarCuenta(String archivo) throws FileNotFoundException {
		PrintWriter pr = new PrintWriter(new File(archivo));
		pr.println("Bodegon La Curva");
		
		for (int i = 0; i < cuenta.size(); i ++) {
			pr.print(consultasConsumosDelComensal(i));
		} pr.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		CuentaCompartida c = new CuentaCompartida(2, 100);
		c.agregarConsumo(2, "Pastel de papas", 650.00);
		c.agregarConsumo(1, "Vino de la casa", 500.00);
		c.agregarConsumo(1, "Costillar", 6500.00);
		System.out.println(c.consultasConsumosDelComensal(2));
		System.out.println(c.obtenerImporteAPagarPorComensal(2));
		c.consultarConsumoMaximo();
		c.exportarCuenta("miCena.out");
	}
	

}
