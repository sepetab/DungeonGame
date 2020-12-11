package unsw.dungeon;

import java.io.File;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartController {
	Stage stage;
	DungeonApplication app;

	/**
	 * Responsible for generating a prompt that displays the starting menu for the player
	 * @param stage
	 * @param app
	 */
	public StartController(Stage stage, DungeonApplication app) {	
		this.stage = stage;
		this.app =app;
	}
	
	
	@FXML
	GridPane gridpane;
	
	@FXML
	Button burton;
	
	/**
	 * Displays the options (different game modes) that are available on the start screen
	 */
	public void initialize() {
		File dir = new File("/tmp_amd/kamen/export/kamen/2/z5113751/2511/F14A-DreamTeam/dungeons");
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
			  int i=0;
			  int j=0;
		    for (File child : directoryListing) {
		    	
		    	Button button = new Button();
		    	String buttonname = child.getName().replaceAll(".json","");
		    	button.setText(buttonname);
		    	button.setOnAction(e -> {
					try {
						this.Action(child.getName());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("DIDNT WORK MATE");
					}
				});
		    	//System.out.println(buttonname);
		    	gridpane.add(button, i, j);
		    	i++;
		    	if(i==5) {
		    		i=0;
		    		j++;
		    	}
		    }
		  }
	}
	
	/**
	 * 
	 * @param filename
	 * @throws IOException
	 */
    private void Action(String filename) throws IOException {
    	app.gameStarter(stage, filename);
	
    }
	

}
