package entities;

public class Company extends TaxPayer {

    protected int numberOfEmployees;

    @Override
    public double getTaxInfo() {
        
            double totalTax;
    
            if(numberOfEmployees < 10) {
                totalTax = anualIncome * (16.0 / 100.0);
            } else {
                totalTax = anualIncome * (12.0 / 100.0);
            }
            return totalTax;
    }

    public Company(String name, double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
        this.tax = getTaxInfo();
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return getName() + " - Empresarial - Imposto R$ " + String.format("%.2f", this.tax);
    }

}
