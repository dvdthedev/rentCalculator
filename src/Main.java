import model.entities.CarRental;
import model.entities.Invoice;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data = LocalDateTime.now();
        LocalDateTime newDate = LocalDateTime.parse("13/06/2025 15:06", sdf);

        CarRental cr = new CarRental(newDate, data, new Vehicle("Civic"));

        double pricePerDay = 120.0;
        double pricePerHour = 10.0;
        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println(cr.getInvoice());
    }





}

