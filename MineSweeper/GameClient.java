//Irfanur Rahman PA1

import java.util.*;

public class GameClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the x value of the grid: ");
		int x = input.nextInt();
		System.out.println("Enter the y value of the grid: ");
		int y = input.nextInt();
		System.out.println("Enter the amount of mines you would like to have:");
		int m = input.nextInt();
		GameBoard game = new GameBoard(x, y, m);

		do {
			try {

				int answer;//code for entering flags
				System.out.println("Would you like to enter a flag?(1 for yes, 2 for no)");
				answer = input.nextInt();
				if (answer == 1) {
					game.flag = true;
					System.out.println("Enter the coordinates for the flag:");
					System.out.println("Enter the x value of the tile you would like to flag:");
					int xTile = input.nextInt() - 1;
					System.out.println("Enter the y value of the tile you would like to flag:");
					int yTile = input.nextInt() - 1;
					game.showAdjBombs(game.getTile(xTile, yTile));
				} else {
					System.out.println("Enter the x value of the tile you would like to check:");
					int xTile = input.nextInt() - 1;
					System.out.println("Enter the y value of the tile you would like to check:");
					int yTile = input.nextInt() - 1;
					game.showAdjBombs(game.getTile(xTile, yTile));
				}
			} catch (ArrayIndexOutOfBoundsException e) {//error checking
				System.out.println(
						"Please enter an x value of the tile you would like to check within the specified parameters:");
				int xTile = input.nextInt() - 1;
				System.out.println(
						"Please enter a y value of the tile you would like to check within the specified parameters:");
				int yTile = input.nextInt() - 1;
				game.showAdjBombs(game.getTile(xTile, yTile));
			}

		} while ((game.gameOver == false));
	}
}
