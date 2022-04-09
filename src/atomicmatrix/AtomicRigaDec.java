package atomicmatrix;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicRigaDec extends Thread{
    AtomicIntegerArray[] matrice;
    int riga, x;

    public AtomicRigaDec(AtomicIntegerArray[] matrice, int riga, int x) {
        super();
        this.matrice = matrice;
        this.riga = riga;
        this.x = x;
    }

    public void run() {
        for (int i = 1; i <= x; i++)
            for(int j = 0; j < matrice[riga].length(); j++) matrice[riga].addAndGet(j, -1);
    }
}
