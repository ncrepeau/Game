import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	ImageView viewPlayer;
	int x = 550, y = 600;
	ImageView viewEnemy;
	Text highScoreText;
	Scene gameScreen, start;

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {

		Movement playMove = new Movement();

		// Player image and position
		Player myPlayer = new Player();
		Image player = new Image(myPlayer.getPlayerImg());
		viewPlayer = new ImageView(player);
		viewPlayer.setX(x);
		viewPlayer.setY(y);

		// Enemy image and position
		Enemy myEnemy = new Enemy();
		Image enemy = new Image(myEnemy.getEnemyImg());
		viewEnemy = new ImageView(enemy);
		int enemyX = myEnemy.setEnemyX();
		int enemyY = myEnemy.setEnemyY();
		viewEnemy.setLayoutX(enemyX);
		viewEnemy.setLayoutY(enemyY);
		viewEnemy.setFitHeight(190);
		viewEnemy.setFitWidth(150);

		// Items and their positions
		Items myItem = new Items();
		ArrayList<String> itemArray = new ArrayList<String>();
		itemArray = Items.getImagePath();

		Image item1 = new Image(itemArray.get(0));
		ImageView viewItem1 = new ImageView(item1);
		viewItem1.setLayoutX(myItem.setItemX());
		viewItem1.setLayoutY(myItem.setItemY());

		Image item2 = new Image(itemArray.get(1));
		ImageView viewItem2 = new ImageView(item2);
		viewItem2.setLayoutX(myItem.setItemX());
		viewItem2.setLayoutY(myItem.setItemY());

		Image item3 = new Image(itemArray.get(2));
		ImageView viewItem3 = new ImageView(item3);
		viewItem3.setLayoutX(myItem.setItemX());
		viewItem3.setLayoutY(myItem.setItemY());

		Image item4 = new Image(itemArray.get(3));
		ImageView viewItem4 = new ImageView(item4);
		viewItem4.setLayoutX(myItem.setItemX());
		viewItem4.setLayoutY(myItem.setItemY());

		Image item5 = new Image(itemArray.get(4));
		ImageView viewItem5 = new ImageView(item5);
		viewItem5.setLayoutX(myItem.setItemX());
		viewItem5.setLayoutY(myItem.setItemY());

		Image item6 = new Image(itemArray.get(5));
		ImageView viewItem6 = new ImageView(item6);
		viewItem6.setLayoutX(myItem.setItemX());
		viewItem6.setLayoutY(myItem.setItemY());

		// Rest Button
		Button reset = new Button("Restart");
		reset.setLayoutX(1115);
		reset.setLayoutY(15);
		
		//HighScore Text
		highScoreText = new Text(1000,5, "");
		// Button Action
		reset.setOnAction(e -> {
			x = 550;
			y = 600;
			viewPlayer.setX(x);
			viewPlayer.setY(y);
			playMove.setMovement(x, y, viewPlayer, viewEnemy);

			viewEnemy.setLayoutX(myEnemy.setEnemyX());
			viewEnemy.setLayoutY(myEnemy.setEnemyY());

			viewItem1.setLayoutX(myItem.setItemX());
			viewItem1.setLayoutY(myItem.setItemY());

			viewItem2.setLayoutX(myItem.setItemX());
			viewItem2.setLayoutY(myItem.setItemY());

			viewItem3.setLayoutX(myItem.setItemX());
			viewItem3.setLayoutY(myItem.setItemY());

			viewItem4.setLayoutX(myItem.setItemX());
			viewItem4.setLayoutY(myItem.setItemY());

			viewItem5.setLayoutX(myItem.setItemX());
			viewItem5.setLayoutY(myItem.setItemY());

			viewItem6.setLayoutX(myItem.setItemX());
			viewItem6.setLayoutY(myItem.setItemY());
		});

		// the group of objects that will be added to the window
		Group myGroup = new Group(viewPlayer, viewEnemy, viewItem1, viewItem2, viewItem3, viewItem4, viewItem5,
				viewItem6, reset);
		gameScreen = new Scene(myGroup, 1200, 800, Color.CORNSILK);

		// Player Movement
		playMove.setMovement(x, y, viewPlayer, viewEnemy);
		playMove.playerMovement(gameScreen);
		playMove.enemyMovement(gameScreen);

		Game myGame = new Game();
		myGame.highscore1 = myItem.item1Collision(gameScreen, viewItem1) + myItem.item2Collision(gameScreen, viewItem2)+ myItem.item3Collision(gameScreen, viewItem3) + myItem.item4Collision(gameScreen, viewItem4) + myItem.item5Collision(gameScreen, viewItem5);
		if(playMove.isColliding == true) {
			viewPlayer.setLayoutX(0);
			viewPlayer.setLayoutY(0);
			viewEnemy.setLayoutX(0);
			viewEnemy.setLayoutY(0);
			highScoreText.setText(myGame.toString());	
		}
		
		

		// Start Screen: replace "primaryStage.setScene(gameScreen);" with
		// "primaryStage.setScene(start);" to implement when ready
		StartScreen begin = new StartScreen();
		start = begin.Starting(primaryStage, gameScreen);

		primaryStage.setTitle("Game"); // title of window in the window's bar
		primaryStage.setScene(gameScreen); // implements the "scene" (objects/background)
		primaryStage.show(); // shows the window (would probably not appear w/o it)
	}
}