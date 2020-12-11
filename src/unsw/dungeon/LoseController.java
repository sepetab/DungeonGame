package unsw.dungeon;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoseController {
	
	Stage stage;
	DungeonApplication app;
	
	/**
	 *responsible for generating a prompt that informs the player of 'losing' a game 
	 * @param stage
	 * @param app
	 */
	public LoseController(Stage stage, DungeonApplication app) {
		this.stage = stage;
		this.app =app;
	}
	
	@FXML
    private Button again;
	
	/**
	 * handles the restart functionality by returning player to start page upon losing
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void restartHandler(ActionEvent event) throws IOException {
        app.start(stage);
    }
	
}
