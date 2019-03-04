package javahw2;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MosaicButton extends Button {
	public ImageView A;
	public ImageView B;
	public boolean clicked = true;
	
	public void imageButton() {
		if (clicked) {
			this.setGraphic(B);
			clicked = false;
		} else {
			this.setGraphic(A);
			clicked = true;
		}
	}
	}