/* Lauren Kim, 07/16/2021
Assignment #4 Budgeter: This program asks for monthly income and expenses and displays the net monthly income.  */

import java.util.*;
public class Budgeter {  
   public static final int DAYS = 31; 
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.println("This program asks for your monthly income and ");
      System.out.println("expenses, then tells you your net monthly income.");
      double incomeSum = income(console);
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int num = console.nextInt();
      double expenseSum = expense(console);
      double difference = total(console, incomeSum, expenseSum, num);
      end(console, difference);
   } 
   
   /* Method to ask for number of income categories and income amounts. Number 
   of income amount inquiries are equal to number of income categories, given
   by console. Method returns sum of each income amount as incomeSum.*/
   public static double income(Scanner console) {
      System.out.println();
      System.out.print("How many categories of income? ");
      int incomeCat = console.nextInt();
      double incomeSum = 0.0;
      for (int i = 1; i <= incomeCat; i++) {
         System.out.print("    Next income amount? $");
         double incomeAmt = console.nextDouble();
         incomeSum = incomeSum + incomeAmt; 
      }
      System.out.println();
      return incomeSum;
   }
   
   /* Method to ask for number of expense categories and expense amounts. Number
   of expense amount inquiries are equal to number of expense categories, given
   by console. Method returns sum of each expense amount as expenseSum. */
   public static double expense(Scanner console) {
      System.out.print("How many categories of expense? ");
      int expenseCat = console.nextInt();
      double expenseSum = 0.0;
      for (int i = 1; i <= expenseCat; i++) {
         System.out.print("    Next expense amount? $");
         double expenseAmt = console.nextDouble();
         expenseSum = expenseSum + expenseAmt;
      }
      System.out.println();
      return expenseSum;
   }
   
   /* Method to calculate and display total income and expenses. Also displays 
   daily income and expenses, calculated by dividing the respectives sum by the 
   class constant DAYS -- the number of days in a month. Method also returns 
   difference of total income and expenses value as difference.  */
   public static double total(Scanner console, double incomeSum, double expenseSum, int num) {
      double monthlyExpense;
      double dailyExpense;
      if (num == 1) {
         dailyExpense = expenseSum / DAYS;
         monthlyExpense = expenseSum;
      } else {
         monthlyExpense = expenseSum * DAYS;
         dailyExpense = expenseSum;
      }         
      double dailyIncome = incomeSum / DAYS; 
      System.out.printf("Total income = $" + incomeSum 
      + " ($%.2f/day)", dailyIncome);
      System.out.println();
      System.out.printf("Total expenses = $%.2f", monthlyExpense);
      System.out.printf(" ($%.2f/day)", dailyExpense);
      System.out.println();
      double difference = incomeSum - monthlyExpense; 
      return difference; 
   } 
   
   /* Method displays the net value using the difference found in the 
   total() method. Displays custom message per value. */
   public static void end(Scanner console, double difference) { 
      System.out.println();
      if (difference < 0) {
         double absDifference = Math.abs(difference); 
         System.out.printf("You spent $%.2f more than you earned this month.", absDifference);
         System.out.println();
         if (difference < -250) {
            System.out.println("You're a big spender.");
            System.out.println("Woah. Save now so you don't go in debt!");
         } else if (difference > -250) {
            System.out.println("You're a spender.");
            System.out.println("Save while you can!");
         }
       
      } else if (difference >= 0) {
         System.out.printf("You earned $%.2f more than you spent this month.", difference);
         System.out.println();
         if (difference >= 250) {
            System.out.println("You're a big saver.");
            System.out.println("Treat yourself today! You've earned it.");
         } else if (difference < 250) { 
            System.out.println("You're a saver.");
            System.out.println("Keep saving, you're doing great!");
         }   
      }
   }
} 