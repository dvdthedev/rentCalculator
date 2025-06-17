import model.entities.Invoice;
import model.entities.Vehicle;
import model.service.BrazilTaxService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();
        Date newDate = sdf.parse("13/06/2025 15:06");


        Invoice invoice = new Invoice(new Vehicle("Civic"), data, newDate, BigDecimal.valueOf(10), BigDecimal.valueOf(120));
        System.out.println(invoice);


        BrazilTaxService brt = new BrazilTaxService();

        System.out.println(brt.tax(99.0));
    }





}

