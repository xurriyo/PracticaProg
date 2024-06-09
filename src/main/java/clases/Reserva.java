package clases;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva {
    protected String token;
    protected Asistente Asistente;
    protected Evento Evento;
    protected Butaca Butaca;
    protected LocalDate fecha;
    protected String hora;
    protected String metodo_pago;

    public Reserva(String token, clases.Asistente asistente, clases.Evento evento, clases.Butaca butaca, LocalDate fecha, String hora, String metodo_pago) {
        this.token = token;
        Asistente = asistente;
        Evento = evento;
        Butaca = butaca;
        this.fecha = fecha;
        this.hora = hora;
        this.metodo_pago = metodo_pago;
    }

    public static UUID generartoken() {
        UUID token = UUID.randomUUID();  // Genera un nuevo UUID aleatorio
        System.out.println("Token generado: " + token.toString());
        return token;  // devuelve el UUID generado
    }
}
