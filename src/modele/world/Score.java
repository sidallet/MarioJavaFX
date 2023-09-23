package modele.world;

import javafx.beans.property.*;

public class Score {

    private StringProperty pseudo = new SimpleStringProperty();
    public String getPseudo() {return pseudo.get();}
    public void setPseudo(String s) {pseudo.set(s);}
    public ReadOnlyStringProperty pseudoProperty() {return pseudo;}

    private IntegerProperty score = new SimpleIntegerProperty();
    public Integer getScore() {return score.get();}
    public void setScore(Integer i) {
        score.set(i);
    }
    public ReadOnlyIntegerProperty scoreProperty() {return score;}


    public Score() {
        setScore(2000);
    }
}
