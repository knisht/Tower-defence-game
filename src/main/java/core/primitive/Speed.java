package core.primitive;

public class Speed {
	private double speedX;
	private double speedY;
	
	public Speed(double speedX, double speedY) {
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	public double getSpeedX() {
		return speedX;
	}
	
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	
	public double getSpeedY() {
		return speedY;
	}
	
	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	public Speed scale(double factor) {
		return new Speed(speedX*factor, speedY*factor);
	}
	
}
