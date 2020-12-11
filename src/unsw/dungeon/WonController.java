package unsw.dungeon;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WonController {
	
	Stage stage;
	DungeonApplication app;
	/**
	 * Displays a prompt informing the player that a game has been 'won' upon completion of objectives
	 * @param stage
	 * @param app
	 */
	public WonController(Stage stage, DungeonApplication app) {
		this.stage = stage;
		this.app =app;
	}
	@FXML
    private Button again;
	
	/**
	 * Responsible for routing the game back to menu
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void restartHandler(ActionEvent event) throws IOException {
        app.start(stage);
    }
	
}
