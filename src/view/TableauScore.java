package view;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import launcher.Launcher;
import persistance.Chargeur;
import persistance.ScoreTesteur;
import viewManage.ManagerView;

public class TableauScore {

    @FXML
    private Button retourButton;

    @FXML
    private Text first;
    @FXML
    private Text seconde;
    @FXML
    private Text third;

    @FXML
    private void retourButtonAction()throws Exception {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        stage.close();
        ManagerView managerView = Launcher.getManagerView();
        managerView.dirigerAction("fermerScore");
    }

    @FXML
    public void initialize() {
        Chargeur ch = new Chargeur();
        ScoreTesteur s = new ScoreTesteur();
        String[][] tab = s.returnTabScore();
        first.setText(tab[0][0] + " - " +tab[0][1]);
        seconde.setText(tab[1][0] + " - " +tab[1][1]);
        third.setText(tab[2][0] + " - " +tab[2][1]);
    }
}
