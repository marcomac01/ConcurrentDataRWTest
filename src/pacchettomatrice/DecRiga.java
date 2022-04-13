package pacchettomatrice;

import java.util.concurrent.Semaphore;

public class DecRiga extends Thread{
    private Semaphore sem;
    private final Matrice matrice;
    private final int riga, x;

    public DecRiga(Matrice matrice, int riga, int x) {
        super();
        this.matrice = matrice;
        this.riga = riga;
        this.x = x;
    }
    public DecRiga(Semaphore sem ,Matrice matrice, int riga, int x) {
        super();
        this.sem = sem;
        this.matrice = matrice;
        this.riga = riga;
        this.x = x;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= x; i++) {
                if (sem != null){
                    sem.acquire();
                    matrice.decrementaRiga(riga);
                    sem.release();
                } else {
                    matrice.decrementaRiga(riga);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
