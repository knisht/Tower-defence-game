package core;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import types.cell.FinishCell;
import types.cell.RoadCell;

import static core.World.*;

public abstract class Enemy extends MovableObject {

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

	public Enemy(String src, double x, double y, Color color, int hitpoints, double absoluteSpeed,
			String flying) {
		super(src, x, y, TILE_SIDE / 2 - 3, color, 0, 0);
		this.hitpointBar = new Rectangle(TILE_SIDE - 2, 2);
		hitpointBar.setFill(Color.RED);
		curpx = field.startCell.wIndex;
		oldpx = curpx;
		curpy = field.startCell.hIndex;
		oldpy = curpy;
		this.currentCell = field.startCell;
		this.hitpoints = hitpoints;
		this.maximumHitpoints = hitpoints;
		this.absoluteSpeed = absoluteSpeed;
		this.flying = flying;
		hitpointBar.relocate(x, y - 5);
		hitpointBar.setVisible(false);
		root.getChildren().add(hitpointBar);
		this.setMouseTransparent(true);
	}

	public void move(long now) {
		if (!alive())
			return;
		hitpointBar.setVisible(true);
		specialMechanic(now);
		if (getX() >= field.tiles[curpx][curpy].x 
				&& getX() + 2 * base.getRadius() <= field.tiles[curpx][curpy].x + TILE_SIDE
				&& getY() >= field.tiles[curpx][curpy].y
				&& getY() + 2 * base.getRadius() <= field.tiles[curpx][curpy].y + TILE_SIDE) {

			if (field.tiles[curpx][curpy] instanceof FinishCell) {
				gameLostState = true;
				return;
			}

			if ((curpx > 0) && !(curpx - 1 == oldpx && curpy == oldpy) && acceptable(field.tiles[curpx - 1][curpy])) {
				oldpx = curpx;
				oldpy = curpy;
				curpx--;
				setSpeedX(-absoluteSpeed);
				setSpeedY(0);
			} else if ((curpx < TILES_AMOUNT_WIDTH - 1) && !(curpx + 1 == oldpx && curpy == oldpy)
					&& acceptable(field.tiles[curpx + 1][curpy])) {
				oldpx = curpx;
				oldpy = curpy;
				curpx++;
				setSpeedX(absoluteSpeed);
				setSpeedY(0);
			} else if ((curpy > 0) && !(curpx == oldpx && curpy - 1 == oldpy)
					&& acceptable(field.tiles[curpx][curpy - 1])) {
				oldpx = curpx;
				oldpy = curpy;
				curpy--;
				setSpeedX(0);
				setSpeedY(-absoluteSpeed);
			} else if ((curpy < TILES_AMOUNT_HEIGHT - 1) && !(curpx == oldpx && curpy + 1 == oldpy)
					&& acceptable(field.tiles[curpx][curpy + 1])) {
				oldpx = curpx;
				oldpy = curpy;
				curpy++;
				setSpeedX (0);
				setSpeedY(absoluteSpeed);
			}

		}
		currentCell = (RoadCell) field.tiles[curpx][curpy];
		this.setX(getX() + getSpeedX() * currentCell.speedRate);
		this.setY(getY() + getSpeedY() * currentCell.speedRate) ;
		super.render();
		hitpointBar.setWidth(hitpoints / maximumHitpoints * (TILE_SIDE - 2));
		hitpointBar.relocate(getX(), getY() - 5);
	}

	public void render() {
		super.relocate(getX() - TILE_SIDE / 2 + 1, getY() - TILE_SIDE / 2 + 1);
	}

	public boolean acceptable(Cell r) {
		return r.available;
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


}
