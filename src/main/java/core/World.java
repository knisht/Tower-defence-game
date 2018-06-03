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

	public static final int FIELD_WIDTH = 1000;
	public static final int FIELD_HEIGHT = 500;
	public static final int WINDOW_WIDTH = FIELD_WIDTH;
	public static final int WINDOW_HEIGHT = FIELD_HEIGHT + 100;
	public static int TILE_SIDE = 1;
	public static int TILES_AMOUNT_WIDTH = FIELD_WIDTH / TILE_SIDE;
	public static int TILES_AMOUNT_HEIGHT = FIELD_HEIGHT / TILE_SIDE;
	public static final int LEVEL_AMOUNT = 5;
	public static final String sources = "src" + File.separator + "main";
	public static final String resources = sources + File.separator + "resources";
	public static final String imgDir = resources + File.separator + "img";
	public static final String leveldataDir = resources + File.separator + "data";

	public static Field field;
	public static boolean gameLostState;
	public static boolean gameWonState;
	public static boolean actionStartedState;
	public static boolean greetingClosed;
	public static boolean actionHappensState;
	public static boolean levelStarted;
	public static boolean windowsClosed;
	public static boolean activePause;
	public static int selectedLevel;

	public static Set<Bullet> bullets;
	public static Set<Enemy> enemies;
	public static Set<Tower> towers;
	public static Set<Miner> miners;
	public static Set<Bomb> bombs;
	public static Deque<Enemy> enemiesStack;
	public static Deque<Long> enemiesOutcomeTime;

	public static long actionTime;
	public static long currentPauseTime;
	public static long fullPauseTime;
	public static long startMoment;
	public static long goldAmount;
	// public static long[] cost;
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
	// TODO Bomb explosion
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
