package modele.collisionneur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Monde;
import modele.world.Objet;

public abstract class CollisionneurAbstrait {
    protected Monde leMonde;

    public CollisionneurAbstrait(Monde monde) {
        this.leMonde = monde;
    }

    public abstract boolean verifierCollision(double x, double y,String direction);

    public abstract boolean verifierSol(double x, double y);

    public abstract boolean verifierTete(double x, double y);

    public abstract boolean verifierMort(double x, double y);

    public abstract boolean verifierCle(double x, double y);

    public abstract boolean verifierFin(double x, double y);

}
