package view;

import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import launcher.Launcher;
import modele.Monde;
import modele.manager.Manager;
import modele.world.*;
import viewManage.ManagerView;

/**
 * Vue du jeu en lui meme
 */
public class Niveau {
    Image bg = new Image("images/game/blocV2.jpg");
    Image drp = new Image("images/game/porte.png");
    Image perso = new Image("images/game/mariobros.png");
    Image la = new Image("images/game/lava.jpg");
    Image clf = new Image("images/game/cle.png");

    @FXML
    private BorderPane fond;

    private ImageView elementBoy;

    @FXML
    private Button gameButton;

    @FXML
    private ImageView fondEcran;

    /**
     * Lance la partie en mettant en place le monde et les event
     * @throws Exception
     */
    @FXML
    public void initialize() throws Exception {
        fondEcran.setFitWidth(800);
        fondEcran.setFitHeight(600);
        ManagerView manView = Launcher.getManagerView();
        Manager man = Launcher.getManager();

        Image image= new Image("images/game/blocV2.jpg");
        gameButton.setFocusTraversable(false);

        gameButton.setOnMouseClicked(mouseEvent -> {
            try {
                //closeGameAction();
                Stage stage = (Stage) fond.getScene().getWindow();
                Launcher.getManager().setScoreJoueur(Launcher.getManager().getLeScore().getScore() - Launcher.getManager().getLeScore().getScore());
                stage.close();
                manView.dirigerAction("quitter");
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        for (Objet o : Launcher.getManager().getListObjet()) {
            if(o.getClass()==Bloc.class) image=bg;
            else if (o.getClass()==Lave.class) image=la;
            else if (o.getClass()==Cle.class) image=clf;
            else if (o.getClass()== Porte.class) image=drp;

            miseAJour(o, image);
            System.out.println(o);
        }


        Launcher.getManager().getLaCle().activeProperty().addListener((obs, wasActive, nowActive) -> {
            if (!nowActive) {
                recupCleAction();
                System.out.println("clé recupéré (niveau)");
            }
        });

    }


    /**
     * Permet de mettre à jour la vue (vide) en ajoutant les entites
     * @param o
     * @param image
     */
    public void miseAJour(Objet o, Image image) {
        if (o.getClass() == Personnage.class) {
            Text nom = new Text();
            nom.textProperty().bindBidirectional((Property<String>) Launcher.getManager().getLeScore().pseudoProperty());
            nom.setX(300);
            nom.setY(10);

            Text score = new Text();
            score.textProperty().bind(Launcher.getManager().getLeScore().scoreProperty().asString());
            score.setX(300);
            score.setY(30);
            score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC,20));

            ImageView monPerso = new ImageView();
            monPerso.setImage(perso);
            monPerso.setFitWidth(Launcher.getManager().getLePerso().getMaxWidth());
            monPerso.setFitHeight(Launcher.getManager().getLePerso().getMaxHeight());
            monPerso.layoutXProperty().bind(o.xProperty());
            monPerso.layoutYProperty().bind(o.yProperty());
            fond.getChildren().add(monPerso);
            fond.getChildren().add(nom);
            fond.getChildren().add(score);
        }
        else {
            ImageView objet = new ImageView(image);
            objet.setFitWidth(Launcher.getManager().getLeMonde().getMaxWidth());
            objet.setFitHeight(Launcher.getManager().getLeMonde().getMaxHeight());
            objet.setX(o.getX());
            if (o.getClass() == Lave.class) objet.setY(o.getY() + 15);
            else objet.setY(o.getY());
            if(o.getClass()==Cle.class) objet.setUserData("cleASuppr");
            fond.getChildren().add(objet);
        }

    }


    /**
     * Permet de rendre invisible la clé apres sa recupération
     * Regret : methode qui doit etre dans le ManagerView mais problème pas résolu en la deplacant
     */
    public void recupCleAction() {
        for (Node monNode : fond.getChildren()) {
            if (monNode.getUserData() != null) {
                if (monNode.getUserData().toString() == "cleASuppr") {
                    monNode.setVisible(false);
                }
            }
        }

    }

    public BorderPane getFond() {
        return fond;
    }
}
