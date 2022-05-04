package Program;

import java.util.Locale;
import java.util.Scanner;

import Entitie.AccountSettings;
import model.exceptions.DomainException;

public class Application {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Locale.setDefault(Locale.US);
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
		
			System.out.print("Enter amount for withdrawn: ");
			Double amount = sc.nextDouble();
		
			System.out.println();
		
			AccountSettings accSet = new AccountSettings(number, holder, initialBalance, withdrawLimit, amount);
			System.out.print("New Balance: ");
			System.out.print(accSet.Withdraw(amount)); }
		
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		
		}
		sc.close();
	}
}
