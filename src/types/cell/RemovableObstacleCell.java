package types.cell;

import core.Cell;
import core.Maps;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import ui.PopUpWindow;
import ui.window.RemoveObstacleWindow;

import static core.World.*;



public class RemovableObstacleCell extends Cell implements EventHandler<MouseEvent> {

	public static final long cost = 10;

	private static final String src = "remobstaclecell.jpg";
	
	static {
		Maps.storeImage(src);
	}
	public RemovableObstacleCell(int wIndex, int hIndex) {
		super(src, wIndex, hIndex, Color.GREY, false);
		this.setOnMouseClicked(this);
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton() == MouseButton.SECONDARY && !activePause) {
			PopUpWindow.closeAll();
			RemoveObstacleWindow window = new RemoveObstacleWindow(event, this);
			window.show();
		}
		
	}

	
	public void makeActive() {
		if (gold < cost)
			return;
		gold-=cost;
		root.getChildren().remove(this);
		TowerCell newCell = new TowerCell(wIndex, hIndex);
		field.tiles[wIndex][hIndex] = newCell;
		root.getChildren().add(newCell);
	}

}
