import java.util.Scanner;
import java.util.Random;

public class Game
{
  private Player player1;
  private Player player2;
  private Player currentPlayer;

  Scanner input = new Scanner(System.in);

  public Game()
  {
    System.out.print("Enter Player 1 name: ");
    player1 = new Player(input.nextLine());

    System.out.print("Enter Player 2 name: ");
    player2 = new Player(input.nextLine());

    chooseFirstPlayer();
  }

  private void chooseFirstPlayer()
  {
    Random rand = new Random();

    if(rand.nextBoolean())
      currentPlayer = player1;
    else
      currentPlayer = player2;

    System.out.println(currentPlayer.getName() + " goes first!");
  }

  public void play()
  {
    while(Board.getPieces() > 0)
    {
      System.out.println("\nPieces remaining: " + Board.getPieces());

      int maxTake = Board.getPieces() / 2;
      if(maxTake < 1)
        maxTake = 1;

      System.out.println(currentPlayer.getName() + "'s turn.");
      System.out.println("You may take 1 to " + maxTake + " pieces.");

      int take = input.nextInt();

      while(take < 1 || take > maxTake)
      {
        System.out.println("Invalid move. Try again.");
        take = input.nextInt();
      }

      Board.removePieces(take);

      if(Board.getPieces() == 0)
      {
        switchPlayer();
        System.out.println(currentPlayer.getName() + " wins!");
        currentPlayer.addWin();
        break;
      }

      switchPlayer();
    }

    System.out.println("\nScores:");
    System.out.println(player1.getName() + ": " + player1.getScore());
    System.out.println(player2.getName() + ": " + player2.getScore());
  }

  private void switchPlayer()
  {
    if(currentPlayer == player1)
      currentPlayer = player2;
    else
      currentPlayer = player1;
  }
}