package unsw.dungeon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonApplication extends Application {
	
	/**
	 * loads the start screen upon running java application
	 */
    @Override
    public void start(Stage primaryStage) throws IOException{
        
    	primaryStage.setTitle("Start Screen");

        StartController controller = new StartController(primaryStage,this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));
        loader.setController(controller);

        // load into a Parent node called root
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root, 600, 400));
      
        
        primaryStage.show();
        
    
    }
    
    /**
     * uses DungeonController and DungeonControllerLoader to load and display the dungeonview and scene 
     * @param primaryStage
     * @param filename
     * @throws IOException
     */
    public void gameStarter(Stage primaryStage, String filename) throws IOException {
    	primaryStage.setTitle("Dungeon");

        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader(filename,primaryStage,this);

        DungeonController controller = dungeonLoader.loadController(primaryStage);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root,1000,1000);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }

  
    /**
     * launches application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
