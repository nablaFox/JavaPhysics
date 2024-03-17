package simulation.bullet;

import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import simulation.Simulation;
import javafx.scene.paint.Color;

public class BulletSimulation extends Simulation {
	Bullet bullet;
	boolean fire = false;

	@Override
	public void simulate(double dt) {
		bullet.draw(gc);

		if (!fire && bulletAtLeft() && bulletAtLeft())
			return;

		if (bulletAtBottom())
			bullet.updatePos(dt);
	}

	public BulletSimulation(Stage stage) {
		this(stage, 0, 0);
	}

	public BulletSimulation(Stage stage, double initialV, double angle) {
		super(800, 500, Color.BLACK);

		this.bullet = new Bullet(0, height - 30, 30, 30, initialV, angle);

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(100, 0, 0, 0));

		root.setCenter(canvas);
		root.setBottom(new BulletControls(this));

		stage.setScene(new Scene(root));
		stage.show();
	}

	public boolean bulletAtBottom() {
		return bullet.getY() <= height - bullet.getHeight();
	}

	public boolean bulletAtLeft() {
		return bullet.getX() == 0;
	}

	Bullet getBullet() {
		return bullet;
	}
}
