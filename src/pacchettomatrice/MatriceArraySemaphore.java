package pacchettomatrice;

import java.util.concurrent.Semaphore;

public class MatriceArraySemaphore extends MatriceArray{
    private Semaphore sem;
    public MatriceArraySemaphore(int righe, int colonne) {
        super(righe, colonne);
    }
    public MatriceArraySemaphore(int[][] matrice) {
        super(matrice);
    }
    @Override
    public void testaMatrice(int x) {
        try {
            sem = new Semaphore(1);
            DecRiga[] tr = new DecRiga[matrice.length];
            IncColonna[] tc = new IncColonna[matrice[0].length];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = new DecRiga(sem, this, i, x);
                tr[i].start();
            }
            for (int i = 0; i < tc.length; i++) {
                tc[i] = new IncColonna(sem, this, i, x);
                tc[i].start();
            }
            for (DecRiga r : tr) r.join();
            for (IncColonna c : tc) c.join();
            this.stampaMatrice();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
