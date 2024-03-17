package simulation;

import simulation.bullet.BulletSimulation;

// TODO: keep state of previous simulations
public class SimulationFactory {
	public BulletSimulation createBulletSimulation(Physics physics) {
		return new BulletSimulation(physics);
	}

	public BulletSimulation createBulletSimulation(
			Physics physics,
			double initialV,
			double angle) {
		return new BulletSimulation(physics, initialV, angle);
	}

	public Simulation create(String name, Physics physics) {
		switch (name) {
			case "Ballistics":
				return createBulletSimulation(physics);
		}

		return null;
	}
}
