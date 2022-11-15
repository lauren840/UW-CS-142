// Lauren Kim
// 06/24/21
// HW 1 Song

public class Song {
   public static void main(String[] args) {
      verse1();
      verse2();
      verse3();
      verse4();
      verse5();
      verse6();
      verse7();
   }
   public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly.");
      end();
   } 
   
   public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spiderFly();      
   }
   
   public static void verse3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      birdSpider();
   }
   
   public static void verse4() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      catBird();   
   }
   
   public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dogCat();
   }
      
   public static void verse6() {
      System.out.println("There was an old woman who swallowed a fish,");
      System.out.println("On a dish she ate that fish");
      fishCat();
   }
   
   public static void verse7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course."); 
   }
   
   public static void end() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
   
   public static void spiderFly() {
      System.out.println("She swallowed the spider to catch the fly,");
      end();
   }
   
   public static void birdSpider() {
      System.out.println("She swallowed the bird to catch the spider,");
      spiderFly();
   }
   
   public static void catBird() {
      System.out.println("She swallowed the cat to catch the bird,"); 
      birdSpider();
   }
   
   public static void dogCat() {
      System.out.println("She swallowed the dog to catch the cat,"); 
      catBird();
   } 
   
   public static void fishCat() {
      System.out.println("She swallowed the fish to catch the dog,"); 
      dogCat();
   }
}

   