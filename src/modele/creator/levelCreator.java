package modele.creator;

import modele.world.*;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe qui genere les bons objets à partir d'un fichier txt
 */
public class levelCreator {
    private char tableauLevel[][] = new char[100][100];

    /**
     * Charge dans une arrayList les objets
     * @return
     * @throws Exception
     */
    public ArrayList<Objet> loadLevel() throws Exception {
        FileReader fr = new FileReader(new File(getClass().getResource("/text/level1.txt").toURI()));
        BufferedReader reader = new BufferedReader(fr);
        int ligne=0, colonne=0,carac,ligneTableau=0,colonneTableau=0;
        ArrayList<Objet> level = new ArrayList<>();

        while((carac= reader.read()) != -1) {
            tableauLevel[ligneTableau][colonneTableau] = (char) carac;
            colonneTableau+=1;
            switch ((char)carac) {
                case '0':
                    colonne+=50;
                    break;
                case '1':
                    level.add(new Bloc(colonne,ligne, "images/game/blocV2.jpg"));
                    colonne+=50;
                    break;
                case '9':
                    level.add(new Personnage(colonne,ligne, "images/game/mariobros.png"));
                    colonne+=50;
                    break;
                case 'X':
                    level.add(new Lave(colonne,ligne));
                    colonne+=50;
                    break;
                case '/':
                    level.add(new Cle(colonne,ligne));
                    colonne+=50;
                    break;
                case 'A':
                    level.add(new Porte(colonne,ligne));
                    colonne+=50;
                    break;
                case '\n':
                    colonne=0;
                    colonneTableau=0;
                    ligne+=50;
                    ligneTableau+=1;
                    break;
            }
        }
        return level;
    }

    public char[][] getTableauLevel() {
        return tableauLevel;
    }
}
