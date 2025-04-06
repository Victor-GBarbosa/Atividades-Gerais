package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    protected Integer number;
    protected LocalDate date;
    protected Double totalValue;

    List<Installment> installments = new ArrayList<>();

    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Contract(Integer number, LocalDate date, Double totalValue, int installmentsQuantity) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }
}
