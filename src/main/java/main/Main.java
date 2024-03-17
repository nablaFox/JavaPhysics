package main;

import simulation.bullet.BulletSimulation;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new BulletSimulation(primaryStage, 50, 45).start();
	}
}
