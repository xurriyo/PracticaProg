import clases.Administrador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

        if(gestor.getUsuario_activo() instanceof Administrador) {
            //TODO: MENÚ ADMNISTRADOR
            int seleccion = 0;
            Scanner scanner = new Scanner(System.in);

            System.out.println("                             ");
            System.out.println("                             ");
            System.out.println("   Panel de Administrador    ");
            System.out.println("   1. Gestionar Eventos      ");
            System.out.println("   2. Gestionar Asistentes   ");
            System.out.println("   3. Gestionar Reservas     ");
            System.out.println("   0. Salir                  ");
            System.out.println("                             ");
            System.out.println("      Elige una opcion       ");
            seleccion = scanner.nextInt();
            scanner.nextLine();
            switch (seleccion) {
                case 0:
                    System.out.println("Saliendo");
                    break;
                case 1:
                    System.out.println("Has seleccionado Gestion de Eventos.");
                    break;
                case 2:
                    System.out.println("Has seleccionado Gestion de Asistentes.");
                    break;
                case 3:
                    System.out.println("Has seleccionado la Gestion de Reservas.");
                    break;
                default:
            }while (opcion!=0);
        }else{
            //TODO: MENÚ ASISTENTE
            int seleccion=0;
            Scanner scanner = new Scanner(System.in);

            System.out.println("                             ");
            System.out.println("                             ");
            System.out.println("   Panel de Asistente        ");
            System.out.println("   1. Ver Eventos            ");
            System.out.println("   2. Hacer Reserva          ");
            System.out.println("   0. Salir/Volver           ");
            System.out.println("                             ");
            System.out.println("                             ");
            System.out.println("      Elige una opcion       ");
            seleccion = scanner.nextInt();
            scanner.nextLine();
            switch (seleccion){
                case 0:
                    System.out.println("Volviendo");
                    break;
                case 1:
                    System.out.println("Accediendo a los eventos");
                    break;
                case 2:
                    System.out.println("Acciendo para una reserva");
                    break;
                default:
            }while (seleccion!=0);
        }

    }
}
