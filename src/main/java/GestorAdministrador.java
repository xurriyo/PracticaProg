import clases.*;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorAdministrador {
    ArrayList<Evento> eventos;
    ArrayList<Usuario> usuarios;
    ArrayList<Reserva> reservas;
    ArrayList<Asistente> asistentes = new ArrayList<>();

    Sala[] listado_salas;
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    FileInputStream fis=null;
    ObjectInputStream ois=null;

    GestorAdministrador(){}
    public GestorAdministrador(ArrayList<Evento> eventos, ArrayList<Usuario> usuarios, ArrayList<Reserva> reservas, Sala[] listado_salas) {
        this.eventos = eventos;
        this.usuarios = usuarios;
        this.reservas = reservas;
        this.listado_salas = listado_salas;
    }

    public void panelAdministrador() {
        Scanner scAdmin = new Scanner(System.in);

        String opcion;

        //MENÚ PARA EVENTOS: 1 agregar, mostrar, eliminar
        do {
            System.out.println("--- PANEL DE AMINISTRADOR ---");
            System.out.println("   1. Gestionar eventos");
            System.out.println("   2. Gestionar asistentes");
            System.out.println("   3. Gestionar reservas");
            System.out.println("   0. SALIR DEL SISTEMA");
            System.out.println("Por favor, escoja una opción:");
            opcion = scAdmin.nextLine();

            switch (opcion) {
                case "1":
                    gestionEventos();
                    break;
                case "2", "3":
                    System.out.println("\nFuncionalidad no implementada, escoja otra opción por favor:\n");
                    break;
                case "0":
                    System.exit(0);
                default:
            }

        } while (opcion != "0");
    }
    public void gestionEventos() {
        Scanner scAdmin = new Scanner(System.in);
        GestorEventos gestor = new GestorEventos();
        String opcionEventos;

        do {
            System.out.println("--- PANEL DE AMINISTRADOR ---");
            System.out.println("   1. Agregar un evento");
            System.out.println("   2. Modificar un evento");
            System.out.println("   3. Eliminar un evento");
            System.out.println("   4. Mostrar un evento");
            System.out.println("   5. Listado de eventos");
            System.out.println("   0. SALIR DEL SISTEMA");
            System.out.println("Por favor, escoja una opción:");
            opcionEventos = scAdmin.nextLine();

            switch (opcionEventos) {
                case "1":
                    agregarEvento();
                    try {
                        gestor.escribirUsuarios();
                    } catch (IOException e) {
                        System.out.println("ERROR AL CARGAR EL FICHERO");
                    }
                    break;
                case "2":
                    System.out.println("\nFuncionalidad no implementada, escoja otra opción por favor:\n");
                    break;
                case "3":
                    eliminarEvento();
                    break;
                case "4":
                    System.out.println("Elige el evento que deseas mostrar en detalle: ");
                    mostrarEvento();
                    break;
                case "5":
                    gestor.mostrarEventos();
                    break;
                case "0":
                    System.exit(0);
                default:
            }

        } while (opcionEventos!= "0");
    }
    public void agregarEvento(){
        Scanner sc = new Scanner(System.in);
        String nombreEvento;
        String inviConferencia;
        String inviTeatro;
        String fecha;
        String hora;
        String tipo = "";
        double precio = 0;
        int num_invitados_max = 0;
        boolean precioOK= false;
        boolean asisMaxOK = false;


        do {
            System.out.println("Introduzca el nombre del evento, por favor: ");
            nombreEvento = sc.nextLine();
        }while(!Validaciones.comprobarnombre(nombreEvento));

        System.out.println("¿El evento será tipo conferencia? (RESPONDA SI / NO)");
        inviConferencia = sc.nextLine();

        System.out.println("¿El evento será tipo conferencia? (RESPONDA SI / NO)");
        inviTeatro = sc.nextLine();

        System.out.println("Fecha del evento: yyyy/MM/dd");
        fecha = sc.nextLine();

        System.out.println("Hora del evento: ");
        hora = sc.nextLine();

        while (!precioOK){
            try{
                System.out.println("Introduce el precio del evento: ");
                precio = sc.nextDouble();
                precioOK = true;
                sc.nextLine();
            }catch (InputMismatchException ex){
                System.out.println("\n---Formato no válido, inténtelo de nuevo---\n");
                sc.nextLine();
            }
        }
        do {
            System.out.println("Introduzca el tipo de evento, por favor: ");
            tipo = sc.nextLine();
        }while(!Validaciones.comprobarnombre(tipo));

        while (!asisMaxOK) {
            try {
                System.out.print("Introduce Numero maximo asistentes: ");
                num_invitados_max = sc.nextInt();
                asisMaxOK = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
            } catch (NumberFormatException ex){
                sc.nextLine();
            }
        }

        Evento eventoNuevo = new Evento("20-10-2019","Pelicula",listado_salas[2],"12:00:00","Pelicula",usuarios);
        eventos.add(eventoNuevo);

    }
    public void eliminarEvento() {
        Scanner sc = new Scanner(System.in);

        Evento evento = new Evento();

        int evento_a_eliminar;
        boolean eventoExiste = false;

        do {
            for (int i = 0; i < eventos.size() ; i++){
                System.out.println(i+ 1 + ". " + eventos.get(i).getNombre() );
            }
            try {
                //SELECIONAR EVENTO
                System.out.println("\nEscribe el número del evento que deseas eliminar:\n");
                evento_a_eliminar = sc.nextInt();
                sc.nextLine(); // me cargo el intro de introducir el numero
                if(evento_a_eliminar-1 < 0 || evento_a_eliminar > eventos.size()){
                    System.err.println("\nEl evento seleccionado no existe, introducelo de nuevo : \n");
                }else{
                    System.out.println(eventos.get(evento_a_eliminar-1).getNombre());
                    evento = eventos.remove(evento_a_eliminar-1);
                    try {
                        fos=new FileOutputStream("src/data/eventos.dat", true);
                        oos=new ObjectOutputStream(fos);
                        for (Evento e:eventos){
                            oos.writeObject(e);
                        }
                    } catch (FileNotFoundException e){
                        e.getMessage();
                    } catch (IOException e) {
                        System.out.println("ERROR DE ENTRADA Y SALIDA");
                    } finally {
                        fos.close();
                        oos.flush();
                        oos.close();
                    }
                    System.out.println("\nEvento eliminado correctamente\n");
                    eventoExiste = true;
                }
            }catch (InputMismatchException | IOException ex){
                System.out.println("Introduce el numero correcto: ");
                eventoExiste = false;
            }

        }while(eventoExiste == false);

    }
    public void mostrarEvento(){

    }


}
