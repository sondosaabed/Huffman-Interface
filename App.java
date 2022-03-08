import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class App extends Application {
	public static FileChooser fileChooser;
	public static File file;
	
	@Override
	public void start(Stage stage) {
		//Creating grid pane
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100,80,100,80));
		pane.setHgap(10.5);
		pane.setVgap(10.5); 
		
		//Background Image
		Image img = new Image("key.png");
		BackgroundImage bImg = new BackgroundImage(img,
				BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		pane.setBackground(bGround); 
				
		//Greeting User
		Label label = new Label("                                          Hello user, Select what you want to do to your file...");
		label.setFont(Font.font(16));  
		pane.add(label, 1,0);
				
		//This label will be updated by process of file importing
		Label process = new Label("                                                         Process");
		process.setFont(Font.font(12));  
		process.setTextFill(Color.RED );
		pane.add(process, 1, 1);
		
		//User button to run the program
		Button run = new Button("Run");
		run.setFont(Font.font(14)); 
		run.setTextFill(Color.BLACK);
		run.setPrefSize(100, 30);
		run.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
		
		//User Button to browse file
		Button browse = new Button("Browse"); 
		browse.setFont(Font.font(14)); 
		browse.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
		browse.setTextFill(Color.BLACK);
		browse.setPrefSize(100, 30);
		pane.add(browse , 2,2);
		browse.setOnAction(d-> { 
			Stage stage3 = new Stage();
    		fileChooser = new FileChooser();
    		file=fileChooser.showOpenDialog(stage3); 
			if(file==(null)) {
				process.setText("You haven't chose a file yet!");
				System.out.println("null pointer");
			} else {
				if(readFile(file)==-1) {
					process.setText("----");
				}else {
					GridPane.setHalignment(run,HPos.CENTER);
					pane.add(run, 1, 2);
					process.setText(" ");
					label.setText("             Reday to Process...");
				}
			}
    	});
		
		run.setOnAction(e->{
			Stage stage1 = new Stage();
			GridPane pane1 = new GridPane();
			pane1.setPadding( new Insets(40,150,40,150)); 
		    pane1.setAlignment(Pos.CENTER); 
			pane1.setHgap(10);
			pane1.setVgap(10); 
			BackgroundFill bGroundb1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
			Background bGround1 = new Background(bGroundb1);
			pane1.setBackground(bGround1); 
			
			//Greeting User
			Label label1 = new Label("What do you want to do with your file");
			label1.setFont(Font.font(16));  
			pane1.add(label1, 0,0);
			
	    	//Add a LED Image to the scene
	    	Image img0 = new Image("compress.png");
	    	ImageView v0=new ImageView(img0);
	    	v0.setFitWidth(180);
	    	v0.setFitHeight(180);
	    	
			//User Button to browse file
			Button compress = new Button(""); 
			compress.setFont(Font.font(14)); 
			compress.setStyle("-fx-background-color: transparent;");
			compress.setPrefSize(180, 180); 
			compress.setGraphic(v0);
			pane1.add(compress, 0,1);
			compress.setOnAction(o->{
				Stage stage2 = new Stage();
				GridPane pane2 = new GridPane();
				pane2.setPadding( new Insets( 110,130, 110,130 )); 
			    pane2.setAlignment(Pos.CENTER); 
				pane2.setHgap(10);
				pane2.setVgap(10); 
				pane2.setBackground(bGround1);
				
				//Greeting User
				Label label2 = new Label("Your compressed file is ready to download...");
				label2.setFont(Font.font(16));  
				pane2.add(label2, 0,0);
				
				FileChooser fileChooser = new FileChooser();
		      	fileChooser.setTitle("Save");
		        fileChooser.getExtensionFilters().addAll(new ExtensionFilter(".huffman", "*.*"));

				//User button to download file 
	    		Button btdown = new Button("Download");
	    		btdown.setPrefSize(100, 30);
	    		btdown.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
	    		btdown.setFont(Font.font(16));
		    	pane2.add(btdown, 1, 1);  
		    	btdown.setOnAction(d-> {
		    		fileChooser.showSaveDialog(stage);
		    	});
		    	
				//User button to exit
	    		Button btCancel = new Button("Cancel");
				btCancel.setPrefSize(100, 30);
				btCancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
				btCancel.setFont(Font.font(16));
		    	pane2.add(btCancel, 2, 1);  
		    	btCancel.setOnAction(d-> stage2.close());
		    	
		    	//Scene setting
		    	Scene scene2 = new Scene(pane2); 		
		    	stage2.setTitle("Power source supplied");
				stage2.getIcons().add(new Image("icon.png"));
				stage2.setScene(scene2);  
		    	stage2.show(); 
			});	
			
	    	//Add a LED Image to the scene
	    	Image img1 = new Image("decompress.png");
	    	ImageView v1=new ImageView(img1);
	    	v1.setFitWidth(180);
	    	v1.setFitHeight(180);
	    	
			//User Button to browse file
			Button decompress = new Button(); 
			decompress.setFont(Font.font(14)); 
			decompress.setGraphic(v1);
			decompress.setStyle("-fx-background-color: transparent;");
			decompress.setPrefSize(180, 180); 
			pane1.add(decompress , 1,1);
			decompress.setOnAction(o->{
				Stage stage2 = new Stage();
				GridPane pane2 = new GridPane();
				pane2.setPadding( new Insets( 110,130, 110,130 )); 
			    pane2.setAlignment(Pos.CENTER); 
				pane2.setHgap(10);
				pane2.setVgap(10); 
				pane2.setBackground(bGround1);

				//Greeting User
				Label label2 = new Label("Your decompressed file is ready to download...");
				label2.setFont(Font.font(16));  
				pane2.add(label2, 0,0);
				
				//User button to download file 
	    		Button btdown = new Button("Download");
		    	//btCancel.setTextFill(c4);
	    		btdown.setPrefSize(100, 30);
	    		btdown.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
	    		btdown.setFont(Font.font(16));
		    	pane2.add(btdown, 1, 1);  
		    	btdown.setOnAction(d-> {
		    	
		    	});
		    	
				//User button to exit
	    		Button btCancel = new Button("Cancel");
		    	//btCancel.setTextFill(c4);
				btCancel.setPrefSize(100, 30);
				btCancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
				btCancel.setFont(Font.font(16));
		    	pane2.add(btCancel, 2, 1);  
		    	btCancel.setOnAction(d-> stage2.close());
		    	
		    	//Scene setting
		    	Scene scene2 = new Scene(pane2); 		
		    	stage2.setTitle("Power source supplied");
				stage2.getIcons().add(new Image("icon.png"));
				stage2.setScene(scene2);  
		    	stage2.show(); 
			});	
			//User button to exit
			Button cancel = new Button("Cancel");
			cancel.setFont(Font.font(12)); 
			cancel.setPrefSize(80, 20);
			cancel.setTextFill(Color.BLACK);
			GridPane.setHalignment(cancel,HPos.RIGHT);
			cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
			pane1.add(cancel,1,0); 
			cancel.setOnAction(j -> stage1.close());
			
	    	//Scene setting
	    	Scene scene1 = new Scene(pane1); 		
	    	stage1.setTitle("Choices of Huffman");
			stage1.getIcons().add(new Image("icon.png"));
			stage1.setScene(scene1);  
	    	stage1.show(); 
		});

		//User button to exit
		Button cancel = new Button("Cancel");
		cancel.setFont(Font.font(14)); 
		cancel.setPrefSize(100, 30);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#eba116;");
		cancel.setTextFill(Color.BLACK);
		pane.add(cancel,3,2); 
		cancel.setOnAction(e -> Platform.exit()); 
		
		//Create Scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Huffman Encoding program");
		stage.getIcons().add(new Image("icon.png"));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static int readFile(File input) {
		try {
			 FileReader fileR = new FileReader(input);
		     BufferedReader buffer = new BufferedReader(fileR);
		     buffer.close();
		}catch(NumberFormatException t) {
			System.out.println(t);
		}catch (FileNotFoundException e1) {
			System.out.println(e1);
		}catch (IOException e1) {
			System.out.println(e1);
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
		return 0;
	}
}
