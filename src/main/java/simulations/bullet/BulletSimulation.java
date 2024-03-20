package simulations.bullet;

import engine.InputPane;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class BulletSimulation extends engine.Simulation {
	Bullet bullet;

	double initialV, angle;
	boolean fire = false;

	@Override
	public void simulate(double dt) {
		bullet.draw(gc);

		if (!bulletAtBottom() && fire)
			bullet.updatePos(dt);
	}

	@Override
	public void init() {
		this.bullet = new Bullet(
				0,
				0,
				30,
				30,
				this.initialV,
				this.angle,
				consts.getGravity());

		setControls();
	}

	public BulletSimulation() {
		this(80, 45);
	}

	public BulletSimulation(
			double initialV,
			double angle) {
		super("Balistics");

		this.initialV = initialV;
		this.angle = angle;
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
}
