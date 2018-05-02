package ui.window;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import types.cell.RemovableObstacleCell;
import ui.PopUpWindow;

public class RemoveObstacleWindow extends PopUpWindow {

	public RemovableObstacleCell cell;

	public RemoveObstacleWindow(MouseEvent event, RemovableObstacleCell removableObstacleCell) {
		super(event.getScreenX(), event.getScreenY());
		this.cell = removableObstacleCell;

		VBox layout = new VBox();
		layout.setPrefSize(50, 50 + 10);

		Rectangle background = new Rectangle(0, 0, 50, 50);
		background.setFill(Color.AQUAMARINE);
		Text description = new Text("Free cell");
		Text cost = new Text("Cost: " + RemovableObstacleCell.cost);
		VBox box = new VBox(10, description, cost);
		box.setAlignment(Pos.CENTER);
		StackPane window = new StackPane(background, box);

		Rectangle lower = new Rectangle(0, 50, 50, 10);
		StackPane combDown = new StackPane(lower, new Text("Cancel"));
		lower.setFill(Color.DARKORANGE);

		layout.getChildren().addAll(window, combDown);

		layout.setOnMouseClicked(this);
		setScene(new Scene(layout));

	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			double y = event.getSceneY();
			if (y <= 50) {
				cell.makeActive();
			}
			close();
		}

	}

}
