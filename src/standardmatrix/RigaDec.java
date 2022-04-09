package standardmatrix;

public class RigaDec extends Thread{
    int[][] matrice;
    int riga, x;

    public RigaDec(int[][] matrice, int riga, int x) {
        super();
        this.matrice = matrice;
        this.riga = riga;
        this.x = x;
    }

    public void run() {
        for(int i = 1; i <= x; i++)
            for(int j = 0; j < matrice[riga].length; j++) matrice[riga][j]--;
    }
}
