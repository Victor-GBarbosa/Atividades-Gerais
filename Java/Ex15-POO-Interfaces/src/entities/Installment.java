package entities;

import java.time.LocalDate;

public class Installment {
    private LocalDate dueDate;
    private Double amounmt;

    public Installment() {
    }

    public Installment(LocalDate dueDate, Double amounmt) {
        this.dueDate = dueDate;
        this.amounmt = amounmt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmounmt() {
        return amounmt;
    }

    public void setAmounmt(Double amounmt) {
        this.amounmt = amounmt;
    }

    
}
