//Manohar Chitoda
//Suraj Upadhyay
package view;

import java.io.IOException;


import app.Song;
import app.SongLibFunc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayController
{
	@FXML ListView<Song> vlist;
	@FXML Label songlb, artistlb, yearlb, albumlb;
	@FXML Button add, delete, edit;
	static ObservableList<Song> obs;
	
	
	public void start() throws IOException
	{
		obs = FXCollections.observableArrayList(SongLibFunc.songList);
	
		vlist.setItems(obs);
		
		vlist.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> 
        selected());
		
		//vlist.getFocusModel().focus(0);
		vlist.getSelectionModel().selectFirst();
	}
	
	@FXML
	public void buttonClicked(ActionEvent e) throws IOException
	{
		if(e.getSource() == add)
		{
			
			BorderPane n = FXMLLoader.load(getClass().getResource("/view/AddSongs.fxml"));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene newScene= new Scene(n);
			stage.setScene(newScene);
			stage.show();
		}else if(e.getSource() == delete)
		{
			BorderPane n = FXMLLoader.load(getClass().getResource("/view/DeleteSong.fxml"));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene newScene= new Scene(n);
			stage.setScene(newScene);
			stage.show();
		}else if(e.getSource() == edit)
		{
			BorderPane n = FXMLLoader.load(getClass().getResource("/view/EditSong.fxml"));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene newScene= new Scene(n);
			stage.setScene(newScene);
			stage.show();
		}
	}
	
	public void selected()
	{
		if(!obs.isEmpty())
		{
			songlb.setText(vlist.getSelectionModel().getSelectedItem().getSong());
			artistlb.setText(vlist.getSelectionModel().getSelectedItem().getArtist());
			yearlb.setText(vlist.getSelectionModel().getSelectedItem().getYear());
			albumlb.setText(vlist.getSelectionModel().getSelectedItem().getAlbum());
		}
	}
}
