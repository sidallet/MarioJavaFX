package persistance;

import java.io.*;

/**
 * Classe qui charge les scores à partir d'un fichier
 */
public class Chargeur implements ChargeurInterface{
    public String sPseudo;
    public Integer sScore=0;
    public String[][] tableau = new String[500][2];
    private int i =0;

    /**
     * Permet de charger les scores depuis un fichier pour les afficher apres
     * @return
     */
    public String[][] ChargerScore() {
        int charCode;

            try {
                File file = new File("fichierScore.txt");

                Reader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);

                String line;
                while((line = br.readLine()) != null) {
                    String[] leSplit;
                    leSplit = line.split("#");
                    tableau[i]= leSplit;
                    i++;
                }
                br.close();
                return tableau;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        return new String[0][];
    }

    public String getsPseudo() {
        return sPseudo;
    }

    public Integer getsScore() {
        return sScore;
    }

    public String[][] getTableau() {
        return tableau;
    }
}
