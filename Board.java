import java.util.Random;

public class Board
{
  private static int pieces;

  public static void populate()
  {
    Random rand = new Random();
    pieces = rand.nextInt(60) + 10; 
    System.out.println("Starting pile: " + pieces + " pieces");
  }

  public static int getPieces()
  {
    return pieces;
  }

  public static void removePieces(int amount)
  {
    pieces -= amount;
  }
}