package modele.collisionneur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Monde;
import modele.world.*;

/**
 * Classe qui gere les collisions entre le personnage et les elements du jeu
 * les methodes sont tres ressemblantes mais des petits details et changements sont présents entre chaque classe
 */
public class Collisionneur extends CollisionneurAbstrait {

    private ObservableList<Objet> objets;
    public Collisionneur(Monde leMonde) {
        super(leMonde);
        objets= FXCollections.observableArrayList();
    }


    /**
     * Verifie les collisions a droite et a gauche
     * @param x
     * @param y
     * @param direction
     * @return
     */
    public boolean verifierCollision(double x, double y,String direction) {

        //System.out.println("mario x " + x + " y " + y);
        if (direction == "DROITE") {
            x=x+50; //Largeur personnage
        }
        else if (direction == "GAUCHE"){
            //Rien, x est le debut du perso
        }
        if (x < 0 || x >800) {
            return true;
        }

        this.objets=leMonde.getObjets();
        if (leMonde.getObjets().isEmpty()){
            return false;
        }
        System.out.println("deplacement mario x " + x + " y " + y);
        for (Objet objet: objets) {
            if (!(objet instanceof Personnage || objet instanceof Lave || objet instanceof Cle || objet instanceof Porte)) {
                if ((x > objet.getX() && x < objet.getX()+50 ) && ((y >= objet.getY() && y < objet.getY()+50 ) || (y+50 > objet.getY() && y+50 < objet.getY()+50 ))) {
                    //if ((x > objet.getX() && x < objet.getX()+50 ) && ((y >= objet.getY() && y < objet.getY()+50 ) || (y+50 > objet.getY() && y+50 < objet.getY()+50 ))) {
                    System.out.println(" objet o : x " + objet.getX() + " y " + objet.getY());
                    //System.out.println(objet.toString());
                    System.out.println("collision ");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifie les colllisions au niveau des pieds du personnage
     * @param x
     * @param y
     * @return
     */
    public boolean verifierSol(double x, double y) {
        int hauteurPerso = 50;
        y=y+hauteurPerso;
        this.objets=leMonde.getObjets();
        if (leMonde.getObjets().isEmpty()){
            return false;
        }
        for (Objet objet: objets) {
            if (!(objet instanceof Personnage || objet instanceof Lave || objet instanceof Cle || objet instanceof Porte)) {
                if ((x > objet.getX()-50 && x < objet.getX()+50 ) && (y > objet.getY() && y <objet.getY()+50)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Verifie les collisions sur la tete du personnage
     * @param x
     * @param y
     * @return
     */
    public boolean verifierTete(double x, double y) {
        this.objets=leMonde.getObjets();
        if (leMonde.getObjets().isEmpty()){
            return false;
        }
        for (Objet objet: objets) {
            if (!(objet instanceof Personnage || objet instanceof Lave )) {
                if ((x > objet.getX()-50 && x < objet.getX()+50 ) && (y < objet.getY()+50 && y > objet.getY()  )) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifie si le personnage est en contact de la lave
     * @param x
     * @param y
     * @return bool
     */
    public boolean verifierMort(double x, double y) {
        int hauteurPerso = 50;
        y = y + hauteurPerso;
        this.objets = leMonde.getObjets();
        if (leMonde.getObjets().isEmpty()) {
            return false;
        }
        for (Objet objet : objets) {
            if (objet instanceof Lave) {
                if ((x > objet.getX() - 50 && x < objet.getX() + 50) && (y > objet.getY() && y < objet.getY() + 50)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifie si le personnage est en contact avec la clé
     * @param x
     * @param y
     * @return
     */
    public boolean verifierCle(double x, double y) {
        int hauteurPerso = 50;
        y = y + hauteurPerso;
        this.objets = leMonde.getObjets();
        if (leMonde.getObjets().isEmpty()) {
            return false;
        }
        for (Objet objet : objets) {
            if (objet instanceof Cle) {
                if ( x == objet.getX() && y == objet.getY() + 50) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifie si le personnage est rentré dans la porte
     * @param x
     * @param y
     * @return
     */
    public boolean verifierFin(double x, double y) {
        int hauteurPerso = 50;
        y = y + hauteurPerso;

        this.objets = leMonde.getObjets();
        if (leMonde.getObjets().isEmpty()) {
            return false;
        }
        for (Objet objet : objets) {
            if (objet instanceof Porte) {
                if ( x == objet.getX() && y == objet.getY() + 50) {
                    return true;
                }
            }
        }
        return false;
    }


}

