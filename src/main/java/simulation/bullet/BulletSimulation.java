package simulation.bullet;

import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import simulation.AbstractSimulation;

public class BulletSimulation extends AbstractSimulation {
	Bullet bullet;
	boolean fire = false;

	@Override
	public void simulate(double dt) {
		if (!isSimulating)
			return;
	}

	public BulletSimulation(Stage stage) {
		this(stage, 0, 0);
	}

	public BulletSimulation(Stage stage, double initialV, double angle) {
		this.bullet = new Bullet(initialV, angle);

		BorderPane root = new BorderPane();

		root.setBottom(new BulletControls(this));
		root.setPadding(new Insets(100, 0, 0, 0));

		Pane bulletPane = new Pane();
		bulletPane.setStyle("-fx-background-color: #000000;");
		bulletPane.getChildren().add(new Bullet(initialV, angle));

		root.setCenter(bulletPane);

		stage.setScene(new Scene(root));
		stage.show();
	}
}
