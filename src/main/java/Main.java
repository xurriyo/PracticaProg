import clases.Administrador;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        int opcion = 0;
        Scanner sc=new Scanner(System.in);
        GestorEventos gestor = new GestorEventos();
        gestor.info_inicial();

        do {
            System.out.println("           Menu               ");
            System.out.println("------------------------------");
            System.out.println("|      1.  Login             |");
            System.out.println("|      2.  Registro          |");
            System.out.println("|      0.  Salir             |");
            System.out.println("------------------------------");
            System.out.println("");
            System.out.println("Elige la Opcion: ");
            opcion= sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 0:
                    System.out.println("Saliendo");
                    break;
                case 1:
                    System.out.println("Has logeado");
                    gestor.login();
                    break;
                case 2:
                    System.out.println("Tienes que registrarte");
                    gestor.registro();
                    break;
                default:
            }
        } while (opcion != 0);

        //TODO: Mostrar menú asistente o menú administrador




    }
}
