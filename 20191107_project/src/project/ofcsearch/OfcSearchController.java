package project.ofcsearch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import project.AppMain;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class OfcSearchController implements Initializable {
	
	@FXML private AnchorPane main;
	@FXML private StackPane aptlist;
	@FXML private Button btnBack, btnSearch;

	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				try {
					Parent ofclist = FXMLLoader.load(AppMain.class.getResource("ofclist/ofclist.fxml"));
					
					StackPane start = (StackPane)btnSearch.getScene().getRoot();
					start.getChildren().add(ofclist);
					
					ofclist.setTranslateX(350);	
					
					Timeline timeLine = new Timeline();
					KeyValue keyValue = new KeyValue(ofclist.translateXProperty(),0);		
					KeyFrame keyFrame = new KeyFrame(Duration.millis(100),keyValue);	
					timeLine.getKeyFrames().add(keyFrame);
					timeLine.play();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
						
			}
			
		});
		
	}
	
}

