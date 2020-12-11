package unsw.dungeon;
import unsw.entites.*;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * A JavaFX controller for the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonController {
	
	Stage primaryStage;

    @FXML
    private GridPane squares;
    @FXML
    private TextFlow textflow;

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;
    private DungeonApplication app;
    private String filename;

    
    /**
     * Used to initialize the dungeon setting and display and keyboard prompts
     * for player movement
     * @param dungeon
     * @param filename
     * @param initialEntities
     * @param primaryStage
     * @param app
     */
    public DungeonController(Dungeon dungeon, String filename, List<ImageView> initialEntities, Stage primaryStage,DungeonApplication app) {
    	this.primaryStage = primaryStage;
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.initialEntities = new ArrayList<>(initialEntities);
        this.app = app;
        this.filename = filename;
    }
    
    /**
     * used to initialize the dungeon background and display
     * also sets up the side pane which is used for viewing goals
     */
    @FXML
    public void initialize() {

         
        Image ground = new Image("/sandal.png");
        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }
     

        for (ImageView entity : initialEntities) {
            squares.getChildren().add(entity);
        }
      
        
        for(Entity entity : dungeon.getEntity()) {
        	if(entity instanceof Enemy) {
        		Timeline timeline = new Timeline();
        		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(300),new EventHandler<ActionEvent>() {
        			public void handle(ActionEvent e) {
        				Enemy em = (Enemy) entity;
        				
        				em.run(dungeon.getPlayer());
        			}
        		}));
        		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>() {
        			public void handle(ActionEvent e) {
        				dungeon.checkGoal();
        			}
        		}));
        		timeline.setCycleCount(Animation.INDEFINITE);
        		timeline.play();
        	}
        }
        
        
        
   	 Text text1 = new Text("TO WIN:\n");
     text1.setFill(Color.RED);
     text1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
     Text text2 = new Text(dungeon.goals.toString() + "\n");
     text2.setFill(Color.BLUE);
     text2.setFont(Font.font("Helvetica", FontWeight.BOLD, 23));
     textflow.getChildren().add(text1);
     textflow.getChildren().add(text2);
     Text text3 = new Text();
     text3.textProperty().bindBidirectional(dungeon.keyLeft());
     Text text4 = new Text();
     text4.textProperty().bindBidirectional(dungeon.swordLeft());
     Text text5 = new Text();
     text3.setFill(Color.GREEN);
     text3.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
     text4.setFill(Color.GREEN);
     text4.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
     text5.setFill(Color.GREEN);
     text5.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
     text5.textProperty().bindBidirectional(dungeon.invincibilityLeft());
     Text text8 = new Text();
     text8.setFill(Color.GREEN);
     text8.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
     text8.textProperty().bindBidirectional(dungeon.treasure());
     textflow.getChildren().add(text8);
     textflow.getChildren().add(text3);
     textflow.getChildren().add(text4);
     textflow.getChildren().add(text5);
     Text text6 = new Text("\nRules:\n\n");
     text6.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
     text6.setFill(Color.BLACK);
     textflow.getChildren().add(text6);
     Text text7 = new Text("The invincibility effect lasts for 25 steps...so plan carefully!\n\n" + 
     "You can only hold one Key at once!\n\n" + "You can only hold one sword at once!\n\n" + "Using sword can eliminate enemies adjacent to you!\n\n" + 
    		 "You die when enemies catch you!\n");
     text7.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
     text7.setFill(Color.BLACK);
     textflow.getChildren().add(text7);
    
}
   
    /**
     * handles key events for player: up, down, left, right, sword
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleKeyPress(KeyEvent event) throws IOException {
        switch (event.getCode()) {
        case UP:
            player.moveUp();
            break;
        case DOWN:
            player.moveDown();
            break;
        case LEFT:
            player.moveLeft();
            break;
        case RIGHT:
            player.moveRight();
            break;
        case SPACE:
        	player.useSword();
        	break;							
        case R:
        	for(Entity entity : dungeon.getEntity()) {
        		if(entity instanceof Enemy) {
        			((Enemy) entity).dead = true;
        		}
        		
        	}
        	app.gameStarter(primaryStage,filename);
            break;
        case M:
        	for(Entity entity : dungeon.getEntity()) {
        		if(entity instanceof Enemy) {
        			((Enemy) entity).dead = true;
        		}
        		
        	}
        	app.start(primaryStage);
        default:
            break;
        }
    }
    
}

