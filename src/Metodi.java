import atomicmatrix.*;
import standardmatrix.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Metodi {
    public static void stampaMatrice(int[][] matriceInt) {
        for(int[] r : matriceInt) System.out.println(Arrays.toString(r));
    }
    public static void stampaMatrice(AtomicIntegerArray[] matrice) {
        for (int i = 0; i < matrice.length; i++) System.out.println(matrice[i]);
    }
    public static void testaMatriceInteri(int[][] matrice, int x) throws Exception {
        RigaDec[] tr = new RigaDec[matrice.length];
        ColonnaInc[] tc = new ColonnaInc[matrice[0].length];
        for (int i = 0; i < tr.length; i++) {
            tr[i] = new RigaDec(matrice, i, x);
            tr[i].start();
        }
        for (int i = 0; i < tc.length; i++) {
            tc[i] = new ColonnaInc(matrice, i, x);
            tc[i].start();
        }
        for (RigaDec r : tr) r.join();
        for (ColonnaInc c : tc) c.join();
        stampaMatrice(matrice);
    }
    public static void testaMatriceAtomic(AtomicIntegerArray[] matrice, int x) throws Exception{
        AtomicRigaDec[] tr = new AtomicRigaDec[matrice.length];
        AtomicColonnaInc[] tc = new AtomicColonnaInc[matrice[0].length()];
        for (int i = 0; i < tr.length; i++) {
            tr[i] = new AtomicRigaDec(matrice, i, x);
            tr[i].start();
        }
        for (int i = 0; i < tc.length; i++) {
            tc[i] = new AtomicColonnaInc(matrice, i, x);
            tc[i].start();
        }
        for (AtomicRigaDec r : tr) r.join();
        for (AtomicColonnaInc c : tc) c.join();
        stampaMatrice(matrice);
    }
}
