package ui.window;

import javafx.scene.input.MouseEvent;
import types.cell.Buildable;
import ui.BuildDescription;
import ui.UpgradeWindow;
import ui.description.BigBombDescription;
import ui.description.MiddleBombDescription;
import ui.description.SmallBombDescription;

import java.util.ArrayList;

import core.Bomb;

public class BombListWindow extends UpgradeWindow<Bomb> {

	static ArrayList<BuildDescription<Bomb>> alts;
	static {
		alts = new ArrayList<BuildDescription<Bomb>>();
		alts.add(new SmallBombDescription());
		alts.add(new MiddleBombDescription());
		alts.add(new BigBombDescription());
	}

	public BombListWindow(MouseEvent event, Buildable<Bomb> caller) {
		super(event, caller, alts);
	}
}