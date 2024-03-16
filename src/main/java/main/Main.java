package main;

import simulation.bullet.BulletSimulation;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public final static double GRAVITY = 9.81;

	@Override
	public void start(Stage primaryStage) {
		new BulletSimulation(primaryStage).start();
	}
}
