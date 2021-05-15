package com.skilldistillery;

import java.util.Scanner;
import java.lang.Math;

public class MakesChange {
	public static void main(String[] args) {
		// get user input of amount tendered and amount given
		double amountTendered;//Tendered means asked.
		double amountGiven;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the price of the item: ");
		amountTendered = input.nextDouble();
		System.out.println("Enter the amount given to the cashier: ");
		amountGiven = input.nextDouble();

		// define doubles for dollars and coins
		double hundredDollar = 100.00;
		double twentyDollar = 20.00;
		double tenDollar = 10.00;
		double fiveDollar = 5.00;
		double dollar = 1.00;
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double penny = 0.01;

		// round changeDue to 2 decimal places and calculate the modulus in a hierarchy
		double changeDue = ((double) ((int) Math.round((amountGiven - amountTendered) * 100)) / 100.0);
		double modHundred = ((double) ((int) Math.round((changeDue % hundredDollar) * 100)) / 100.0);
		double modTwenty = ((double) ((int) Math.round((modHundred % twentyDollar) * 100)) / 100.0);
		double modTen = ((double) ((int) Math.round((modHundred % tenDollar) * 100)) / 100.0);
		double modFive = ((double) ((int) Math.round((modHundred % fiveDollar) * 100)) / 100.0);
		double modDollar = ((double) ((int) Math.round((modHundred % dollar) * 100)) / 100.0);
		double modQuarter = ((double) ((int) Math.round((modHundred % quarter) * 100)) / 100.0);
		double modDime = ((double) ((int) Math.round((modHundred % dime) * 100)) / 100.0);
		double modNickel = ((double) ((int) Math.round((modHundred % nickel) * 100)) / 100.0);
		double modPenny = ((double) ((int) Math.round((modHundred % penny) * 100)) / 100.0);

		// count number of dollar bills and coins
		int numHundreds = (int) ((changeDue - modHundred) / (hundredDollar));
		int numTwenties = (int) ((modHundred - modTwenty) / (twentyDollar));
		int numTens = (int) ((modTwenty - modTen) / (tenDollar));
		int numFives = (int) ((modTen - modFive) / (fiveDollar));
		int numDollars = (int) ((modFive - modDollar) / (dollar));
		int numQuarters = (int) ((modDollar - modQuarter) / (quarter));
		int numDimes = (int) ((modQuarter - modDime) / (dime));
		int numNickels = (int) ((modDime - modNickel) / (nickel));
		int numPennies = (int) ((modNickel - modPenny) / (penny));

		// return information to user
		System.out.println("\nTotal amount of change to give: " + changeDue);
		System.out.println("Number of hundred dollar bills to give: " + numHundreds);
		System.out.println("Number of twenty dollar bills to give: " + numTwenties);
		System.out.println("Number of ten dollar bills to give: " + numTens);
		System.out.println("Number of five dollars bills to give: " + numFives);
		System.out.println("Number of dollars bills to give: " + numDollars);
		System.out.println("Number of quarters to give: " + numQuarters);
		System.out.println("Number of dimes to give: " + numDimes);
		System.out.println("Number of nickels to give: " + numNickels);
		System.out.println("Number of pennies to give: " + numPennies);

	}
}