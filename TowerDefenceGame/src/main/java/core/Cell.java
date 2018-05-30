package core;

import static core.World.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {

	public double x;
	public double y;
	public int wIndex;
	public int hIndex;
	private Rectangle base;
	private ImageView img;
	boolean simplified;
	boolean available;

	public Cell(String src, int wIndex, int hIndex, Color color, boolean available) {
		super();
		x = TILE_SIDE * wIndex + ((WIDTH - (TILE_SIDE * TILES_AMOUNT_WIDTH)) / 2);
		y = TILE_SIDE * hIndex + ((HEIGHT - (TILE_SIDE * TILES_AMOUNT_HEIGHT)) / 2);
		this.wIndex = wIndex;
		this.hIndex = hIndex;
		base = new Rectangle(x, y, TILE_SIDE, TILE_SIDE);
		base.setFill(color);
		this.available = available;
		if (src != "") {
			img = new ImageView(Maps.getImage(src));
			img.setFitWidth(TILE_SIDE);
			img.setFitHeight(TILE_SIDE);
			base.setVisible(false);
			simplified = false;
		} else {
			img = null;
			simplified = true;
		}
		super.relocate(x, y);
		if (simplified) {
			super.getChildren().addAll(base);
		} else {
			super.getChildren().addAll(base, img);
		}
	}

}
