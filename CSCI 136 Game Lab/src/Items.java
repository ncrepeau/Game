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
	//item 1
	public int item1TopLeftX;
	public int item1BottomRightX;
	public int item1TopLeftY;
	public int item1BottomRightY;
	//item 2
	public int item2TopLeftX;
	public int item2BottomRightX;
	public int item2TopLeftY;
	public int item2BottomRightY;
	//item 3
	public int item3TopLeftX;
	public int item3BottomRightX;
	public int item3TopLeftY;
	public int item3BottomRightY;
	//item 4
	public int item4TopLeftX;
	public int item4BottomRightX;
	public int item4TopLeftY;
	public int item4BottomRightY;
	//item 5
	public int item5TopLeftX;
	public int item5BottomRightX;
	public int item5TopLeftY;
	public int item5BottomRightY;

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

	public void item1Collision (Scene gameScreen, ImageView viewItem1) {
		Bounds item1Bounds = viewItem1.getBoundsInParent();
		int x = (int)(viewItem1.getLayoutX());
		int y = (int)(viewItem1.getLayoutY());
		item1TopLeftX = (int) (x);
		item1BottomRightX = (int) (x + (item1Bounds.getWidth()));
		item1TopLeftY = (int) (y);
		item1BottomRightY = (int) (y + (item1Bounds.getHeight()));
	}
	public void item2Collision(Scene gameScreen, ImageView viewItem2) {
		Bounds item2Bounds = viewItem2.getBoundsInParent();
		int x = (int)(viewItem2.getLayoutX());
		int y = (int)(viewItem2.getLayoutY());
		item2TopLeftX = (int) (x);
		item2BottomRightX = (int) (x + (item2Bounds.getWidth()));
		item2TopLeftY = (int) (y);
		item2BottomRightY = (int) (y + (item2Bounds.getHeight()));
	}
	public void  item3Collision(Scene gameScreen, ImageView viewItem3) {
		Bounds itemBounds = viewItem3.getBoundsInParent();
		int x = (int)(viewItem3.getLayoutX());
		int y = (int)(viewItem3.getLayoutY());
		item3TopLeftX = (int) (x);
		item3BottomRightX = (int) (x + (itemBounds.getWidth()));
		item3TopLeftY = (int) (y);
		item3BottomRightY = (int) (y + (itemBounds.getHeight()));
	}

	public void item4Collision(Scene gameScreen, ImageView viewItem4) {
		Bounds itemBounds = viewItem4.getBoundsInParent();
		int x = (int)(viewItem4.getLayoutX());
		int y = (int)(viewItem4.getLayoutY());
		item4TopLeftX = (int) (x);
		item4BottomRightX = (int) (x + (itemBounds.getWidth()));
		item4TopLeftY = (int) (y);
		item4BottomRightY = (int) (y + (itemBounds.getHeight()));
	}
	public void item5Collision(Scene gameScreen, ImageView viewItem5) {
		Bounds itemBounds = viewItem5.getBoundsInParent();
		int x = (int)(viewItem5.getLayoutX());
		int y = (int)(viewItem5.getLayoutY());
		item5TopLeftX = (int) (x);
		item5BottomRightX = (int) (x + (itemBounds.getWidth()));
		item5TopLeftY = (int) (y);
		item5BottomRightY = (int) (y + (itemBounds.getHeight()));
	}	
	
}
	

	
