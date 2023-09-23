package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.collisionneur.CollisionneurAbstrait;
import modele.world.Personnage;

public abstract class DeplaceurAbstrait {
        protected CollisionneurAbstrait leCollisionneur;
        private static final int PAS = 25;
        private int hauteurMax;

        public DeplaceurAbstrait(CollisionneurAbstrait collisionneur) {

            leCollisionneur = collisionneur;
        }

        public abstract void courirDroite(Personnage perso);

        public abstract void setNumSaut(int numSaut);
        public abstract void courirGauche(Personnage perso);

        public abstract void sauter(Personnage perso);

        public abstract void gravite(Personnage perso);

        public abstract boolean isJumping();
        public abstract void setJumping(boolean jumping);
}

