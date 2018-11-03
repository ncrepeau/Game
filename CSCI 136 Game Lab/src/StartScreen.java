import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartScreen {
	
	public Scene Starting(Stage primaryStage, Scene gameScreen){
		
			//Start Screen Objects
			Button play = new Button("Start");
			play.setOnAction(e -> primaryStage.setScene(gameScreen));		
			
			Group root = new Group(play);
			Scene start = new Scene(root, 1200, 800, Color.DARKSEAGREEN);
			return start;
	}

}