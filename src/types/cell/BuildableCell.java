package types.cell;

import core.Cell;
import core.GameObject;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class BuildableCell<T extends GameObject> extends Cell
		implements EventHandler<MouseEvent>, Buildable<T> {

	public BuildableCell(String src, int wIndex, int hIndex, Color color, boolean available) {
		super(src, wIndex, hIndex, color, available);
	}

	@Override
	public abstract void handle(MouseEvent event);

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	public abstract void build(T target);
}
