import engine.Engine;

import javafx.application.Application;
import javafx.stage.Stage;
import simulations.bullet.BulletSimulation;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Engine physicsEngine = new Engine(primaryStage);

		// add the simulations
		physicsEngine.addSimulation(new BulletSimulation());

		physicsEngine.init();
	}
}
