package ui.lowerpanel;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static core.World.*;

public class TimeCell extends InformationCell {

	private Text fulltime;
	private Text beforeGold;

	public TimeCell(double x, double y, double width, double height) {
		super(x, y, width, height);
		fulltime = new Text();
		fulltime.setTextAlignment(TextAlignment.CENTER);
		beforeGold = new Text();
		beforeGold.setTextAlignment(TextAlignment.CENTER);
		VBox box = new VBox(1);
		box.getChildren().add(fulltime);
		box.getChildren().add(beforeGold);
		container.getChildren().add(box);
	}

	@Override
	public void refresh() {
		fulltime.setText("Time passed: " + Long.toString((time - start) / 60_000_000_000L) + "m, "
				+ Long.toString(((time - start) / 1_000_000_000L) % 60) + "s, "
				+ Long.toString(((time - start) / 1_000_000L) % 1000) + "ms");
		beforeGold.setText(
				"Next income in " + Long.toString((goldInterval - (time - start) % goldInterval) / 1_000_000_000) + "."
						+ Long.toString(((goldInterval - (time - start) % goldInterval) / 1_000_000) % 1000) + "s");
	}
}
