import java.util.concurrent.atomic.AtomicIntegerArray;

public class Test {

    public static void main(String[] args) throws Exception {
        int[][] matriceInt = {{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        System.out.println("# Proviamo a mandare in esecuzione la versione non thread safe");
        Metodi.testaMatriceInteri(matriceInt, 10000);

        System.out.println("------------------------------------------------------");

        System.out.println("# Testiamo la versione Thread-Safe con AtomicIntegerArray");
        AtomicIntegerArray[] matriceAtomic = new AtomicIntegerArray[5];
        for (int i = 0; i < matriceAtomic.length; i++) matriceAtomic[i] = new AtomicIntegerArray(8);
        Metodi.testaMatriceAtomic(matriceAtomic, 10000);
    }
}
