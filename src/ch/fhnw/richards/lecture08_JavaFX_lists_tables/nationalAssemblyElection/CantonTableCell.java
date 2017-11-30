package ch.fhnw.richards.lecture08_JavaFX_lists_tables.nationalAssemblyElection;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Dieter Holz
 */
class CantonTableCell extends TableCell<Result, String> {
	private static final Map<String, Image> EMBLEMS = new HashMap<>();

	private static final Insets INSETS = new Insets(1, 8, 1, 5);

	@Override
	protected void updateItem(String item, boolean empty) {
		setText("");
		setGraphic(null);
		if (!empty) {
			Image img = EMBLEMS.get(item);
			if (img == null) {
				img = new Image(getClass().getResource("canton_emblems/" + item + ".png")
				                          .toExternalForm(), 18, 18, true, true, true);
				EMBLEMS.put(item, img);
			}

			ImageView imageView = new ImageView(img);

			setGraphic(imageView);
			setTooltip(new Tooltip(item));
			setAlignment(Pos.CENTER);
			setPadding(INSETS);
		}

	}
}
