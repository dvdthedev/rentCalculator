package model.service;

import model.entities.CarRental;
import model.entities.Invoice;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RentalService {


    private Double pricePerDay;
    private Double pricePerHour;

    private  TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){
        Long minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayment;
        if(hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        else {
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    //    public BigDecimal parkingChargeTime() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//
//        Date data = new Date();
//        Date newDate = sdf.parse(sdf.format(returnDate));
//        Long diff = TimeUnit.MINUTES.convert((data.getTime() - newDate.getTime()), TimeUnit.MILLISECONDS);
//        BigDecimal valueToPay = valueCalculator(diff, pricePerHour, pricePerDay);
//
//        return valueToPay;
//    }
//
//    public BigDecimal valueCalculator(Long diff, BigDecimal pricePerHour, BigDecimal pricePerDay){
//        Long oneHour = 60L;
//        Long totalHours = diff / oneHour;
//        if(diff > 600){
//            return dayCalculator(diff, pricePerDay);
//        } else
//        if(diff % oneHour != 0){
//            return new BigDecimal((totalHours + 1)).multiply(pricePerHour);
//        }
//        else
//            return pricePerHour.multiply(new BigDecimal(totalHours));
//    }
//
//    public BigDecimal dayCalculator(Long diff, BigDecimal pricePerDay){
//        Long minutesInADay = 1440L;
//        Long totalDays = diff / minutesInADay;
//
//        if (diff < minutesInADay){
//            return pricePerDay;
//        } else
//        if(diff % minutesInADay != 0){
//            return new BigDecimal((totalDays + 1)).multiply(pricePerDay);
//        }
//        else return pricePerDay.multiply(new BigDecimal(totalDays));
//
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//

}
