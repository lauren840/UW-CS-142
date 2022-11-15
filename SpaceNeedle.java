/* Lauren Kim 
06/29/21
Assignment #2 Space Needle*/

public class SpaceNeedle {

   public static final int SIZE = 4;
   
   public static void main(String[] args) {
      top();  
      middle();
      colon();
   }
   
   public static void top() {
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 1; j <= (3 * SIZE); j++) {
            System.out.print(" ");
         }
         System.out.println("||");   
      }
      colon();
      System.out.println();
      slash();
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 1; j <= (3 * SIZE); j++) {
            System.out.print(" ");
         }
         System.out.println("||"); 
      }
   }                              
   
   public static void middle() {
      for (int i = 1; i <= (SIZE * SIZE); i++) {
         for (int j = 1; j <= (2 * SIZE + 1); j++) {
            System.out.print(" ");
         }
         System.out.print("|"); 
         for (int k = 1; k <= (SIZE - 2); k++) {
            System.out.print("%");
         }
         System.out.print("||"); 
         for (int k = 1; k <= (SIZE - 2); k++) {
            System.out.print("%");
         }
         System.out.print("|");
         System.out.println();
      }
   }       
   
   public static void colon() {
      for (int line = 1; line <= SIZE; line++) {
         for (int i = 1; i <= (-3 * line + (3 * SIZE)); i++) {
            System.out.print(" "); 
         }
         System.out.print("__/");
         for (int j = 1; j <= (3 * line - 3); j++) {
            System.out.print(":");
         }  
         System.out.print("||");
         for (int k = 1; k <= (3 * line - 3); k++) {
            System.out.print(":");
         }
         System.out.print("\\__");
         System.out.println("");    
      }
      System.out.print("|");
      for (int i = 1; i <= (6 * SIZE); i++) {
         System.out.print("\"");
      }
      System.out.print("|");
   }
   
   public static void slash() {
      for (int line = 1; line <= SIZE; line++) {
         for (int i = 1; i <= (2 * line - 2); i++) {
            System.out.print(" "); 
         }
         System.out.print("\\_");
         for (int j = 1; j <= (-2 * line + (3 * SIZE + 1)); j++) {
            System.out.print("/\\");
         }
         System.out.print("_/");
         System.out.println("");
      } 
   }
}
                   
        