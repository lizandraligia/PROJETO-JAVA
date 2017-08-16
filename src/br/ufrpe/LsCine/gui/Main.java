package br.ufrpe.LsCine.gui;
	
import br.ufrpe.LsCine.negocio.Fachada;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			this.root = FXMLLoader.load(getClass().getResource("/br/ufrpe/LsCine/gui/Login.fxml"));
			Scene scene = new Scene(root,750,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("LsCine");
			primaryStage.getIcons().add(new Image("/br/ufrpe/LsCine/imagens/Logo.png"));
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static BorderPane getRoot() { 
		return root; 
	} 
}
