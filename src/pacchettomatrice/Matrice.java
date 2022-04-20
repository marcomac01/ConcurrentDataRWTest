package pacchettomatrice;

public abstract class Matrice {
    public abstract void incrementaColonna(int colonna);

    public abstract void decrementaRiga(int riga);

    public abstract void stampaMatrice();

    public abstract int getNRighe();

    public abstract int getNColonne();

    public void testaMatrice(int x) {
        try {
            DecRiga[] tr = new DecRiga[this.getNRighe()];
            IncColonna[] tc = new IncColonna[this.getNColonne()];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = new DecRiga(this, i, x);
                tr[i].start();
            }
            for (int j = 0; j < tc.length; j++) {
                tc[j] = new IncColonna(this, j, x);
                tc[j].start();
            }
            for (DecRiga r : tr) r.join();
            for (IncColonna c : tc) c.join();
            this.stampaMatrice();
        } catch (Exception e) {System.out.println(e);}
    }

}
