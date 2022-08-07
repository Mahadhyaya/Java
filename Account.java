import java.util.*;
import java.io.*;
import java.io.File;
import java.util.function.*;
import java.util.stream.*;


public class Account {
	double balance = 500;
	static Scanner scanner = new Scanner(System.in);
	static String str = "Soorya";
	int acn;
	Account(int acn) {
		this.acn = acn;
	}

	public static void main(String[] args) {
		Account[] account = new Account[2];
		for (int j = 0; j < account.length; j++) {
			System.out.println("Enter account number");
			account[j] = new Account(scanner.nextInt());
		}
		boolean choices = true;
		while (choices) {
		boolean bool = true;
		System.out.println("Menu\n1.Deposit\n2.Withdraw\n3.Balance Enquiry\n4.Exit");
		System.out.println("Enter your choice");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1 :
					System.out.println("Enter Account number");
					int t = scanner.nextInt();
					for (int i = 0; i < account.length; i++) {
						if (t == account[i].acn) {
							account[i].deposit();
							bool = false;
							break;
						}
					}
					if (bool) {
						System.out.println("Enter Proper account number");
					}
					break;
			case 2 :
					System.out.println("Enter Account number");
					int m = scanner.nextInt();
					for (int i = 0; i < account.length; i++) {
					if (m == account[i].acn) {
						account[i].withdraw();
						bool = false;
						break;
					}
					}
					if (bool) {
						System.out.println("Enter Proper account number");
					}
					break;
			case 3 :
					System.out.println("Enter Account number");
										int l = scanner.nextInt();
										for (int i = 0; i < account.length; i++) {
										if (l == account[i].acn) {
											account[i].balanceEnquiry();
											bool = false;
											break;
										}
										}
										if (bool) {
											System.out.println("Enter Proper account number");
										}
					break;
			case 4 :
					System.exit(0);
		}
		System.out.println("Thank You\n");
		}
	}

	 void deposit() {
		/*System.out.println("Enter Account number");
		int i = scanner.nextInt();
		if (i == acn1 || i == acn2) {
			System.out.println("Enter the amount");
			double deposits = scanner.nextDouble();
			balance += deposits;
		} else {
			System.out.println("Enter Proper account number");
		}*/
		System.out.println("Enter the amount");
		double deposits = scanner.nextDouble();
		this.balance += deposits;
	}

	 void withdraw() {
		/*System.out.println("Enter Account number");
		int i = scanner.nextInt();
		System.out.println("Enter the amount");
		double withdrawn = scanner.nextDouble();
		try {
		if (i == acn1 || i == acn2) {
			if (balance - withdrawn < 500) {
				throw new LessBalanceException(withdrawn);
			} else {
				balance -= withdrawn;
			}
		}
		} catch (LessBalanceException e) {
			return;
		}*/
		System.out.println("Enter the amount");
		double withdrawn = scanner.nextDouble();
		try {
					if (this.balance - withdrawn < 500) {
						throw new LessBalanceException(withdrawn);
					} else {
						this.balance -= withdrawn;
					}
		} catch (LessBalanceException e) {
			return;
		}
	}
	 void balanceEnquiry() {
		/*System.out.println("Enter Account number");
		int i = scanner.nextInt();
		if (i == acn1 || i == acn2) {
			System.out.println("Balance is:" + balance);
		} else {
			System.out.println("Enter Proper account number");
		}*/
		System.out.println("Balance is:" + this.balance);
	}
}

class LessBalanceException extends Throwable{
	LessBalanceException(double withdrawn) {
		System.out.println("Withdraw amount Rs." + withdrawn + " is not Valid.");
	}
}