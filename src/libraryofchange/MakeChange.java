package libraryofchange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		double price = 0, moneytendered = 0, y = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the item's price: ");
		price = input.nextDouble();
		// input.checkRightPrice();
		System.out.println("Please enter the amount tendered by customer: ");
		moneytendered = input.nextDouble();
		System.out.println("So the amount tendered was ..." + moneytendered);
		input.close();

	}

	public static boolean isTender(double moneytendered, double price) {
		boolean result = false;
		if (moneytendered > price) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}   
