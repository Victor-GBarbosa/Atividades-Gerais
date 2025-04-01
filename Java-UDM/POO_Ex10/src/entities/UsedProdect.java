package entities;

public class UsedProdect extends Product {
    protected String manufectureDate;

    @Override
    public void getInfo() {
        System.out.printf("%s (Usado) - R$%.2f (Data de fabricação %s)", this.name, this.price, this.manufectureDate);
    }

    public UsedProdect(String name, double price, String manufectureDate) {
        super(name, price);
        this.manufectureDate = manufectureDate;
    }

    public String getManufectureDate() {
        return manufectureDate;
    }

    public void setManufectureDate(String manufectureDate) {
        this.manufectureDate = manufectureDate;
    }

    

}
