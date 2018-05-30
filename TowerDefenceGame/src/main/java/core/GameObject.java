package core;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class GameObject extends StackPane {
	public double x;
	public double y;
	public Circle base;
	public ImageView img;
	public boolean simplified;

	public GameObject(String src, double x, double y, double radius, Color color) {
		super();
		base = new Circle(x, y, radius, color);
		this.x = x;
		this.y = y;
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
		super.relocate(x, y);
	}
}
