package modele.world;
import javafx.beans.property.*;

public class Personnage extends Objet {
    //private Rectangle perso;
    String lImage;

    public Personnage(double x, double y,String image) {
        super(x, y);
        this.lImage=image;
        setGameEnded(false);
    }


    public double getPersonnageX(){
        return super.getX();
    }

    public double getPersonnageY(){
        return super.getY();
    }

    private final BooleanProperty gameEnded = new SimpleBooleanProperty();

    public BooleanProperty gameEndedProperty() {
        return gameEnded ;
    }

    public final boolean isGameEnded() {
        return gameEndedProperty().get();
    }

    public final void setGameEnded(boolean gameEnded) {
        gameEndedProperty().set(gameEnded);
    }

    @Override
    public String toString() {
        return "Personnage";
    }


}
