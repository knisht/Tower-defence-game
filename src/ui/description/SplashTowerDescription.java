package ui.description;

import core.Tower;
import types.tower.SplashTower;
import ui.BuildDescription;

public class SplashTowerDescription extends BuildDescription<Tower> {
	public SplashTowerDescription() {
		super(SplashTower.src, "Splash tower", "Cost: " + SplashTower.cost, "Damage: " + SplashTower.bullet.damage,
				"Range: " + SplashTower.range);
	}

	@Override
	public SplashTower forge(double x, double y) {
		return new SplashTower(x, y);
	}
}
