package javahw2;
import javahw2.ImageUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MosaicButtonNxN extends Application {
	public int PROWS = 20;
	private MosaicButton[][] tiles = new MosaicButton[PROWS][PROWS];
	private Image tileImage = new Image(getClass().getResourceAsStream("/images/untitledsize.png"));

	int scrHeight = 400;
	int scrWidth = 400;
	int bwidth = scrWidth/20;
	int bheight = scrHeight/20;
	
	private GridPane root;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("NxN Mosaic Button Images");

		root = new GridPane();
		root.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		root.setPrefHeight(scrHeight);
		root.setPrefWidth(scrWidth);
		initialize();

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	void initialize(){

		for (int row = 0 ; row < PROWS ; row++ ){
			RowConstraints rc = new RowConstraints();
			rc.setFillHeight(true);
			rc.setVgrow(Priority.ALWAYS);
			rc.prefHeightProperty().bind(root.prefHeightProperty().divide(20));
			rc.maxHeightProperty().bind(root.maxHeightProperty().divide(20));
			rc.minHeightProperty().bind(root.minHeightProperty().divide(20));
			
			root.getRowConstraints().add(rc);
		}
		for (int col = 0 ; col < PROWS; col++ ) {
			ColumnConstraints cc = new ColumnConstraints();
			cc.setFillWidth(true);
			cc.setHgrow(Priority.ALWAYS);
			cc.prefWidthProperty().bind(root.prefWidthProperty().divide(20));
			cc.maxWidthProperty().bind(root.maxWidthProperty().divide(20));
			cc.minWidthProperty().bind(root.minWidthProperty().divide(20));
			
			root.getColumnConstraints().add(cc);
		}
		for (int row=0; row<PROWS; ++row){
			for (int col=0; col<PROWS; ++col) {
				tiles[row][col] = new MosaicButton();
				tiles[row][col].A = new ImageView(ImageUtils.getSubImage(tileImage, bwidth*row, bheight*col, bwidth, bheight));
				tiles[row][col].B = new ImageView(ImageUtils.getOneColorImage(bwidth, bheight,ImageUtils.getAverageColor(tiles[row][col].A.getImage())));
				
				tiles[row][col].A.fitWidthProperty().bind(tiles[row][col].widthProperty());
				tiles[row][col].A.fitHeightProperty().bind(tiles[row][col].heightProperty());
				tiles[row][col].B.fitWidthProperty().bind(tiles[row][col].widthProperty());
				tiles[row][col].B.fitHeightProperty().bind(tiles[row][col].heightProperty());		
				tiles[row][col].A.fitHeightProperty().bind(tiles[row][col].heightProperty());
				tiles[row][col].A.fitWidthProperty().bind(tiles[row][col].widthProperty());
				tiles[row][col].B.fitHeightProperty().bind(tiles[row][col].heightProperty());
				tiles[row][col].B.fitWidthProperty().bind(tiles[row][col].widthProperty());
				
				tiles[row][col] .prefHeightProperty().bind(root.prefHeightProperty().divide(20));
				tiles[row][col] .prefWidthProperty().bind(root.prefWidthProperty().divide(20));
				tiles[row][col] .maxHeightProperty().bind(root.maxHeightProperty().divide(20));
				tiles[row][col] .maxWidthProperty().bind(root.maxWidthProperty().divide(20));
				tiles[row][col] .minHeightProperty().bind(root.minHeightProperty().divide(20));
				tiles[row][col] .minWidthProperty().bind(root.minWidthProperty().divide(20));
				tiles[row][col].setGraphic(tiles[row][col].A);
				tiles[row][col].setOnAction(e->((MosaicButton)(e.getSource())).imageButton());

				root.add(tiles[row][col], row, col);
			}
		}
	}
}
