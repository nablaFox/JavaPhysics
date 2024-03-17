package simulation.bullet;

import main.InputPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class BulletControls extends HBox {
	BulletSimulation simulation;

	public BulletControls(BulletSimulation simulation) {
		super();
		this.simulation = simulation;

		setPrefHeight(100);
		addControls();
	}

	private void addControls() {
		setSpacing(10);

		setPadding(new Insets(10, 10, 10, 10));

		setStyle("-fx-alignment: center;");

		getChildren().add(new InputPane(
				"Initial Velocity",
				simulation.getBullet().initialV + "",
				(oldValue, newValue) -> {
					simulation.getBullet().updateInitialV(Double.parseDouble(newValue));
				}));

		getChildren().add(new InputPane(
				"Angle",
				simulation.getBullet().angle + "",
				(oldValue, newValue) -> {
					simulation.getBullet().updateAngle(Double.parseDouble(newValue));
				}));

		Button fireButton = new Button("Fire");
		fireButton.setOnAction(e -> {
			simulation.fire = true;
		});
		getChildren().add(fireButton);

		Button stopButton = new Button("Stop simulation");
		stopButton.setOnAction(e -> {
			simulation.stop();
		});
		getChildren().add(stopButton);

		Button resumeButton = new Button("Resume simulation");
		resumeButton.setOnAction(e -> {
			simulation.start();
		});
		getChildren().add(resumeButton);
	}
}
