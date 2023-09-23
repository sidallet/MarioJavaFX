package viewManage;
import javafx.stage.Stage;
import launcher.Launcher;
import modele.manager.Manager;
import persistance.Chargeur;
import view.MainWindow;
import view.Niveau;
import view.TableauScore;

import java.io.IOException;


/**
 * Classe qui gère tout le code behind
 */
public class ManagerView {
    private Navigator navigator;
    private TableauScore tableauScore;
    private MainWindow mainWindow;
    private Niveau fondNiv;
    private Stage stage;

    public ManagerView() {
        navigator=new Navigator();
        stage=new Stage();
        mainWindow=new MainWindow();
        fondNiv=new Niveau();

        //Ajout d'un listener sur une propriété specifique a un objet (perso)
        Launcher.getManager().getLePerso().gameEndedProperty().addListener((obs, gameWasEnded, gameIsNowEnded) -> {
            if (gameIsNowEnded) {
                try {
                    closeGameAction();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
        Launcher.getManager().getLaCle().activeProperty().addListener((obs, wasActive, nowActive) -> {
            if (!nowActive) {
                recupCleAction();
                System.out.println("clé recupéré (niveau)");
            }
        });*/
    }

    /**
     * Permet de diriger l'action dans les bonnes mthodes
     * @param action
     * @throws Exception
     */
    public void dirigerAction(String action) throws Exception {

        switch (action){
            case "quitter":
                stage.close();
                this.closeGameAction();
                break;
            case "jouer":
                this.play();
                break;
            case "fermerScore":
                this.fermerScore();
                break;
            case "score":
                this.openScore();
                break;
           /* case "debutPartie":
                this.initializeGame();
                break;*/
        }
    }

    /**
     * Permet d'ouvrir la fenetre de score
     * @throws IOException
     */
    public void openScore() throws IOException {
        navigator.goToScore(stage);
    }


    /**
     * Gere l'action de terminer le jeu
     * @throws IOException
     */
    public void closeGameAction() throws IOException {
        //Stage stage = (Stage) fondNiv.getFond().getScene().getWindow();
        Launcher.getManager().stopBoucleur();
        Launcher.getManager().getLaCle().setCleActive(true);
        Launcher.getManager().getLePerso().setGameEnded(false);
        Launcher.getManager().getLePerso().setX(0);
        Launcher.getManager().getLePerso().setY(400);
        Launcher.getManager().setScoreJoueur(2000);
        navigator.goToMainWindow(stage);


    }

    /**
     * Permet de lancer le jeu
     * @throws Exception
     */

    private void play() throws Exception{
        Manager man = Launcher.getManager();
        man.startBoucleur();
        man.setPseudoJoueur(mainWindow.getPseudoJoueur());
        navigator.goToNiveau(stage);
    }

    /*
    public void recupCleAction() {

        for (Node monNode : fondNiv.getFond().getChildren()) {
            if (monNode.getUserData() != null) {
                if (monNode.getUserData().toString() == "cleASuppr") {
                    monNode.setVisible(false);
                }
            }
        }

    }*/

    /**
     * Permet de fermer la fenetre des scores
     * @throws IOException
     */
    public void fermerScore() throws IOException {
        navigator.goToMainWindow(stage);

    }




}
