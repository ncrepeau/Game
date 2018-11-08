
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartScreen {

	public Scene Starting(Stage primaryStage, Scene gameScreen, ImageView viewPlayer){
		
		Text selected = new Text("**Selected**");
		selected.setScaleX(2);	selected.setScaleY(2);
		selected.setX(193); 	selected.setY(150);
		selected.setFill(Color.TEAL);
		
		Text instructions = new Text("Use the arrow keys to move.\n\nCollect gems and try to avoid\nthe Time Master at all costs!");
		instructions.setScaleX(2);	instructions.setScaleY(2);
		instructions.setX(515); 	instructions.setY(300);
		instructions.setFill(Color.TEAL);
		
		
		//Start Screen Objects
		Button play = new Button("Start");
		play.setOnAction(e -> primaryStage.setScene(gameScreen));
		play.setLayoutX(568);	play.setLayoutY(550);
		play.setScaleX(3);		play.setScaleY(3);

		//Avatar choice button (Bunny)
		Button bunnyBttn = new Button("Bunny");
		bunnyBttn.setLayoutX(200);	bunnyBttn.setLayoutY(400);
		bunnyBttn.setScaleX(2);		bunnyBttn.setScaleY(2);
		bunnyBttn.setOnAction(e ->{ Image player1 = new Image("file:src/Bunny.png");
									viewPlayer.setImage(player1);
									selected.setX(193); selected.setY(150);});

		//Avatar choice button (Bird)
		Button birdBttn = new Button("Bird");
		birdBttn.setLayoutX(925);	birdBttn.setLayoutY(400);
		birdBttn.setScaleX(2);		birdBttn.setScaleY(2);
		birdBttn.setOnAction(e ->{	Image player2 = new Image("file:src/Bird.png");
									viewPlayer.setImage(player2);
									selected.setX(918); selected.setY(150);});
		//Avatar Preview (Bunny)
		Image bunny = new Image("file:src/Bunny.png");
		ImageView viewBunny = new ImageView(bunny);
		viewBunny.setX(167);	viewBunny.setY(170);
		
		//Avatar Preview (Bird)
		Image bird = new Image("file:src/Bird.png");
		ImageView viewBird = new ImageView(bird);
		viewBird.setX(888);	viewBird.setY(175);

		Group root = new Group(selected, viewBunny, viewBird, bunnyBttn, birdBttn, instructions, play);
		Scene start = new Scene(root, 1200, 800, Color.HONEYDEW);
		return start;
	}

}