package libraryofchange;

import java.util.*;
import java.text.DecimalFormat;

public class MakeChange {

	public static void main(String[] args) {
		double price = 0, moneytendered = 0, priceparse, moneyparse, y = 0, z = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the item's price: ");
		price = input.nextDouble();
		priceparse = Double.parseDouble(new DecimalFormat("##.##").format(price));
		System.out.println("Please enter the amount tendered by customer: ");
		moneytendered = input.nextDouble();
		moneyparse = Double.parseDouble(new DecimalFormat("##.##").format(moneytendered));
		System.out.println("So the amount tendered was ..." + moneyparse);
		checkRightPrice(moneyparse, priceparse, moneytendered, z, y);

		// do {
		// System.out.println("Select an option: ");
		// System.out.println("1) List Employees");
		// } while (moneyparse > priceparse);

		System.out.print("\nHave a good day. See ya!");

	}

	public static boolean checkRightPrice(double moneyparse, double priceparse, double moneytendered, double z, double y) {
		boolean result = false;
		String cList[] = { "twenty dollar bill", "ten dollar bill", "five dollar bill", 
				"one dollar bill", "quarters", "dimes", "nickels", "pennies" };
		Scanner input = new Scanner(System.in);
		// I insert a input correction loop
		while (!(moneyparse > priceparse)) {
			if (moneyparse < priceparse) {
				result = false;
				System.err.println("ERROR: The customer provided too little money.");
				System.out.println("Please enter another amount: ");
				moneytendered = input.nextDouble();
				moneyparse = Double.parseDouble(new DecimalFormat("##.##").format(moneytendered));

			} else if (moneyparse == priceparse) {
				result = false;
				System.err.println("Can't help you. Customer has given exact change.");
				System.out.println("Let's make change another time.");
				break;

			}
		}
		if (moneyparse > priceparse) {
			z = moneyparse;
			y= (moneyparse - priceparse);
			double Ten, Fiv, Uno, Quarter, Dime, Nickel, Penny;
			int a, b, c, d, e, f, g;
			System.out.println("Let's move forward and see how much change you receive in return.");
			System.out.print("Here is the customer's change, starting ");
			System.out.println("with the largest bill: "); 
			while(z > priceparse) {
				Ten = (y / 10);
				if (Ten > 0.0) {
					a = (int)(Ten);
				    System.out.println(a + " " + cList[1]);
			    }
				Fiv = y / 5;
				if (Ten < 1.0) {
					b = (int)(Fiv);
					System.out.println(b + " " + cList[2]);
				}
				Uno = y / 1;
				if (Fiv < 1.0) {
					c = (int)(Uno);
					System.out.println(c + " " + cList[3]);
				}
				Quarter = y / 0.25;
				if (Uno < 1.0) {
					d = (int)(Quarter);
					System.out.println(d + " " + cList[4]);
				}
				Dime = y / .10;
				if (Quarter < 1.0) {
					e = (int)(Dime);
					System.out.println(e + " " + cList[5]);
				}
				Nickel = y / .05;
				if (Dime < 1.0) {
					f = (int)(Nickel);
					System.out.println(f + " " + cList[6]);
				}
				Penny = y / .01;
				if (Nickel < 1.0) {
					g = (int)(Penny);
					System.out.println(g + " " + cList[7]);
				}

				break;
			}

			System.out.println(Arrays.toString(cList));
		}
		input.close();
		result = true;
		return result;

	}
}
