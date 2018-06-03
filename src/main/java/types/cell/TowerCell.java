package types.cell;

import core.Tower;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import types.tower.MiddleTower;
import types.tower.WeakTower;
import ui.PopUpWindow;
import ui.window.BasicBuildWindow;
import ui.window.MiddleTowerWindow;
import ui.window.WeakTowerWindow;

import static core.World.*;

import core.Maps;

public class TowerCell extends BuildableCell<Tower> implements EventHandler<MouseEvent> {
	private Tower tower;

	private static final String src = "towercell.jpg";

	static {
		Maps.storeImage(src);
	}

	public TowerCell(int wIndex, int hIndex) {
		super(src, wIndex, hIndex, Color.MEDIUMORCHID, false);
		setOnMouseClicked(this);
		this.tower = null;
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton() == MouseButton.SECONDARY && !activePause) {
			PopUpWindow.closeAll();
			if (tower == null) {
				BasicBuildWindow window = new BasicBuildWindow(event, this);
				window.show();
			} else if (tower instanceof WeakTower) {
				WeakTowerWindow window = new WeakTowerWindow(event, this);
				window.show();
			} else if (tower instanceof MiddleTower) {
				MiddleTowerWindow window = new MiddleTowerWindow(event, this);
				window.show();
			}
		}
	}

	@Override
	public void build(Tower target) {
		if (goldAmount < target.getCost())
			return;
		goldAmount -= target.getCost();
		if (tower != null)
			tower.destroy();
		target.setPoint(getPoint());
		towers.add(target);
		tower = target;
		tower.setCell(this);
		root.getChildren().add(target);
	}
}
