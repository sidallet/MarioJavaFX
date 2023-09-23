package modele.world;

public class Bloc extends Objet{
    String lImage;
    public Bloc(double x, double y,String image) {
        super(x, y);
        this.lImage=image;
    }

    @Override
    public String toString() {
        return "Bloc{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

