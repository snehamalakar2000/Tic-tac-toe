import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    boolean end = false;
    Game game1 = new Game();

    while (!end) {
      game1.gameboard();
      game1.printMenu();
      Scanner scannerObj = new Scanner(System.in);
      System.out.println("Enter if you wanna play 1 player gane or 2 players game");
      while (true) {
        String playerChoice = scannerObj.nextLine();
        if (playerChoice.equals("1") || playerChoice.equals("2")) {
          game1.pickMode(Integer.parseInt(playerChoice));
          break;
        } else {
          System.out.println("Invalid Input!");
        }
      }
      System.out.println("Press any key to play a New Game!");
      String playerChoice = scannerObj.nextLine();
      if (playerChoice.equals("n") || playerChoice.equals("N")) {
        break;
      }

    }

  }
}