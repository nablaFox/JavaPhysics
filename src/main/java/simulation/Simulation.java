package simulation;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract public class Simulation {
	protected boolean isSimulating = false;
	protected double width, height;
	protected Color background;
	protected Canvas canvas;
	protected GraphicsContext gc;
	SimulationLoop loop;

	public abstract void simulate(double dt);

	public Simulation(int width, int height, Color background) {
		loop = new SimulationLoop();

		this.width = width;
		this.height = height;
		this.background = background;
		canvas = new Canvas(width, height);
		gc = canvas.getGraphicsContext2D();
		setBackground();
	}

	public class SimulationLoop extends AnimationTimer {
		private long lastTime = 0;

		@Override
		public void handle(long now) {
			if (lastTime == 0) {
				lastTime = now;
				return;
			}

			double deltaTime = (now - lastTime) / 1_000_000_000.0;
			lastTime = now;

			gc.clearRect(0, 0, width, height);
			setBackground();
			simulate(deltaTime);
		}
	}

	public void start() {
		isSimulating = true;
		loop.start();
		loop.lastTime = 0;
	}

	public void stop() {
		isSimulating = false;
		loop.stop();
	}

	private void setBackground() {
		gc.setFill(background);
		gc.fillRect(0, 0, width, height);
	}
}
