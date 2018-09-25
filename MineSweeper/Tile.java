//Irfanur Rahman

public class Tile {
	// Element and attriubutes for a tile
	boolean isMined; // describes if the tile is a mine
	boolean isMarked; //describes if the tile is marked
	boolean isHidden; //describes if the tile is hidden
	int adjMines; //the amount of mines nearby the mine
	int cordX;  //x-location
	int cordY; //y-location 

	Tile() {//default constructor for a tile
		isMined = false;
		isMarked = false;
		isHidden = true;
		adjMines = 0;

	}
			//assigned mutators
	public boolean isMined() {
		return isMined;
	}

	public void setMined(boolean isMined) {
		this.isMined = isMined;
	}

	public boolean isMarked() {
		return isMarked;
	}

	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public int getAdjMines() {
		return adjMines;
	}

	public void setAdjMines(int adjMines) {
		this.adjMines = adjMines;
	}

	public int getCordX() {
		return cordX;
	}

	public void setCordX(int cordX) {
		this.cordX = cordX;
	}

	public int getCordY() {
		return cordY;
	}

	public void setCordY(int cordY) {
		this.cordY = cordY;
	}
	// toString method
	public String toString() {
		String output = "-";

		if ((this.adjMines >= 0) && (this.isHidden) == false) {
			output = "" + this.adjMines;
		}

		if (this.isMined && (this.isHidden == false)) {
			output = "*";
		}
		if (this.isMarked == true && this.isHidden == false) {
			output = "f";
		}

		return output;
	}

}