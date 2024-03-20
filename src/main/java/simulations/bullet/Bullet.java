package simulations.bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet {
	double angle, initialV, x, y, width, height, angleRad, velocityY, velocityX, gravity;

	Bullet(
			double initialX,
			double initialY,
			double bulletWidth,
			double bulletHeight,
			double initialV,
			double angle,
			double gravity) {
		this.initialV = initialV;
		this.gravity = gravity;
		width = bulletWidth;
		height = bulletHeight;
		x = initialX;
		y = initialY;

		updateAngle(angle);
	}

	// EDO Solver
	public void updatePos(double dt) {
		velocityY -= gravity * dt;

		x += velocityX * dt;
		y += velocityY * dt;
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

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.FIREBRICK);
		gc.fillRect(x + 10, gc.getCanvas().getHeight() - height - 30 - y, width, height);
	}
}
