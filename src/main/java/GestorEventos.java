import clases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class GestorEventos {

    ArrayList<Usuario> listadoUsuarios = new ArrayList<>();
    ArrayList<Evento> listadoEvento = new ArrayList<>();

    ArrayList<Reserva> listadoReserva = new ArrayList<>();

    ArrayList<Sala> listado_salas = new ArrayList<>();

    Usuario usuario_activo;

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

    public void info_inicial() {

        listadoEvento.add(new Evento(20/10/2024,"Concierto sticky. MA",5,"20:20:00","Concierto",200));
        listadoEvento.add(new Evento("","","","","",""));
        listadoEvento.add(new Evento("","","","","",""));
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
                    misbutacas.add(new Butaca((i * 1) * 100 + columna, false, false, posicion));
                }
            }
            listado_salas.add(i, new Sala("Sala " + i, 200, 100.0, misbutacas));
        }

        listadoUsuarios.add(new Asistente("nombre", "722817349", "usuario@gmail.com", "hola", "241241241D"));
        listadoUsuarios.add(new Asistente("nombre", "722817349", "usuario@gmail.com", "hola", "5435345345D"));
        listadoUsuarios.add(new Asistente("nombre", "722817349", "usuario@gmail.com", "hola", "4324235252D"));
        listadoUsuarios.add(new Administrador("Administrador", "722817349", "administrador@gmail.com", "hola", 1));
    }

    public void login() {
        String email;
        String contrasenia;
        boolean comprobrar = false;
        Scanner datos = new Scanner(System.in);
        System.out.println("Email: ");
        email = datos.nextLine();
        System.out.println("Contraseña: ");
        contrasenia = datos.nextLine();

        for (Usuario u : listadoUsuarios) {
            if (email.equals(u.getEmail_usuario())) {
                System.out.println("Es correcto.");
                usuario_activo = u;
                comprobrar = true;
               return;
            } else {
                comprobrar = false;
            }
        }
        if (!comprobrar) {
            System.out.println("No es correcto.");
        }
    }

    public void registro() {
        String nombre;
        String telefono;
        String email;
        String contrasenia;
        String dni;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nombre: ");
            nombre = sc.nextLine();
        } while (!Validaciones.comprobarnombre(nombre));

        System.out.println("Telefono: ");
        telefono = sc.nextLine();
        System.out.println("Email: ");
        email = sc.nextLine();
        System.out.println("Contraseña: ");
        contrasenia = sc.nextLine();
        System.out.println("Dni: ");
        dni = sc.nextLine();
        usuario_activo = new Asistente("pepe", "923919329", "ejemplo@gmail.com", "hola", "null");
        listadoUsuarios.add(usuario_activo);
    }

}



