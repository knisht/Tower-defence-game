package core;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import types.cell.FinishCell;
import types.cell.MinerCell;
import types.cell.ObstacleCell;
import types.cell.RemovableObstacleCell;
import types.cell.SandRoadCell;
import types.cell.SpawnCell;
import types.cell.StraightRoadCell;
import types.cell.TowerCell;
import types.enemy.Boss;
import types.enemy.FastEnemy;
import types.enemy.FatEnemy;
import types.enemy.FlyingFastEnemy;
import types.enemy.FlyingFatEnemy;
import types.enemy.FlyingWeakEnemy;
import types.enemy.HealEnemy;
import types.enemy.WeakEnemy;

import static core.World.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Field extends StackPane {
	public Cell[][] tiles;
	public SpawnCell startCell;

	public Field() {
		super();
		root.getChildren().add(this);
		String levelmappath = new String(
				leveldataDir + File.separator + "levelmap" + Integer.toString(selectedLevel) + ".txt");
		try (Scanner in = new Scanner(new File(levelmappath))) {
			TILE_SIDE = Integer.parseInt(in.nextLine());
			ImageView background = null;
			try {
				background = new ImageView(
						new Image(new FileInputStream(new File(imgDir + File.separator + "stones.jpg"))));
			} catch (FileNotFoundException e) {
				System.err.println("Did not found field background");
			}
			background.setFitHeight(FIELD_HEIGHT);
			background.setFitWidth(FIELD_WIDTH);
			root.getChildren().add(background);
			TILES_AMOUNT_WIDTH = FIELD_WIDTH / TILE_SIDE;
			TILES_AMOUNT_HEIGHT = FIELD_HEIGHT / TILE_SIDE;
			tiles = new Cell[TILES_AMOUNT_WIDTH][TILES_AMOUNT_HEIGHT];
			String[] strField = new String[TILES_AMOUNT_HEIGHT];
			for (int i = 0; i < TILES_AMOUNT_HEIGHT; i++) {
				strField[i] = in.nextLine();
			}
			for (int i = 0; i < TILES_AMOUNT_WIDTH; i++) {
				for (int j = 0; j < TILES_AMOUNT_HEIGHT; j++) {
					char cur = strField[j].charAt(i);
					switch (cur) {
					case '-':
						tiles[i][j] = new ObstacleCell(i, j);
						break;
					case 'O':
						tiles[i][j] = new StraightRoadCell(i, j);
						break;
					case 'Y':
						tiles[i][j] = new SandRoadCell(i, j);
						break;
					case 'F':
						tiles[i][j] = new FinishCell(i, j);
						break;
					case '?':
						tiles[i][j] = new TowerCell(i, j);
						break;
					case 'M':
						tiles[i][j] = new MinerCell(i, j);
						break;
					case 'R':
						tiles[i][j] = new RemovableObstacleCell(i, j);
						break;
					case 'S':
						startCell = new SpawnCell(i, j);
						tiles[i][j] = startCell;
						break;
					}
					root.getChildren().add(tiles[i][j]);
				}
			}
			field = this;
			enemiesStack = new ArrayDeque<>();
			enemiesOutcomeTime = new ArrayDeque<>();
			int n = in.nextInt();
			for (int i = 0; i < n; ++i) {
				int type = in.nextInt();
				if (type == 1)
					enemiesStack.addLast(new WeakEnemy(startCell.x, startCell.y));
				if (type == 2)
					enemiesStack.addLast(new FatEnemy(startCell.x, startCell.y));
				if (type == 3)
					enemiesStack.addLast(new FastEnemy(startCell.x, startCell.y));
				if (type == 4)
					enemiesStack.addLast(new HealEnemy(startCell.x, startCell.y));
				if (type == 5)
					enemiesStack.addLast(new FlyingWeakEnemy(startCell.x, startCell.y));
				if (type == 6)
					enemiesStack.addLast(new FlyingFastEnemy(startCell.x, startCell.y));
				if (type == 7)
					enemiesStack.addLast(new FlyingFatEnemy(startCell.x, startCell.y));
				if (type == 100)
					enemiesStack.addLast(new Boss(startCell.x, startCell.y));
				enemiesOutcomeTime.addLast(in.nextLong() * 1_000_000L);
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + levelmappath);
		}

	}

}
