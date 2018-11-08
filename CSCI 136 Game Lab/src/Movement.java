import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Movement {
	private ImageView viewEnemy;
	private ImageView viewPlayer;
	private ImageView viewItem1;
	private ImageView viewItem2;
	private ImageView viewItem3;
	private ImageView viewItem4;
	private ImageView viewItem5;
	private int x = 550, y = 600;
	private double enemyX;
	private double enemyY;
	private boolean isColliding;
	public int highScore1;
	public int playerTopLeftX;
	private Items myItem = new Items();	
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
		
	
		highScore1 = myItem.item1Collision(viewItem1) + myItem.item2Collision(viewItem2) + myItem.item3Collision(viewItem3) + myItem.item4Collision(viewItem4) + myItem.item5Collision(viewItem5);
	
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