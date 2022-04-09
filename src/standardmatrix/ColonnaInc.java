package standardmatrix;

public class ColonnaInc extends Thread{
    int[][] matrice;
    int colonna, x;

    public ColonnaInc(int[][] matrice, int colonna, int x) {
        super();
        this.matrice = matrice;
        this.colonna = colonna;
        this.x = x;
    }

    public void run() {
        for(int i = 1; i <= x; i++)
            for(int j = 0; j < matrice.length; j++) matrice[j][colonna]++;
    }
}
