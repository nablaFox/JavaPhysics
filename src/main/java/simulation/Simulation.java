package simulation;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

abstract public class Simulation {
	abstract public void simulate(double dt);

	protected double width, height;

	final protected Physics physics;
	final protected Canvas canvas;
	final protected GraphicsContext gc;
	final protected MainUI mainUI;
	protected Constants consts;

	public Simulation(Physics physics) {
		this.physics = physics;
		this.canvas = physics.getCanvas();
		this.gc = canvas.getGraphicsContext2D();
		this.mainUI = physics.getUI();
		this.consts = physics.getConsts();

		canvas.widthProperty().addListener((___, __, newValue) -> {
			this.width = newValue.doubleValue();
		});

		canvas.heightProperty().addListener((___, __, newValue) -> {
			this.height = newValue.doubleValue();
		});
	}
}
