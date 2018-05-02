package core;

import java.io.File;
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
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		root = new Group();

		primaryStage.setTitle("Hard tower defence");

		TableScreen.showStartScreen(root);

		mainStage.show();
		started = false;
		greetingClosed = false;
		started = true;
		actionHappens = false;
		closeWindows = false;

		AnimationTimer startScreen = new AnimationTimer() {

			@Override
			public void handle(long now) {

				if (greetingClosed) {
					initStartValues();
				}

				if (actionHappens && !activePause) {
					actionLoop(now);
				}

				if (activePause) {
					if (pause != 0)
						fullPauseTime += now - pause;
					pause = now;
				} else {
					pause = 0;
				}

				if (startLevel) {
					startLevel = false;
					win = false;
					lose = false;
					actionHappens = true;
					initStartValues();
				}

				if (closeWindows) {
					primaryStage.close();
					stop();
				}

			}

		};

		startScreen.start();
	}

	private void initStartValues() {
		root = new Group();
		field = new Field("data" + File.separator);
		mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		mainStage.setScene(mainScene);
		bottomMenu = new StateMenu();
		bottomMenu.addCells();
		bullets = new LinkedHashSet<>();
		towers = new LinkedHashSet<>();
		enemies = new LinkedHashSet<>();
		miners = new LinkedHashSet<>();
		infowindows = new LinkedHashSet<>();
		cost = new long[10];
		goldtime = -1;
		gold = 0;
		goldIncome = defaultGoldIncome;
		pause = 0;
		fullPauseTime = 0;

		mainScene.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.P)
				activePause = Boolean.logicalXor(activePause, true);
		});

		greetingClosed = false;
		actionHappens = true;

	}

	private void actionLoop(long now) {
		time = now - fullPauseTime;
		if (goldtime == -1) {
			start = time;
			goldtime = time;
		}
		while (!enemyStack.isEmpty() && (time - start) > timeForDestroying.peek()) {
			Enemy newEnemy = enemyStack.removeFirst();
			timeForDestroying.removeFirst();
			enemies.add(newEnemy);
			root.getChildren().add(newEnemy);
		}
		for (Tower tower : towers) {
			Bullet bullet = tower.shoot(time);
			if (bullet != null) {
				bullets.add(bullet);
			}
		}
		if (time - goldtime > goldInterval) {
			gold += goldIncome;
			goldtime = time;
		}
		for (Bullet a : bullets) {
			a.move();
		}
		int aliveAmount = 0;
		for (Enemy enemy : enemies) {
			if (enemy.alive())
				++aliveAmount;
			enemy.move(now);
		}
		if (aliveAmount == 0 && enemyStack.isEmpty()) {
			win = true;
		}
		if (win || lose) {
			actionHappens = false;
			root = new Group();
			if (win) {
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
