import pacchettomatrice.*;


public class Test {

    public static void main(String[] args) throws Exception {
        int x = 100000;
        System.out.println("# Testiamo la versione non Thread-Safe con Arrray di interi");
        Matrice m = new MatriceArray(5,8);
        m.testaMatrice(x);

        System.out.println("------------------------------------------------------");

        System.out.println("# Testiamo la versione Thread-Safe con AtomicIntegerArray");
        Matrice m2 = new MatriceAtomicInteger(5,8);
        m2.testaMatrice(x);

        System.out.println("------------------------------------------------------");

        System.out.println("# Testiamo la versione Thread-Safe con Array di interi + Semaphore");
        Matrice m3 = new MatriceArraySemaphore(5,8);
        m3.testaMatrice(x);


    }
}
