package types.cell;

import static core.World.activePause;
import static core.World.gold;
import static core.World.goldIncome;
import static core.World.root;

import static core.World.miners;

import core.Maps;
import core.Miner;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import types.miner.AdvancedMiner;
import types.miner.SimpleMiner;
import ui.PopUpWindow;
import ui.window.AdvancedMinerWindow;
import ui.window.BasicMinerWindow;
import ui.window.SimpleMinerWindow;

public class MinerCell extends BuildableCell<Miner> implements EventHandler<MouseEvent> {

	private Miner miner;

	private static final String src = "mine.jpg";

	static {
		Maps.storeImage(src);
	}

	public MinerCell(int wIndex, int hIndex) {
		super(src, wIndex, hIndex, Color.DODGERBLUE, true);
		setOnMouseClicked(this);
		this.miner = null;
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton() == MouseButton.SECONDARY && !activePause) {
			PopUpWindow.closeAll();
			if (miner == null) {
				BasicMinerWindow window = new BasicMinerWindow(event, this);
				window.show();
			} else if (miner instanceof SimpleMiner) {
				SimpleMinerWindow window = new SimpleMinerWindow(event, this);
				window.show();
			} else if (miner instanceof AdvancedMiner) {
				AdvancedMinerWindow window = new AdvancedMinerWindow(event, this);
				window.show();
			}
		}
	}

	@Override
	public void build(Miner target) {
		if (gold < target.cost)
			return;
		gold -= target.cost;
		goldIncome += target.income;
		if (miner != null)
			miner.destroy();
		target.x = x;
		target.y = y;
		miners.add(target);
		miner = target;
		miner.cell = this;
		root.getChildren().add(miner);
	}

}
