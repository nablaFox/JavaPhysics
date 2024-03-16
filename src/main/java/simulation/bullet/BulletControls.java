package simulation.bullet;

import main.InputPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class BulletControls extends HBox {
	BulletSimulation simulation;

	public BulletControls(BulletSimulation simulation) {
		super();
		setPrefHeight(100);
		addControls();

		this.simulation = simulation;
	}

	private void addControls() {
		setSpacing(10);

		setPadding(new Insets(10, 10, 10, 10));

		setStyle("-fx-alignment: center;");

		getChildren().add(new InputPane("Initial Velocity"));
		getChildren().add(new InputPane("Angle"));

		getChildren().add(new Button("Fire"));
		getChildren().add(new Button("Stop simulation"));
	}
}
