package simulation;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Physics {
	boolean isSimulating = false;
	double width, height;

	Canvas canvas;
	GraphicsContext gc;
	SimulationLoop loop;
	Constants consts;
	SimulationFactory simulationFactory;
	MainUI mainUI;

	Simulation currentSimulation;

	public Physics(Stage primaryStage) {
		loop = new SimulationLoop();
		consts = new Constants();
		canvas = new Canvas();
		simulationFactory = new SimulationFactory();
		mainUI = new MainUI(primaryStage, this);
		gc = canvas.getGraphicsContext2D();
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

			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			mainUI.drawGrid(gc);

			if (currentSimulation != null)
				currentSimulation.simulate(deltaTime);
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

	public void setSimulation(Simulation simulation) {
		if (simulation == null)
			mainUI.reset();

		currentSimulation = simulation;
	}

	public SimulationFactory getFactory() {
		return simulationFactory;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public MainUI getUI() {
		return mainUI;
	}

	public Constants getConsts() {
		return consts;
	}
}
