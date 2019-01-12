import static java.lang.Math.abs;
import java.util.Observable;
import java.util.Observer;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Application for connect four
 * @author vijay
 */
public class ConnectFourApplication extends Application implements Observer{
    
    /**
     * number of columns
     */
    public static final int NUM_COLUMNS = 8;
    /**
     * number of rows
     */
    public static final int NUM_ROWS = 8;
    /**
     * number of buttons in a row to win
     */
    public static final int NUM_TO_WIN = 4;
    /**
     * size of each button
     */
    public static final int BUTTON_SIZE = 20;
    /**
     * game model
     */
    private ConnectFourGame gameEngine;
    /**
     * 2d array of buttons
     */
    private ConnectButton[][] buttons;
    
    private Button bottom;
    
    private int rowPosition;
    
    private int columnPosition;
    private String colour;
    
    /**
     * start method for the gui
     * @param primaryStage stage of the gui
     */
    @Override
    public void start(Stage primaryStage) { 
        gameEngine = new ConnectFourGame(ConnectFourEnum.BLACK);
        gameEngine.addObserver(this);
        BorderPane root = new BorderPane();
        GridPane leaf = new GridPane();
        Scene scene = new Scene(root, 510, 380);
        TextField top = new TextField();
        top.setText(gameEngine.getTurn().enumToString(gameEngine.getTurn()));
        bottom = new Button("Take My Turn");
        buttons = new ConnectButton[NUM_ROWS][NUM_COLUMNS];
        for (int i = NUM_ROWS - 1; i >= 0; i--) {
            for(int j = 0; j < NUM_COLUMNS; j++) {
                buttons[i][j] = new ConnectButton("EMPTY", i, j);
                buttons[i][j].setText("EMPTY");
                buttons[i][j].setMinHeight(20);
                buttons[i][j].setMaxWidth(Double.MAX_VALUE);
                leaf.add(buttons[i][j], j, abs(i-(NUM_ROWS - 1)));
                GridPane.setHgrow(buttons[i][j], Priority.ALWAYS);
                buttons[i][j].setOnAction(new ButtonHandler(buttons[i][j], this.gameEngine, bottom));
            }
        }
        bottom.setOnAction((ActionEvent event) -> {
            System.out.println("Drop the Checker");
            this.buttons[rowPosition][columnPosition].setText(colour);    
        });

        root.setCenter(leaf);
        root.setTop(top);
        root.setBottom(bottom);
        primaryStage.setTitle("Connect Four Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void update(Observable obs, Object arg) {
        ConnectMove cm = (ConnectMove) arg;
        this.rowPosition = cm.getRow();
        this.columnPosition = cm.getColumn();
        this.colour = cm.getColour().enumToString(cm.getColour());
    }
    
    /**
     * launches the gui
     * @param args the gui
     */
    public static void main (String[] args) {
        launch(args);
    }
}

/**
 * handles what the buttons do when pressed
 * @author vijay
 */
class ButtonHandler implements EventHandler <ActionEvent> {
    /**
     * button instance
     */
    private ConnectButton b;
    private ConnectFourGame g;
    private Button bottom;
    
    /**
     * default constructor
     * @param b button being passed
     */
    public ButtonHandler(ConnectButton b, ConnectFourGame g, Button bottom) {
        this.b = b;
        this.g = g;
        this.bottom = bottom;
    }
    /**
     * What happens when button is pressed
     * @param event 
     */
    @Override
    public void handle(ActionEvent event) {
        System.out.println("(" + b.getRow() + "," + b.getColumn() + ")");
        g.takeTurn(b.getRow(), b.getColumn());
    }
}
