package atomicmatrix;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicColonnaInc extends Thread{
        AtomicIntegerArray[] matrice;
        int colonna, x;

        public AtomicColonnaInc(AtomicIntegerArray[] matrice, int colonna, int x) {
            super();
            this.matrice = matrice;
            this.colonna = colonna;
            this.x = x;
        }

        public void run() {
            for (int i = 1; i <= x; i++)
                for(int j = 0; j < matrice.length; j++) matrice[j].addAndGet(colonna, 1);
        }

}
