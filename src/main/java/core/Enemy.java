package core;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import types.cell.FinishCell;
import types.cell.RoadCell;

import static core.World.*;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import core.primitive.Point;
import core.primitive.Speed;

public abstract class Enemy extends MovableObject implements EventHandler<MouseEvent> {
	private int oldpx;
	private int oldpy;
	private int curpx;
	private int curpy;
	private double absoluteSpeed;
	private double hitpoints;
	public final double maximumHitpoints;
	private RoadCell currentCell;
	private Rectangle hitpointBar;
	public final String flying;
	private boolean important = false;

	public Enemy(String src, Point point, Color color, int hitpoints, double absoluteSpeed, String flying) {
		super(src, point, TILE_SIDE / 2 - 3, color, new Speed(0, 0));
		this.hitpointBar = new Rectangle(TILE_SIDE - 2, 2);
		hitpointBar.setFill(Color.RED);
		curpx = field.startCell.getwIndex();
		oldpx = curpx;
		curpy = field.startCell.gethIndex();
		oldpy = curpy;
		this.currentCell = field.startCell;
		this.hitpoints = hitpoints;
		this.maximumHitpoints = hitpoints;
		this.absoluteSpeed = absoluteSpeed;
		this.flying = flying;
		hitpointBar.relocate(point.getX(), point.getY() - 5);
		hitpointBar.setVisible(false);
		root.getChildren().add(hitpointBar);
		this.setOnMouseClicked(this);
	}

	public void move(long now) {
		if (!alive())
			return;
		hitpointBar.setVisible(true);
		specialMechanic(now);
		if (getPoint().getX() - base.getRadius() >= field.tiles[curpx][curpy].getPoint().getX()
				&& getPoint().getX() + base.getRadius() <= field.tiles[curpx][curpy].getPoint().getX() + TILE_SIDE
				&& getPoint().getY() - base.getRadius() >= field.tiles[curpx][curpy].getPoint().getY()
				&& getPoint().getY() + base.getRadius() <= field.tiles[curpx][curpy].getPoint().getY() + TILE_SIDE) {

			if (field.tiles[curpx][curpy] instanceof FinishCell) {
				gameLostState = true;
				return;
			}

			if ((curpx > 0) && !(curpx - 1 == oldpx && curpy == oldpy) && acceptable(field.tiles[curpx - 1][curpy])) {
				oldpx = curpx;
				oldpy = curpy;
				curpx--;
				setSpeed(new Speed(-absoluteSpeed, 0));
			} else if ((curpx < TILES_AMOUNT_WIDTH - 1) && !(curpx + 1 == oldpx && curpy == oldpy)
					&& acceptable(field.tiles[curpx + 1][curpy])) {
				oldpx = curpx;
				oldpy = curpy;
				curpx++;
				setSpeed(new Speed(absoluteSpeed, 0));
			} else if ((curpy > 0) && !(curpx == oldpx && curpy - 1 == oldpy)
					&& acceptable(field.tiles[curpx][curpy - 1])) {
				oldpx = curpx;
				oldpy = curpy;
				curpy--;
				setSpeed(new Speed(0, -absoluteSpeed));
			} else if ((curpy < TILES_AMOUNT_HEIGHT - 1) && !(curpx == oldpx && curpy + 1 == oldpy)
					&& acceptable(field.tiles[curpx][curpy + 1])) {
				oldpx = curpx;
				oldpy = curpy;
				curpy++;
				setSpeed(new Speed(0, absoluteSpeed));
			}

		}
		currentCell = (RoadCell) field.tiles[curpx][curpy];
		super.move(getSpeed().scale(currentCell.speedRate));
	}

	public void render() {
		super.relocate(getPoint().getX() - getBase().getRadius(), getPoint().getY() - getBase().getRadius());
		hitpointBar.setWidth(hitpoints / maximumHitpoints * (TILE_SIDE - 2));
		hitpointBar.relocate(getPoint().getX() - getBase().getRadius(), getPoint().getY() - getBase().getRadius() - 5);
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton() == MouseButton.PRIMARY) {
			this.important = Boolean.logicalXor(this.important, true);
			if (this.important) {
				Lighting lighting = new Lighting();
				lighting.setLight(new Light.Distant(45, 45, Color.RED));
				this.img.setEffect(lighting);
			} else {
				ColorAdjust blackout = new ColorAdjust();
				blackout.setSaturation(0);
				this.img.setEffect(blackout);
			}
		} else if (event.getButton() == MouseButton.SECONDARY) {
			currentCell.handle(event);
		}

	}

	public boolean acceptable(Cell r) {
		return r.isAvailable();
	}

	public boolean alive() {
		return hitpoints > 0;
	}

	public void tryToDie() {
		if (hitpoints <= 0) {
			setVisible(false);
			root.getChildren().remove(this);
			enemies.remove(this);
			destroyMechanics();
			hitpointBar.setVisible(false);
		}
	}

	public void receiveDamage(double dmg) {
		hitpoints -= dmg;
	}

	public abstract void specialMechanic(long now);

	public abstract void destroyMechanics();

	public double getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(double hitpoints) {
		this.hitpoints = hitpoints;
	}

	public String getFlying() {
		return flying;
	}
	public boolean isImportant() {
		return important;
	}

	
}
