package viewManage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import launcher.Launcher;
import modele.manager.Manager;
import view.MainWindow;
import view.Niveau;
import view.TableauScore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Classe qui permet le changement de page sur le jeu
 */
public class Navigator {

    public void goToMainWindow(Stage stage) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml")));
        scene.getStylesheets().add(getClass().getResource("/CSS/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goToNiveau(Stage primaryStage) throws IOException{ //public void goToNiveau() throws IOException{
        Manager man = Launcher.getManager();
        //Stage primaryStage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/Niveau.fxml")));
        scene.getStylesheets().add(getClass().getResource("/CSS/style.css").toExternalForm());
        primaryStage.setScene(scene);
        scene.setOnKeyPressed(keyEvent -> man.deplace(keyEvent.getCode()));
        primaryStage.show();
    }


    public void goToScore(Stage stage) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/TableauScore.fxml")));
        scene.getStylesheets().add(getClass().getResource("/CSS/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


}
