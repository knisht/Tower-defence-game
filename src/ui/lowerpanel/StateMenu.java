package ui.lowerpanel;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static core.World.*;

import java.util.ArrayList;

public class StateMenu extends StackPane {

	double x;
	double y;
	double wid;
	double hei;

	public StateMenu() {
		super();
		root.getChildren().add(this);
		x = 0;
		y = HEIGHT;
		wid = WINDOW_WIDTH;
		hei = WINDOW_HEIGHT - HEIGHT;
		Rectangle full = new Rectangle(x, y, wid, hei);
		full.setFill(Color.LIGHTBLUE);
		getChildren().add(full);
		relocate(x, y);
		cells = new ArrayList<InformationCell>();
	}

	public void addCells() {
		cells.add(new TimeCell(x, y, wid / 3, hei));
		cells.add(new GoldCell(x + wid / 3, y, wid / 3, hei));
		cells.add(new EnemyCell(x + 2 * wid / 3, y, wid / 3, hei));
	}
}
