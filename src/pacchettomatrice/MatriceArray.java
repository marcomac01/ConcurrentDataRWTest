package pacchettomatrice;

import java.util.Arrays;

public class MatriceArray extends Matrice{
    protected int[][] matrice;

    public MatriceArray(int righe, int colonne) {
        this.matrice = new int[righe][colonne];
    }
    public MatriceArray(int[][] matrice) {
        this.matrice = matrice;
    }

    @Override
    public void incrementaColonna(int colonna) {
        for(int j = 0; j < matrice.length; j++) matrice[j][colonna]++;
    }

    @Override
    public void decrementaRiga(int riga) {
        for(int j = 0; j < matrice[riga].length; j++) matrice[riga][j]--;
    }

    @Override
    public void stampaMatrice() {
        for(int[] r : this.matrice) System.out.println(Arrays.toString(r));
    }

    @Override
    public void testaMatrice(int x) {
        try {
            DecRiga[] tr = new DecRiga[matrice.length];
            IncColonna[] tc = new IncColonna[matrice[0].length];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = new DecRiga(this, i, x);
                tr[i].start();
            }
            for (int i = 0; i < tc.length; i++) {
                tc[i] = new IncColonna(this, i, x);
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
