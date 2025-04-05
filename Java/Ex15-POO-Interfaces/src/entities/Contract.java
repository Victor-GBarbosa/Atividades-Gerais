package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    protected Integer number;
    protected Date date;
    protected Double totalValue;

    List<Installment> installments = new ArrayList<>();

    public Contract(Integer number, Date date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }
}
