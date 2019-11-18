//Manohar Chitoda
//Suraj Upadhyay
package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditController
{
	DisplayController disp;
	@FXML Button saveEdit;
	@FXML Button cancel;
	@FXML TextField song;
	@FXML TextField artist;
	@FXML TextField year;
	@FXML TextField album;
	
	public void buttonClicked(ActionEvent e) throws IOException
	{
		if(e.getSource() == saveEdit) 
		{
			//call SongLibFunc.edit(...);
		}else if(e.getSource() == cancel)
		{
			BorderPane n = FXMLLoader.load(getClass().getResource("/view/Display.fxml"));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene newScene= new Scene(n);
			stage.setScene(newScene);
			stage.show();
		}
		
	}
}
