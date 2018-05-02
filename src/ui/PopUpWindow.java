package ui;

import static core.World.infowindows;
import static core.World.mainStage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class PopUpWindow extends Stage implements EventHandler<MouseEvent> {

	protected PopUpWindow(double x, double y) {
		super(StageStyle.UNDECORATED);
		initOwner(mainStage);
		setX(x);
		setY(y);
		infowindows.add(this);
	}

	@Override
	public abstract void handle(MouseEvent event);

	public static void closeAll() {
		for (Stage window : infowindows) {
			window.close();
		}
		infowindows.clear();
	}
}
