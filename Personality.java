// Lauren Kim
// Assignment #7: Personality Test
// 08/20/21

import java.util.*;
import java.io.*;
 
 public class Personalityy {
 
   public static void main(String[] args) throws FileNotFoundException {
      
      Scanner console = new Scanner(System.in); 
      System.out.println("This program processes a file of answers to the \nKeirsey Temperament Sorter.  It converts the\nvarious A and B answers for each person into \na sequence of B-percentages and then into a \nfour-letter personality type.\n"); 
     
      System.out.print("input file name? "); 
      String inFile = console.nextLine(); 
      Scanner input = new Scanner(new File(inFile));
      
      System.out.print("output file name? ");
      String outFile = console.nextLine();
      PrintStream output = new PrintStream(new File(outFile));
      
      while (input.hasNext()) {
         int[][] ars = read(input, output);
         int[] cents = analyze(ars, output);
         sort(cents, output);
         output.println();
      }
   }
   
    public static int[][] read(Scanner input, PrintStream output) throws FileNotFoundException {
    
      String name = input.nextLine();
      String ans = input.nextLine();
      
      output.print(name + ": "); 
         
      int[][] data = new int[2][4];
               
      for (int i = 1; i <= ans.length(); i++) {
        String lett = ans.substring(i-1, i); 
        int index = -1; 
            if (i%7==1) {
               index = 0;
            } else if (i%7==2 || i%7==3) {
               index = 1; 
            } else if (i%7==4 || i%7==5) {
               index = 2; 
            } else if (i%7==6 || i%7==0) {
               index = 3;
            }         
            
            if (lett.equals("A") || lett.equals("a")) {
               data[0][index]++; 
            } else if (lett.equals("B") || lett.equals("b")) {
               data[1][index]++;
            }
         }
         return data;
    }
 
   public static int[] analyze(int[][] data, PrintStream output) throws FileNotFoundException {
      
      int[] percents = new int[4];
      for (int i = 0; i < 4; i++) {
         int sum = data[0][i] + data[1][i];
         double percentage = ((double) data[1][i] / sum) * 100;
         percents[i] = (int) Math.round(percentage);
      }  
      output.print(Arrays.toString(percents));
      return percents;
   }
   
   public static void sort(int[] percents, PrintStream output) {
   
      String str = "";
      for (int i = 0; i < 4; i++) {
         if (percents[i] > 50) {
           if (i==0) {
               str+="I"; 
           } else if (i==1) {
               str+="N";
           } else if (i==2) {
               str+="F";
           } else if (i==3) {
               str+="P";
           }
        } else if (percents[i] < 50) {
           if (i==0) {
               str+="E"; 
           } else if (i==1) {
               str+="S";
           } else if (i==2) {
               str+="T";
           } else if (i==3) {
               str+="J";
           }
        } else {
           str+="X";
        }   
      }
      output.print(" = " + str);
   }
   
 }
