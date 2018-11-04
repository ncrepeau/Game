
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Movement {
	private ImageView viewEnemy;
	private ImageView viewPlayer;
	private int x = 550, y = 600;
	private double enemyX;
	private double enemyY;
	public boolean isColliding;
	public int playerTopLeftX;
	public int playerBottomRightX;
	public int playerTopLeftY;
	public int playerBottomRightY;

	public void setMovement(int x, int y, ImageView viewPlayer, ImageView viewEnemy) {
		this.viewPlayer = viewPlayer;
		this.viewEnemy = viewEnemy;
		this.x = x;
		this.y = y;
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
		int enemyTopLeftX = (int) (x);
		int enemyBottomRightX = (int) (x + (enemyBounds.getWidth()));
		int enemyTopLeftY = (int) (y);
		int enemyBottomRightY = (int) (y + (enemyBounds.getHeight()));

		if (areRectsColliding(playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY, enemyTopLeftX,
				enemyBottomRightX, enemyTopLeftY, enemyBottomRightY) == true) {
			isColliding = true;
			System.out.println("colliding set true");
		} else {
			isColliding = false;
			System.out.println("colliding set false");
		}
		viewPlayer.setX(x);
		viewPlayer.setY(y);
		viewEnemy.setX(enemyX);
		viewEnemy.setY(enemyY);

	}

	public void enemyMovement(Scene gameScreen) {
		gameScreen.setOnKeyPressed(this::listenUp);
	}

	private boolean areRectsColliding(int r1TopLeftX, int r1BottomRightX, int r1TopLeftY, int r1BottomRightY,
			int r2TopLeftX, int r2BottomRightX, int r2TopLeftY, int r2BottomRightY) {
//		System.out.println("BottomRight 1 = (" + r1BottomRightX + ", " + r1BottomRightY + ")");
//		System.out.println("BottomRight 2 = (" + r2BottomRightX + ", " + r2BottomRightY + ")");
//
//		System.out.println("TopLeft 1 = (" + r1TopLeftX + ", " + r1TopLeftY + ")");
//		System.out.println("TopLeft 2 = (" + r2TopLeftX + ", " + r2TopLeftY + ")");

		if (r1TopLeftX < r2BottomRightX && r1BottomRightX > r2TopLeftX && r1TopLeftY < r2BottomRightY
				&& r1BottomRightY > r2TopLeftY) {
			//System.out.println("Returning true");
			return true;
		} else {
			//System.out.println("Returning false");
			return false;
		}
	}

}
