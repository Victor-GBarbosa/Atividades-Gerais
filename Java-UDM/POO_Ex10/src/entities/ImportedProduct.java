package entities;

public class ImportedProduct extends Product{
    protected double customsFee;
    private double bPrice;

    @Override
    public void getInfo() {
        System.out.printf("%s (Importado) - R$%.2f (Taxa: R$%.2f %.2f%%)", this.name, this.price, this.bPrice * (this.customsFee / 100) ,this.customsFee);
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
        this.bPrice = price;
        this.price = price + (price * (customsFee / 100));
    }

    
}
