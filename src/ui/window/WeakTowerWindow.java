package ui.window;

import javafx.scene.input.MouseEvent;
import types.cell.Buildable;
import ui.BuildDescription;
import ui.UpgradeWindow;
import ui.description.WeakUpgrDescription;
import ui.description.WeakUpgrFlyingDescription;

import java.util.ArrayList;

import core.Tower;

public class WeakTowerWindow extends UpgradeWindow<Tower> {

	static ArrayList<BuildDescription<Tower>> alts;
	static {
		alts = new ArrayList<BuildDescription<Tower>>();
		alts.add(new WeakUpgrDescription());
		alts.add(new WeakUpgrFlyingDescription());
	}

	public WeakTowerWindow(MouseEvent event, Buildable<Tower> caller) {
		super(event, caller, alts);
	}
}
