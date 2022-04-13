package pacchettomatrice;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class MatriceAtomicInteger extends Matrice{
    private final AtomicIntegerArray[] matrice;

    public MatriceAtomicInteger(int righe, int colonne) {
        this.matrice = new AtomicIntegerArray[5];
        for (int i = 0; i < this.matrice.length; i++) this.matrice[i] = new AtomicIntegerArray(8);
    }
    public MatriceAtomicInteger(AtomicIntegerArray[] matrice) {
        this.matrice = matrice;
    }

    @Override
    public void incrementaColonna(int colonna) {
        for(int j = 0; j < this.matrice.length; j++) this.matrice[j].addAndGet(colonna, 1);
    }

    @Override
    public void decrementaRiga(int riga) {
        for(int j = 0; j < this.matrice[riga].length(); j++) this.matrice[riga].addAndGet(j, -1);
    }

    @Override
    public void stampaMatrice() {
        for (int i = 0; i < matrice.length; i++) System.out.println(matrice[i]);
    }

    @Override
    public void testaMatrice(int x) {
        try {
            DecRiga[] tr = new DecRiga[matrice.length];
            IncColonna[] tc = new IncColonna[matrice[0].length()];
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
        } catch (Exception e) {System.out.println(e);}
    }
}
