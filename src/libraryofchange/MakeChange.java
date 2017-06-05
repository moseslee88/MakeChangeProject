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

		// considered adding a While loop here, but wasn't too sure

		System.out.print("\nHave a good day. See ya!");
	}

	public static boolean checkRightPrice(double moneyparse, double priceparse, double moneytendered, double z,
			double y) {
		boolean result = false;
		String cList[] = { "twenty dollar bill", "ten dollar bill", "five dollar bill", "one dollar bill", "quarters",
				"dimes", "nickels", "pennies" };
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
			y = (moneyparse - priceparse);
			double Ten, Fiv, Uno, Quarter, Dime, Nickel, Penny;
			int a, b, c, d, e, f, g;
			System.out.println("Let's move forward and see how much change you receive in return.");
			System.out.print("Here is the customer's change, starting ");
			System.out.println("with the largest bill: ");
			while (z > priceparse) {
				Ten = (y / 10);
				if (Ten > 0.0) {
					a = (int) (Ten);
					y = y % 10;
					System.out.println(a + " " + cList[1]);
				}
				Fiv = y / 5;
				if (Fiv > 0.0) {
					b = (int) (Fiv);
					y = y % 5;
					System.out.println(b + " " + cList[2]);
				}
				Uno = y / 1;
				if (Uno > 0.0) {
					c = (int) (Uno);
					y = y % 1;
					System.out.println(c + " " + cList[3]);
				}
				Quarter = y / 0.25;
				if (Quarter > 0.0) {
					d = (int) (Quarter);
					y = y % .25;
					System.out.println(d + " " + cList[4]);
				}
				Dime = y / .10;
				if (Dime > 0.0) {
					e = (int) (Dime);
					y = y % .10;
					System.out.println(e + " " + cList[5]);
				}
				Nickel = y / .05;
				if (Nickel > 0.0) {
					f = (int) (Nickel);
					y = y % .05;
					System.out.println(f + " " + cList[6]);
				}
				Penny = y / .01;
				if (Penny > 0.0) {
					g = (int)(Math.round(Penny));
					y = y % .01;
					System.out.println(g + " " + cList[7]);
				}
				break;
			}
			System.out.println("\n\n\n\n Here's the array I borrowed from.");
			System.out.println(Arrays.toString(cList));
		}
		input.close();
		result = true;
		return result;
	}
}
