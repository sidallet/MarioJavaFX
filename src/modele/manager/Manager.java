package modele.manager;

import boucleur.Boucleur;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import modele.Monde;
import modele.collisionneur.CollisionneurAbstrait;
import modele.deplaceur.DeplaceurAbstrait;
import modele.deplaceur.Sauteur;
import modele.deplaceur.SauteurAbstrait;
import modele.world.*;
import modele.collisionneur.Collisionneur;
import modele.deplaceur.Deplaceur;
import persistance.Chargeur;
import persistance.Sauveur;

/**
 * Classe qui gère toutes les actions du modele
 */
public class Manager implements InvalidationListener {
    private Monde leMonde;
    private DeplaceurAbstrait leDeplaceur;
    public Score leScore;
    private Personnage lePerso;
    private Cle laCle;
    private SauteurAbstrait leSauteur;
    private Boucleur leBoucleur;
    private CollisionneurAbstrait leCollisionneur;
    private int timer = 0;
    private int seconde= 50;

    public Manager() throws Exception {

        this.creerMonde();
    }

    /**
     * Instancie toutes les classes essentielles au fonctionnement du jeu
     * @throws Exception
     */
    public void creerMonde() throws Exception {
        leMonde= new Monde();
        leBoucleur=new Boucleur();
        leBoucleur.addListener(this);
        leSauteur = new Sauteur();
        leCollisionneur = new Collisionneur(leMonde);
        leDeplaceur=new Deplaceur(leCollisionneur);
        leScore=new Score();
        lePerso=leMonde.getPersonnage();
        laCle=leMonde.getCle();
    }

    public Monde getLeMonde() {
        return leMonde;
    }


    public Score getLeScore() {
        return leScore;
    }

    public Personnage getLePerso() {
        return lePerso;
    }

    public Cle getLaCle() {
        return laCle;
    }

    public ObservableList<Objet> getListObjet() {
        return leMonde.getObjets();
    }


    /**
     * Recupere l'event de la vue et renvoie les methodes de deplacement, saut
     * @param code
     */
    public void deplace(KeyCode code) {

        switch (code) {
            case D,RIGHT:
                System.out.println("droite");
                leDeplaceur.courirDroite(lePerso);
                break;
            case Q,LEFT:
                System.out.println("gauche");
                leDeplaceur.courirGauche(lePerso);
                break;
            case SPACE,UP:
                leSauteur.sautSimple(leDeplaceur,lePerso);
                break;
        }
    }

    /**
     * Lance le boucleur
     */
    public void startBoucleur() {
        leBoucleur.setActif(true);
        new Thread(leBoucleur).start();
    }

    /**
     * Stop le boulceur
     */

    public void stopBoucleur() {
        leBoucleur.setActif(false);
        this.setTimer(0);

        Sauveur sv = new Sauveur();
        sv.saveScoreToFile();

    }

    public void setPseudoJoueur (String pseudo) {
        leScore.setPseudo(pseudo);
    }

    public void setScoreJoueur (Integer score) {
        leScore.setScore(score);
    }

    public Integer getScoreJoueur() {
        return leScore.getScore();
    }


    public int getSeconde() {
        return seconde;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    /**
     * Cette methode permet grace a la boucle et les listener d'effectuer des opérations avec la boucle
     * @param observable
     */
    @Override
    public void invalidated(Observable observable) {
        leDeplaceur.gravite(lePerso);
        leDeplaceur.sauter(lePerso);

        if (leCollisionneur.verifierMort(lePerso.getX(), lePerso.getY())) {
            this.setScoreJoueur(getScoreJoueur() / 2);
            this.lePerso.setGameEnded(true);
        }

        if (leCollisionneur.verifierCle(lePerso.getX(), lePerso.getY())) {
            if (this.laCle.isCleActive()) {
                this.setScoreJoueur(getScoreJoueur() + 300);
            }
            this.laCle.setCleActive(false);
        }

        if (leCollisionneur.verifierFin(lePerso.getX(), lePerso.getY())) {
            if (this.laCle.isCleActive() == false) {
                this.lePerso.setGameEnded(true);

            }
        }
        //Boucleur dans le boucleur
        if (timer%200==0) {
            if (this.getLeScore().getScore() >  0) {
                this.setScoreJoueur(getScoreJoueur()-seconde);
            }


        }
        timer++;
    }
}
