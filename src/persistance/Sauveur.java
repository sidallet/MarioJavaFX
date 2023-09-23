package persistance;

import launcher.Launcher;

import java.io.*;

/**
 * Classe qui permet de sauvegarder le score d'une partie
 */
public class Sauveur implements SauveurInterface{
    /**
     * Enregistre le score dans un fichier à partir d'un tableau de score
     */
    public void saveScoreToFile() {

        Integer score = Launcher.getManager().getLeScore().getScore();
        String pseudo = Launcher.getManager().getLeScore().getPseudo();
        ScoreTesteur testeur = new ScoreTesteur();
        String[][] tab = testeur.testerScore(score, pseudo);
        String scoreGlobal ="";

        for (int i=0;i< 3;i++) {
            scoreGlobal+=tab[i][0] +"#"+tab[i][1] +"\r\n";
            System.out.println("valeur tab " + tab[i][0]);
            System.out.println("valeur tab " + tab[i][1]);
            System.out.println("----------------- " );
            
        }
            try {

                FileWriter fw = new FileWriter("fichierScore.txt");
                fw.write(scoreGlobal);
                fw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
