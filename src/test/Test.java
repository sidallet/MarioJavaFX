package test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Monde;
import modele.collisionneur.Collisionneur;
import modele.creator.levelCreator;
import modele.deplaceur.Deplaceur;
import modele.world.Objet;
import modele.world.Personnage;

public class Test {
    public static void main(String args[]) throws Exception {
    /*
        Personnage perso = new Personnage(0,0,"");
        Monde monde = new Monde();
        Collisionneur collisionneur = new Collisionneur(monde);
        Deplaceur deplaceur = new Deplaceur(collisionneur);

        ObservableList<Objet> objets;
        objets = monde.getObjets();

        //Affichage des entités du monde ///////////////////////////////////////////////////////////////////////////////
        System.out.println(objets);

        //Position de elementBoy
        for(Objet o : objets) {
            if (o instanceof Personnage) {
                perso =(Personnage) o;

            }
        }

        System.out.println(perso);
        System.out.println(perso.getX());
        System.out.println(perso.getY());
        //Deplacement du personnage ////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Un deplacement à droite");
        deplaceur.courirDroite((Personnage) perso);

        //Test collisionneur : doit etre false /////////////////////////////////////////////////////////////////////////
        System.out.println(collisionneur.verifierCollision(perso.getX(),perso.getY(),"DROITE"));

        perso.setX(375);
        System.out.println(perso.getX());
        System.out.println(perso.getY());

        //Test collisionneur : doit etre true (au prochain deplacement donc +25)
        System.out.println(collisionneur.verifierCollision(perso.getX()+25,perso.getY(),"DROITE"));*/
    }
}
