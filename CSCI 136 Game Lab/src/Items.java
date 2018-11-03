import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Items  {
	
	Random myRand = new Random();

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
	
}