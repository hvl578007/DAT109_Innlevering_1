package no.hvl.dat109;

/**
 * Klasse som definerar eit brett
 * @author Stian Grønås
 */
public class Brett {

    private final static int TAL_PAA_RUTER = 100;

    private Rute[] ruter;

    /**
     * Opprettar eit brett med 100 ruter
     */
    public Brett() {

        ruter = new Rute[TAL_PAA_RUTER];

        for (int i = 0; i < TAL_PAA_RUTER; i++) {
            //kallar dei rute 1-100
            ruter[i] = new Rute(i+1);
        }

        //"hardkoda" slangar og stigar
        this.lagStigarOgSlangar();

    }

    /**
     * Reknar ut den nye ruta brikka skal liggje på
     * @param rute den ruta som brikka ligg på
     * @param verdi det som blei kasta
     * @return den nye ruta
     */
    public Rute finnNyRute(Rute rute, int verdi) {
        int nr = rute.getNummer();
        nr = nr + verdi;

        //går ikkje over tabellen
        //ITERASJON 2 - målregelen (om ein går over rute 100 så står ein i ro) - berre setje nummeret til det gamle nummeret
        if(nr > 100) {
            return rute;
        } else if (nr < 0) {
            //iterasjon 3 - om nummeret blir mindre enn 0 -> skal til startruta
            return ruter[0];
        } else {

            //iterasjon 2 - henter verdien til ruta og legg til på nr-variabelen som hentar ut den nye ruta
            //TODO info om ein landar på ein slange/stige?
            int ruteVerdi = ruter[nr-1].getVerdi();
            nr += ruteVerdi;

            //trekk frå 1 fordi rute 1 ligg i pos 0 i tabellen.
            return ruter[nr-1];
        }
    }

    /**
     * Hente den første ruta i brettet (blir brukt til å setje brikkene på startruta)
     * @return den første ruta
     */
    public Rute hentForsteRute() {
        return ruter[0];
    }

    public Rute[] getRuter() {
        return ruter;
    }

    public void setRuter(Rute[] ruter) {
        this.ruter = ruter;
    }

    /**
     * Set stigar og slangar på brettet slik som det er på biletet i oppgåva
     */
    private void lagStigarOgSlangar() {
        /**
         * Stigar:
         *  2 -> 38 = +36
         *  4 -> 14 = +10
         *  8 -> 31 = +23
         *  21 -> 42 = +21
         *  28 -> 84 = +56
         *  36 -> 44 = +8
         *  51 -> 67 = +16
         *  71 -> 91 = +20
         *  80 -> 100 = +20
         * Slangar:
         *  98 -> 78 = -20
         *  95 -> 75 = -20
         *  92 -> 73 = -19
         *  87 -> 24 = -63
         *  64 -> 60 = -4
         *  62 -> 18 = -44
         *  56 -> 53 = -3
         *  49 -> 11 = -38
         *  47 -> 26 = -21
         *  16 -> 6 = -10
         * 
         */
        this.ruter[2-1].setVerdi(36);
        this.ruter[4-1].setVerdi(10);
        this.ruter[8-1].setVerdi(23);
        this.ruter[21-1].setVerdi(21);
        this.ruter[28-1].setVerdi(56);
        this.ruter[36-1].setVerdi(8);
        this.ruter[51-1].setVerdi(16);
        this.ruter[71-1].setVerdi(20);
        this.ruter[80-1].setVerdi(20);
        this.ruter[98-1].setVerdi(-20);
        this.ruter[95-1].setVerdi(-20);
        this.ruter[92-1].setVerdi(-19);
        this.ruter[87-1].setVerdi(-63);
        this.ruter[64-1].setVerdi(-4);
        this.ruter[62-1].setVerdi(-44);
        this.ruter[56-1].setVerdi(-3);
        this.ruter[49-1].setVerdi(-38);
        this.ruter[47-1].setVerdi(-21);
        this.ruter[16-1].setVerdi(-10);
    }

}