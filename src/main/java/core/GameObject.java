package core;

import core.primitive.Point;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class GameObject extends StackPane {
	protected Circle base;
	protected ImageView img;
	public boolean simplified;

	public GameObject(String src, Point point, double radius, Color color) {
		super();
		base = new Circle(point.getX(), point.getY(), radius, color);
		if (src != "") {
			img = new ImageView(Maps.getImage(src));
			img.setFitWidth(radius * 2);
			img.setFitHeight(radius * 2);
			base.setVisible(false);
			simplified = false;
		} else {
			simplified = true;
		}
		if (!simplified) {
			super.getChildren().addAll(base, img);
		} else {
			super.getChildren().add(base);
		}
	}

	public void render() {
		super.relocate(base.getCenterX(), base.getCenterY());
	}

	public Point getPoint() {
		return new Point(base.getCenterX(), base.getCenterY());
	}

	public void setPoint(Point point) {
		base.setCenterX(point.getX());
		base.setCenterY(point.getY());
	}

	public Circle getBase() {
		return base;
	}
}
