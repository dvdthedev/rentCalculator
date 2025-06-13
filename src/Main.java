import model.entities.Rent;

import java.math.BigDecimal;
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
        Date newDate = sdf.parse("13/06/2025 15:06");


        Rent rent = new Rent("Civic", data, newDate, BigDecimal.valueOf(10), BigDecimal.valueOf(120));
        System.out.println(rent);
    }


}

