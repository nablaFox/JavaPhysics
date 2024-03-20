# Java Physics

The main goal of this project is to create something similar (possibly a 1-to-1 copy) of the
physics engine built in this [video](https://www.youtube.com/watch?v=TtgS-b191V0&t=23s) but with Java.

## How To (Windows)

> [!NOTE] 
> You need [gradle](https://gradle.org/install/) to be installed.

Inside `.` run:

```sh
.\gradlew.bat run
```

(ps: if you're using IntelliJ just try to click on the run button, maybe it will work)

## Simulate!

1. create a package "pendulum" inside `src/main/java/simulations/`
2. the main file of the pendulum package should look something like this:

```java
// we are in src/main/java/simulations/pendulum/SimplePendulumSimulation.java

package pendulum;
import engine.Simulation;

public class SimplePendulumSimulation extends Simulation {
    // ..

    @Override 
    public void init() {
       // ... 
    }

    @Override 
    public void simulate(double deltaTime) {
        pendulum.draw(gc);
        pendulum.updatePos(deltaTime);
        // ..
    }

    public SimplePendulumSimulation() {
        super("Simple Pendulum"); // this is mandatory
        this.initialAngle = 45;
        this.initialVelocity = 10;
        // ...
    }
}
```

Here:

- `init` is called when you toggle between simulations
- `simulate` is called in the main loop of the engine. You can use `deltaTime` to solve your EDO's 
(in the future that should be handled by the engine)

Thanks to the `Simulation` class you have access to:

- `gc`: the [2D Canvas Graphic Context](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/Canvas.html), that you can use to draw objects on the screen
- `width`, `height` of the window
- `consts`: handy physical constants 
- `mainUI`: useful to add javaFX controls of your simulation

3. Add your simulation in the Main.java file:

```java
Engine physicsEngine = new Engine(primaryStage);

// add your simulations
physicsEngine.addSimulation(new SimplePendulumSimulation());

physicsEngine.init();
```

## Todos
