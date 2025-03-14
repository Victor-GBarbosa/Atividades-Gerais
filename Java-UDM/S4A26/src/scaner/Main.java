package scaner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String a;
		a = scan.next();
		
		System.out.println("Voce digitou: " + a);
		
		scan.close();
	}

}
