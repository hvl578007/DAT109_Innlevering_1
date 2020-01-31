package no.hvl.dat109;

/**
 * Definerar ei brikke
 * @author Stian Grønås
 */
public class Brikke {

    private final static String[] TILGJENGELEGE_FARGAR = {"raud", "grøn", "blå", "gul"};

    //nødvendig?
    //ligg kanskje inni Spelaren?
    private String farge;
    private Rute rute;
    private Brett brett;

    /**
     * Opprettar ei brikke. Forhandsdefinerte fargar for spelar 1, 2, 3 og 4.
     * @param fargeNr Nummeret på spelaren
     */
    public Brikke(int fargeNr, Brett brett, Rute ruteStart) {
        this.farge = TILGJENGELEGE_FARGAR[fargeNr];
        this.brett = brett;
        this.rute = ruteStart;
    }

    /**
     * Flyttar ei brikke framover med den oppgitte verdien
     * @param verdi
     */
    public void flytt(int verdi) {
        Rute nyRute = brett.finnNyRute(rute, verdi);
        setRute(nyRute);
    }

    public String getFarge() {
        return farge;
    }

	public void setFarge(String farge) {
		this.farge = farge;
    }

    public Rute getRute() {
        return rute;
    }

    public void setRute(Rute rute) {
        this.rute = rute;
    }
}