package engine;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Engine {
	boolean isSimulating = false;
	double width, height;

	Canvas canvas;
	GraphicsContext gc;
	SimulationLoop loop;
	Constants consts;
	MainUI mainUI;

	Simulation currentSimulation;
	ArrayList<Simulation> simulations;

	public Engine(Stage primaryStage) {
		simulations = new ArrayList<Simulation>();
		loop = new SimulationLoop();
		consts = new Constants();
		canvas = new Canvas();
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

	public void init() {
		mainUI.init();
		start();
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

	public void addSimulation(Simulation simulation) {
		simulation.thisInit(this);
		simulations.add(simulation);
	}

	// very inefficient, hash maps bla bla
	public void setSimulation(String name) {
		for (Simulation sim : simulations) {
			if (sim.name.equals(name)) {
				currentSimulation = sim;
				currentSimulation.init();
				break;
			}
		}
	}

	public ArrayList<String> getSimulationList() {
		ArrayList<String> names = new ArrayList<String>();
		for (Simulation sim : simulations) {
			names.add(sim.name);
		}

		return names;
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
