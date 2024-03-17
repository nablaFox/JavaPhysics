package simulation.bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simulation.Constants;

public class Bullet {
	double angle, initialV, x, y, width, height, angleRad, velocityY, velocityX;

	Bullet(
			double initialX,
			double initialY,
			double bulletWidth,
			double bulletHeight,
			double initialV,
			double angle) {
		this.initialV = initialV;
		width = bulletWidth;
		height = bulletHeight;
		x = initialX;
		y = initialY;

		updateAngle(angle);
	}

	// EDO Solver
	public void updatePos(double dt) {
		velocityY -= Constants.GRAVITY * dt;

		x += velocityX * dt;
		y -= velocityY * dt;
	}

	public void updateInitialV(double velocity) {
		this.initialV = velocity;
		this.velocityY = velocity * Math.sin(angleRad);
		this.velocityX = velocity * Math.cos(angleRad);
	}

	public void updateAngle(double angle) {
		this.angle = angle;
		this.angleRad = Math.toRadians(angle);
		updateInitialV(initialV);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.FIREBRICK);
		gc.fillRect(x, y, width, height);
	}
}
