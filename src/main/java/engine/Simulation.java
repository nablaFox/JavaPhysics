package engine;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

abstract public class Simulation {
	abstract public void simulate(double dt);

	abstract public void init();

	protected double width, height;

	protected Engine physics;
	protected Canvas canvas;
	protected GraphicsContext gc;
	protected MainUI mainUI;
	protected Constants consts;

	String name;

	void thisInit(Engine phyiscsEngine) {
		this.physics = phyiscsEngine;
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

	public Simulation(String name) {
		this.name = name;
	}
}
