package com.skilldistillery;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MakesChange {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double itemPrice;
		double amtGiven;
		
		System.out.println("Hi, how much is your item?");
		itemPrice = scanner.nextDouble();
		
		System.out.println("How much are you giving?");
		amtGiven = scanner.nextDouble();
		
		if (itemPrice > amtGiven) {
			System.out.println("You do not have enough! Put this back.");
		} else if (itemPrice == amtGiven) {
			System.out.println("You gave the exact amount. Thank you, have a nice day!");
		} else if (itemPrice < amtGiven) {
			changeMachine(itemPrice, amtGiven);
		} else {
			System.err.println("... There was an error. Please give number amounts.");
		}
	}

	public static void changeMachine(double itemPrice, double amtGiven) {
		// stores the amount of change is due
		double actualChange = (amtGiven - itemPrice);
		
		DecimalFormat twoDeciPlace = new DecimalFormat("#.00");
		System.out.println("Your change sums up to be: $" + twoDeciPlace.format(actualChange));
		
		// first we should make multiply by 100 and everything an integer to make math
		// easier and more precise.
		int fullItemPrice = (int) (itemPrice * 100);
		int fullAmtGiven = (int) (amtGiven * 100);
		int change = fullAmtGiven - fullItemPrice;
		
		
		// figure out the number of hundreds, fifties, coins etc by multiplying their values by 100 and 
		// dividing change by their values
		// set the change to now equal the remainder of change when divided by the bill and coin values
		int hundredsAmt = (change / 10000);
		change = (change % 10000);
		int fiftiesAmt = (change / 5000);
		change = (change % 5000);
		int twentiesAmt = (change / 2000);
		change = (change % 2000);
		int tensAmt = (change / 1000);
		change = (change % 1000);
		int fivesAmt = (change / 500);
		change = (change % 500);
		int onesAmt = (change / 100);
		change = (change % 100);
		
		int quartersAmt = (change / 25);
		change = (change % 25);
		int dimesAmt = (change / 10);
		change = (change % 10);
		int nickelsAmt = (change / 5);
		change = (change % 5);
		int penniesAmt = (change / 1);
		change = (change % 1);
		
		
		// I use if statements to control whether change amounts will be displayed
		// I utilize the not boolean here to make my comparisons
		if (hundredsAmt != 0) {
			System.out.println("We owe you " + hundredsAmt + " hundreds.");
		}	
		if (fiftiesAmt != 0) {
			System.out.println("We owe you " + fiftiesAmt + " fifties.");
		}	
		if (twentiesAmt != 0) {
			System.out.println("We owe you " + twentiesAmt + " twenties.");
		}
		if (tensAmt != 0) {
			System.out.println("We owe you " + tensAmt + " tens.");
		}
		if (fivesAmt != 0) {
			System.out.println("We owe you " + fivesAmt + " fives.");			
		}
		if (onesAmt != 0) {
			System.out.println("We owe you " + onesAmt + " ones.");			
		}
		if (quartersAmt != 0) {
			System.out.println("We owe you " + quartersAmt + " quarters.");			
		}
		if (dimesAmt != 0) {
			System.out.println("We owe you " + dimesAmt + " dimes.");			
		}
		if (nickelsAmt != 0) {
			System.out.println("We owe you " + nickelsAmt + " nickels.");		
		}
		if (penniesAmt != 0) {
			System.out.println("We owe you " + penniesAmt + " pennies.");			
		}
	}

}