package ui.lowerpanel;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import static core.World.*;

public class EnemyCell extends InformationCell {

	private Text left;
	private Text beforeNext;

	public EnemyCell(double x, double y, double width, double height) {
		super(x, y, width, height);
		left = new Text();
		left.setTextAlignment(TextAlignment.CENTER);
		beforeNext = new Text();
		beforeNext.setTextAlignment(TextAlignment.CENTER);
		VBox box = new VBox(2);
		box.getChildren().add(left);
		box.getChildren().add(beforeNext);
		container.getChildren().add(box);
	}

	@Override
	public void refresh() {
		left.setText("Enemies left: " + enemiesStack.size());
		if (enemiesStack.isEmpty()) {
			beforeNext.setText("Every enemy is on the field!");
		} else {
			beforeNext.setText(
					"Next enemy in " + Long.toString((enemiesOutcomeTime.peek() - actionTime + startMoment) / 1_000_000_000L) + "."
							+ Long.toString(((enemiesOutcomeTime.peek() - actionTime + startMoment) / 1_000_000L) % 1000) + "s");
		}
	}

}
