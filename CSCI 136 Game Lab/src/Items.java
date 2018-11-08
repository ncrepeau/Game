import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class Items {

	private int score = 0;
	Random myRand = new Random();
	Movement move = new Movement();
	Game myGame = new Game();

	public static ArrayList<String> getImagePath() throws FileNotFoundException {
		ArrayList<String> itemArray = new ArrayList<String>();
		File myFile = new File("./src/ItemFile.txt");
		Scanner myFileScanner = new Scanner(myFile);
		while(myFileScanner.hasNextLine()) {
			String line = myFileScanner.nextLine();
			itemArray.add(line);
		}
		myFileScanner.close();
		return itemArray;
	}

	public int setItemX() {
		//Used to generate two random integers between 1 and 1150
		int randX = myRand.nextInt(1150)+1;
		
		return randX;
	}
	
	public int setItemY() {
		//Used to generate two random integers between 1 and 750
		int randY = myRand.nextInt(750)+1;
		
		return randY;
	}
	
	public double setItemWorth() {
		return 0.0;
	}

	public int item1Collision(ImageView viewItem1) {
		Bounds item1Bounds = viewItem1.getBoundsInParent();
		int x = (int)(viewItem1.getLayoutX());
		int y = (int)(viewItem1.getLayoutY());
		int itemTopLeftX = (int) (x);
		int itemBottomRightX = (int) (x + (item1Bounds.getWidth()));
		int itemTopLeftY = (int) (y);
		int itemBottomRightY = (int) (y + (item1Bounds.getHeight()));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item2Collision(ImageView viewItem2) {
		Bounds item2Bounds = viewItem2.getBoundsInParent();
		int x = (int)(viewItem2.getLayoutX());
		int y = (int)(viewItem2.getLayoutY());
		int itemTopLeftX = (int) (x);
		int itemBottomRightX = (int) (x + (item2Bounds.getWidth()));
		int itemTopLeftY = (int) (y);
		int itemBottomRightY = (int) (y + (item2Bounds.getHeight()));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item3Collision(ImageView viewItem3) {
		Bounds itemBounds = viewItem3.getBoundsInParent();
		int x = (int)(viewItem3.getLayoutX());
		int y = (int)(viewItem3.getLayoutY());
		int itemTopLeftX = (int) (x);
		int itemBottomRightX = (int) (x + (itemBounds.getWidth()));
		int itemTopLeftY = (int) (y);
		int itemBottomRightY = (int) (y + (itemBounds.getHeight()));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item4Collision(ImageView viewItem4) {
		Bounds itemBounds = viewItem4.getBoundsInParent();
		int x = (int)(viewItem4.getLayoutX());
		int y = (int)(viewItem4.getLayoutY());
		int itemTopLeftX = (int) (x);
		int itemBottomRightX = (int) (x + (itemBounds.getWidth()));
		int itemTopLeftY = (int) (y);
		int itemBottomRightY = (int) (y + (itemBounds.getHeight()));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}
	public int item5Collision(ImageView viewItem5) {
		Bounds itemBounds = viewItem5.getBoundsInParent();
		int x = (int)(viewItem5.getLayoutX());
		int y = (int)(viewItem5.getLayoutY());
		int itemTopLeftX = (int) (x);
		int itemBottomRightX = (int) (x + (itemBounds.getWidth()));
		int itemTopLeftY = (int) (y);
		int itemBottomRightY = (int) (y + (itemBounds.getHeight()));
		
		if(areRectsColliding(itemTopLeftX, itemBottomRightX, itemTopLeftY, itemBottomRightY, move.playerTopLeftX, move.playerBottomRightX, move.playerTopLeftY, move.playerBottomRightY)) {
			score =+ 1;
		}
		return score;
	}

	private boolean areRectsColliding(int playerTopLeftX, int playerBottomRightX, int playerTopLeftY, int playerBottomRightY,
			int enemyTopLeftX, int enemyBottomRightX, int enemyTopLeftY, int enemyBottomRightY) {

		if (playerTopLeftX < enemyBottomRightX && playerBottomRightX > enemyTopLeftX && playerTopLeftY <  enemyBottomRightY
				&& playerBottomRightY > enemyTopLeftY) {
			return true;
		} 
		else {
			return false;
		}
	}
}