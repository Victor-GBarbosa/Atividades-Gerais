package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    protected String productName;
    protected double totalValue;
    protected int id;

    Client client;
    List<Product> products = new ArrayList<>();

}
