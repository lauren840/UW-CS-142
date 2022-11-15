import java.util.*;
import java.io.*;

public class Personality {

   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      int[] aData = new int[4];
      int[] bData = new int[4];
      int[] bPercent = new int[4]; 
      intro();
      System.out.println();
      Scanner input = new Scanner(input(console));
      PrintStream output = new PrintStream(output(console)); 
      String personalityType = "";
      while (input.hasNextLine()) {  
         String name = input.nextLine();
         String answer = input.nextLine();
         sort(answer, aData, bData);
         calculate(aData, bData, bPercent);
         personalityType = results(bPercent, personalityType);
         output.println(name + ": " + Arrays.toString(bPercent) + " = " + personalityType);   
         Arrays.fill(aData, 0); 
         Arrays.fill(bData, 0); 
         Arrays.fill(bPercent, 0); 
         personalityType = "";
      } 
   }
   
   public static void intro() { 
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type."); 
   }
   
   public static File input(Scanner console) throws FileNotFoundException { 
      System.out.print("input file name? "); 
      String inputFile = console.nextLine();
      File inF = new File(inputFile);
      return inF;
   } 
   
   public static File output(Scanner console) throws FileNotFoundException {
      System.out.print("output file name? "); 
      String outputFile = console.nextLine();
      File outF = new File(outputFile);
      return outF;    
   }
       
   public static void sort(String answer, int[] aData, int[] bData) {
      for (int i = 0; i < 70; i++) {
         if (i % 7 == 0) {
               if(answer.charAt(i) == 'A' || answer.charAt(i) == 'a') {
                  aData[0]++;
               } else if(answer.charAt(i) == 'B' || answer.charAt(i) == 'b') {
                  bData[0]++;
               }
                              
         } else if (i % 7 == 1 || i % 7 == 2) {
               if(answer.charAt(i) == 'A' || answer.charAt(i) == 'a') {
                  aData[1]++;
               } else if(answer.charAt(i) == 'B' || answer.charAt(i) == 'b') {
                  bData[1]++;
               }
               
         } else if (i % 7 == 3 || i % 7 == 4) { 
               if(answer.charAt(i) == 'A' || answer.charAt(i) == 'a') {
                  aData[2]++;
               } else if(answer.charAt(i) == 'B' || answer.charAt(i) == 'b') {
                  bData[2]++;
               }
               
         } else if (i % 7 == 5 || i % 7 == 6) {
               if(answer.charAt(i) == 'A' || answer.charAt(i) == 'a') {
                  aData[3]++;
               } else if(answer.charAt(i) == 'B' || answer.charAt(i) == 'b') {
                  bData[3]++;
               }
         }
      }
   }
   
   public static void calculate(int[] aData, int[] bData, int bPercent[]) {
      for (int i = 0; i < 4; i++) {
         double sum = aData[i] + bData[i];
         double percentage = bData[i] / sum * 100;
         int percent = (int) Math.round(percentage);
         bPercent[i] = percent;
      }
   }
   
   public static String results(int[] bPercent, String personalityType) {  
      if (bPercent[0] < 50) {
         personalityType = personalityType + "E";
      } else if (bPercent[0] == 50) {
         personalityType = personalityType + "X";
      } else if (bPercent[0] > 50) {
         personalityType = personalityType + "I";
      }
      
      if (bPercent[1] < 50) {
         personalityType = personalityType + "S";
      } else if (bPercent[1] == 50) {
         personalityType = personalityType + "X";
      } else if (bPercent[1] > 50) {
         personalityType = personalityType + "N";
      }   
      
      if (bPercent[2] < 50) {
         personalityType = personalityType + "T";
      } else if (bPercent[2] == 50) {
         personalityType = personalityType + "X";
      } else if (bPercent[2] > 50) {
         personalityType = personalityType + "F";
      } 
      
      if (bPercent[3] < 50) {
         personalityType = personalityType + "J";
      } else if (bPercent[3] == 50) {
         personalityType = personalityType + "X";
      } else if (bPercent[3] > 50) {
         personalityType = personalityType + "P";
      } 
      
      return personalityType; 
   }
}   