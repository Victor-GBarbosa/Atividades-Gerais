package entities;

public class Individual extends TaxPayer {

        protected double healthExpenditures;

        

    public Individual(String name, double anualIncome, double healthExpenditures) {
            super(name, anualIncome);
            this.healthExpenditures = healthExpenditures;
            this.tax = getTaxInfo();
        }

    @Override
    public double getTaxInfo() {
        double totalTax;

        if(anualIncome < 20000) {
            totalTax = anualIncome * (15.0 / 100.0);
        } else {
            totalTax = anualIncome * (25.0 / 100.0);
        }

        totalTax = totalTax - (healthExpenditures * .5);
    
        return totalTax;
    }

    public double getHealthExpenditures() {
        return healthExpenditures;
    }

    @Override
    public String toString() {
        return getName() + " - Individual - Imposto R$ " + String.format("%.2f", this.tax);
    }

}
