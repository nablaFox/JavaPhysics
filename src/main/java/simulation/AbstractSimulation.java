package simulation;

import javafx.animation.AnimationTimer;

abstract public class AbstractSimulation {
	SimulationLoop loop;
	protected boolean isSimulating = false;

	public abstract void simulate(double dt);

	public AbstractSimulation() {
		loop = new SimulationLoop();
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

			simulate(deltaTime);
		}
	}

	public void start() {
		isSimulating = true;
		loop.start();
	}

	public void stop() {
		isSimulating = false;
		loop.stop();
	}
}
