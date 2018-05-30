package ui.window;

import javafx.scene.input.MouseEvent;
import types.cell.Buildable;
import ui.BuildDescription;
import ui.UpgradeWindow;
import ui.description.SniperTowerDescription;
import ui.description.SplashTowerDescription;

import java.util.ArrayList;

import core.Tower;

public class MiddleTowerWindow extends UpgradeWindow<Tower> {

	static ArrayList<BuildDescription<Tower>> alts;
	static {
		alts = new ArrayList<BuildDescription<Tower>>();
		alts.add(new SplashTowerDescription());
		alts.add(new SniperTowerDescription());
	}

	public MiddleTowerWindow(MouseEvent event, Buildable<Tower> caller) {
		super(event, caller, alts);
	}
}
