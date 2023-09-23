package modele.world;

public class Lave extends Objet {
    protected int maxHeight=35 ;
    protected int maxWidth=50;

    public Lave(double x, double y) {
        super(x, y);
    }

    public void tuer(Personnage perso){

    }

    @Override
    public int getMaxWidth(){
        return maxWidth;

    }
    @Override
    public int getMaxHeight(){
        return maxHeight;

    }
}
