package main;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.function.BiConsumer;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputPane extends VBox {

	public InputPane(String label) {
		this(label, "");
	}

	public InputPane(String label, String defaultValue) {
		this(label, defaultValue, (oldValue, newValue) -> {
		});
	}

	public InputPane(
			String label,
			String defaultValue,
			BiConsumer<String, String> update) {
		super();
		setSpacing(10);

		Label labelNode = new Label(label);
		labelNode.setTextFill(Color.WHITE);
		getChildren().add(labelNode);

		TextField textField = new TextField();
		textField.setText(defaultValue);

		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			textField.setText(newValue);
			if (newValue.isEmpty())
				return;

			update.accept(oldValue, newValue);
		});

		getChildren().add(textField);
	}
}
