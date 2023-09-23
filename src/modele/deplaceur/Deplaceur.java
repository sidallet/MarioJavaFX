package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.collisionneur.CollisionneurAbstrait;
import modele.world.Personnage;

/**
 * Classe pour deplacer le personnage
 */
public class Deplaceur extends DeplaceurAbstrait  {

    private static final int PAS = 25;
    private int hauteurMax;
    private boolean isJumping = false;
    private int numSaut = 0;
    private double pasGravite=2;

    public Deplaceur(CollisionneurAbstrait leCollisionneur) {
        super(leCollisionneur);
    }

    /**
     * Permet le deplacement a droite
     * @param perso
     */
    public void courirDroite(Personnage perso) {
        if(!leCollisionneur.verifierCollision(perso.getPersonnageX()+PAS,perso.getPersonnageY(),"DROITE"))
            perso.setX(perso.getPersonnageX()+PAS);
    }

    /**
     * Permet le deplacement a gauche
     * @param perso
     */
    public void courirGauche(Personnage perso) {
        if(!leCollisionneur.verifierCollision(perso.getPersonnageX()-PAS,perso.getPersonnageY(),"GAUCHE"))
            perso.setX(perso.getPersonnageX()-PAS);
    }

    /**
     * Permet de sauter
     * @param perso
     */
    public void sauter(Personnage perso) {
        if (numSaut!=0) {
            numSaut--;
        }

        if (numSaut > 0) {
            if (!leCollisionneur.verifierTete(perso.getPersonnageX(),perso.getPersonnageY()-Math.round(numSaut*0.9))) {
                perso.setY(perso.getPersonnageY() - Math.round(numSaut * 0.9)); //Coefficient permettant de faire un saut progressif : rapide puis lent
            }
            else {
                numSaut=0;
            }
        }

    }

    /**
     * Permet au personnage de descendre (=gravite)
     * @param perso
     */
    public void gravite(Personnage perso) {

        if (!leCollisionneur.verifierSol(perso.getPersonnageX(),perso.getPersonnageY() + pasGravite)) {
            perso.setY(perso.getPersonnageY() + pasGravite);
            isJumping=true;
        }
        else {
            pasGravite=2;
            isJumping=false;
        }

    }

    public boolean isJumping() {
        return isJumping;
    }

    public int numSaut() {
        return numSaut;
    }

    public void setNumSaut(int numSaut) {
        this.numSaut = numSaut;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }
}
