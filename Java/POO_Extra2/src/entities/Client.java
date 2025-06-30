package entities;

import entities.enums.UserType;

public class Client extends Order {
    private String name;
    private String email;
    private UserType userType;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public UserType getUserType() {
        return userType;
    }
}
