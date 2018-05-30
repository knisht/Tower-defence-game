package ui;

import static core.World.*;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TableScreen {

	public static void showWinScreen(Group root) {
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		Rectangle rect = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT);
		rect.setFill(Color.FLORALWHITE);
		Text text = new Text(selectedLevel != LEVEL_AMOUNT ? "YOU WON THIS BATTLE, BUT THE WAR IS NOT OVER!!11oneone"
				: "I congratulate you, but it is not our last meeting...");
		Button exitButton = new Button("Exit");
		Button continueButton = new Button("Go to level " + (Math.min(selectedLevel + 1, LEVEL_AMOUNT)));
		Button replayButton = new Button("Replay this level");
		HBox buttons = new HBox(10, exitButton, continueButton, replayButton);
		buttons.setAlignment(Pos.CENTER);
		VBox box = new VBox(10, text, buttons);
		box.setAlignment(Pos.CENTER);
		StackPane layout = new StackPane(rect, box);
		layout.setAlignment(Pos.CENTER);
		mainStage.setScene(scene);
		exitButton.setOnMouseClicked(event -> windowsClosed = true);
		continueButton.setOnMouseClicked(event -> {
			levelStarted = true;
			selectedLevel++;
		});
		replayButton.setOnMouseClicked(event -> levelStarted = true);
		root.getChildren().add(layout);

	}

	public static void showLoseScreen(Group root) {
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		Rectangle rect = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT);
		rect.setFill(Color.FLORALWHITE);
		Text text = new Text("I expected your fail, and I am never wrong.");
		Button exitButton = new Button("Exit");
		Button replayButton = new Button("Replay this level");
		HBox buttons = new HBox(10, exitButton, replayButton);
		buttons.setAlignment(Pos.CENTER);
		VBox box = new VBox(10, text, buttons);
		box.setAlignment(Pos.CENTER);
		StackPane layout = new StackPane(rect, box);
		layout.setAlignment(Pos.CENTER);
		mainStage.setScene(scene);
		exitButton.setOnMouseClicked(event -> windowsClosed = true);
		replayButton.setOnMouseClicked(event -> levelStarted = true);
		root.getChildren().add(layout);
	}

	static class LevelCell extends StackPane implements EventHandler<MouseEvent> {
		int number;

		public LevelCell(Rectangle rect, Text text, int x) {
			super(rect, text);
			number = x;
		}

		@Override
		public void handle(MouseEvent event) {
			greetingClosed = true;
			selectedLevel = number;
		}
	}

	public static void showStartScreen(Group root) {
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		Rectangle leftRect = new Rectangle(WINDOW_WIDTH / 2, WINDOW_HEIGHT);
		Rectangle rightRect = new Rectangle(WINDOW_WIDTH / 2, WINDOW_HEIGHT);
		leftRect.setFill(Color.FLORALWHITE);
		rightRect.setFill(Color.LIGHTCYAN);
		LevelCell[] levels = new LevelCell[LEVEL_AMOUNT];
		VBox levelBox = new VBox();
		for (int i = 0; i < LEVEL_AMOUNT; ++i) {
			Rectangle localRect = new Rectangle(WINDOW_WIDTH / 2, 50);
			localRect.setFill(Color.SEAGREEN);
			Text localText = new Text("Level " + (i + 1));
			levels[i] = new LevelCell(localRect, localText, i + 1);
			levels[i].setOnMouseClicked(levels[i]);
			levelBox.getChildren().add(levels[i]);
		}
		StackPane rightLayout = new StackPane(rightRect, levelBox);
		HBox primaryLayout = new HBox(leftRect, rightLayout);
		mainStage.setScene(scene);
		root.getChildren().add(primaryLayout);
	}

}
