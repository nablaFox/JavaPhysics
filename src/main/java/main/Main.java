package main;

import javafx.application.Application;
import javafx.stage.Stage;
import simulation.Physics;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new Physics(primaryStage).start();
	}
}
