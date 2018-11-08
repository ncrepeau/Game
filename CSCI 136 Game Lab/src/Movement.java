import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Movement {
	Items myItem = new Items();
	private ImageView viewEnemy, viewPlayer;
	private int x = 550, y = 600;
	private double enemyX, enemyY;
	private Stage primaryStage;
	private Scene start, gameScreen;
	private ImageView viewItem1, viewItem2, viewItem3, viewItem4, viewItem5, viewItem6;
	public boolean isColliding;
	public int score1, score2, score3, score4, score5, score6;
	public int totalScore;
	public int highScore1;
	public int playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY;
	private EndScreen myEnd = new EndScreen();
	
	
	public void setMovement(int x, int y, int enemyX, int enemyY, ImageView viewPlayer, ImageView viewEnemy, Stage primaryStage, Scene start, Scene gameScreen) {
		this.viewPlayer = viewPlayer;
		this.viewEnemy = viewEnemy;
		this.x = x;
		this.y = y;
		this.enemyX = enemyX;
		this.enemyY = enemyY;
		this.primaryStage = primaryStage;
		this.start = start;
		this.gameScreen = gameScreen;
	}
	
	public void setItems(ImageView viewItem1, ImageView viewItem2, ImageView viewItem3, ImageView viewItem4, ImageView viewItem5, ImageView viewItem6) {
		this.viewItem1 = viewItem1;
		this.viewItem2 = viewItem2;
		this.viewItem3 = viewItem3;
		this.viewItem4 = viewItem4;
		this.viewItem5 = viewItem5;
		this.viewItem6 = viewItem6;
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
			Scene end = myEnd.Ending(primaryStage, gameScreen, start);
			primaryStage.setScene(end);
		} 
		else {
			isColliding = false;
		}
		
		myItem.item1Collision(gameScreen, viewItem1);
		if(areRectsColliding(myItem.item1TopLeftX, myItem.item1BottomRightX, myItem.item1TopLeftY, myItem.item1BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			viewItem1.setImage(null);
			score1 = 1;
		}
		myItem.item2Collision(gameScreen, viewItem2);
		if(areRectsColliding(myItem.item2TopLeftX, myItem.item2BottomRightX, myItem.item2TopLeftY, myItem.item2BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			viewItem2.setImage(null);
			score2 = 1;
		}
		myItem.item3Collision(gameScreen, viewItem3);
		if(areRectsColliding(myItem.item3TopLeftX, myItem.item3BottomRightX, myItem.item3TopLeftY, myItem.item3BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			viewItem3.setImage(null);
			score3 = 1;
		}
		myItem.item4Collision(gameScreen, viewItem4);
		if(areRectsColliding(myItem.item4TopLeftX, myItem.item4BottomRightX, myItem.item4TopLeftY, myItem.item4BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			viewItem4.setImage(null);
			score4 = 1;
		}
		myItem.item5Collision(gameScreen, viewItem5);
		if(areRectsColliding(myItem.item5TopLeftX, myItem.item5BottomRightX, myItem.item5TopLeftY, myItem.item5BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			viewItem5.setImage(null);
			score5 = 1;
		}
		myItem.item6Collision(gameScreen, viewItem6);
		if(areRectsColliding(myItem.item6TopLeftX, myItem.item6BottomRightX, myItem.item6TopLeftY, myItem.item6BottomRightY, playerTopLeftX, playerBottomRightX, playerTopLeftY, playerBottomRightY)) {
			viewItem6.setImage(null);
			score6 =1;
		}
		
		totalScore = score1+score2+score3+score4+score5+score6;
	
		myEnd.score = totalScore;
		System.out.println(myEnd.score);
		if(totalScore == 6) {
			Scene end = myEnd.Ending(primaryStage, gameScreen, start);
			primaryStage.setScene(end);
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