//Irfanur Rahman

import java.math.*;

public class GameBoard {

	int rows;   //"x" values
	int columns; //"y" values
	int numbMines; //number of mines
	Double maxMines;// double is later converted to int; necessary for // calculations
	int bombCount; //count
	boolean gameOver;// boolean value for game
	Tile[][] board; //the actual "array" of the game board
	boolean flag = false;// flag for flagging
	int gameCounter = 0;// counts how many bombs there are

	GameBoard() {  
	}
	// GameBoard constructor
	GameBoard(int inRow, int inColumn, int nBombs) {
		gameOver = false;
		this.rows = inRow;
		this.numbMines = nBombs;
		this.columns = inColumn;

		board = new Tile[inRow][inColumn];

		populateBoard(board);// gives board default values
		printBoard(board);// prints the original game board
	}

	// getters and setters
	public Tile getTile(int x, int y) {// returns a specific tile at coordinates
		Tile outTile = new Tile();
		outTile = board[x][y];
		return outTile;
	}

	public Tile[][] getBoard() {
		return board;
	}

	public void setBoard(Tile[][] board) {
		this.board = board;
	}

	public void populateBoard(Tile[][] inBoard) {
		for (int x = 0; x < this.rows; x++) {
			for (int y = 0; y < this.columns; y++) {
				Tile tile = new Tile(); // default tile
				tile.setCordX(x);
				tile.setCordY(y);
				board[x][y] = tile;
			}

		}
		createMines();

	}

	public void lostGame() {// sets game over value to true
		this.gameOver = true;
	}

	public void markTile(Tile inTile) {
		if (inTile.isMarked == false) {//code for flagging a tile
			inTile.setMarked(true);
			if (inTile.isMined) {
				gameCounter++;
				if (gameCounter == this.numbMines) {
					lostGame();
					System.out.println("You won the game!!");

				}
			}
		} else {

			inTile.setMarked(false);
			inTile.isHidden = true;
			if (inTile.isMined == true) {
				gameCounter--;
			}
		}
		flag = false;
	}

	public void showAdjBombs(Tile inTile) {//shows how many bombs are around a tile... this is how the user interacts with the program

		int adjBombCount;
		int xPointer = inTile.getCordX();
		int yPointer = inTile.getCordY();
		adjBombCount = 0;
		inTile.setHidden(false);
		if (flag == false) {
			if (inTile.isMined) {
				lostGame();
				System.out.println("You lose");
			}

			try {
				// right of tile
				if (board[xPointer + 1][yPointer].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			// left
			try {
				if (board[xPointer - 1][yPointer].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			// up
			try {
				if (board[xPointer][yPointer + 1].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			// down
			try {
				if (board[xPointer][yPointer - 1].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			// diagonals
			// up-right
			try {
				if (board[xPointer + 1][yPointer + 1].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			// up-left
			try {
				if (board[xPointer - 1][yPointer + 1].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			// down-right
			try {
				if (board[xPointer + 1][yPointer - 1].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			// down-left
			try {
				if (board[xPointer - 1][yPointer - 1].isMined) {
					adjBombCount++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				//sorry about try catch statements <3
			}
		} else {
			markTile(inTile);
		}
		board[inTile.cordX][inTile.cordY].setAdjMines(adjBombCount);
		printBoard(board);

	}

	public void createMines() {// creates mines and puts them among the
								// gameboard
		this.maxMines = (this.rows * this.columns) * 0.25;
		if (this.numbMines > this.maxMines.intValue()) {
			// picks a bigger amount of mines
			System.out.println("you entered the maxium amount we defautled your bombs to 25% mines: "
					+ this.maxMines.intValue());
			this.numbMines = this.maxMines.intValue();

		}
		while (bombCount != this.numbMines) {
			int randomBombRows = (int) Math.ceil(Math.random() * this.rows - 1);// generates
																				// a
																				// random
																				// row
			int randomBombCols = (int) Math.ceil(Math.random() * this.columns - 1);// generates
																					// a
																					// random
																					// column
			bombCount++;
			board[randomBombRows][randomBombCols].setMined(true);
		}

	}

	public void printBoard(Tile[][] inBoard) {//prints the board out
		System.out.print("\n");//new line after every new board
		int tabCount = 0;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				if (this.gameOver) {
					inBoard[i][j].setHidden(false);//reveals the tiles
				}
				if (tabCount < this.rows - 1) {
					System.out.print("" + inBoard[i][j] + " ");
					tabCount++;
				} else {
					System.out.print("" + inBoard[i][j] + "\n");
					tabCount = 0;
				}

			}

		}

	}
}
