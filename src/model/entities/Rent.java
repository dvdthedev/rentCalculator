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
    private Double pricePerHour;
    private Double pricePerDay;
    private BigDecimal price;

    public Rent(String model, Date pickupDate, Date returnDate, Double pricePerHour, Double pricePerDay) throws ParseException {
        this.model = model;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.price = parkingChargeTime();
    }

    public BigDecimal parkingChargeTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Date data = new Date();
        Date newDate = sdf.parse(sdf.format(returnDate));
        Long diff = TimeUnit.MINUTES.convert((data.getTime() - newDate.getTime()), TimeUnit.MILLISECONDS);
        BigDecimal hours = valueCalculator(diff);

        System.out.println(diff);

        return hours;
    }

    public BigDecimal valueCalculator(Long diff){
        if(diff > 720){
            System.out.println("Case diary");
        }
        return new BigDecimal(10.00);
//        if((diff % 60) != 0){
//            return diff / 60 + 1;
//        }
//        else return diff / 60;
    }

    public Long dayCalculator(Long diff){
        if(diff < 1200){
            return 1L;
        } else
        if(diff % 1200 != 0){
            return diff / 1200 + 1;
        } else
            System.out.println();
            return diff / 1200;
    }

}
