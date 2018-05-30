package ui.window;

import javafx.scene.input.MouseEvent;
import types.cell.Buildable;
import ui.BuildDescription;
import ui.UpgradeWindow;
import ui.description.MiddleTowerDescription;
import ui.description.WeakTowerDescription;

import java.util.ArrayList;

import core.Tower;

public class BasicBuildWindow extends UpgradeWindow<Tower> {

	static ArrayList<BuildDescription<Tower>> alts;
	static {
		alts = new ArrayList<BuildDescription<Tower>>();
		alts.add(new WeakTowerDescription());
		alts.add(new MiddleTowerDescription());
	}

	public BasicBuildWindow(MouseEvent event, Buildable<Tower> caller) {
		super(event, caller, alts);
	}
}
