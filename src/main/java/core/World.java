package core;

import java.io.File;
import java.util.Deque;
import java.util.List;
import java.util.Set;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.lowerpanel.InformationCell;
import ui.lowerpanel.StateMenu;

public class World {

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 500;
	public static final int WINDOW_WIDTH = WIDTH;
	public static final int WINDOW_HEIGHT = HEIGHT + 100;
	public static int TILE_SIDE = 1;
	public static int TILES_AMOUNT_WIDTH = WIDTH / TILE_SIDE; // 28
	public static int TILES_AMOUNT_HEIGHT = HEIGHT / TILE_SIDE; // 14
	public static final int LEVEL_AMOUNT = 5;
	public static final String resourcesAddress = "src"+File.separator+"main"+File.separator+"resources";

	public static double dist(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}


	public static Field field;
	public static boolean lose;
	public static boolean win;
	public static boolean started;
	public static boolean greetingClosed;
	public static boolean actionHappens;
	public static boolean startLevel;
	public static boolean closeWindows;
	public static boolean activePause;
	public static int selectedLevel;

	public static Set<Bullet> bullets;
	public static Set<Enemy> enemies;
	public static Set<Tower> towers;
	public static Set<Miner> miners;
	public static Deque<Enemy> enemyStack;
	public static Deque<Long> timeForDestroying;

	public static long time;
	public static long pause;
	public static long fullPauseTime;
	public static long start;
	public static long gold;
	public static long[] cost;
	public static long goldInterval = 5_000_000_000L;
	public static long goldIncome = 30;
	public static long defaultGoldIncome = 30;

	public static Set<Stage> infowindows;
	public static Group root;
	public static Stage mainStage;
	public static Scene mainScene;
	public static StateMenu bottomMenu;
	public static List<InformationCell> cells;

	// TODO music
	// TODO configuration
	// TODO save
	// What should I do to make interesting game?
	// TODO The hardest, graphics
	// TODO List of upgrades in the right part of screen? // Nah, my system of
	// upgrades is suitable enough
	// TODO Very optional, some plot
	// TODO Greeting in the beginning of level
	// What about gui?
	// TODO Tutorial?

}
