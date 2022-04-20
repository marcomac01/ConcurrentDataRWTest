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
    public int getNRighe() {
        return matrice.length;
    }

    @Override
    public int getNColonne() {
        return matrice[0].length;
    }

}
