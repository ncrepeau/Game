import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class Items {
	private ImageView viewItem1;
	private ImageView viewItem2;
	private ImageView viewItem3;
	private ImageView viewItem4;
	private ImageView viewItem5;
	private int score = 0;
	Random myRand = new Random();
	Movement move = new Movement();
	Game myGame = new Game();

	public static ArrayList<String> getImagePath() throws FileNotFoundException {
		ArrayList<String> itemArray = new ArrayList<String>();
		File myFile = new File("./src/ItemFile.txt");
		Scanner myFileScanner = new Scanner(myFile);
		while (myFileScanner.hasNextLine()) {
			String line = myFileScanner.nextLine();
			itemArray.add(line);
		}
		myFileScanner.close();
		return itemArray;

	}

	public int setItemX() {
		// Used to generate two random integers between 1 and 1150
		int randX = myRand.nextInt(1150) + 1;

		return randX;
	}

	public int setItemY() {
		// Used to generate two random integers between 1 and 750
		int randY = myRand.nextInt(750) + 1;

		return randY;
	}

	public double setItemWorth() {
		return 0.0;
	}

	public int item1Collision(Scene gameScreen, ImageView viewItem1) {
		Bounds item1Bounds = viewItem1.getBoundsInParent();
		int x = (int)(viewItem1.getLayoutX());
		int y = (int)(viewItem1.getLayoutY());
		int itemTopLeftX = (int) (x - (item1Bounds.getWidth())/2);
		int itemBottomRightX = (int) (x + (item1Bounds.getWidth()/2));
		int itemTopLeftY = (int) (y + (item1Bounds.getHeight()/2));
		int itemBottomRightY = (int) (y - (item1Bounds.getHeight()/2));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item2Collision(Scene gameScreen, ImageView viewItem2) {
		Bounds item2Bounds = viewItem2.getBoundsInParent();
		int x = (int)(viewItem2.getLayoutX());
		int y = (int)(viewItem2.getLayoutY());
		int itemTopLeftX = (int) (x - (item2Bounds.getWidth())/2);
		int itemBottomRightX = (int) (x + (item2Bounds.getWidth()/2));
		int itemTopLeftY = (int) (y + (item2Bounds.getHeight()/2));
		int itemBottomRightY = (int) (y - (item2Bounds.getHeight()/2));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item3Collision(Scene gameScreen, ImageView viewItem3) {
		Bounds itemBounds = viewItem3.getBoundsInParent();
		int x = (int)(viewItem3.getLayoutX());
		int y = (int)(viewItem3.getLayoutY());
		int itemTopLeftX = (int) (x - (itemBounds.getWidth())/2);
		int itemBottomRightX = (int) (x + (itemBounds.getWidth()/2));
		int itemTopLeftY = (int) (y + (itemBounds.getHeight()/2));
		int itemBottomRightY = (int) (y - (itemBounds.getHeight()/2));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item4Collision(Scene gameScreen, ImageView viewItem4) {
		Bounds itemBounds = viewItem4.getBoundsInParent();
		int x = (int)(viewItem4.getLayoutX());
		int y = (int)(viewItem4.getLayoutY());
		int itemTopLeftX = (int) (x - (itemBounds.getWidth())/2);
		int itemBottomRightX = (int) (x + (itemBounds.getWidth()/2));
		int itemTopLeftY = (int) (y + (itemBounds.getHeight()/2));
		int itemBottomRightY = (int) (y - (itemBounds.getHeight()/2));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item5Collision(Scene gameScreen, ImageView viewItem5) {
		Bounds itemBounds = viewItem5.getBoundsInParent();
		int x = (int)(viewItem5.getLayoutX());
		int y = (int)(viewItem5.getLayoutY());
		int itemTopLeftX = (int) (x - (itemBounds.getWidth())/2);
		int itemBottomRightX = (int) (x + (itemBounds.getWidth()/2));
		int itemTopLeftY = (int) (y + (itemBounds.getHeight()/2));
		int itemBottomRightY = (int) (y - (itemBounds.getHeight()/2));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}

	private boolean areRectsColliding(int r1TopLeftX, int r1BottomRightX, int r1TopLeftY, int r1BottomRightY,
			int r2TopLeftX, int r2BottomRightX, int r2TopLeftY, int r2BottomRightY) {
		System.out.println("BottomRight 1 = (" + r1BottomRightX + ", " + r1BottomRightY + ")");
		System.out.println("BottomRight 2 = (" + r2BottomRightX + ", " + r2BottomRightY + ")");

		System.out.println("TopLeft 1 = (" + r1TopLeftX + ", " + r1TopLeftY + ")");
		System.out.println("TopLeft 2 = (" + r2TopLeftX + ", " + r2TopLeftY + ")");

		if (r1TopLeftX < r2BottomRightX && r1BottomRightX > r2TopLeftX && r1TopLeftY < r2BottomRightY
				&& r1BottomRightY > r2TopLeftY) {
			System.out.println("Returning true");
			return true;
		} else {
			System.out.println("Returning false");
			return false;
		}
	}
}