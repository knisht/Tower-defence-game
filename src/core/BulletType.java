package core;

import javafx.scene.paint.Color;

public abstract class BulletType {
	public double damage;
	public String imageSource;
	public Color color;
	public double speed;
	public double radius;
	public String damageType;
	public String src = "";

	public abstract boolean hit(double x, double y);
}
