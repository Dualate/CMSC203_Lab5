


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	private Button hello, howdy, chinese, clear, exit;
	private Label feedback;
	private TextField text_field;
	private HBox box1, box2;
	private VBox big_boi;
	private DataManager thing;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {

		hello = new Button("Hello");
		howdy = new Button("Howdy");
		chinese = new Button("Chinese");
		clear = new Button("Clear");
		exit = new Button("Exit");
		
		feedback = new Label("Feedback");
		
		text_field = new TextField();
		
		big_boi = new VBox();
		box1 = new HBox();
		box2 = new HBox();
		
		thing = new DataManager();
		
		
		box1.getChildren().addAll(hello, howdy, chinese, clear, exit);
		box2.getChildren().addAll(text_field, feedback);
		setMargin(hello, new Insets(5, 30, 10, 30));
		setMargin(howdy, new Insets(5, 30, 20, 30));
		big_boi.getChildren().addAll(box1, box2);
		getChildren().addAll(big_boi);
		
		hello.setOnAction(new ButtonEventHandler());
		howdy.setOnAction(new ButtonEventHandler());
		chinese.setOnAction(new ButtonEventHandler());
		clear.setOnAction(new ButtonEventHandler());
		exit.setOnAction(new ButtonEventHandler());
	}

	private class ButtonEventHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			if (e.getSource() == hello) {
				text_field.setText(thing.getHello());
			}
			else if (e.getSource() == howdy) {
				text_field.setText(thing.getHowdy());
			}
			else if (e.getSource() == chinese) {
				text_field.setText(thing.getChinese());
			}
			else if (e.getSource() == clear) {
				text_field.setText("");
			}
			else if (e.getSource() == exit) {
				Platform.exit();
				System.exit(0);
			}
		}
		
	}
}
	