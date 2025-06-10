import model.entities.Rent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();
        Date newDate = sdf.parse("10/06/2025 01:30");
        Long diff = TimeUnit.MINUTES.convert((data.getTime() - newDate.getTime()), TimeUnit.MILLISECONDS);
        //System.out.println(diff);

        //Rent rent = new Rent("Civic", data, newDate, 10.00, 120.0);

        ZonedDateTime inicioHora = ZonedDateTime.of(2024, 6, 7, 10, 0, 0, 0, ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime fimHora = ZonedDateTime.of(2024, 6, 10, 11, 15, 0, 0, ZoneId.of("America/Sao_Paulo"));
        Duration duration = Duration.between(inicioHora, fimHora);
        Long hours = duration.getSeconds() / 3600;
        Long days = (long) Math.ceil(duration.getSeconds() / 86400.0);
        System.out.println("segundos: " + duration.getSeconds() + " "  + "horas: " + hours + " " + "dias: " + days);

        //System.out.println(rent.parkingChargeTime());
    }


}

