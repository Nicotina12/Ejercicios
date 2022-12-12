import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Jugueteria jet = new Jugueteria();
        Empleado juan = new Empleado("Juan", "Perez");
        Empleado ana = new Empleado("Ana", "Flyn");
        Empleado jorge = new Empleado("Jorge", "Tais");
        Empleado juan_l = new Empleado("Juan", "Lab");

        jet.agregarEmpleado(juan);
        jet.agregarEmpleado(ana);
        jet.agregarEmpleado(jorge);
        jet.agregarEmpleado(juan_l);

        System.out.println(jet.elegirEmpleadoAlAzar());

        jet.ponerEnListaDeEspera(ana);
        jet.ponerEnListaDeEspera(jorge);
        jet.ponerEnListaDeEspera(juan_l);
        jet.ponerEnListaDeEspera(juan);

        jet.entregarEntradas();

        jet.listarNombres(jet.nombresDeNuevosJuguetes());
    }
}
