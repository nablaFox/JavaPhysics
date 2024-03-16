package simulation.bullet;

import javafx.scene.shape.Rectangle;
import simulation.Constants;

public class Bullet extends Rectangle {
	double angle, initialV;

	Bullet(double initialV, double angle) {
		super();
		updateInitial(initialV, angle);
	}

	public void updatePos(double dt) {
		double updateX = getX() + initialV * Math.cos(angle) * dt;
		double updateY = getY() + initialV * Math.sin(angle) * dt - 1 / 2 * Constants.GRAVITY * dt * dt;

		setX(updateX);
		setY(updateY);
	}

	public void updateInitial(double initialV, double angle) {
		this.initialV = initialV;
		this.angle = angle;
	}
}
