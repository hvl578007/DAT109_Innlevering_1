package no.hvl.dat109;

/**
 * Klasse som definerar ei rute
 */
public class Rute {

    private int nummer;
    //iterasjon 2
    private int verdi;

    /**
     * Lagar ei rute med det nummeret
     * @param nummer
     */
    public Rute(int nummer) {
        this.nummer = nummer;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getVerdi() {
        return verdi;
    }

    public void setVerdi(int verdi) {
        this.verdi = verdi;
    }
}