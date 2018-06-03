package core;

import static core.World.*;

import core.primitive.Point;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {

	private final Point point;
	private final Point centerPoint;
	private final int wIndex;
	private final int hIndex;
	private final Rectangle base;
	private final ImageView img;
	private boolean simplified;
	private final boolean available;

	public Cell(String src, int wIndex, int hIndex, Color color, boolean available) {
		super();
		point = new Point(TILE_SIDE * wIndex + ((FIELD_WIDTH - (TILE_SIDE * TILES_AMOUNT_WIDTH)) / 2),
				TILE_SIDE * hIndex + ((FIELD_HEIGHT - (TILE_SIDE * TILES_AMOUNT_HEIGHT)) / 2));
		centerPoint = new Point(point.getX() + (TILE_SIDE / 2), point.getY() + (TILE_SIDE / 2));
		this.wIndex = wIndex;
		this.hIndex = hIndex;
		base = new Rectangle(point.getX(), point.getY(), TILE_SIDE, TILE_SIDE);
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
		super.relocate(point.getX(), point.getY());
		if (simplified) {
			super.getChildren().addAll(base);
		} else {
			super.getChildren().addAll(base, img);
		}
	}

	public Point getCenterPoint() {
		return centerPoint;
	}

	public boolean isSimplified() {
		return simplified;
	}

	public Point getPoint() {
		return point;
	}

	public int getwIndex() {
		return wIndex;
	}

	public int gethIndex() {
		return hIndex;
	}

	public Rectangle getBase() {
		return base;
	}

	public ImageView getImg() {
		return img;
	}

	public boolean isAvailable() {
		return available;
	}

}
