package types.cell;

import static core.World.activePause;
import static core.World.goldAmount;

import core.Bomb;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import ui.PopUpWindow;
import ui.window.BombListWindow;

public class RoadCell extends BuildableCell<Bomb> implements EventHandler<MouseEvent> {

	public double speedRate;

	public RoadCell(String src, int wIndex, int hIndex, Color color, double speedRate) {
		super(src, wIndex, hIndex, color, true);
		this.speedRate = speedRate;
		this.setOnMouseClicked(this);
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton() == MouseButton.SECONDARY && !activePause) {
			PopUpWindow.closeAll();
			BombListWindow window = new BombListWindow(event, this);
			window.show();
		}
	}

	@Override
	public void build(Bomb target) {
		if (goldAmount < target.getCost())
			return;
		goldAmount -= target.getCost();
		target.setX(x);
		target.setY(y);
		target.explode();
		
	}
}
