package pacchettomatrice;

import java.util.concurrent.Semaphore;

public class IncColonna extends Thread{
    private Semaphore sem;
    private final Matrice matrice;
    private final int colonna, x;

    public IncColonna(Matrice matrice, int colonna, int x) {
        super();
        this.matrice = matrice;
        this.colonna = colonna;
        this.x = x;
    }
    public IncColonna(Semaphore sem, Matrice matrice, int colonna, int x) {
        super();
        this.sem = sem;
        this.matrice = matrice;
        this.colonna = colonna;
        this.x = x;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= x; i++) {
                if (sem != null){
                    sem.acquire();
                    matrice.incrementaColonna(colonna);
                    sem.release();
                } else {
                    matrice.incrementaColonna(colonna);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
