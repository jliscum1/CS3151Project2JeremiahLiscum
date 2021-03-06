/**
 * 
 */
package edu.westga.cs3151.mondrian.main;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Jeremiah Liscum
 *
 */
public class Main extends Application {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.displayDialog();

			Canvas canvas = new Canvas(600, 600);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			this.createGraphics(gc);

			Group group = new Group();
			group.getChildren().add(canvas);
			Scene scene = new Scene(new BorderPane(group), WIDTH, HEIGHT);
			primaryStage.setTitle("Mondrian Art by Jeremiah Liscum");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Entry point
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param args Not used
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Example code displaying a dialog to get user input
	 */
	private void displayDialog() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Test Dialog");
		dialog.setHeaderText("Please enter a word.");
		dialog.setContentText("Word:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			System.out.println("You entered: " + result.get());
		} else {
			System.out.println("No word was returned by the dialog. Did you cancel or close the dialog?");
		}
	}

	/**
	 * Example code creating a collection of rectangles
	 */
	private void createGraphics(GraphicsContext gc) {
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 300, 600);

		gc.setStroke(Color.WHITE);
		gc.setLineWidth(20);
		gc.strokeLine(290, 10, 290, 590);

		gc.setFill(Color.color(0.9, 0.3, 0));
		gc.fillRect(300, 0, 300, 300);

		gc.setFill(Color.YELLOW);
		gc.fillRect(300, 300, 300, 300);

		gc.setStroke(Color.GREEN);
		gc.setLineWidth(30);
		gc.strokeLine(315, 300, 585, 300);
	}
}
