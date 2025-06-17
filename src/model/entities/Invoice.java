package model.entities;

import model.service.TaxService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Invoice {

    private Double basicPayment;
    private Double tax;

    private TaxService taxService;

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public double getTotalPayment(){
        return tax + basicPayment;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "basicPayment=" + basicPayment +
                ", tax=" + tax +
                ", totalPayment=" + getTotalPayment() +
                '}';
    }
}
