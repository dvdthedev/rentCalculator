package model.entities;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rent {
    private String model;
    private Date pickupDate;
    private Date returnDate;
    private BigDecimal pricePerHour;
    private BigDecimal pricePerDay;
    private BigDecimal price;

    public Rent(String model, Date pickupDate, Date returnDate, BigDecimal pricePerHour, BigDecimal pricePerDay) throws ParseException {
        this.model = model;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.price = parkingChargeTime();
    }

    public BigDecimal parkingChargeTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Date data = new Date();
        Date newDate = sdf.parse(sdf.format(returnDate));
        Long diff = TimeUnit.MINUTES.convert((data.getTime() - newDate.getTime()), TimeUnit.MILLISECONDS);
        BigDecimal valueToPay = valueCalculator(diff, pricePerHour, pricePerDay);

        return valueToPay;
    }

    public BigDecimal valueCalculator(Long diff, BigDecimal pricePerHour, BigDecimal pricePerDay){
        Long oneHour = 60L;
        Long totalHours = diff / oneHour;
        if(diff > 600){
            return dayCalculator(diff, pricePerDay);
        } else
            if(diff % oneHour != 0){
                return new BigDecimal((totalHours + 1)).multiply(pricePerHour);
            }
            else
        return pricePerHour.multiply(new BigDecimal(totalHours));
    }

    public BigDecimal dayCalculator(Long diff, BigDecimal pricePerDay){
        Long minutesInADay = 1440L;
        Long totalDays = diff / minutesInADay;

        if (diff < minutesInADay){
            return pricePerDay;
        } else
        if(diff % minutesInADay != 0){
            return new BigDecimal((totalDays + 1)).multiply(pricePerDay);
        }
        else return pricePerDay.multiply(new BigDecimal(totalDays));

    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "model='" + model + '\'' +
                ", pickupDate=" + pickupDate +
                ", returnDate=" + returnDate +
                ", pricePerHour=" + pricePerHour +
                ", pricePerDay=" + pricePerDay +
                ", price=" + price +
                '}';
    }
}
