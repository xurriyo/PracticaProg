import Excepciones.ContraseñaIncorrectaException;
import Excepciones.EmailExistenteException;
import Excepciones.TelefonoExistenteException;
import clases.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

import static clases.Reserva.generartoken;

/**
 *Clase para gestionar eventos salas usuarios y reservas
 *
 */
public class GestorEventos {


    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    /**
     * Obtiene las arrays de usuarios eventos reservas salas
     *
     */
    ArrayList<Usuario> listadoUsuarios = new ArrayList<>();
    ArrayList<Evento> listadoEvento = new ArrayList<>();

    ArrayList<Reserva> listadoReserva = new ArrayList<>();

    ArrayList<Sala> listado_salas = new ArrayList<>();

    Usuario usuario_activo;
    private Evento evento1;

    /**
     * Getter y setter de las clases
     *
     * @return
     */

    public ArrayList<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }


    public void setListadoUsuarios(ArrayList<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public ArrayList<Evento> getListadoEvento() {
        return listadoEvento;
    }

    public void setListadoEvento(ArrayList<Evento> listadoEvento) {
        this.listadoEvento = listadoEvento;
    }

    public ArrayList<Reserva> getListadoReserva() {
        return listadoReserva;
    }

    public void setListadoReserva(ArrayList<Reserva> listadoReserva) {
        this.listadoReserva = listadoReserva;
    }

    public ArrayList<Sala> getListado_salas() {
        return listado_salas;
    }

    public void setListado_salas(ArrayList<Sala> listado_salas) {
        this.listado_salas = listado_salas;
    }

    public Usuario getUsuario_activo() {
        return usuario_activo;
    }

    public void setUsuario_activo(Usuario usuario_activo) {
        this.usuario_activo = usuario_activo;
    }

    /**
     * Genera una informacion sobre butacas junto con eventos
     *
     * @return IOException si ocurre algun error de entrada o salida
     */
    public void info_inicial() throws IOException {

        for (int i = 0; i < 5; i++) {
            //System.out.println("Sala " +i);
            //Generar butacas
            int sumar = (int) (Math.random() * 5) + 3;

            ArrayList<Butaca> misbutacas = new ArrayList<>();

            for (char fila = 'A'; fila <= 'E'; fila++) {
                for (int columna = 1; columna <= 6; columna++) {
                    int identificador = 0;
                    identificador++;
                    String posicion = fila + "" + columna + "";
                    misbutacas.add(new Butaca((i * 1) * 100 + columna, posicion, false, false));
                }
            }
            listado_salas.add(i, new Sala("Sala " + i, misbutacas.size(), 100, misbutacas));
        }

        listadoUsuarios.add(new Asistente("Johnny", "722817349", "Johnny@gmail.com", "password", "12345678P"));
        listadoUsuarios.add(new Asistente("christian", "722817349", "christian@gmail.com", "password", "12345678B"));
        listadoUsuarios.add(new Asistente("Saul", "722817349", "Saul@gmail.com", "password", "12345678W"));
        listadoUsuarios.add(new Administrador("Administrador", "722817349", "administrador@gmail.com", "hola", 1));
        escribirUsuarios();
        leerUsuarios();

        listadoEvento.add(new Evento("20/10/2024", "Concierto sticky. MA", listado_salas.get(0), "20:20:00", "Concierto", null));
        listadoEvento.add(new Evento("22/10/2024", "Funcion de teatro", listado_salas.get(4), "22:00:00", "Teatro", null));
        listadoEvento.add(new Evento("21/10/2024", "Concierto El Cigala", listado_salas.get(2), "21:00:00", "Concierto", null));
        escribirEventos();
        leerEventos();

        listadoReserva.add(new Reserva((Asistente)usuario_activo,listadoEvento.get(0),1,"20-10-2024","16:00:00"));
        listadoReserva.add(new Reserva((Asistente)usuario_activo,listadoEvento.get(0),8,"12-10-2024","10:00:00"));
        listadoReserva.add(new Reserva((Asistente)usuario_activo,listadoEvento.get(0),9,"3-10-2024","19:00:00"));
        escribirReservas();
        leerReservas();
    }

    /**
     *
     * Mostramos la lista de eventos que tenemos
     */

    public void mostrarEventos(){
        int i=1;
        for (Evento e:listadoEvento){
            System.out.println(i+ " "+ e.getNombre()+"\n"+e.getSala()+"\n"+e.getFecha()+"\n"+e.getHora()+"\n");
            i++;
        }

    }


    /**
     * Hacemos que un usuario se pueda logear atraves del array donde tenemos definidos los usuarios y
     * los que vamos creando en registro
     */
    public void login() {
        String email;
        String contrasenia;
        boolean salir = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Introduzca correo electrónico");
            email = sc.nextLine();
            if (Validaciones.comprobaremail(email)) {
                System.out.println("Introduzca contraseña");
                contrasenia = sc.nextLine();
                for (Usuario u : listadoUsuarios) {
                    if ((u.getEmail_usuario().equals(email)) && u.getContrasenia().equals(contrasenia)) {
                        System.out.println("Los credenciales introducidos son válidos.");
                        //Si es administrador le mostraremos este menu
                        if(getUsuario_activo() instanceof Administrador) {
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
                            }while (seleccion!=0);
                        }else{
                            //Si es asistente le mostrara este menu
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
                                    mostrarEventos();
                                    break;
                                case 2:
                                    System.out.println("Acciendo para una reserva");
                                    menuReserva();
                                    break;
                                default:
                            }while (seleccion!=0);
                        }
                    }else {
                        salir=false;
                    }
                }
                if (salir==false){
                    System.out.println("Usuario no es correcto");
                }
            }
        }while (salir);
    }

    /**
     * Registro nos servira para registrar a un usuario para que pueda utilizar la funcion de login
     */
    public void registro() {
        String nombre;
        String telefono;
        String email;
        String contrasenia;
        String dni;
        Scanner sc = new Scanner(System.in);
        boolean salir = true;

        do {
            System.out.println("Nombre: ");
            nombre = sc.nextLine();
        } while (!Validaciones.comprobarnombre(nombre));

        do {
            System.out.println("Telefono: ");
            telefono = sc.nextLine();
            salir = true;
        } while (!Validaciones.comprobartelefono(telefono));

        try {
            for (Usuario u : listadoUsuarios) {
                if (telefono.equals(u.getNumero_telefono())) {
                    salir = false;
                    throw new TelefonoExistenteException();
                }
            }
        } catch (TelefonoExistenteException te) {
            System.out.println(te.getMessage());
            return;
        }
        while (!salir) ;
        do {
            do {
                System.out.println("Email: ");
                email = sc.nextLine();
                salir = true;
            } while (!Validaciones.comprobaremail(email));

            try {
                for (Usuario u : listadoUsuarios) {
                    if (email.equals(u.getEmail_usuario())) {
                        salir = false;
                        throw new EmailExistenteException();
                    }
                }
            } catch (EmailExistenteException em) {
                System.out.println(em.getMessage());
                return;
            }
        } while (!salir);

        System.out.println("Contraseña: ");
        contrasenia = sc.nextLine();
        System.out.println("Dni: ");
        dni = sc.nextLine();
        System.out.println("");
        System.out.println("");
        System.out.println("Registro Completado");

        usuario_activo = new Asistente(nombre, telefono, email, contrasenia, dni);
        listadoUsuarios.add(usuario_activo);
    }



    public void menuReserva() {
        Scanner scanner = new Scanner(System.in);

        Evento evento = new Evento();

        int eventoSelecionado = 0;
        String butacaSelecionada;

        boolean eventoExiste = false;

        do {
            mostrarEventos();

            try {
                //SELECIONAR EVENTO
                System.out.println("\nEscribe el número del evento:\n");
                eventoSelecionado = scanner.nextInt();
                scanner.nextLine(); // me cargo el intro de introducir el numero

                if (eventoSelecionado - 1 < 0 || eventoSelecionado > listadoEvento.size()) {
                    System.err.println("\nEl evento seleccionado no existe, introducelo de nuevo : \n");
                } else {
                    System.out.println(listadoEvento.get(eventoSelecionado - 1).getNombre());
                    evento = listadoEvento.get(eventoSelecionado - 1);
                    eventoExiste = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Introduce el numero correcto: ");
                eventoExiste = false;
            }

        } while (eventoExiste == false);
        reservar_butaca(evento);

    }
    public void reservar_butaca(Evento evento) {
        String token = String.valueOf(generartoken());
        String asiento;
        Butaca butaca = null;
        boolean salir = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nSeleccione un asiento para el evento: \n");
            System.out.println(" A1  A2  A3  A4  A5 ");
            System.out.println(" B1  B2  B3  B4  B5 ");
            System.out.println(" C1  C2  C3  C4  C5 ");
            System.out.println(" D1  D2  D3  D4  D5 ");
            evento.getSala().mostrar_butacas();
            System.out.println();
            asiento = sc.nextLine();

            for (Butaca b : evento.getSala().getListado_butacas_disponibles()) {
                if (b.getId() == Integer.parseInt(asiento)) {
                    butaca = b;
                    break;
                }
            }

            if (butaca != null) {
                butaca.setDisponibilidad(false);
                System.out.println("¡Esta butaca está libre!\n");
                salir = true;
            } else {
                System.out.println("Esta butaca está ocupada, escoja otra por favor.");
            }
        } while (!salir);

        System.out.println("\n¿De qué manera quiere efectuar el pago?");
        menuPago(butaca, evento);

        try {
            listadoReserva.add(new Reserva((Asistente) usuario_activo,evento, butaca.getId(), evento.getFecha(),evento.getHora()));
            escribirReservas();
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }

        System.out.println("Aquí tienes el token de tu reserva procura no perderlo: " + token + "\n");

        datos_reserva(evento);

        return ;
    }

    public void menuPago(Butaca butaca, Evento evento) {
        int seleccion = 0;
        int telef;
        Scanner scanner = new Scanner(System.in);

        System.out.println("                             ");
        System.out.println("                             ");
        System.out.println("   Metodos de pago           ");
        System.out.println("   1. Bizum                  ");
        System.out.println("                             ");
        System.out.println("   0. Salir/Volver           ");
        System.out.println("                             ");
        System.out.println("                             ");
        System.out.println("      Elige una opcion       ");
        seleccion = scanner.nextInt();
        scanner.nextLine();
        switch (seleccion) {
            case 0:
                System.out.println("Volviendo");
                break;
            case 1:
                System.out.println("Ha seleccionado Bizum");
                
                break;
            default:
        }
        while (seleccion != 0) ;
    }

    public void listadoEvento() {
    }

    public void leerUsuarios() throws IOException {
        try {
            fis = new FileInputStream("src/main/java/data/usuarios.dat");
            ois = new ObjectInputStream(fis);
            while (true) {
                Usuario u = (Usuario) ois.readObject();
                listadoUsuarios.add(u);
            }
        } catch (EOFException e) {
            System.out.println("Fichero leído");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        } finally {
            fis.close();
            ois.close();
        }
    }

    public void escribirUsuarios() throws IOException {
        try {
            fos = new FileOutputStream("src/main/java/data/usuarios.dat", true);
            oos = new ObjectOutputStream(fos);
            for (Usuario u : listadoUsuarios) {
                oos.writeObject(u);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            fos.close();
            oos.flush();
            oos.close();
        }
    }

    public void leerEventos() throws IOException {
        try {
            fis = new FileInputStream("src/main/java/data/eventos.dat");
            ois = new ObjectInputStream(fis);
            while (true) {
                Evento e = (Evento) ois.readObject();
                listadoEvento.add(e);
            }
        } catch (EOFException e) {
            System.out.println("Fichero leído");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        } finally {
            fis.close();
            ois.close();
        }
    }

    public void escribirEventos() throws IOException {
        try {
            fos = new FileOutputStream("src/main/java/data/eventos.dat", true);
            oos = new ObjectOutputStream(fos);
            for (Evento e : listadoEvento) {
                oos.writeObject(e);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            fos.close();
            oos.flush();
            oos.close();
        }
    }

    public void escribirReservas() throws IOException {
        try {
            fos = new FileOutputStream("src/main/java/data/reservas.dat", true);
            oos = new ObjectOutputStream(fos);
            for (Reserva r : listadoReserva) {
                oos.writeObject(r);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            fos.close();
            oos.flush();
            oos.close();
        }
    }
    public void leerReservas() throws IOException {
        try {
            fos = new FileOutputStream("src/main/java/data/reservas.dat", true);
            oos = new ObjectOutputStream(fos);
            for (Reserva r : listadoReserva) {
                oos.writeObject(r);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            fos.close();
            oos.flush();
            oos.close();
        }
    }
    public void datos_reserva(Evento evento){
        for (Reserva r:listadoReserva) {
            if (r.getAsistente().equals(getListadoUsuarios())) {
                System.out.println("--- ¡RESERVA REALIZADA CORRECTAMENTE! ---\nEstos son los datos de tu reserva:\n");
                System.out.println("Nombre del evento reservado: " + evento.getNombre());
                System.out.println("Fecha del evento: " + evento.getFecha() + "\nHora del evento: " + evento.getHora());
                System.out.println("Butaca seleccionada: " + r.getButaca());
                System.out.println("Id de la reserva: " + generartoken());
            }
        }
    }
}






