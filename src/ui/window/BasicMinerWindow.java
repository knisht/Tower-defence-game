package ui.window;

import javafx.scene.input.MouseEvent;
import types.cell.Buildable;
import ui.BuildDescription;
import ui.UpgradeWindow;
import ui.description.SimpleMinerDescription;

import java.util.ArrayList;

import core.Miner;

public class BasicMinerWindow extends UpgradeWindow<Miner> {

	static ArrayList<BuildDescription<Miner>> alts;
	static {
		alts = new ArrayList<BuildDescription<Miner>>();
		alts.add(new SimpleMinerDescription());
	}

	public BasicMinerWindow(MouseEvent event, Buildable<Miner> caller) {
		super(event, caller, alts);
	}
}