package no.hvl.dat109;

/**
 * Definerar ein spelar
 * @author Stian Grønås
 */
public class Spelar {

    //felles terning?
    //private Terning terning;
    private String namn;
    private Brikke brikke;

    /**
     * Opprettar ein spelar med det namnet og brikka
     * @param namn
     * @param brikke
     */
    public Spelar(String namn, Brikke brikke) {
        this.namn = namn;
        this.brikke = brikke;
        //this.terning = terning;
    }

    /**
     * Spelaren utførar eit trekk i spelet
     */
    public void gjerTrekk(Terning terning) {

        //Rute forrigeRute = brikke.getRute();

        terning.trill();
        int verdi = terning.getVerdi();

        //evt la spelaren flytte brikka?
        brikke.flytt(verdi);

        //TODO spelaren seier trekket sitt til UI? Litt usikkert... Berre ny rute? Eller ta med at ein gjekk frå rute nr x til rute nr y?
        //SpelUI.skrivUtTrekk(this, brikke.getRute(), verdi);
        //treng vel ikkje sende med ruta...
    }

    /**
     * Spelaren sjekkar brikka si om den ligg på rute 100
     * @return true om den er på rute 100, false ellers
     */
    public boolean harVunne() {
        return this.brikke.getRute().getNummer() >= 100;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public Brikke getBrikke() {
        return brikke;
    }

    public void setBrikke(Brikke brikke) {
        this.brikke = brikke;
    }

    
}