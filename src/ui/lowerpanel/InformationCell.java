package ui.lowerpanel;

import static core.World.root;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public abstract class InformationCell extends Rectangle {
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	protected StackPane container;

	public InformationCell(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		container = new StackPane();
		container.relocate(x, y);
		root.getChildren().add(container);
	}

	public abstract void refresh();

}
