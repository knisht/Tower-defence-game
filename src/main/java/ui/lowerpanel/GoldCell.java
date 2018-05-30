package ui.lowerpanel;

import static core.World.*;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GoldCell extends InformationCell {

	private Text amount;
	private Text income;

	public GoldCell(double x, double y, double width, double height) {
		super(x, y, width, height);
		amount = new Text();
		amount.setTextAlignment(TextAlignment.CENTER);
		income = new Text();
		income.setTextAlignment(TextAlignment.CENTER);
		VBox box = new VBox(2);
		box.getChildren().add(amount);
		box.getChildren().add(income);
		container.getChildren().add(box);
	}

	@Override
	public void refresh() {
		amount.setText("Gold available: " + Long.toString(gold));
		income.setText("Current income: " + Long.toString(goldIncome) + " coins every "
				+ Long.toString(goldInterval / 1_000_000_000L) + "." + Long.toString((goldInterval / 1_000_000L) % 1000)
				+ "s");
	}

}
