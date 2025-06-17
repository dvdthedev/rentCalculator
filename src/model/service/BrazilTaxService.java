package model.service;

public class BrazilTaxService implements TaxService{
    @Override
    public Double tax(Double amount) {
        Double tax = amount > 100.0 ? amount * 0.15 : amount * 0.2;
        return tax + amount;
    }
}
