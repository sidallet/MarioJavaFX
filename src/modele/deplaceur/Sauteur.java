package modele.deplaceur;

import modele.world.Personnage;

/**
 * Classe qui permet de definir l'algorithme d'un saut
 */
public class Sauteur extends SauteurAbstrait{

    /**
     * Definit la maniere de sauter
     * @param leDeplaceur
     * @param lePerso
     */
    public void sautSimple(DeplaceurAbstrait leDeplaceur, Personnage lePerso) {
        if (leDeplaceur.isJumping() == false) {
            leDeplaceur.setJumping(true);
            leDeplaceur.setNumSaut(20);
            leDeplaceur.sauter(lePerso);
        }
    }


}
