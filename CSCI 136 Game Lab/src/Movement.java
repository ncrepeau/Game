
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Movement {
	private ImageView viewEnemy;
	private ImageView viewPlayer;
	Items myItem = new Items();
	private int x = 550, y = 600;
	private double enemyX;
	private double enemyY;
	private boolean isColliding;
	public int score;
	public int highScore1;
	public int playerTopLeftX;	
	public int playerBottomRightX;
	public int playerTopLeftY;
	public int playerBottomRightY;
	
	public void setMovement(int x, int y, int enemyX, int enemyY, ImageView viewPlayer, ImageView viewEnemy) {
		this.viewPlayer = viewPlayer;
		this.viewEnemy = viewEnemy;
		this.x = x;
		this.y = y;
		this.enemyX = enemyX;
		this.enemyY = enemyY;
	}

	public void playerMovement(Scene gameScreen) {
		gameScreen.setOnKeyPressed(this::listenUp);
	}

	public void listenUp(KeyEvent event) {
		KeyCode myCode = event.getCode();

		if (myCode == KeyCode.LEFT) {
			x -= 10;
			enemyX += 10;
		} else if (myCode == KeyCode.RIGHT) {
			x += 10;
			enemyX -= 10;
		} else if (myCode == KeyCode.DOWN) {
			y += 10;
			enemyY -= 10;
		} else if (myCode == KeyCode.UP) {
			y -= 10;
			enemyY += 10;
		}

		Bounds playerBounds = viewPlayer.getBoundsInParent();
		int playerTopLeftX = (int) (x);
		int playerBottomRightX = (int) (x + (playerBounds.getWidth()));
		int playerTopLeftY = (int) (y);
		int playerBottomRightY = (int) (y + (playerBounds.getHeight()));

		Bounds enemyBounds = viewEnemy.getBoundsInParent();
		int enemyTopLeftX = (int) (enemyX);
		int enemyBottomRightX = (int) (enemyX + (enemyBounds.getWidth()));
		int enemyTopLeftY = (int) (enemyY);
		int enemyBottomRightY = (int) (enemyY + (enemyBounds.getHeight()));

		if (areRectsColliding(playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY, enemyTopLeftX,
				enemyBottomRightX, enemyTopLeftY, enemyBottomRightY) == true) {
			isColliding = true;
			System.out.println("true");
		} 
		else {
			isColliding = false;
			System.out.println("false");
		}
		
		
		if(areRectsColliding(myItem.item1TopLeftX, myItem.item1BottomRightX, myItem.item1TopLeftY, myItem.item1BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			score =+ 1;
		}
		if(areRectsColliding(myItem.item2TopLeftX, myItem.item2BottomRightX, myItem.item2TopLeftY, myItem.item2BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			score =+ 1;
		}
		if(areRectsColliding(myItem.item3TopLeftX, myItem.item3BottomRightX, myItem.item3TopLeftY, myItem.item3BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			score =+ 1;
		}
		if(areRectsColliding(myItem.item4TopLeftX, myItem.item4BottomRightX, myItem.item4TopLeftY, myItem.item4BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			score =+ 1;
		}
		if(areRectsColliding(myItem.item5TopLeftX, myItem.item5BottomRightX, myItem.item5TopLeftY, myItem.item5BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			score =+ 1;
		}
		
		
	
		viewPlayer.setX(x);
		viewPlayer.setY(y);
		viewEnemy.setX(enemyX);
		viewEnemy.setY(enemyY);
		

	}

	public void enemyMovement(Scene gameScreen) {
		gameScreen.setOnKeyPressed(this::listenUp);
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