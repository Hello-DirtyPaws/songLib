package app;
	
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.DisplayController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class SongLib extends Application 
{
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		this.primaryStage = primaryStage;
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			@Override
			public void handle(WindowEvent e) 
			{
				try 
				{
					SongLibFunc.printList();
				} catch (FileNotFoundException e1) 
				{
					System.out.println("No File Foud!");
					// e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		
		this.primaryStage.setTitle("Song Library");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/Display.fxml"));
		BorderPane root = (BorderPane)loader.load();
		
		DisplayController disp = loader.getController();
		disp.start();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		primaryStage.show();
	}	
	
	public static void main(String[] args) throws IOException, ParseException 
	{
		SongLibFunc.readNLoad();
		launch(args);
		
		/*
		for(int i = 0; i < 2; i++)
		{
			SongLibFunc.add(""+i, ""+i, ""+i, ""+i);
		}
		
		SongLibFunc.printList();
		*/
	}
}
