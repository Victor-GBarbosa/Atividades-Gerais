package entities;

public abstract class TaxPayer {

    protected String name;
    protected double anualIncome;
    protected double tax;

    public TaxPayer(String name, double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnualIncome(double anualIncome) {
        this.anualIncome = anualIncome;
    }

    public String getName() {
        return name;
    }

    public double getAnualIncome() {
        return anualIncome;
    }

    public abstract double getTaxInfo();

}
