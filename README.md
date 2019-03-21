# Chess - By Team Before
## Introduction
We've created the base game of chess with the framework for modification and extension. New pieces can be implemented by following the documentation in the <a href="#Extending-the-Game">Extending the Game</a> section.
## Index
- [Screenshots](#Screenshots)
- [Game Features](#Game-Features)
	- [Rules](#Rules)
	- [Controls](#Controls)
	- [Versus AI](#Versus-AI)
- [Installation](#Installation)
- [Extending the Game](#Extending-the-Game)
	- [Extending the Pieces](#Extending-the-Pieces)
	- [Extending the Board](#Extending-the-Board)
- [Issues](#Issues)
- [License](#License)

## Screenshots
| ![Screen 1](https://i.imgur.com/xjdCBks.png) |
|----------|
| ![Screen 2](https://i.imgur.com/yThzNwr.png) |
## Game Features
<a href="#">[To Top]</a>
### Rules
The rules of chess can be found <a href="https://www.chess.com/learn-how-to-play-chess">here</a> which redirects to https://www.chess.com/learn-how-to-play-chess.
<br><strong>Rules we have omitted from our game:</strong>
<ul>
	<li>Points of each piece</li>
	<li>Promoting a Pawn</li>
	<li>"en passant"</li>
	<li>Castling</li>
	<li>And most other special rules/interactions</li>
</ul>

### Controls
Click on a piece to select it, then click on the desired square to move it to that position.
- If the chosen position is in the valid movement path for the selected piece it will move to that position or take the opponent's piece at that position.
- If the chosen position is <strong>not</strong> a valid movement path for the piece the selected piece will be deselected and no movement will occur.
- You cannot take your own pieces.
- Only the knight may "jump" past pieces; that is to say all other pieces cannot pass or jump past other pieces.

Clicking `Game` in the toolbar will give you a list of options:
<ul>
	<li><strong>New Game</strong> will initialize a new board and restart the game</li>
	<li><strong>Help</strong> will take you to the GitHub README.md</li>
	<li><strong>Main Menu</strong> Will take you back to the Start Panel screen</li>
	<li><strong>Exit</strong> will close the game</li>
</ul>

### Versus AI
## Installation
<a href="#">[To Top]</a><br>
To play the game download the executable .JAR file in the [Rleases section](https://github.com/Samarium150/Before/releases) and run it on your computer.<br>
If you want to play your game after extending or modifying it you have to export the project as a runnable .jar file:<br>
For [Eclipse](https://www.eclipse.org/downloads/packages/):
<ol>
	<li>Right click the project folder inside Eclipse -> Export</li>
	<li>Select Java -> Runnable JAR file</li>
	<li>Hit Next</li>
	<li>Select the Play class as launch configuration</li>
	<li>Choose where you want to export the JAR file to</li>
	<li>Select Package required libraries into generated JAR (the game is small so it won't lag)</li>
	<li>Hit Finish</li>
	<li>Run the JAR file</li>
</ol>

For [IntelliJ IDEA](https://www.jetbrains.com/idea/):

<ol>
	<li>File -> Project Structure -> Project Settings -> Artifacts -> Click the Plus Sign -> JAR -> From modules with dependencies</li>
	<li>Then go to Builds on the toolbar -> Build Artifact -> Build</li>
	<li>Run the JAR file</li>
</ol>


## Extending the Game
<a href="#">[To Top]</a><br>
The game is coded in Java using JavaFX, so be sure to have an editor and an IDE such as [Eclipse](https://www.eclipse.org/downloads/packages/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/) if you want to extend this game for yourself.
### Extending the Board
The board is an array with positions 0 to 63 with 0 being the top left of the board, 7 being top right, 56 being bottom left, and 63 being bottom right.

<img src="https://i.imgur.com/4pn6yN5.png" height=auto width= 50%>

Changing the length and/or width of the board by adding more indexes to the array or how the array is counted will force you to change the algorithms for calculating possible moves within each Piece's <strong>possibleMoves</strong> function. You will also have to change the initial starting position of pieces or add more pieces however you see fit.

### Extending the Pieces
Each piece has a <strong>moves</strong> array which stores the possible moves of piece at its current position on the board (tile 0 to 63). Possible moves are added to the array by calculating the piece's current position on the board (var <strong>curr</strong>) and the algorithm for its movement path.
<div>
	<p>For example a King's possible moves from index 60 can move to the green indexes: </p>
	<img src="https://i.imgur.com/27JAGrK.png" height=auto width= 50%>
	<p>and is implemented like so (inside the piece class):</p>
</div>

```
@Override
public ArrayList<Integer> possibleMoves() {
	int curr = this.board.getPieceLocation(this.id);
	ArrayList<Integer> moves =  new ArrayList<Integer>();
	int[] excludeLeft = {0,8,16,24,32,40,48,56};
	int[] excludeRight = {7,15,23,31,39,47,55,63};
	int[] excludeBottom = {56,57,58,59,60,61,62,63};
	int[] excludeTop = {0,1,2,3,4,5,6,7};

	if(!isInArray(excludeLeft,curr)) {
		moves.add(curr-1);
		moves.add(curr+7);
		moves.add(curr-9);
	}  
	if(!isInArray(excludeRight,curr)) {
		moves.add(curr+1);
		moves.add(curr-7);
		moves.add(curr+9);
	}  
	if(!isInArray(excludeBottom,curr)) moves.add(curr+8);
	if(!isInArray(excludeTop,curr)) moves.add(curr-8);
	return movesFilter(moves);
}
```
The `possibleMoves` function returns the array `[59, 67, 51, 61, 53, 69, 52]` which indicates what indexes are possible moves.
We already checked for friendly pieces so there is no need to worry about taking your own piece.

The `ChessBoardPanel.java` class is also important for implementing custom pieces as this is where you will initialize them. This shows a snippet of the code using a white rook as an example piece.
In this function you will need to initialize your custom piece's and position using the documentation below.
```
ChessBoardPanel(View view)
	white_rook = new Image(this.getClass().getResource("/white_rook.png").toString());
	button[7][7].setGraphic(new ImageView(white_rook));
```
and the function `setImg(int x, int y, String piece)` within `ChessBoardPanel` also has to be modified to include your custom piece.
```
void setImg(int x, int y, String piece) {
		Image img = null;

		switch (piece) {
			case "white_rook":
				img = white_rook;
				break;
```
## Issues
If there are any issues, report them in the [Issue Section](https://github.com/Samarium150/Before/issues).
## License
Created by Team Before under the [Apache 2.0 License](https://github.com/Samarium150/Before/blob/master/LICENSE).
<br><a href="#">[To Top]</a>
