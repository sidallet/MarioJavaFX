package modele.world;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Classe abstraite des entites du monde
 */
public abstract class Objet {
    protected int maxHeight  =50 ;
    protected int maxWidth = 50;

    protected final DoubleProperty x = new SimpleDoubleProperty();
    public final double getX() {return x.get(); }
    public final DoubleProperty xProperty() {return x;}
    public final void setX(double x) {
        this.x.set(x);
    }


    protected DoubleProperty y = new SimpleDoubleProperty();
    public double getY() {return y.get(); }
    public DoubleProperty yProperty() {return y;}

    public void setY(double y) {this.y.set(y);}

    protected String image;

    public Objet(double x, double y) {
        setX(x);
        setY(y);
    }



    public int getMaxWidth(){
        return maxWidth;

    }
    public int getMaxHeight(){
        return maxHeight;

    }

    public String getImage(){
        return image;

    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }


    @Override
    public String toString() {
        return "Objet{" +
                "image='" + image + '\'' +
                '}';
    }
}
