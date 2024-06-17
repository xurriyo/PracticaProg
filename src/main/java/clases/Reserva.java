package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Reserva implements Serializable {

    protected Asistente Asistente;
    protected Evento Evento;
    protected Butaca Butaca;
    protected String fecha;
    protected String hora;
    protected String metodo_pago;
    protected String token;

    Asistente asistente1;
    Evento evento1;
    String butaca1;

    public Reserva(clases.Asistente usuarioActivo, clases.Evento evento, int butaca, String fecha, String hora) {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public clases.Asistente getAsistente() {
        return Asistente;
    }

    public void setAsistente(clases.Asistente asistente) {
        Asistente = asistente;
    }

    public clases.Evento getEvento() {
        return Evento;
    }

    public void setEvento(clases.Evento evento) {
        Evento = evento;
    }

    public clases.Butaca getButaca() {
        return Butaca;
    }

    public void setButaca(clases.Butaca butaca) {
        Butaca = butaca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public clases.Asistente getAsistente1() {
        return asistente1;
    }

    public void setAsistente1(clases.Asistente asistente1) {
        this.asistente1 = asistente1;
    }

    public clases.Evento getEvento1() {
        return evento1;
    }

    public void setEvento1(clases.Evento evento1) {
        this.evento1 = evento1;
    }

    public String getButaca1() {
        return butaca1;
    }

    public void setButaca1(String butaca1) {
        this.butaca1 = butaca1;
    }

    public Reserva( clases.Asistente asistente, clases.Evento evento, clases.Butaca butaca, String fecha, String hora, String metodo_pago) {

        Asistente = asistente;
        Evento = evento;
        Butaca = butaca;
        this.fecha = fecha;
        this.hora = hora;
        this.metodo_pago = metodo_pago;
    }

    public static UUID generartoken() {
        UUID token = UUID.randomUUID();  // Genera un nuevo UUID aleatorio
        return token;  // devuelve el UUID generado
    }
    public void mostrarReserva(){
            System.out.println("--- ¡RESERVA REALIZADA CORRECTAMENTE! ---\nEstos son los datos de tu reserva:\n");
            System.out.println("Nombre del evento reservado: "+evento1.getNombre());
            System.out.println("Fecha del evento: "+evento1.getFecha()+"\nHora del evento: "+evento1.getHora());
            System.out.println("Butaca seleccionada: "+getButaca1());
            System.out.println("Id de la reserva: "+generartoken());
    }

}
