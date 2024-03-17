package simulation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

public class MainUI {
	AnchorPane root;
	Stage primaryStage;
	Physics physics;

	public MainUI(Stage primaryStage, Physics physics) {
		this.physics = physics;
		this.primaryStage = primaryStage;
		root = new AnchorPane();

		setCanvas();
		setSimulationControls();
		selectSimulationControl();

		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	void setCanvas() {
		physics.getCanvas().widthProperty().bind(primaryStage.widthProperty());
		physics.getCanvas().heightProperty().bind(primaryStage.heightProperty());

		root.getChildren().add(physics.getCanvas());
	}

	void setSimulationControls() {
		Button start = new Button("Start");
		start.setOnAction(e -> {
			physics.start();
		});

		Button stop = new Button("Stop");
		stop.setOnAction(e -> {
			physics.stop();
		});

		VBox buttons = new VBox();
		buttons.getChildren().addAll(start, stop);
		AnchorPane.setTopAnchor(buttons, 10.0);
		AnchorPane.setLeftAnchor(buttons, 10.0);
		root.getChildren().add(buttons);
	}

	void selectSimulationControl() {
		ComboBox<String> simulationSelector = new ComboBox<>();
		simulationSelector.getItems().addAll("Ballistics", "Pendulum", "Spring");

		simulationSelector.setOnAction(e -> {
			String selected = simulationSelector.getValue();
			if (selected == null)
				return;

			physics.setSimulation(
					physics.getFactory().create(selected, physics));
		});

		AnchorPane.setTopAnchor(simulationSelector, 80.0);
		AnchorPane.setLeftAnchor(simulationSelector, 10.0);
		root.getChildren().add(simulationSelector);
	}

	public void add(Node... children) {
		root.getChildren().addAll(children);
	}

	public void reset() {
		root.getChildren().clear();

		setCanvas();
		setSimulationControls();
		selectSimulationControl();
	}

	// TODO: temp
	public void drawGrid(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}
}
