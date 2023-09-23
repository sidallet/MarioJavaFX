package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import launcher.Launcher;
import modele.manager.Manager;
import viewManage.ManagerView;

import java.io.IOException;

public class MainWindow {
    private final Image marioBros = new Image("images/game/mariobros.png");
    private final Image marioBrosInv = new Image("images/game/mariobrosInv.png");
    private static int i=0;
    private static String textDuField;
    @FXML
    private TextField pseudoJoueur;

    @FXML
    private ImageView mario;

    @FXML
    private ImageView marioInv;

    @FXML
    private Button closeButton;

    @FXML
    private Button scoreButton;

    @FXML
    private Button playButton;

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void openHighScoreButton(ActionEvent e) throws Exception //throws Exception
    {
        ManagerView managerView = Launcher.getManagerView();
        e.consume();
        managerView.dirigerAction("score");
        try {
            this.closeButtonAction();
        } catch (Exception exception) {
            exception.getSuppressed();
        }

    }


    @FXML
    private void play(ActionEvent e) throws Exception{
        ManagerView managerView = Launcher.getManagerView();
        e.consume();
        textDuField=pseudoJoueur.getText();
        managerView.dirigerAction("jouer");
        try {
            this.closeButtonAction();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    @FXML
    public void initialize() {
        ManagerView managerView =Launcher.getManagerView();
        mario.setImage(marioBros);
        marioInv.setImage(marioBrosInv);
        closeButton.setFocusTraversable(false);
        scoreButton.setFocusTraversable(false);


    }



    public String getPseudoJoueur() {
        return textDuField;
    }
}
