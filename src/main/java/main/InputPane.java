package main;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputPane extends VBox {

	public InputPane(String label) {
		super();

		setSpacing(10);

		getChildren().add(new Label(label));
		getChildren().add(new TextField());
	}

}
