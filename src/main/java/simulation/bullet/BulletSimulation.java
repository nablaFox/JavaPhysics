package simulation.bullet;

import simulation.Physics;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.InputPane;

public class BulletSimulation extends simulation.Simulation {
	Bullet bullet;
	boolean fire = false;

	@Override
	public void simulate(double dt) {
		bullet.draw(gc);

		if (!bulletAtBottom() && fire)
			bullet.updatePos(dt);
	}

	public BulletSimulation(Physics physics) {
		this(physics, 80, 45);
	}

	public BulletSimulation(
			Physics physics,
			double initialV,
			double angle) {
		super(physics);

		this.bullet = new Bullet(
				0,
				0,
				30,
				30,
				initialV,
				angle,
				consts.getGravity());

		setControls();
	}

	void setControls() {
		VBox controls = new VBox();
		controls.setSpacing(10);

		Button fireButton = new Button("Fire");
		fireButton.setOnAction(e -> {
			fire = true;
		});
		controls.getChildren().add(fireButton);

		controls.getChildren().add(new InputPane(
				"Initial Velocity",
				bullet.initialV + "",
				(oldValue, newValue) -> {
					bullet.updateInitialV(Double.parseDouble(newValue));
				}));

		controls.getChildren().add(new InputPane(
				"Angle",
				bullet.angle + "",
				(oldValue, newValue) -> {
					bullet.updateAngle(Double.parseDouble(newValue));
				}));

		AnchorPane.setTopAnchor(controls, 10.0);
		AnchorPane.setRightAnchor(controls, 10.0);
		mainUI.add(controls);
	}

	public boolean bulletAtBottom() {
		return bullet.y < 0;
	}

	public boolean bulletAtLeft() {
		return bullet.x == 0;
	}

	Bullet getBullet() {
		return bullet;
	}
}
