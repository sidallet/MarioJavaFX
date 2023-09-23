package boucleur;



import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public abstract class BoucleurAbstrait implements Runnable, Observable {


    private List<InvalidationListener> lesObservateurs = new ArrayList<>();
    public boolean boucle = false;

    /**
     * Methode pour s'abonner
     * @param invalidationListener
     */
    @Override
    public void addListener(InvalidationListener invalidationListener) {
        lesObservateurs.add(invalidationListener);
    }

    /**
     * Methide pour se desabonner
     * @param invalidationListener
     */
    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        lesObservateurs.remove(invalidationListener);
    }

    /**
     * Permet de lancer la boucle
     * @param boucle
     */
    public void setActif(boolean boucle) {
        this.boucle= boucle;
    }

    /**
     * Permet de notifier les classes abonnées
     */
    public void beep() {
        lesObservateurs.forEach(o-> Platform.runLater(()-> o.invalidated(this)));
    }
}
