package applications;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: $");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: $");
			double limit = sc.nextDouble();

			Account acc = new Account(number, holder, balance, limit);

			System.out.print("\nEnter amount for withdraw: ");
			double withdraw = sc.nextDouble();
			acc.withdraw(withdraw);
			System.out.println(acc);
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("\nUnexpected Error!");
		} finally {
			System.out.println("End of program!");
		}
		sc.close();

	}

}
