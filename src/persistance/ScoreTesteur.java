package persistance;

/**
 * Classe qui permet de savoir si on doit enregistrer un score ou non
 */
public class ScoreTesteur {

    /**
     * Methode qui permet d'inserer un score s'il fait parti du top 3 des scores, au bon endroit
     * @param score
     * @param pseudo
     * @return
     */
    public String[][] testerScore(Integer score, String pseudo) {
        Chargeur ch = new Chargeur();
        String[][] tab= ch.ChargerScore();
        int i;
        int insertion=-1;
        for (i=0;i< 3;i++) {
            System.out.println("score recu : " + score);
            System.out.println("score a comparer : " + tab[i][1]);
            if (score>=Integer.parseInt(tab[i][1])) {
                insertion=i;
                break;
            }
        }
        System.out.println("valeur instertion apres boucle " + insertion);
        if (insertion>=0) {

            for (i=2;i>insertion;i--) {
                tab[i][0] = tab[i-1][0];
                tab[i][1] = tab[i-1][1];
            }
            tab[insertion][0]=pseudo;
            tab[insertion][1]=String.valueOf(score);
        }
        return tab;
    }

    /**
     * Renvoie le tableau trié
     * @return
     */
    public String[][] returnTabScore() {
        Chargeur ch = new Chargeur();
        String[][] tab= ch.ChargerScore();
        return tab;
    }



}
