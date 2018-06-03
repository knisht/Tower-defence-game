package core;

import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashSet;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.TableScreen;
import ui.lowerpanel.InformationCell;
import ui.lowerpanel.StateMenu;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import static core.World.*;

public class Main extends Application {

	private long goldtime = -1;

	public static void main(String[] args) {
		try {
			System.setErr(new PrintStream(Maps.log));
		} catch (IOException e) {
			System.out.println("Could not create logger");
		}
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		root = new Group();

		primaryStage.setTitle("Hard tower defence");

		TableScreen.showStartScreen(root);
		mainStage.show();
		actionStartedState = false;
		greetingClosed = false;
		actionStartedState = true;
		actionHappensState = false;
		windowsClosed = false;
		

		AnimationTimer startScreen = new AnimationTimer() {

			long lastFrameMoment = 0;

			@Override
			public void handle(long moment) {
				if (greetingClosed) {
					initStartValues();
				}

				if (actionHappensState && !activePause) {
					if (moment - lastFrameMoment > 15_000_000L) {
						lastFrameMoment = moment;
						actionLoop(moment);
					}
				}

				if (activePause) {
					if (currentPauseTime != 0)
						fullPauseTime += moment - currentPauseTime;
					currentPauseTime = moment;
				} else {
					currentPauseTime = 0;
				}

				if (levelStarted) {
					levelStarted = false;
					gameWonState = false;
					gameLostState = false;
					actionHappensState = true;
					initStartValues();
				}

				if (windowsClosed) {
					primaryStage.close();
					stop();
				}

			}

		};

		startScreen.start();
	}

	private void initStartValues() {
		root = new Group();
		field = new Field();
		mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		mainStage.setScene(mainScene);
		bottomMenu = new StateMenu();
		bottomMenu.addCells();
		bullets = new LinkedHashSet<>();
		towers = new LinkedHashSet<>();
		enemies = new LinkedHashSet<>();
		miners = new LinkedHashSet<>();
		infowindows = new LinkedHashSet<>();
		// cost = new long[10]; why?
		goldtime = -1;
		goldAmount = 0;
		goldIncome = defaultGoldIncome;
		currentPauseTime = 0;
		fullPauseTime = 0;

		mainScene.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.P)
				activePause = Boolean.logicalXor(activePause, true);
		});

		greetingClosed = false;
		actionHappensState = true;

	}

	private void actionLoop(long now) {
		actionTime = now - fullPauseTime;
		if (goldtime == -1) {
			startMoment = actionTime;
			goldtime = actionTime;
		}
		while (!enemiesStack.isEmpty() && (actionTime - startMoment) > enemiesOutcomeTime.peek()) {
			Enemy newEnemy = enemiesStack.removeFirst();
			enemiesOutcomeTime.removeFirst();
			enemies.add(newEnemy);
			root.getChildren().add(newEnemy);
		}
		for (Tower tower : towers) {
			if (tower.active) {
				Bullet bullet = tower.shoot(Instant.now().minus(Duration.ofNanos(fullPauseTime)));
				if (bullet != null) {
					bullets.add(bullet);
				}
			}
		}
		for (Bullet bullet : bullets) {
			bullet.move();
		}
		if (actionTime - goldtime > goldInterval) {
			goldAmount += goldIncome;
			goldtime = actionTime;
		}
		int aliveAmount = 0;
		for (Enemy enemy : enemies) {
			if (enemy.alive())
				++aliveAmount;
			enemy.move(now);
			enemy.render();
		}
		if (aliveAmount == 0 && enemiesStack.isEmpty()) {
			gameWonState = true;
		}
		for (Enemy enemy : enemies) {
			enemy.tryToDie();
		}
		if (gameWonState || gameLostState) {
			actionHappensState = false;
			root = new Group();
			if (gameWonState) {
				TableScreen.showWinScreen(root);
			} else {
				TableScreen.showLoseScreen(root);
			}
		}
		for (InformationCell cell : cells) {
			cell.refresh();
		}

	}

}
