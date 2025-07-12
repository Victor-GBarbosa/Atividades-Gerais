package org.quantaidk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String pf = "./test.csv";
        Scanner scan = new Scanner(System.in);
        List<User> userList = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(pf))) {

            String line;


            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                userList.add(new User(data[0], data[1], Double.parseDouble(data[2])));
            }
            System.out.printf("Enter salary: ");
            double salaryInput = scan.nextDouble(); scan.nextLine();


            Comparator<String> comp = (str1, str2) -> str1.compareTo(str2);

            userList.stream().filter(u -> u.getSalary() >= salaryInput).map(p -> p.getName()).sorted(comp);

            List<Double> prices = userList.stream().map(User::getSalary).reduce((x, y) -> (x + y)).stream().toList();

            for (double price : prices) {
                System.out.printf("%.2f\n", price);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}