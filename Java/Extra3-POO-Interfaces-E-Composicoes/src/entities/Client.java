package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {

    protected String name;
    protected String email;

    List<Order> orderList = new ArrayList<>();
}
