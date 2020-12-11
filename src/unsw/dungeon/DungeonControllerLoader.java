 package unsw.dungeon;
import unsw.entites.*;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;

    //Images
    private Image playerImage;
    private Image wallImage;
    private Image swordImage;
    private Image potionImage;
    private Image closedImage;
    private Image openImage;
    private Image portalImage;
    private Image treasureImage;
    private Image enemyImage;
    private Image switchImage;
    private Image exitImage;
    private Image keyImage;
    private Image boulderImage;
    private Image invinciblegnome;
    private Image swordElf;
    public Stage primarystage;
    private DungeonApplication app;
    private String filename;
    
    /**
     * Loads all the elements (entities) inside the dungeon as well as any 
     * customised images
     * @param filename
     * @param primaryStage
     * @param app
     * @throws FileNotFoundException
     */
    public DungeonControllerLoader(String filename,Stage primaryStage,DungeonApplication app)
            throws FileNotFoundException {
        super(filename);
        entities = new ArrayList<>();
        playerImage = new Image("/human_new.png");
        wallImage = new Image("/brick_brown_0.png");
        swordImage = new Image("/greatsword_1_new.png");
        potionImage = new Image("/brilliant_blue_new.png");
        closedImage = new Image("/closed_door.png");
        openImage = new Image("/open_door.png");
        enemyImage = new Image("/hound.png");
        switchImage = new Image("/pressure_plate.png");
        portalImage = new Image("/portal.png");
        exitImage = new Image("/exit.png");
        keyImage = new Image("/key.png");
        treasureImage = new Image("/gold_pile.png");
        boulderImage = new Image("/boulder.png");
        invinciblegnome = new Image("/gnome.png");
        swordElf = new Image("/deep_elf_master_archer.png");
        this.primarystage = primaryStage;
        this.app =app;
        this.filename = filename;
    }
    
    /**
     * Gets player image and adds entity to dungeon
     */
    @Override
    public void onLoad(Player player) {
        ImageView view = new ImageView(playerImage);
        addEntity(player, view);
    }
    
    /**
     * Gets wall image and adds entity to dungeon
     */
    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }
    
    /**
     * Gets treasure image and adds entity to dungeon
     */
   @Override
    public void onLoad(Treasure treasure) {
        ImageView view = new ImageView(treasureImage);
        addEntity(treasure, view);
    }
   
   /**
    * Gets exit image and adds entity to dungeon
    */
   @Override
	public void onLoad(Exit exit) {
	   ImageView view = new ImageView(exitImage);
       addEntity(exit, view);
		
	}
   	
    /**
     * Gets enemy image and adds entity to dungeon
     */
	@Override
	public void onLoad(Enemy enemy) {
		 ImageView view = new ImageView(enemyImage);
	     addEntity(enemy, view);
		
	}
	/**
	 * Gets portal image and adds entity to dungeon
	 */
	@Override
	public void onLoad(Portal portal) {
		 ImageView view = new ImageView(portalImage);
	     addEntity(portal, view);
		
	}
	
	/**
	 * Gets key image and adds entity to dungeon
	 */
	@Override
	public void onLoad(Key key) {
		 ImageView view = new ImageView(keyImage);
	      addEntity(key, view);
		
	}
	/**
	 * Gets door image and adds entity to dungeon
	 */
	@Override
	public void onLoad(Door door) {
			ImageView view = new ImageView(closedImage);
	        addEntity(door, view);		
	}
	
	/**
	 * Gets floorswitch image and adds entity to dungeon
	 */
	@Override
	public void onLoad(Floorswitch swich) {
		ImageView view = new ImageView(switchImage);
        addEntity(swich, view);
		
	}
	
	/**
	 * Gets sword image and adds entity to dungeon
	 */
	@Override
	public void onLoad(Sword sword) {
		ImageView view = new ImageView(swordImage);
        addEntity(sword, view);
		
	}
	/**
	 * Gets potion image and adds entity to dungeon
	 */
	@Override
	public void onLoad(Potion potion) {
		ImageView view = new ImageView(potionImage);
        addEntity(potion, view);
		
	}
	/**
	 * Gets boulder image and adds entity to dungeon
	 */
	@Override
	public void onLoad(Boulder boulder) {
		ImageView view = new ImageView(boulderImage);
        addEntity(boulder, view);
		
	}
	/**
	 * Adds entity to grid
	 * @param entity
	 * @param view
	 */
    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        entities.add(view);
    }

    /**
     * Set a node in a GridPane to have its position track the position of an
     * entity in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the
     * model will automatically be reflected in the view.
     * @param entity
     * @param node
     */
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        entity.x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
 
            }
           
        });
        entity.removal().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
            		Boolean oldValue, Boolean newValue) {
            	//System.out.println(entities.size());
            	node.setVisible(false);
            	if(entity instanceof Player) {
            		primarystage.setTitle("End Screen");

                    LoseController controller = new LoseController(primarystage,app);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Die.fxml"));
                    loader.setController(controller);

                    // load into a Parent node called root
                    Parent root = null;
					try {
						root = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Can't load");
					}
                    primarystage.setScene(new Scene(root, 600, 400));
                    primarystage.show();
            	}
            	//System.out.println(entities.size());
            	
            }
           
        });
        entity.UIgnome().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
            		Boolean oldValue, Boolean newValue) {
            	ImageView i = (ImageView) node;
            	if(newValue) {
            		i.setImage(invinciblegnome);
            	}else if(entity.UIsword().get()){
            		i.setImage(swordElf);
            	}else {
            		i.setImage(playerImage);
            	}
            	
            }
           
        });
        entity.UIsword().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
            		Boolean oldValue, Boolean newValue) {
            	ImageView i = (ImageView) node;
            	
            	if(entity.UIgnome().get()) {
            		i.setImage(invinciblegnome);
            	}else if(newValue){
            		i.setImage(swordElf);
            	}else {
            		i.setImage(playerImage);
            	}
            	
            }
           
        });
        entity.UIDoor().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
            		Boolean oldValue, Boolean newValue) {
            	ImageView i = (ImageView) node;
            	if(newValue) {
            		i.setImage(openImage);
            	}else {
            		i.setImage(closedImage);
            	}
            	
            }
           
        });
        entity.UIGoal().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
            		Boolean oldValue, Boolean newValue) {
            	
            	primarystage.setTitle("Win Screen");

                WonController controller = new WonController(primarystage,app);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Won.fxml"));
                loader.setController(controller);

                // load into a Parent node called root
                Parent root = null;
				try {
					root = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Can't load");
				}
                primarystage.setScene(new Scene(root, 600, 400));
                primarystage.show();
        	
            }
           
        });
       
     
        
    }

    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController(Stage stage) throws FileNotFoundException {
        return new DungeonController(load(), filename, entities,stage,app);
    }

	


}
