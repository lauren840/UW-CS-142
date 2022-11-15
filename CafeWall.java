/* Lauren Kim, 07/09/2021
Assignment #3 Cafe Wall: This program displays the illusions of a Cafe Wall.  */

import java.awt.*;
public class CafeWall {
   public static final int MORTAR = 2;
   
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650,400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      //upper-left row 
      drawRow(g, 0, 0, 4, 20);
      
      //mid-left row
      drawRow(g, 50, 70, 5, 30);
      
      //lower left grid 
      drawGrid(g, 10, 150, 4, 25, 0);
      
      //lower middle grid 
      drawGrid(g, 250, 200, 3, 25, 10);
      
      //lower right grid 
      drawGrid(g, 425, 180, 5, 20, 10);
      
      //upper right grid
      drawGrid(g, 400, 20, 2, 35, 35);
   }

   /* Method to print rows with alternating black and white squares. 
   Parameters for Graphics g, starting point for x- and y- coordinates,
   number of box (square) pairs, and size for each square. */
   public static void drawRow(Graphics g, int x, int y, int pairs, int size) {                
      for (int i = 1; i <= pairs; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(x, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(x, y, x + size, y + size);
         g.drawLine(x + size, y, x, y + size);
         x = x + size;
         g.setColor(Color.WHITE);
         g.fillRect(x, y, size, size);
         x = x + size;
      }
   }   

   /* Method to print grids with the rows of alternating black and white squares. 
   Parameters for Graphics g, starting point for x- and y- coordinates, number of 
   box/row pairs, size for each square, and number of x-coordinates for 2nd row offset. */
   public static void drawGrid(Graphics g, int x, int y, int pairs, int size, int offset) {
      for (int j = 1; j <= pairs; j++) {
         drawRow(g, x, y, pairs, size);
         y = y + size + MORTAR;
         x = x + offset; 
         drawRow(g, x, y, pairs, size);
         y = y + size + MORTAR;
         x = x - offset;
      }
   } 
}  