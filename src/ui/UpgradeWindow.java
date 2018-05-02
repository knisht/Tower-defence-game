package ui;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import types.cell.Buildable;

import java.util.List;

import core.GameObject;

public class UpgradeWindow<T extends GameObject> extends PopUpWindow {

	Buildable<T> caller;
	int amountOfAlternatives;
	List<BuildDescription<T>> options;
	String buildType;
	double width;
	double height;

	public UpgradeWindow(MouseEvent event, Buildable<T> caller, List<BuildDescription<T>> options) {
		super(event.getScreenX(), event.getScreenY());
		this.options = options;
		this.caller = caller;
		this.width = options.get(0).width;
		this.height = options.get(0).height;
		VBox layout = new VBox();
		amountOfAlternatives = options.size();
		layout.setPrefSize(width, height * amountOfAlternatives+ 10);

		for (int i = 0; i < amountOfAlternatives; i++) {
			layout.getChildren().addAll(options.get(i), new Rectangle(width, 1, Color.BLACK));
		}
		Rectangle lower = new Rectangle(0, height * amountOfAlternatives, width, 15);
		StackPane combDown = new StackPane(lower, new Text("Cancel"));
		lower.setFill(Color.DARKORANGE);

		layout.getChildren().add(combDown);

		layout.setOnMouseClicked(this);
		setScene(new Scene(layout));
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			double y = event.getSceneY();
			for (int i = 0; i < amountOfAlternatives; i++) {
				if (y < (height * (i + 1))) {
					caller.build(options.get(i).forge(caller.getX(), caller.getY()));
					break;
				}
			}
			close();
		}
	}

}
