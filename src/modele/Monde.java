package modele;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.creator.levelCreator;
import modele.world.*;

import java.util.ArrayList;

public class Monde {
    private ObservableList<Objet> objets;
    private char tableauLevel[][];
    private levelCreator lc = new levelCreator();
    protected final int maxHeight = 50;
    protected final int maxWidth = 50;

    public Monde() throws Exception {
        //Permet d'observer les modifications de propriétés des objets en les remontant dans Niveau.java
        objets = FXCollections.observableArrayList(eventShowable ->
                        new Observable[] { eventShowable.xProperty(), eventShowable.yProperty() });

        objets.addAll(lc.loadLevel());

        tableauLevel = lc.getTableauLevel();
    }

    public void addObjet(Bloc objet){
        objets.add(objet);
    }

    public void suprObjet(Objet objet){
        objets.remove(objet);
    }

    public ObservableList<Objet> getObjets() {
        return FXCollections.unmodifiableObservableList(objets);
    }

    public char[][] getTableauLevel() {
        return tableauLevel;
    }

    public Personnage getPersonnage() {
        for(Objet o : objets) {
            if (o instanceof Personnage) {
                return (Personnage) o;
            }
        }
        return null;
    }

    public Cle getCle() {
        for(Objet o : objets) {
            if (o instanceof Cle) {
                return (Cle) o;
            }
        }
        return null;
    }

    public int getMaxWidth(){
        return maxWidth;

    }
    public int getMaxHeight(){
        return maxHeight;

    }

}
