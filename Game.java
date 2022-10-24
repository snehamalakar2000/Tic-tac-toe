import java.util.Scanner;

public class Game {
  String[] Board = new String[9];
  int players;
  String currentTurn;
  int numberOfMoves;
  int gameState;

  public void gameboard() {
    for (int i = 0; i < 9; i++) {
      Board[i] = "_";
    }
    players = 0;
    currentTurn = "X";
    numberOfMoves = 0;
    gameState = 0;

  }

  public void copyboard(String[] newBoard) {
    for (int i = 0; i < 9; i++) {
      this.Board[i] = newBoard[i];
      if (newBoard[i] != "_")
        numberOfMoves += 1;
    }
  }

  public void pickMode(int noOfPlayers) {
    players = noOfPlayers;
    if (noOfPlayers == 1) {
      singleplayerGame();
    } 
    else {
      multiplayerGame();
    }
  }

  public void printMenu() {
    System.out.println("Enter if you wanna play 1 player game or 2 players game");
    System.out.println("1. Single player");
    System.out.println("2. Double player");
  }

  public void printBoard() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(Board[(i + j)]);
        if (j != 2) {
          System.out.print("|");
        }
      }
      i += 2;
      System.out.println();
    }
  }

  public boolean mark(int position) {
    if (position < 0 || position > 8) {
      return false;
    }
    if (this.Board[position] == "_") {
      this.Board[position] = this.currentTurn;
      this.numberOfMoves += 1;
      return true;
    }
    return false;

  }

  public void changePlayer() {
    currentTurn = (currentTurn.equals("X")) ? "O" : "X";
  }

  public int getnumberOfMoves() {
    return numberOfMoves;

  }

  public String getCurrentTurn() {
    return currentTurn;
  }

  public int getGameState() {
    return gameState;
  }

  public boolean checkPossibleWin(int[] scenario) {

    if (this.Board[scenario[0]] != "_" && this.Board[scenario[0]] == this.Board[scenario[1]]
        && this.Board[scenario[0]] == this.Board[scenario[2]]) {
      return true;
    }
    return false;

  }

  public void checkForWin() {
    int[][] win = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
        { 2, 4, 6 } };

    for (int i = 0; i < 8; i++) {
      if (this.checkPossibleWin(win[i])) {
        this.gameState = 1;
        break;
      } else {
        this.gameState = 0;
      }
    }
    if (this.numberOfMoves == 9 && this.gameState == 0) {
      this.gameState = 2;
    }
  }

  public void makeAIMove() {
    Game dummyGame = new Game();
    int positionToMark = 0;
    int lastFreeSpace = 0;

    for (int i = 0; i < 9; i++) {
      dummyGame.gameboard();
      dummyGame.copyboard(this.Board);
      if (this.Board[i] == "_") {
        dummyGame.mark(i);
        dummyGame.checkForWin();
        if (dummyGame.getGameState() == 1) {
          positionToMark = i;
          break;

        }

      }
    }
    if (positionToMark == 0) {
      for (int i = 0; i < 9; i++) {
        dummyGame.gameboard();
        dummyGame.changePlayer();
        dummyGame.copyboard(this.Board);
        if (this.Board[i] == "_") {
          lastFreeSpace = i;
          dummyGame.mark(i);
          dummyGame.checkForWin();
          if (dummyGame.getGameState() == 1) {
            positionToMark = i;
            break;
          }
        }

      }
    }
    if (positionToMark == 0) {
      if (Board[4] == "_") {
        positionToMark = 4;

      } else {
        positionToMark = lastFreeSpace;
      }
    }
    this.mark(positionToMark);

  }

  public void singleplayerGame() {
    Scanner scannerObj = new Scanner(System.in);
    while (true) {
      System.out.println("Moves: " + numberOfMoves);
      this.printBoard();
      makeAIMove();
      this.checkForWin();
      System.out.println("state" + this.gameState);
      this.printBoard();
      if (this.gameState == 1) {
        System.out.println("The player " + this.getCurrentTurn() + " has won!");
        break;

      } else if (this.gameState == 2) {
        System.out.println("Draw!");
        break;

      }
      this.changePlayer();
      while(true){
        System.out.println("Moves: " + numberOfMoves);
        System.out.println("It is " + this.getCurrentTurn() + "'s turn.");
        System.out.println("Enter position to place your mark");
        int position = scannerObj.nextInt();
        if(this.mark(position)){
          this.checkForWin();
          if(this.gameState==1){
            System.out.println("The player is "+this.getCurrentTurn()+" has won!");

          }
          else if(this.gameState==2){System.out.println("The game is drawn.");
          }
          break;

        }
        else{
          System.out.println("Invalid Input");
        }

      }
      this.changePlayer();
    }
      

       


  }

  public void multiplayerGame() {
    Scanner scannerObj = new Scanner(System.in);
    System.out.println("Multiplayer Mode");
    while (true) {
      System.out.println("Moves:" + numberOfMoves);
      this.printBoard();
      System.out.println("It is " + this.getCurrentTurn() + " 's turn.");
      System.out.println("Enter position to place your mark");
      int position = scannerObj.nextInt();
      if (this.mark(position)) {
        this.checkForWin();
        if (this.gameState == 1) {
          System.out.println("The player is " + this.getCurrentTurn() + "  has won!");
          break;

        } else if (this.gameState == 2) {
          System.out.println("The game is drawn.");
          break;

        }
        this.changePlayer();

      } else {
        System.out.println("Invalid Input");

      }
    }
  }
}
