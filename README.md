# Tic-Tac-Toe

(Note that the most recent version of this markdown will be on Moodle. Once you start a project, your README will not update if I make changes. I will announce any changes on Slack and you can copy the new markdown to replace this information.)

Create a tic-tac-toe game that offers both one and two player modes. The one player mode will have the user playing against the computer. The two player mode will have the two players alternate choosing moves.

The game should print out the board in a reasonable fashion. I recommend using an array of 9 characters to store the board. You will then print out it across three rows.

Example:
```
O| | 
-----
X|O|O
-----
X| |X
```

The game should be able to determine when someone has won and when the game is a draw. Make sure to check all possible ways someone could have won.

Your game should have a game loop that processes the game and gets input. Your game should gracefully handle the situation where the user's input is improper. For example, if you prompt the user to input a number 0-8 to select a move, then you should be able ot handle them inputting 'w' or a selecting an illegal move (i.e. a spot that is already marked). Before the main game loop you should prompt the user to select a 1 or 2 person game.

You can use Scanner or TextIO for getting user input. You do not need to be able to read the input from a file. Although if that is helpful for testing, you are welcome to add a method that does that.

The AI for the one player game does not need to be complex. Have it follow a basic strategy like picking the middle and corners or blocking the opponent from winning.

You program should have unit tests to test things like marking the board and determining whether someone has one. Make sure these tests are reasonably robust, i.e. that different situations are tested.

See the Hangman repl for a game that bears some similarity to this. I have purposely not given you a bunch of code to work around, so that you have some flexibility. Start off small, get your board printed out, then add some ability to mark it, then user input, then checking for winning and so on. Keep each step manageable and you'll be done quickly.

Don't forget to submit your brief statement on your contribution to your group to Moodle.