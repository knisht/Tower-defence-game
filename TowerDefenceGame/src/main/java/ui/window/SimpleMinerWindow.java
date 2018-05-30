package ui.window;

import javafx.scene.input.MouseEvent;
import types.cell.Buildable;
import ui.BuildDescription;
import ui.UpgradeWindow;
import ui.description.AdvancedMinerDescription;

import java.util.ArrayList;

import core.Miner;

public class SimpleMinerWindow extends UpgradeWindow<Miner> {

	static ArrayList<BuildDescription<Miner>> alts;
	static {
		alts = new ArrayList<BuildDescription<Miner>>();
		alts.add(new AdvancedMinerDescription());
	}

	public SimpleMinerWindow(MouseEvent event, Buildable<Miner> caller) {
		super(event, caller, alts);
	}
}