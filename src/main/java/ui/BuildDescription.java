package ui;

import core.GameObject;
import core.Maps;
import core.primitive.Point;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class BuildDescription<T extends GameObject> extends StackPane {

	public double width;
	public double height;

	public BuildDescription(String src, String title, String... text) {
		super();
		height = 70 + 15 * text.length;
		width = 80;
		Rectangle rect = new Rectangle(width, height);
		rect.setFill(Color.AQUAMARINE);
		ImageView image = new ImageView(Maps.getImage(src));
		image.setFitHeight(50);
		image.setFitWidth(50);
		VBox info = new VBox(new Text(title), image);
		for (String txt : text) {
			info.getChildren().add(new Text(txt));
		}
		info.setAlignment(Pos.CENTER);
		getChildren().addAll(rect, info);
	}
	
	public abstract T forge(Point point);

}
