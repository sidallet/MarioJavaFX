package modele.world;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import modele.world.Objet;

public class Cle extends Objet {

    //Cette propriété permet de supprimer la clé mais va aussi permettre de verifier si clé est supprimée + arrivée = victoire
    //c-a-d si clé == false && position perso est sur le drapeau == niveau fini
    private final BooleanProperty cleActive = new SimpleBooleanProperty();

    public BooleanProperty activeProperty() {
        return cleActive ;
    }

    public final boolean isCleActive() {
        return activeProperty().get();
    }

    public final void setCleActive(boolean cleActive) {
        activeProperty().set(cleActive);
    }

    public Cle(double x, double y) {
        super(x, y);
        setCleActive(true);
    }

}