package boucleur;

public class Boucleur extends BoucleurAbstrait {
    @Override
    public void run() {
        while(boucle) {
            beep();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                boucle = false;
                e.printStackTrace();
            }
        }
    }


}
