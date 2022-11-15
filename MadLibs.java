// Lauren Kim, 08/06/2021
// HW 6: Mad Libs 
// This program prompts the user for input and output strings and uses different 
// files to create fun mad-libs for the user to view. 

import java.io.*;
import java.util.*;
public class MadLibs { 
   public static void main(String[] args) throws FileNotFoundException { 
      Scanner console = new Scanner(System.in);       
      boolean test = true;
      intro();
      while (test) {    // reprompts user until "q", "c",  or "v" (case-insensitively) is inputed
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? "); 
         String prompt = console.nextLine();
         prompt = prompt.toLowerCase();
         if (prompt.equals("q")) {
            test = false; 
         } else if (prompt.equals("c")) {
            create(console);
         } else if (prompt.equals("v")) {
            view(console);
         }
      }    
   } 
   
  // Introduction of the Mad Libs game.  
  public static void intro() {
   System.out.println("Welcome to the game of Mad Libs.");
   System.out.println("I will ask you to provide various words"); 
   System.out.println("and phrases to fill in a story.");
   System.out.println("The result will be written to an output file.");
   System.out.println();
  }
  
  // Method views the inputed file, and prints out its content in the console. 
  public static void view(Scanner console) throws FileNotFoundException{
     Scanner input = new Scanner(inputCheck(console));  //inputCheck() prompts and checks for an existing input file
     System.out.println();
      while (input.hasNextLine()) {    // reads per line so it can be printed per line, like the original
         String line = input.nextLine();
         Scanner lineScan = new Scanner(line);
      
         while (lineScan.hasNext()) {  // reads each token and prints in the console
            String word = lineScan.next();              
            System.out.print(word + " ");    
         }
         System.out.println();
      }
      System.out.println();    
   } 
   
   // Method creates a mad-lib by reading input file and printing it to output file.  
   // Placeholders in input files are replaced by user input while printing.  
   public static void create(Scanner console) throws FileNotFoundException {      
      Scanner input = new Scanner(inputCheck(console));  //inputCheck() prompts and checks for an existing input file
      System.out.print("Output file name: "); 
      String outputFile = console.nextLine(); 
      PrintStream output = new PrintStream(new File(outputFile));
      System.out.println();
           
      while (input.hasNextLine()) {   // reads per line first to print output by lines
         String line = input.nextLine();
         Scanner lineScan = new Scanner(line);
      
         while (lineScan.hasNext()) {  // reads per token, within the first while loop 
            String word = lineScan.next();  
            
            if (word.startsWith("<") && word.endsWith(">")) {  // if the token is a placeholder
               int length = word.length(); 
               word = word.substring(1, length - 1); 
               word = word.replace("-", " ");
               System.out.print("Please type a"); 
            
               // If the placeholder begins with a vowel, use "an". If not, use "a"
               if (word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u")) { 
                  System.out.print("n " + word + ": ");
               } else {
                  System.out.print(" " + word + ": ");
               } 
               word = console.nextLine();  // prompts user to fill in the placeholder    
            }      
            output.print(word + " ");             
         } 
         output.println();
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
 
   // Method prompts user for input file's name and checks if the file exists
   // Returns File f, catched in view() and create() methods. 
   public static File inputCheck(Scanner console) throws FileNotFoundException {
      System.out.print("Input file name: "); 
      String inputFile = console.nextLine(); 
      File f = new File(inputFile);
      while (!f.exists()) {
         System.out.print("File not found. Try again: ");
         inputFile = console.nextLine();
         f = new File(inputFile);
      }
      return f;
   }
} 