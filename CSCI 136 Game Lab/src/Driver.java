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
	int enemyX = 0, enemyY= 0;
	ImageView viewEnemy;
	ImageView viewItem1, viewItem2, viewItem3, viewItem4, viewItem5, viewItem6;
	Scene gameScreen, start, end;
	Text highScoreText;

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {

		Movement playMove = new Movement();
		highScoreText = new Text(1000, 10, "");

		//Player image and position
		Player myPlayer = new Player();
		Image player = new Image(myPlayer.getPlayerImg());
		viewPlayer = new ImageView(player);
		viewPlayer.setX(x);	viewPlayer.setY(y);

		//Enemy image and position
		Enemy myEnemy = new Enemy();
		Image enemy = new Image(myEnemy.getEnemyImg());
		viewEnemy = new ImageView(enemy);
		viewEnemy.setX(enemyX);
		viewEnemy.setY(enemyY);

		//Item Array
		Items myItem = new Items();
		ArrayList<String> itemArray = new ArrayList<String>();
		itemArray = Items.getImagePath();
		
		//Items and their positions
		Image item1 = new Image(itemArray.get(0));
		viewItem1 = new ImageView(item1);
		viewItem1.setLayoutX(myItem.setItemX());
		viewItem1.setLayoutY(myItem.setItemY());


		Image item2 = new Image(itemArray.get(1));
		viewItem2 = new ImageView(item2);
		viewItem2.setLayoutX(myItem.setItemX());
		viewItem2.setLayoutY(myItem.setItemY());

		Image item3 = new Image(itemArray.get(2));
		viewItem3 = new ImageView(item3);
		viewItem3.setLayoutX(myItem.setItemX());
		viewItem3.setLayoutY(myItem.setItemY());

		Image item4 = new Image(itemArray.get(3));
		viewItem4 = new ImageView(item4);
		viewItem4.setLayoutX(myItem.setItemX());
		viewItem4.setLayoutY(myItem.setItemY());

		Image item5 = new Image(itemArray.get(4));
		viewItem5 = new ImageView(item5);
		viewItem5.setLayoutX(myItem.setItemX());
		viewItem5.setLayoutY(myItem.setItemY());

		Image item6 = new Image(itemArray.get(5));
		viewItem6 = new ImageView(item6);
		viewItem6.setLayoutX(myItem.setItemX());
		viewItem6.setLayoutY(myItem.setItemY());
		
		playMove.setItems(viewItem1, viewItem2, viewItem3, viewItem4, viewItem5, viewItem6);

		//Reset Button
		Button reset = new Button("Restart");
		reset.setLayoutX(1115);
		reset.setLayoutY(15);

		//Button Action
		reset.setOnAction(e -> {
			x = 550; y = 600;
			viewPlayer.setX(x);
			viewPlayer.setY(y);
			
			enemyX = 0;
			enemyY = 0;
			viewEnemy.setX(enemyX);
			viewEnemy.setY(enemyY);
			
			playMove.setMovement(x, y, enemyX, enemyY, viewPlayer, viewEnemy, primaryStage, start, gameScreen);
			
			viewItem1.setImage(item1);
			viewItem1.setLayoutX(myItem.setItemX());
			viewItem1.setLayoutY(myItem.setItemY());
			
			viewItem2.setImage(item2);
			viewItem2.setLayoutX(myItem.setItemX());
			viewItem2.setLayoutY(myItem.setItemY());

			viewItem3.setImage(item3);
			viewItem3.setLayoutX(myItem.setItemX());
			viewItem3.setLayoutY(myItem.setItemY());

			viewItem4.setImage(item4);
			viewItem4.setLayoutX(myItem.setItemX());
			viewItem4.setLayoutY(myItem.setItemY());
			
			viewItem5.setImage(item5);
			viewItem5.setLayoutX(myItem.setItemX());
			viewItem5.setLayoutY(myItem.setItemY());

			viewItem6.setImage(item6);
			viewItem6.setLayoutX(myItem.setItemX());
			viewItem6.setLayoutY(myItem.setItemY());
			
			playMove.score1 = 0;
			playMove.score2 = 0;
			playMove.score3 = 0;
			playMove.score4 = 0;
			playMove.score5 = 0;
			playMove.score6 = 0;
		});
		
		//Start Menu Button (goes back to the start menu)
		Button startMenu = new Button("Start Menu");
		startMenu.setOnAction(e -> {primaryStage.setScene(start);});
		startMenu.setLayoutX(1000);	startMenu.setLayoutY(15);
		
		//The group of objects that will be added to the window
		Group myGroup = new Group(viewItem1, viewItem2, viewItem3, viewItem4, viewItem5, viewItem6, viewPlayer, viewEnemy, startMenu, reset); 
		gameScreen = new Scene(myGroup, 1200, 800, Color.CORNSILK);

		//Movement
		playMove.setMovement(x, y, enemyX, enemyY, viewPlayer, viewEnemy, primaryStage, start, gameScreen);
		playMove.playerMovement(gameScreen);
		playMove.enemyMovement(gameScreen);
		//HighScoreScreen, Move to end screen.
		Game myGame = new Game();
		myGame.highscore1 = playMove.highScore1;
		highScoreText.setText(myGame.toString());
		
		//Start Screen
		StartScreen begin = new StartScreen();
		start = begin.Starting(primaryStage, gameScreen, viewPlayer);
		
		//End Screen (Needs to be implemented by colliding with enemy or collecting all items)
		EndScreen gameOver = new EndScreen();
		end = gameOver.Ending(primaryStage, gameScreen, start);

		primaryStage.setTitle("Game"); // title of window in the window's bar
		primaryStage.setScene(start); // implements the "scene" (objects/background)
		primaryStage.show(); // shows the window (would probably not appear w/o it)
	}
}