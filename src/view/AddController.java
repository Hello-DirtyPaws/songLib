//Manohar Chitoda
//Suraj Upadhyay
package view;

import java.io.IOException;

import app.SongLibFunc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AddController
{
	@FXML Button add;
	@FXML Button cancel;
	@FXML TextField song;
	@FXML TextField artist;
	@FXML TextField year;
	@FXML TextField album;
	
	public void buttonClicked(ActionEvent e) throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/Display.fxml"));
		BorderPane root = (BorderPane)loader.load();
		DisplayController disp = loader.getController();
		
		SongLibFunc.add(song.getText(),artist.getText(),year.getText(),album.getText());
		disp.start();
		
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene newScene= new Scene(root);
		stage.setScene(newScene);
		stage.show();
	}
	public void cancel(ActionEvent e) throws IOException
	{
		BorderPane n = FXMLLoader.load(getClass().getResource("/view/Display.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene newScene= new Scene(n);
		stage.setScene(newScene);
		stage.show();
	}
}
